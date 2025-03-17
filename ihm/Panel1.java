package ihm;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import websocket.Client;

public class Panel1 extends JPanel implements ActionListener
{
	private JLabel labMess;
	private JTextField envoieMessage;
	private JButton btnEnvoyer;
	private JTextArea historiqueMessages; // Zone d'affichage des messages reçus

	public Panel1()
	{
		this.setLayout(new BorderLayout());

		// Zone d'affichage des messages
		this.historiqueMessages = new JTextArea(10, 30);
		this.historiqueMessages.setEditable(false);
		this.add(new JScrollPane(this.historiqueMessages), BorderLayout.CENTER);

		// Champ de texte et bouton d'envoi
		JPanel panelBas = new JPanel();
		this.envoieMessage = new JTextField(20);
		this.btnEnvoyer = new JButton("Envoyer");
		panelBas.add(this.envoieMessage);
		panelBas.add(this.btnEnvoyer);
		this.add(panelBas, BorderLayout.SOUTH);

		// Listeners pour envoyer le message
		this.envoieMessage.addActionListener(this);
		this.btnEnvoyer.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String message = this.envoieMessage.getText().trim();
		if (!message.isEmpty())
		{
			System.out.println("Message envoyé : " + message);
			Client.envoyerMessage(message); // Envoi au serveur
			this.envoieMessage.setText(""); // Nettoyage du champ
		}
	}

	public void update(String message)
	{
		this.historiqueMessages.append("Serveur : " + message + "\n");
	}
}
