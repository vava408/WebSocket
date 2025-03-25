package ihm;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import websocket.Client;

public class Panel1 extends JPanel implements ActionListener
{
	private JTextField envoieMessage;
	private JButton btnEnvoyer, btnDeconnexion, btnRestart;
	private JTextArea historiqueMessages; // Zone d'affichage des messages reçus
	private JScrollPane scrollHistorique; // Utilisation correcte de JScrollPane
	private String message;

	public Panel1()
	{
		this.setLayout(new BorderLayout());

		// Zone d'affichage des messages avec JScrollPane
		this.historiqueMessages = new JTextArea(10, 30);
		this.historiqueMessages.setEditable(false);
		this.scrollHistorique = new JScrollPane(this.historiqueMessages);
		this.scrollHistorique.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// Champ de texte et bouton d'envoi
		JPanel panelBas = new JPanel();
		this.envoieMessage = new JTextField(20);
		this.btnEnvoyer = new JButton("Envoyer");
		this.btnDeconnexion = new JButton("Deconexion");
		this.btnRestart = new JButton("Redemarer");

		panelBas.add(this.envoieMessage);
		panelBas.add(this.btnEnvoyer);
		panelBas.add(this.btnDeconnexion);


		// Ajout des composants au panel
		this.add(scrollHistorique, BorderLayout.CENTER);
		this.add(panelBas, BorderLayout.SOUTH);
		this.add(btnRestart, BorderLayout.NORTH);

		// Listeners pour envoyer le message
		this.envoieMessage.addActionListener(this);
		this.btnEnvoyer.addActionListener(this);
		this.btnDeconnexion.addActionListener(this);
		this.btnRestart.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		message = this.envoieMessage.getText().trim();

		//pour envoyer avec le boutton 
		if(e.getSource() == this.btnEnvoyer)
		{
			message = this.envoieMessage.getText().trim();
			if (!message.isEmpty())
			{
				System.out.println("Message envoyé : " + message);
				Client.envoyerMessage(message); // Envoi au serveur
				this.envoieMessage.setText(""); // Nettoyage du champ
				this.update(); // Mise à jour de l'historique
			}
		}

		// pour se deconnecter avec le boutton
		else if (e.getSource() == this.btnDeconnexion)
		{
			Client.Deconnexion();
		}

		// pour redémarrer avec le bouton
		else if(e.getSource() == this.btnRestart)
		{
			Client.restart();
		}
	}

	//uptadde les messges envoyer par le serveur
	public void update(String serveurMessage)
	{
		// Ajoute le message reçu du serveur
		this.historiqueMessages.append("Serveur : " + serveurMessage + "\n");
		// Faire défiler automatiquement vers le bas après l'ajout d'un message
		this.historiqueMessages.setCaretPosition(this.historiqueMessages.getDocument().getLength());
	}

	//update les messages envoyer par le client
	public void update()
	{
		//ajoute le message envoyer par le client
		this.historiqueMessages.append("Client : " + message + "\n");
		// Faire défiler automatiquement vers le bas après l'ajout d'un message
		this.historiqueMessages.setCaretPosition(this.historiqueMessages.getDocument().getLength());
	}
}
