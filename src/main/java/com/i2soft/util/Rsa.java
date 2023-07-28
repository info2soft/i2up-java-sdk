package com.i2soft.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;

/**
 * https://blog.csdn.net/panjiapengfly/article/details/75318930
 */
public class Rsa {

    private String priKey = "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";
    private String pubKey = "";
    public Rsa() {
        if (!new File("public_key.pem").exists()) {
            pubKey = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAlYMpSqKsQgSeAeUHJE0WllEa1bTRYhn8ZNje6qPevrfwW5mrLioXbIjJefZhZy2xmRI0fI+i8RlLvYmG7awDYSmL31DrOQqUHFS3Os8SvnHmD9o0CFP2llqntO38IT5EmjaCgLvyqvIdXcRVzxf/6exJiH1YnfiJr85qy5e3+JSS335w9wItiT3XsvXLB0pOTo+AfHROaVp0JdBhImKYIxB3qC4k30GgF095GoIy0A/6WmSqPFEWsA2tiDMWvWjodMxBhf2pDp8JtThb9d/dTS8gFwM7MWmhQ+CHljXVTtkJT0KO2A9SZYO5xyB82X2gRdJ3W6kAo+Zx1c3U8OLVm6LqbCcm6F0BgJP9EMI5HX2fKuJKHkkJbNXDD1lqpDmOA0ITRpCym6eCg/8Vj+zmSgkf70I6CPK58ouaG9T4mP/OqB5KHnaj/DBCPgIJnoqMCaTkVCB9ehbUj1tWoF4zM5mvngx9l5O5QoRe+0ygSYDHW+bXydmBWoDGB7S0dD7JAgMBAAE=";
        } else {
            pubKey = readStringFromFile("public_key.pem"); // PKCS8 格式
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
     * 使用公钥加密
     */
    public String encryptByPublicKey(String data) {
        // 加密
        String str = "";
        try {
            byte[] pubbyte = base64decode(pubKey.trim());
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubbyte);
            KeyFactory fac = KeyFactory.getInstance("Rsa");
            RSAPublicKey rsaPubKey = (RSAPublicKey) fac.generatePublic(keySpec);
            Cipher c1 = Cipher.getInstance("RSA/ECB/OAEPPadding");
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
        StringBuilder str = new StringBuilder();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            char[] temp = new char[1024];
            while (fr.read(temp) != -1) {
                str.append(temp);
            }
            fr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return str.toString();
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