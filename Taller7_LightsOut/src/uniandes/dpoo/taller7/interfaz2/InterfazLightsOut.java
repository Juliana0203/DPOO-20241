package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class InterfazLightsOut extends JFrame
{
	private PanelSuperior panelSuperior;
	private PanelDerecho panelDerecho;
	private PanelInferior panelInferior;
	
	
	public InterfazLightsOut() 
	{	
	setTitle("Juego Lights Out");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(1000,700);
	setVisible(true);
	setResizable(true);
	
	setLayout(new BorderLayout());
	
	panelSuperior = new PanelSuperior();
	panelSuperior.setVisible(true);
	add(panelSuperior, BorderLayout.NORTH);
	
	panelDerecho = new PanelDerecho();
	panelDerecho.setVisible(true);
	add(panelDerecho, BorderLayout.EAST);
	
	panelInferior = new PanelInferior();
	panelInferior.setVisible(true);
	add(panelInferior, BorderLayout.SOUTH);
}
	public static void main(String[]args)
	{
		SwingUtilities.invokeLater(() -> new InterfazLightsOut());
	}
}