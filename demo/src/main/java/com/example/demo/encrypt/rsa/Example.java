package com.example.demo.encrypt.rsa;

import sun.misc.BASE64Decoder;

/** */

/**
 * <p>
 * RSA公钥/私钥/签名工具包
 * </p>
 * <p>
 * 罗纳德·李维斯特（Ron [R]ivest）、阿迪·萨莫尔（Adi [S]hamir）和伦纳德·阿德曼（Leonard [A]dleman）
 * </p>
 * <p>
 * 字符串格式的密钥在未在特殊说明情况下都为BASE64编码格式<br/>
 * 由于非对称加密速度极其缓慢，一般文件不使用它来加密而是使用对称加密，<br/>
 * 非对称加密算法可以用来对对称加密的密钥加密，这样保证密钥的安全也就保证了数据的安全
 * </p>
 *
 * @author IceWee
 * @date 2012-4-26
 * @version 1.0
 */
public class Example {



    public static void main(String[] args) throws Exception {
        String privateKey="5fWWGn+1649Qxy+Fd+1Vsw==";


        String source = "r8dJ+ARYA0A3juBKyx5E+4EMuN2rFv2dOMwiHcb0duJ91NhGNEIzkbrDJwAOiGkoLknTC+d5u4cCq9RhB7YA7I6xoji8iCFWRlzThoGcI3meB6jJcVl1kTL1G1ZPUtuRn/5SB4aQYhlm/Q1XNvu4rSk35FB+YSMV9aam5DuGaUvUrAl1PQzSdxa4VT78YCxp9pFkzWdy9AEu51YKErAB7/xgJTWjGnVcc2qIlimOzCKhQ50X2tnX/xbCaaLkM8O9xJ/XpeX+1OFvsWuOaT0ceII0Hg0eOSJguEbT5iX26wsmbOZmPQg8cs5JRLsPp1TLMvimH7pXvqAWejbjHozBDg==";
        byte[] data = source.getBytes();
        byte[] result = RSAUtils.decryptByPrivateKey(data, privateKey);
        System.out.println(result.toString());
        System.out.println(new BASE64Decoder().decodeBuffer(result.toString()));

    }
}