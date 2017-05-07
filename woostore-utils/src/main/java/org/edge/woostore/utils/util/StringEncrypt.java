package org.edge.woostore.utils.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * @ClassName: StringEncrypt 
 * @Description: TODO
 * @author Administrator 
 * @date 2017年3月14日 上午9:09:51 
 *  
 */
public class StringEncrypt {

	public static String Encrypt(String strSrc, String encName) {
        MessageDigest md = null;
        String strDes = null;

        byte[] bt = strSrc.getBytes();
        try {
            if (encName == null || encName.equals("")) {
                encName = "SHA-256";
            }
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp ;
        for (byte bt : bts) {
            tmp = (Integer.toHexString(bt & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}