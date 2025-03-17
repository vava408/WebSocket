package websocket;

import java.io.*;
import java.net.*;
import javax.swing.*;
import ihm.IHM;
import ihm.Panel1;

public class Client
{
	private static String messageRecu;
	private static Panel1 panel1;
	private static PrintWriter out;

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(Client::launchUI);

		String hostName = "localhost";
		int portNumber = 9000;

		System.out.println("Connexion au serveur...");

		try
		{
			Socket socket = new Socket(hostName, portNumber);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("Connecté au serveur");

			Thread reception = new Thread(() -> {
				try
				{
					String messageRecu;
					while ((messageRecu = in.readLine()) != null)
					{ // Attente continue
						Client.messageRecu = messageRecu;
						System.out.println("Serveur: " + messageRecu);
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

	public static String getmessage()
	{
		return messageRecu;
	}

	public static void envoyerMessage(String message)
	{
		if (out != null)
		{
			out.println(message);
		}
	}

	private static void launchUI()
	{
		panel1 = new Panel1();
		new IHM(panel1);
	}
}
