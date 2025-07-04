package com.yond.se.juc.multiThreadedDesign.p7_threadPerMessage.exercise6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Service {
	private Service() {}
	public static void service(Socket clientSocket) throws IOException {
		System.out.println(Thread.currentThread().getName() + ": Service.service(" + clientSocket + ") BEGIN");
		try {
			DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
			out.writeBytes("HTTP/1.0 200 OK\r\n");
			out.writeBytes("Content-type: text/html\r\n");
			out.writeBytes("\r\n");
			out.writeBytes("<html><head><title>Countdown</title></head><body>");
			out.writeBytes("<h1>Countdown start!</h1>");
			for (int i = 10; i >= 0; i--) {
				System.out.println(Thread.currentThread().getName() + ": Countdown i= " + i);
				out.writeBytes("<h1>" + i + "</h1>");
				out.flush();
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}
			out.writeBytes("</body></html>");
		} finally {
			clientSocket.close();
		} 
		System.out.println(Thread.currentThread().getName() + ": Service.service(" + clientSocket + ") END");
	}
}
