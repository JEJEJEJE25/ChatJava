

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serversock = new ServerSocket(6868);
			Socket sock = serversock.accept();
			DataInputStream input = new DataInputStream(sock.getInputStream());
			DataOutputStream output = new DataOutputStream(sock.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			String str =(String)input.readUTF();
			String str1="",str2="";
			while(!str1.equals("end")) {
//				not until someone send end
				str2 = reader.readLine();
				output.writeUTF(str2);
				output.flush();
				System.out.println("The Client Says"+str1);
				
			}
//			System.out.println("Message = "+str1);
			output.close();
			sock.close();
			serversock.close();
		}catch(Exception ex) {
			System.out.print(ex);
		}
	}

}
