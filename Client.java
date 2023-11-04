

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket sock = new Socket("localhost", 5656);//connecting to the server
			DataInputStream input = new DataInputStream(sock.getInputStream());
			DataOutputStream output = new DataOutputStream(sock.getOutputStream());
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			
			String str1="",str2="";
			
			while(!str1.equals("end")) { //terminate the program by entering end
				System.out.print("CHAT: ");//entering message for the server
				str1 = reader.readLine();
				output.writeUTF(str1);
				output.flush();
				str2=input.readUTF();
				System.out.println("SERVER REPLY: "+ str2);//showing server reply
			}
			output.close();
			sock.close();
		}catch(Exception ex) {
			System.out.print(ex);
		}
	}

}
