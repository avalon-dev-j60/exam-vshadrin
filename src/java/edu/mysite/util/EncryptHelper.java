/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mysite.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author vasha
 */
public class EncryptHelper {
    private EncryptHelper() {}
    
    public static String md5(String source) {
        try { MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte[] bytes = md.digest();
            return new String(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}
