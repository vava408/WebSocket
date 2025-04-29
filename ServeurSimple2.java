import java.io.*;
import java.net.*;

public class ServeurSimple2
{
	public static void main(String[] args)
	{
		System.out.println("Attente d’un client...");
		int port = 9000;

		try (ServerSocket serverSocket = new ServerSocket(port))
		{
			while (true)
			{ // Garder le serveur actif
				try
				{
					Socket clientSocket = serverSocket.accept();
					System.out.println("Client connecté...");

					// Gestion de la connexion dans un thread séparé
					new Thread(new ClientHandler(clientSocket)).start();
				} catch (IOException e)
				{
					System.err.println("Erreur avec un client : " + e.getMessage());
				}
			}
		} catch (IOException e)
		{
			System.err.println("Erreur du serveur : " + e.getMessage());
		}
	}
}

class ClientHandler implements Runnable
{
	private Socket clientSocket;

	public ClientHandler(Socket socket)
	{
		this.clientSocket = socket;
	}
	//gere les differente connexion. Il n est pas 
	@Override
	public void run()
	{
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

			Thread reception = new Thread(() -> {
				try
				{
					String messageRecu;
					while ((messageRecu = in.readLine()) != null)
					{
						System.out.println("Client: " + messageRecu);
					}
				} catch (IOException e)
				{
					System.err.println("Connexion terminée par le client.");
				}
			});

			reception.start();

			String message;
			while ((message = consoleInput.readLine()) != null)
			{
				out.println(message);
			}

			clientSocket.close(); // Fermer proprement la connexion
		} catch (IOException e)
		{
			System.err.println("Erreur de communication avec le client : " + e.getMessage());
		}
	}
}
