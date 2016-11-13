package com.encodingTest.unicode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/*
 * java字符编码转换研究
 *
 */
public class TestJavaCharset {



	public static void main(String args[]) throws UnsupportedEncodingException{

		String defaultCharset = Charset.defaultCharset().toString();
		System.out.println("default charset: " + defaultCharset);//get the defaultCharset of JVM

		//args[0]=你好abc
		String testStr = args[0]; //string encoding with UTF-8 charset as java file

		//byte[] bytes = testStr.getBytes();//same as use "testStr.getBytes(Charset.defaultCharset())"
		byte[] bytes = testStr.getBytes(defaultCharset);//use defaultCharset
        int cnt = Charset.availableCharsets().size();
		System.out.println("JAVA supports for " + cnt + " kinds of encoding chars.");
		System.out.println("Here is what you've input encoding in default charset:");
		for(byte b : bytes){
			System.out.print(b + " ");
		}
		System.out.println();
		System.out.println(defaultCharset + " encoding result as below:");
		System.out.println(new String(bytes,Charset.defaultCharset()));

		byte[] bytes2 = testStr.getBytes(Charset.forName("GBK"));//convert to byte array with GBK encode
		System.out.println("Here is what you've input if encoding in GBK charset:");
		for(byte b : bytes2){
			System.out.print(b + " ");
		}
		System.out.println();
		System.out.println("GBK encoding result as below:");
		System.out.println(new String(bytes2,"GBK"));
	}


}
