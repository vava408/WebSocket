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
