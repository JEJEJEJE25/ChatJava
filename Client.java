

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket sock = new Socket("localhost", 6868);
			DataOutputStream output = new DataOutputStream(sock.getOutputStream());
			DataInputStream input = new DataInputStream(sock.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			String str1="",str2="";
			while(!str1.equals("end")) {
				str1 = reader.readLine();
				output.writeUTF(str1);
				output.flush();
				str2=input.readUTF();
				System.out.println("Server Says "+ str2);
			}
//			output.writeUTF("Hello Server");
//			output.flush();
			output.close();
			sock.close();
		}catch(Exception ex) {
			System.out.print(ex);
		}
	}

}
