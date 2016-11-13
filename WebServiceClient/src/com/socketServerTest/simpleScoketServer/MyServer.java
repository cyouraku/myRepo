package com.socketServerTest.simpleScoketServer;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer
{

	//This socketServer would only run once due to no multiThread function.
	public static void main(String args[]) throws Exception {

		ServerSocket server = new ServerSocket(9999);
		Socket sock = server.accept();

		//args[0]= Resource/helloWorld.html
		FileInputStream in = new FileInputStream(args[0]);
		OutputStream out = sock.getOutputStream();

		int len = 0;
		byte buffer[] = new byte[1024];

		while((len = in.read(buffer)) > 0){
			out.write(buffer,0,len);
		}

		in.close();
		out.close();
		sock.close();
		server.close();
	}
}