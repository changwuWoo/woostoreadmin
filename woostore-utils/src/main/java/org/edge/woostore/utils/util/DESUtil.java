package org.edge.woostore.utils.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESUtil {
	private String keyData = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstwxyz0123456789-_.";

	public DESUtil() {
	}

	/*
	    * 
	    */
	public DESUtil(String key) {
		this.keyData = key;
	}

	/*
	     * 
	     */
	public String encrypt(String source) throws UnsupportedEncodingException {
		return encrypt(source, "UTF-8");
	}

	/*
	     * 
	     */
	public String decrypt(String encryptedData)
			throws UnsupportedEncodingException {
		return decrypt(encryptedData, "UTF-8");
	}

	/*
	     * 
	     */
	public String encrypt(String source, String charSet)
			throws UnsupportedEncodingException {
		String encrypt = null;
		byte[] ret = encrypt(source.getBytes(charSet));
		encrypt = new String(Base64.encode(ret));
		return encrypt;
	}

	/*
	     * 
	     */
	public String decrypt(String encryptedData, String charSet)
			throws UnsupportedEncodingException {
		String descryptedData = null;
		byte[] ret = descrypt(Base64.decode(encryptedData.toCharArray()));
		descryptedData = new String(ret, charSet);
		return descryptedData;
	}

	/*
	     * 
	     */
	private byte[] encrypt(byte[] primaryData) {

		byte rawKeyData[] = getKey();

		SecureRandom sr = new SecureRandom();

		DESKeySpec dks = null;
		try {
			dks = new DESKeySpec(keyData.getBytes());
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		SecretKeyFactory keyFactory = null;
		try {
			keyFactory = SecretKeyFactory.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		SecretKey key = null;
		try {
			key = keyFactory.generateSecret(dks);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}

		try {
			cipher.init(Cipher.ENCRYPT_MODE, key, sr);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		byte encryptedData[] = null;
		try {
			encryptedData = cipher.doFinal(primaryData);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return encryptedData;
	}

	private byte[] descrypt(byte[] encryptedData) {

		SecureRandom sr = new SecureRandom();

		byte rawKeyData[] = getKey();

		DESKeySpec dks = null;
		try {
			dks = new DESKeySpec(keyData.getBytes());
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		SecretKeyFactory keyFactory = null;
		try {
			keyFactory = SecretKeyFactory.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		SecretKey key = null;
		try {
			key = keyFactory.generateSecret(dks);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}

		try {
			cipher.init(Cipher.DECRYPT_MODE, key, sr);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		byte decryptedData[] = null;
		try {
			decryptedData = cipher.doFinal(encryptedData);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return decryptedData;
	}

	private byte[] getKey() {

		SecureRandom sr = new SecureRandom();

		KeyGenerator kg = null;
		try {
			kg = KeyGenerator.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		kg.init(sr);

		SecretKey key = kg.generateKey();

		byte rawKeyData[] = key.getEncoded();

		return rawKeyData;
	}

	public static void main(final String[] args) {
		DESUtil k = new DESUtil();
		try {
			System.out.println(k.encrypt("Administrator"));
			System.out.println(k.decrypt("jGCG+dzF/6k="));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
