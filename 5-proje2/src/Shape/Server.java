package Shape;

import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class Server extends Thread{
	public ServerSocket serverSocket=null;
	public Socket sock;
	public DataInputStream din;
	public DataOutputStream dout;
	public int port;
	public String msgout="";
	public 	String msgin="";
	public Shape[] shapes;
	int delay=1;
	public Server(int port) {
		this.port=port;
		try {
			serverSocket=new ServerSocket(port);
			System.out.println("Server Port No: "+port+" olusturuldu");
			
		} catch (Exception e) {
			System.out.println("Server olusturulamadi!");
		}
	}
	
	public void run() {
		try {
			
			
			System.out.println(this.port+" listening!");
			this.sock=serverSocket.accept();
			 this.din=new DataInputStream(sock.getInputStream());
			 this.dout=new  DataOutputStream(sock.getOutputStream());
			
		
		
			msgin=din.readUTF();
			
		
			while(!msgin.equals("end")) {
				String data="";
				for(Shape shape : shapes ) {
					data+=shape.getShapeInfo();
				}	
				msgout=data;
				dout.writeUTF(msgout);
				dout.flush();
				TimeUnit.SECONDS.sleep(delay);
			}
			sock.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}
	
}
