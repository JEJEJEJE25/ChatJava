

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket serversock = new ServerSocket(5656);//connecting to the port
			Socket sock = serversock.accept();//accepting connection
			System.out.println("A Client has Join the server");
			DataInputStream input = new DataInputStream(sock.getInputStream());
			DataOutputStream output = new DataOutputStream(sock.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String str1="",str2="";

			while(!str1.equals("end")) { //end means terminate
				str1 = input.readUTF();
				System.out.println("CLient CHAT: "+str1);//display the client message
				System.out.print("REPLY: "); //Entering the client reply
				str2 = reader.readLine();
				output.writeUTF(str2);
				output.flush();
			}
			input.close();
			sock.close();
			serversock.close();
		}catch(Exception ex) {
			System.out.print(ex);
		}
	}

}
