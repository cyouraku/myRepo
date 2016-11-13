package com.encodingTest.unicode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileTest {

	public static void main(String[] args) throws IOException {

//		File f = new File("Resource/helloWorld.html");
		//args[0]= Resource/helloWorld.html
		File f = new File(args[0]);
		InputStream in = null;
		byte[] data = new byte[(int)f.length()];

		in = new FileInputStream(f);
		int len = 0;
		int read;

		System.out.println("以字节为单位读取文件内容，一次读一个字节");
		while((read = in.read()) != -1){
			data[len++] = (byte)read;
			// 单个输出,非汉字正确输出.转换成字符输出  
			System.out.write(read);
		}

		String result = new String(data,0,len);
		System.out.println(result);

		in.close();
	}

}
