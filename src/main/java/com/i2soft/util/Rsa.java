package com.i2soft.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * https://blog.csdn.net/panjiapengfly/article/details/75318930
 */
public class Rsa {

    private String priKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDl9TjTh8beXEGxPnHNj0MqPvVIpHz1PT+9cyBdpU3FTM5lYyPuOT3uCqByX4qCFY2zRa0MtJV9JlOkhQRkN3yUDAw1QneuAtJ5gQXGJjIDULaPO3WkbEVAu4+3IytG2TPVP9aZWO+DGfGu6lih+HRuUkitxB2fzpQwKXFwPv60+SVM5GN3bhZU2sK3/HfONHWhfrxFiGETW4FxVwXGMLQBcOMKIyic3fUL3zX72WbGvmxdGoWCunRKZVRGOgacAirTR+qx3dVLlTpJl81vOP2S+M6zJkMxNK6x3fcnuzPsKWtmz/athVbgUitM60A+qdssFuyBkHaXR8DMLLNI6VNrAgMBAAECggEANrL2+nIQnvHo+mU1IsVSH6lsJQRjaN5R3BmXeE8KycS0T6+ea1sYXRgQBESvqLPBygPn3t7RtDw6pyaw3bnJG1omSUDvQOgQ8q/7FKAfQ2SemEF3gU3zxysWS2TFNYwS5UXTIRTjnBa+w3Gg9Z4o69kMyrCcr1evLimdfyqs4ZTymbHNHdNtLIfyK7sIEufPh/07jV1h94FiYpuUw2rMRLfDyn074jYhCABYBRB1LZ7NCDtGfaUUyXGNWXo6nioIjGBacpc45C1pNIudm9aBrgrOJeAd+8CiOT3GSm8VHKWdZFbBp7FQJ2RNPHgULTpyZinsu2u+j5rB90eQ+VNUwQKBgQDzOiVOscLVPtBJEgE68e9t/fHW4xZEJSAi4SKBv0yymjNZmenCkBVdNta364oHBvU0+hxP+JxnJSlfw49F5F19j0azLgzpPRBdiKeNFnlZmy79PvCBI34AGn5lTi8PwCqzObfki3S3SvMPGCh3HeFTS27iXf7Sk0GBmJPBTJk0SwKBgQDyCLCNCQ4lg7hrkFFS/4NHIQRfVvfMOBdwsXGIfmIUwZOLzIfr9nMdC0B9lK262zHDcq/uSVccMhZBBO6Sy6JmHpjw6xkz/oTnwcucmNuIXsc0OFkZoiP0CpKRNLcf7EyXVU8EtYRiJ3xMQplsxEChOQzBpbRCGl6JqFTfYaWpYQKBgA3tsX89LMQbccANeOaQPj7VQQkmPfsvCRUWQWyesNy1eeVSrBFJQP/yiP9FTMU0P8yF2iM2QHajqSfjwgullTkAgHL4WyLsLUi976JjvBVGjr1P4mPyzV9iJQTWIlnLjmZvErnSxp9MenjN0Ftp6aJkengaG+KhLiomu6dhJJDbAoGBAKlm55tvERW0wemXUzRSXmH0fAj25+1p/Q4FRD+Spbd9XXXlq+S91AgqDfNXktlL/eKcbQLNFklHzUeo2gqouHvdQpKtGjDIHeHQRGDQpCconyivn71PPPbcR4WWbe3MCDeLoAjdu1Cv7lG584SrP8kYExOelTIHHtAen3jR8Y9BAoGAT9GRD6UchKGc38D2RIbPDX4uJVYbSuBBbrnKRL7wb5Qhb6ssedvqTj4TMG7TpYlTSu43sZ77o2E5yjOLGlhrHCwzEJ0pX6bS9dg5j6WLQPbf1eJ8M4PLBEW1qK+S1/NzFr+ikHI4RwodjTSTiuFgH7klOlCQGJ2bqpVmRwrxxQ4=";
    private String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5fU404fG3lxBsT5xzY9DKj71SKR89T0/vXMgXaVNxUzOZWMj7jk97gqgcl+KghWNs0WtDLSVfSZTpIUEZDd8lAwMNUJ3rgLSeYEFxiYyA1C2jzt1pGxFQLuPtyMrRtkz1T/WmVjvgxnxrupYofh0blJIrcQdn86UMClxcD7+tPklTORjd24WVNrCt/x3zjR1oX68RYhhE1uBcVcFxjC0AXDjCiMonN31C981+9lmxr5sXRqFgrp0SmVURjoGnAIq00fqsd3VS5U6SZfNbzj9kvjOsyZDMTSusd33J7sz7ClrZs/2rYVW4FIrTOtAPqnbLBbsgZB2l0fAzCyzSOlTawIDAQAB";

    public Rsa() {
        // priKey = readStringFromFile("src/private_key.pem"); // PKCS8 格式
        // pubKey = readStringFromFile("src/public_key.pem"); // PKCS8 格式
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
            Cipher c1 = Cipher.getInstance("Rsa/ECB/PKCS1Padding");
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
            Cipher c1 = Cipher.getInstance("Rsa/ECB/PKCS1Padding");
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
     * @param bstr:
     * @return :
     */
    @SuppressWarnings("restriction")
    private String base64encode(byte[] bstr) {
        String str = new sun.misc.BASE64Encoder().encode(bstr);
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
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
            bt = decoder.decodeBuffer(str);
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
}