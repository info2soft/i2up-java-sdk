package com.i2soft.util;

import com.i2soft.common.Auth;
import com.i2soft.http.Client;
import com.i2soft.http.I2Rs;
import com.i2soft.http.Response;

import static com.i2soft.http.Client.bytes2HexString;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * https://blog.csdn.net/panjiapengfly/article/details/75318930
 */
public class Rsa {

    private String priKey = "";
    private String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5fU404fG3lxBsT5xzY9DKj71SKR89T0/vXMgXaVNxUzOZWMj7jk97gqgcl+KghWNs0WtDLSVfSZTpIUEZDd8lAwMNUJ3rgLSeYEFxiYyA1C2jzt1pGxFQLuPtyMrRtkz1T/WmVjvgxnxrupYofh0blJIrcQdn86UMClxcD7+tPklTORjd24WVNrCt/x3zjR1oX68RYhhE1uBcVcFxjC0AXDjCiMonN31C981+9lmxr5sXRqFgrp0SmVURjoGnAIq00fqsd3VS5U6SZfNbzj9kvjOsyZDMTSusd33J7sz7ClrZs/2rYVW4FIrTOtAPqnbLBbsgZB2l0fAzCyzSOlTawIDAQAB";
    private String encryptMethod = "Rsa/ECB/PKCS1Padding"; // 默认Padding

    public Rsa() {
        // 通过ip生成hash作为路径（与Auth.getAuth中的逻辑一致）
        String ccUrl = Auth.getCcUrlDefault();
        String cachePath = Auth.getCachePath();
        String hash = "temp";
        
        // 当 ccUrl 不为空时，生成 hash 作为子目录
        // 注意：cc_url = addr + "/api"，需要去掉 "/api" 后缀以保持与 Auth.getAuth 中 hash 计算方式一致
        if (ccUrl != null && !ccUrl.isEmpty()) {
            try {
                String addr = ccUrl.endsWith("/api") ? ccUrl.substring(0, ccUrl.length() - 4) : ccUrl;
                Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
                SecretKeySpec secret_key = new SecretKeySpec(addr.getBytes(), "HmacSHA256");
                sha256_HMAC.init(secret_key);
                hash = bytes2HexString(sha256_HMAC.doFinal(addr.getBytes())).toLowerCase();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 读取缓存公钥文件（按IP增加一层路径）
        String FilePath = (cachePath != null ? cachePath : "") + File.separator + hash + File.separator + "pub_key.json";
        File pubKeyFile = new File(FilePath);
//        long timeStamp = System.currentTimeMillis() / 1000;
        StringMap pubKeyJson = null;
        if (pubKeyFile.exists()) {
            try {
                pubKeyJson = IOHelper.readJsonFile(pubKeyFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 存在缓存文件则使用文件中的内容作为公钥信息
            if (pubKeyJson.get("public_key") != null) {
                this.pubKey = pubKeyJson.get("public_key").toString();
                this.encryptMethod = pubKeyJson.get("encrypt_method").toString();
            }
        } else {
            // 获取公钥失败则使用内置默认公钥，接口存在公钥返回则使用RSA/ECB/OAEPPadding，否则为ECB/PKCS1Padding
            String url = String.format("%s/sys/public_settings", ccUrl);
            Client client = Auth.getClientDefault();
            try {
                pubKeyJson = new StringMap();
                Response r = client.get(url, new StringMap());
                I2Rs.I2PublicRs result = r.jsonToObject(I2Rs.I2PublicRs.class);
                if (result != null && result.pubKey != null) {
                    String keyTrimmed = result.pubKey.trim()
                            .replaceAll(System.lineSeparator(), "")
                            .replace("\\\\n", "")
                            .replace("-----BEGIN PUBLIC KEY-----", "")
                            .replace("-----END PUBLIC KEY-----", "")
                            .replace("\\u003d", "=");
                    if (!keyTrimmed.isEmpty()) {
                        this.pubKey = keyTrimmed;
                        this.encryptMethod = "RSA/ECB/OAEPPadding";
                    }
                }
                pubKeyJson.put("encrypt_method", this.encryptMethod);
                pubKeyJson.put("public_key", this.pubKey);
//                pubKeyJson.put("time", timeStamp);
                IOHelper.saveJsonFile(new File(FilePath), pubKeyJson);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 使用私钥加密
     */
    public String encryptByPrivateKey(String data) {
        // 加密
        String str = "";
        try {
            byte[] pribyte = base64decode(priKey.trim());
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pribyte);
            KeyFactory fac = KeyFactory.getInstance("Rsa");
            RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
            Cipher c1 = Cipher.getInstance("Rsa/ECB/PKCS1Padding");
            c1.init(Cipher.ENCRYPT_MODE, privateKey);
            str = base64encode(c1.doFinal(data.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 使用私钥解密
     */
    public String decryptByPrivateKey(String data) {
        // 解密
        String str = "";
        try {
            byte[] pribyte = base64decode(priKey.trim());
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pribyte);
            KeyFactory fac = KeyFactory.getInstance("Rsa");
            RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
            Cipher c1 = Cipher.getInstance("RSA/ECB/OAEPPadding");
            c1.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] temp = c1.doFinal(base64decode(data));
            str = new String(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 使用公钥加密（实际API加密字段均使用此方法）
     */
    public String encryptByPublicKey(String data) {
        // 加密
        String str = "";
        try {
            byte[] pubbyte = base64decode(pubKey.trim());
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubbyte);
            KeyFactory fac = KeyFactory.getInstance("Rsa");
            RSAPublicKey rsaPubKey = (RSAPublicKey) fac.generatePublic(keySpec);
            Cipher c1 = Cipher.getInstance(encryptMethod);
//            OAEPParameterSpec oaepParams = getOAEPParameterSpec("RSA/ECB/OAEPPadding", null);
            c1.init(Cipher.ENCRYPT_MODE, rsaPubKey);
            str = base64encode(c1.doFinal(data.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 使用公钥解密
     */
    public String decryptByPublicKey(String data) {
        // 加密
        String str = "";
        try {
            byte[] pubbyte = base64decode(pubKey.trim());
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubbyte);
            KeyFactory fac = KeyFactory.getInstance("Rsa");
            RSAPublicKey rsaPubKey = (RSAPublicKey) fac.generatePublic(keySpec);
            Cipher c1 = Cipher.getInstance("Rsa/ECB/PKCS1Padding");
            c1.init(Cipher.DECRYPT_MODE, rsaPubKey);
            byte[] temp = c1.doFinal(base64decode(data));
            str = new String(temp);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return str;
    }

    /**
     * 本方法使用SHA1withRSA签名算法产生签名
     *
     * @param src: 签名的原字符串
     * @return String 签名的返回结果(16进制编码)。当产生签名出错的时候，返回null。
     */
    public String signByPrivateKey(String src) {
        try {
            Signature sigEng = Signature.getInstance("SHA1withRSA");
            byte[] pribyte = base64decode(priKey.trim());
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pribyte);
            KeyFactory fac = KeyFactory.getInstance("Rsa");
            RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
            sigEng.initSign(privateKey);
            sigEng.update(src.getBytes());
            byte[] signature = sigEng.sign();
            return base64encode(signature);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 使用共钥验证签名
     *
     * @param sign :
     * @param src  :
     * @return :
     */
    public boolean verifyByPublicKey(String sign, String src) {
        try {
            Signature sigEng = Signature.getInstance("SHA1withRSA");
            byte[] pubbyte = base64decode(pubKey.trim());
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubbyte);
            KeyFactory fac = KeyFactory.getInstance("Rsa");
            RSAPublicKey rsaPubKey = (RSAPublicKey) fac.generatePublic(keySpec);
            sigEng.initVerify(rsaPubKey);
            sigEng.update(src.getBytes());
            byte[] sign1 = base64decode(sign);
            return sigEng.verify(sign1);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * base64加密
     *
     * @param bt:
     * @return :
     */
    @SuppressWarnings("restriction")
    private String base64encode(byte[] bt) {
//        String str = new sun.misc.BASE64Encoder().encode(bstr);
//        Base64.encodeBase64();
        String str = Base64.encodeBase64String(bt);
        str = str.replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");
        return str;
    }

    /**
     * base64解密
     *
     * @param str:
     * @return byte[]
     */
    @SuppressWarnings("restriction")
    private byte[] base64decode(String str) {
        byte[] bt = null;
        try {
//            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
//            bt = decoder.decodeBuffer(str);
            bt = Base64.decodeBase64(str.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bt;
    }

    /**
     * 从文件中读取所有字符串
     *
     * @param fileName:
     * @return String
     */
    private String readStringFromFile(String fileName) {
        StringBuilder str = null;
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            String line;
            str = new StringBuilder();
            while ((line = br.readLine()) != null) {
                str.append(line);
                str.append(System.lineSeparator());
            }

            br.close();
            return str.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void writeStringToFile(String fileName, String content) {
        // overwrite the file content
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}