package com.example.demo.encrypt.AES;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class AESUtils {

    byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    private static String salt = "";

    public static Key getKey(String keySeed) {
        SecretKeySpec secretKey = null;
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//            KeySpec spec = new PBEKeySpec(keySeed.toCharArray(), salt.getBytes(),256);
//            SecretKey tmp = factory.generateSecret(spec);
//            secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            secretKey = new SecretKeySpec(keySeed.getBytes(), "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return secretKey;
    }

    public static final String encrypt(String plainText) {
        Key secretKey = getKey("40ce9e18ee354320");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] p = plainText.getBytes("UTF-8");
            byte[] result = cipher.doFinal(p);
            BASE64Encoder encoder = new BASE64Encoder();
            String encoded = encoder.encode(result);
            return encoded;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static final String dencrypt(String encryptText) {
        Key secretKey = getKey("40ce9e18ee354320");
        String vector = "40ce9e18ee354320";
        String plainText = "";
        try {
            IvParameterSpec iv = new IvParameterSpec(vector.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] c = base64Decoder.decodeBuffer(encryptText);
            byte[] result = cipher.doFinal(c);
            plainText = new String(result, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return plainText;
    }



    public void main(String[] args) {
       String result = AESUtils.dencrypt("0KmYQdKpyTnEJr/oPADEjzeSNsCCw/s0VIEu1OcO9yAL4WkMoDrf22iDShRnNoLf");
        System.out.println("result: "+ result);
    }




}
