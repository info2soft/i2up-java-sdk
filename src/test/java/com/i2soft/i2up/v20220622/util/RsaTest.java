package com.i2soft.i2up.v20220622.util;

import com.i2soft.http.Client;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.Configuration;
import com.i2soft.util.Rsa;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Objects;

public class RsaTest {
    @Test
    public void testRsa() {
        Rsa rsa = new Rsa();
        String str = "我要加密这段文字。";
        System.out.println("原文:" + "我要加密这段文字。");
        String crypt = rsa.encryptByPrivateKey(str);
        System.out.println("私钥加密密文:" + crypt);
        String result = rsa.decryptByPublicKey(crypt);
        System.out.println("解密明文:" + result);

        System.out.println("---");

        str = "我要加密这段文字。";
        System.out.println("原文:" + "我要加密这段文字。");
        crypt = rsa.encryptByPublicKey(str);
        System.out.println("公钥加密密文:" + crypt);
        result = rsa.decryptByPrivateKey(crypt);
        System.out.println("解密明文:" + result);

        System.out.println("---");

        str = "我要签名这段文字。";
        System.out.println("原文：" + str);
        String str1 = rsa.signByPrivateKey(str);
        System.out.println("签名结果：" + str1);
        if (rsa.verifyByPublicKey(str1, str)) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }
}
