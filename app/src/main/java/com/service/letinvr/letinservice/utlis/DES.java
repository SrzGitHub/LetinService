
package com.service.letinvr.letinservice.utlis;


import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DES {

    /**
     * 加密KEY
     */
    private static final byte[] KEY = "Y8JGNU4QX4qpNYvP".getBytes();
    /**
     * IV
     */
    private static final byte[] IV = "UxYwE6ra".getBytes();
    /**
     * 算法
     */
    private static final String ALGORITHM = "DES";

    /**
     * TRANSFORMATION
     */
    private static final String TRANSFORMATION = "DES/CBC/PKCS5Padding";

    /**
     * DES算法，加密
     * @param data 待加密字符串
     * @return 加密后的字节数组，一般结合Base64编码使用
     */
    public static String encode( String data) throws Exception {
        return encode(data.getBytes());
    }
    /**
     * DES算法，加密
     * @param data  待加密字符串
     * @return 加密后的字节数组，一般结合Base64编码使用
     *             异常
     */
    private static String encode(byte[] data) throws Exception {
        try {
            DESKeySpec dks = new DESKeySpec(KEY);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            IvParameterSpec iv = new IvParameterSpec(IV);
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] bytes = cipher.doFinal(data);
            LogToFile.e("Srz_    --->   "+new String(bytes));
            return /*Base64.encodeToString(bytes,false);*/ Base64Utils.encode(bytes);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    /**
     * DES算法，解密
     * @param data  待解密字符串
     * @return 解密后的字节数组
     */
    private static byte[] decode( byte[] data) throws Exception {
        try {
            DESKeySpec dks = new DESKeySpec(KEY);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            IvParameterSpec iv = new IvParameterSpec(IV);
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }



}
