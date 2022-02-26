import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        Socket new_socket = new Socket("localhost", 5678);
        System.out.println("Connection complete!");

        DataInputStream data_in = new DataInputStream(new_socket.getInputStream());
        DataOutputStream data_out = new DataOutputStream(new_socket.getOutputStream());

        System.out.println((String) data_in.readUTF());

        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        data_out.writeInt(number);
        data_out.flush();

        System.out.println((String) data_in.readUTF());

        number = in.nextInt();
        data_out.writeInt(number);
        data_out.flush();

        System.out.println((String) data_in.readUTF());

        new_socket.close();
    }
}