package ihm;
import java.awt.GridLayout;
import javax.swing.*;

public class IHM extends JFrame
{
	public IHM(Panel1 panel1)
	{
		this.setLayout(new GridLayout(4, 1, 5, 5));
		this.setSize(500, 600);

		// Positionnement des composants
		this.add(panel1);

		this.setVisible(true);
	}
}