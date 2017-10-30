import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	static int port;
	static String address;
	public static void main (String[] args) throws UnknownHostException, IOException
	{
		System.out.println("Choose port");
		Scanner scanner = new Scanner (System.in);
		port = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Choose address");
		address = scanner.nextLine();
		Socket socket = new Socket (address, port);
		BufferedWriter bufferedWriter = new BufferedWriter (new OutputStreamWriter(socket.getOutputStream()));	
		String name;
		System.out.println("Choose a name");
		name = scanner.nextLine();
		bufferedWriter.write(name + "\n");
		bufferedWriter.flush();
		String string;
		// I keep sending messages to server, if I want to exit I use /exit
		while (true)
		{
			string = scanner.nextLine();
			bufferedWriter.write(name + ": " + string + "\n");
			bufferedWriter.flush();
			if (string.equals("/exit"))
				break;
		}
	}
}
