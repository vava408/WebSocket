import java.io.*;
import java.net.*;
import java.util.*;

public class ServeurSimple2
{
	// Liste partagée des flux de sortie des clients connectésu tilisée pour
	// diffuser les messages à tous les clients
	private static final List<PrintWriter> clients = Collections.synchronizedList(new ArrayList<>());

	public static void main(String[] args)
	{
		System.out.println("Attente d’un client...");
		int port = 9000; // Port sur lequel le serveur écoute les connexions

		// Création du serveur socket
		try (ServerSocket serverSocket = new ServerSocket(port))
		{
			// Boucle infinie pour accepter les connexions des clients
			while (true)
			{
				try
				{
					// Accepter une connexion client
					Socket clientSocket = serverSocket.accept();
					System.out.println("Client connecté...");

					// Déléguer la gestion de la connexion à un thread séparé
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

	// Classe interne pour gérer les connexions des clients
	static class ClientHandler implements Runnable
	{
		private Socket clientSocket; // Socket pour communiquer avec le client
		private PrintWriter out; // Flux de sortie pour envoyer des messages au
									// client

		// Constructeur pour initialiser le socket du client
		public ClientHandler(Socket socket)
		{
			this.clientSocket = socket;
		}

		@Override
		public void run()
		{
			try
			{
				// Création des flux d'entrée et de sortie pour le client
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new PrintWriter(clientSocket.getOutputStream(), true);

				// Ajouter le flux de sortie du client à la liste partagée
				synchronized (clients)
				{
					clients.add(out);
				}

				String messageRecu; // Variable pour stocker les messages reçus
				// Boucle pour lire les messages envoyés par le client
				while ((messageRecu = in.readLine()) != null)
				{
					System.out.println("Client: " + messageRecu);

					// Diffuser le message à tous les autres clients connectés
					synchronized (clients)
					{
						for (PrintWriter clientOut : clients)
						{
							if (clientOut != out)
							{
								// Ne pas renvoyer le message au client émetteur
								clientOut.println("Client: " + messageRecu);
							}
						}
					}
				}
			} catch (IOException e)
			{
				// Gestion des erreurs de connexion
				System.err.println("Connexion terminée par le client.");
			} finally
			{
				// Supprimer le client de la liste lors de la déconnexion
				synchronized (clients)
				{
					clients.remove(out);
				}

				// Fermer le socket du client
				try
				{
					clientSocket.close();
				} catch (IOException e)
				{
					System.err.println("Erreur lors de la fermeture du socket : " + e.getMessage());
				}
			}
		}
	}
}
