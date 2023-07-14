package edu.global.chat;

import java.net.ServerSocket;
import java.net.Socket;

import edu.global.chat.way.Receiver;
import edu.global.chat.way.Sender;

public class ChatTcpServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(8888); // 포트번호
			System.out.println("서버가 준비되었습니다.");
			socket = serverSocket.accept();
			//System.out.println("연결되었습니다." + socket.getInetAddress().getHostName());
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
