package com.encodingTest.unicode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/*
 *Simple charset convertor
 * Convert input string of args[0] into requested charset of args[1]
 * 把输入字符串(参数1)转换成输入的编码(参数2)
 *
 *cmd: java CharsetConvertor 你好abc GBK
 */
public class CharsetConvertor {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String inputStr = args[0];
		String requestCharset = args[1];

		byte[] bytes = inputStr.getBytes(Charset.forName(requestCharset));

		System.out.println(requestCharset + " encoding result as below:");
		for(byte b : bytes){
			System.out.print(b + " ");
		}
		System.out.println();
		System.out.println("If in 16 digits model: ");
		for(int i=0;i<bytes.length;i++){
			int b = bytes[i] & 0x0f;
			System.out.print(Integer.toUnsignedString(b, 16) + " ");//用16位进制表示
		}

		System.out.println();
		System.out.println("The above code means: \r\n" + new String(bytes,requestCharset));

	}


//	    public static String str2HexStr(String str) {    
//	        char[] chars = "0123456789ABCDEF".toCharArray();    
//	        StringBuilder sb = new StringBuilder("");  
//	        byte[] bs = str.getBytes();    
//	        int bit;    
//	        for (int i = 0; i < bs.length; i++) {    
//	            bit = (bs[i] & 0x0f0) >> 4;    
//	            sb.append(chars[bit]);    
//	            bit = bs[i] & 0x0f;    
//	            sb.append(chars[bit]);    
//	        }    
//	        return sb.toString();    
//	    }

	//convert string to hexString cdes
	public static String str2HexStr(String str){
		char[] c = str.toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] b = str.getBytes();
		int bit;
		for(int i=0;i<b.length;i++){
			bit = (b[i] & 0x0f0) >> 4;
			sb.append(c[bit]);
		}

		return sb.toString();
	}

}
