import java.io.*;
import java.net.*;

public class ServeurSimple2 {
	public static void main(String[] args) {
		System.out.println("Attente d’un client...");
		int port = 9000;

		try (ServerSocket serverSocket = new ServerSocket(port))
		{
			Socket clientSocket = serverSocket.accept();
			System.out.println("Client connecté...");

			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

			Thread reception = new Thread(() ->
			{
				try
				{
					String messageRecu;
					while ((messageRecu = in.readLine()) != null) {
						System.out.println("Client: " + messageRecu);
					}
				} catch (IOException e)
				{
					System.err.println("Erreur de réception : " + e.getMessage());
				}
			});

			reception.start();

			String message;
			while ((message = consoleInput.readLine()) != null)
			{
				out.println(message);
			}
		} catch (IOException e) {
			System.err.println("Erreur du serveur : " + e.getMessage());
		}
	}
}