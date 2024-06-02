package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelInferior extends JPanel
{
	private JLabel jugador;
	private JLabel contador;
	private JLabel jugadas;
	private JLabel nombre;
	
	public PanelInferior()
	{
        
		jugador = new JLabel("Jugador: ", JLabel.LEFT);
		jugador.setFont(new Font("Arial", Font.BOLD, 14));
		jugador.setForeground(Color.GRAY);
		
		this.add(jugador);
		
		nombre = new JLabel("Junito");
		nombre.setFont(new Font("Arial", Font.PLAIN, 14));
		nombre.setForeground(Color.GRAY);
		
		this.add(nombre);
		
		jugadas = new JLabel("Jugadas: ", JLabel.RIGHT);
		jugadas.setFont(new Font("Arial", Font.BOLD, 14));
		jugadas.setForeground(Color.GRAY);
		
		this.add(jugadas);
		
		contador = new JLabel("0");
		contador.setFont(new Font("Arial", Font.PLAIN, 14));
		contador.setForeground(Color.GRAY);
		
		this.add(contador);
		
		this.setLayout(new FlowLayout());
        this.setBackground(Color.WHITE);
	}
	

}
