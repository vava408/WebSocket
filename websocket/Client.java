package websocket;

import java.io.*;
import java.net.*;
import javax.swing.*;
import ihm.IHM;
import ihm.Panel1;

public class Client
{
	private static final String HOSTNAME = "localhost";
	private static final int PORTNUMBER = 9000;

	private static String messageRecu;
	private static Panel1 panel1;
	private static PrintWriter out;
	private static Socket socket;

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(Client::launchUI);
		System.out.println("Connexion au serveur...");

		try
		{
			socket = new Socket(HOSTNAME, PORTNUMBER);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("Connecté au serveur");

			// Thread pour la réception des messages
			Thread reception = new Thread(() -> {
				try
				{
					String messageRecu;
					while ((messageRecu = in.readLine()) != null)
					{ // Attente continue
						Client.messageRecu = messageRecu;
						System.out.println("Serveur: " + messageRecu);
						//envoie le message recu a Panel1
						panel1.update(messageRecu);
					}
				} catch (IOException e)
				{
					System.err.println("Erreur de réception : " + e.getMessage());
				}
			});

			reception.start();

		} catch (IOException e)
		{
			System.err.println("Erreur du client : " + e.getMessage());
		}
	}
	
	//methode pour recuperer le message envoyer par le servuers 
	public static String getmessage()
	{
		return messageRecu;
	}

	//permet d'envoyer un message au serveur a partir du message de Panel1
	public static void envoyerMessage(String message)
	{
		if (out != null)
		{
			out.println(message);
		}
	}

	//deconncete l utilisateur 
	public static void Deconnexion() 
	{
		try
		{
			socket.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}	
	//reconnecte l utilisateur
	public static void restart()
	{
		try
		{
			socket = new Socket(HOSTNAME, PORTNUMBER);
			System.out.println("reconnecté avec succès");
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	private static void launchUI()
	{
		panel1 = new Panel1();
		new IHM(panel1);
	}
}
