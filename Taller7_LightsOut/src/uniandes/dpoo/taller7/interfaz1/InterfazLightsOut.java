package uniandes.dpoo.taller7.interfaz1;


import javax.swing.JFrame;


@SuppressWarnings("serial")
public class InterfazLightsOut extends JFrame
{
	public InterfazLightsOut() 
	{	
	setTitle("Juego Lights Out");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(1000,700);
	setVisible(true);
	setResizable(true);
}
	public static void main(String[]args)
	{
		new InterfazLightsOut();
	}
}
