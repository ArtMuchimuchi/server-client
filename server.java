import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket server_socket = new ServerSocket(5678);
        System.out.println("Waiting for connection.");

        Socket new_socket = server_socket.accept();
        System.out.println("Connection complete!");

        DataInputStream data_in = new DataInputStream(new_socket.getInputStream());
        DataOutputStream data_out = new DataOutputStream(new_socket.getOutputStream());

        String str;

        str = "Please, enter first number!";
        data_out.writeUTF(str);
        data_out.flush();
        int numA = data_in.readInt();
        
        str = "Please, enter second number!";
        data_out.writeUTF(str);
        data_out.flush();
        int numB = data_in.readInt();

        str = numA + " x " + numB + " = " + numA*numB;
        data_out.writeUTF(str);
        data_out.flush();

        server_socket.close();
    }
}