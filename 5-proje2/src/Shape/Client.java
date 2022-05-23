package Shape;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.*;
import java.util.concurrent.TimeUnit;

public class Client extends Thread{

	public Socket sock;
	public DataInputStream din;
	public DataOutputStream dout;
	String msgin="";
	String msgout="connection success";
	int delay=1;
	public Client(String host,int port) {
		try {
			sock=new Socket("127.0.0.1",5001);
			System.out.println("Client Port No: "+port+" olusturuldu");
			
		} catch (Exception e) {
			System.out.println("Client olusturulamadi!");
		}
		
	}
	
	@Override
	public void run() {
		try {
			dout.writeUTF(msgout);
			while(!msgin.equals("end")) {
								
				msgin=din.readUTF();
				System.out.println(msgin);
				TimeUnit.SECONDS.sleep(delay);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
