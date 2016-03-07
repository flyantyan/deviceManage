package com.nuc.device.util;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {
	private static final String PREFIX="encrypt_";
	private static final String UNICODE="UTF-8";

	private Base64Util() {
	}
 
	
	//解密
	public static String decrypt(String data) {
		try {
			if (StringTools.isEmpty(data)) {
				return data;
			} else if (data.startsWith(PREFIX)) {
				return new String(Base64.decodeBase64(data.replaceFirst(PREFIX, "")),UNICODE) ;
			}
		}catch (Exception e) {
			return data;
		}
		return data;
	}

	//加密
	public static String encrypt(String data) {
		try {
			if (StringTools.isEmpty(data)) {
				return data;
			} else {
				return PREFIX + Base64.encodeBase64String(data.getBytes(UNICODE));
			}
		}catch (Exception e) {
			return data;
		}
	}
	 
}
