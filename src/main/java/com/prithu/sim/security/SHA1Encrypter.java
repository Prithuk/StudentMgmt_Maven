package com.prithu.sim.security;

import java.security.MessageDigest;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class SHA1Encrypter {

    /**
     * @param plainText text to encrypt
     * @return encrypted hash of plainText on @param
     *
     */
    public static String getEncrypted(String plainText) {
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
            byte[] result = mDigest.digest(plainText.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param plainText
     * @param encrypted
     * @return true if plainText hash and encrypted are equal
     */
    public static boolean isEqual(String plainText, String encrypted) {
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
            byte[] result = mDigest.digest(plainText.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }
            if (sb.toString().equals(encrypted)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
