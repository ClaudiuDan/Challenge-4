import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static int port = 2000;
	public static void main (String[] args) throws IOException
	{
		ServerSocket socketServer = new ServerSocket (port);
		Socket socket;
		socket = socketServer.accept();
		String name;
		BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		String string;
		//here I wait for connections
		while (true)
		{
			//if there is something to read I read it
			if (bufferedReader.ready())
			{
				name = bufferedReader.readLine();
				System.out.println("User " + name + " has connected!");
				// I keep waiting for inputs from user
				while (true)
				{
					string = bufferedReader.readLine();
					//if the user wants to disconnect, I exit this while loop
					if (string == null || string.equals("/exit"))
						break;
					System.out.println(string);
				}
				//Look for another user
				socket = socketServer.accept();
				bufferedReader = new BufferedReader (new InputStreamReader (socket.getInputStream()));
			}
		}
	}
}
