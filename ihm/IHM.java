package ihm;
import java.awt.GridLayout;
import javax.swing.*;
import ihm.*;

public class IHM extends JFrame
{
	private Panel1 panel;
	public IHM()
	{
		this.panel =new Panel1();
		this.setSize(500, 600);

		// Positionnement des composants
		this.add(panel);

		this.setVisible(true);
	}
}