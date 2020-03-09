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
//    private String key = "40ce9e18ee354320";
    private static String key = "40ce9e18ee354320";

    public static Key getKey(String keySeed) {
        SecretKeySpec secretKey = null;
        try {
            secretKey = new SecretKeySpec(keySeed.getBytes(), "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return secretKey;
    }

    public static final String encrypt(String plainText) {
        Key secretKey = getKey(key);
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



    public static void main(String[] args) {
//        String source = "8BTJsj9GV7uOzibP+VBkeQDQTU0b5Zn+e4dpm7jbTKJQyIh9DSIpb634ZDUG+UFUvbXODrEmYwnaVAmddt+" +
//                "ltmF5X5//M5G8CgRjasXjlPO2Iw11lVn3O" +
//                "rdCUoQ8M0yDemNTfMrC5/qKpGaCKQ8cvkx/FPOyfj" +
//                "HAUPHNJC7pJFK9+kgbrzXPfd4wMft2daTiGi/wwGmTEdqYnakUT3he9" +
//                "TTXcXWW5MRG0JCARXuyYEZYsi6BRM/nnictAOVIwzZhC9K/wJOzhw3gn" +
//                "j3rGfsxFqnLoEiU4WDP1zzYSS2HRAjeTO+KrZwwP2WiJv8LDfVaE0vB03u5mOk5Z7XZn3iSEe" +
//                "D5NMjOwxUomkvKadm6CCPwdYMZg8/FrE6Ot6shT7oAFIBGHtmjlXPev1xDXbm8gYnvQfqk+ncFiHY925HrP+x+I03u" +
//                "xMf+4g4fDKMuh8+dLW9PsDsFR/WfQaVmwI3n1/BJlD9S6zdzIq7Qn5RUJm8=8BTJsj9GV7uOzibP+VBkeQDQTU0" +
//                "b5Zn+e4dpm7jbTKJQyIh9DSIpb634ZDUG+UFUvbXODrEmYwnaVAmddt+ltmF5X5//M5G8CgRjasXjlPO2Iw1" +
//                "1lVn3OrdCUoQ8M0yDemNTfMrC5/qKpGaCKQ8cvkx/FPOyfjHAUPHNJC7pJFK9+kgbrzXPfd4wMft2daT" +
//                "iGi/wwGmTEdqYnakUT3he9TTXcXWW5MRG0JCARXuyYEZYsi6BRM/nnictAOVIwzZhC9K/wJOzhw3gnj3rGfsxFqnLoEiU4" +
//                "WDP1zzYSS2HRAjeTO+KrZwwP2WiJv8LDfVaE0vB03u5mOk5Z7XZn3iSEeD5NMjOwxUomkvKadm6CCPwdYMZg8/FrE6Ot6shT7" +
//                "oAFIBGHtmjlXPev1xDXbm8gYnvQfqk+ncFiHY925HrP+x+I03uxMf+4g4fDKMuh8+dLW9PsDsFR/WfQaVmwI3n1/BJlD9S6zdz" +
//                "Iq7Qn5RUJm8=";

//        String source = "0KmYQdKpyTnEJr/oPADEjzeSNsCCw/s0VIEu1OcO9yAL4WkMoDrf22iDShRnNoLf";
        String source ="r8dJ+ARYA0A3juBKyx5E+4EMuN2rFv2dOMwiHcb0duJ91NhGNEIzkbrDJwAOiGkoLknTC+d5u4cCq9RhB7YA7I6xoji8iCFWRlzThoGcI3meB6jJcVl1kTL1G1ZPUtuRn/5SB4aQYhlm/Q1XNvu4rSk35FB+YSMV9aam5DuGaUvUrAl1PQzSdxa4VT78YCxp9pFkzWdy9AEu51YKErAB7/xgJTWjGnVcc2qIlimOzCKhQ50X2tnX/xbCaaLkM8O9xJ/XpeX+1OFvsWuOaT0ceII0Hg0eOSJguEbT5iX26wsh4W9Hv69Yv0P85eXwIyPnvD4TkP14AK0I+848LoACJQ==";
        String result = AESUtils.dencrypt(source);
        System.out.println("result: "+ result);
    }




}
