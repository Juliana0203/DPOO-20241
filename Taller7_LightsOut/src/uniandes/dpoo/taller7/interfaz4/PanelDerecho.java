package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelDerecho extends JPanel
{
	
	private JButton nuevo;
	private JButton reiniciar;
	private JButton top10;
	private JButton nuevoJugador;
	
	public PanelDerecho (ActionListener inicializarListener, ActionListener reiniciarListener, ActionListener top10Listener, ActionListener cambiarJugadorListener)
	{
		this.setLayout(new GridLayout(4, 1, 0, 150)); 
            
		nuevo = new JButton("NUEVO");
        nuevo.setFont(new Font("Arial", Font.PLAIN, 14));
        nuevo.setForeground(Color.GRAY);
        nuevo.addActionListener(inicializarListener);  
        this.add(nuevo);
        
        reiniciar = new JButton("REINICIAR");
        reiniciar.setFont(new Font("Arial", Font.PLAIN, 14));
        reiniciar.setForeground(Color.GRAY);
        reiniciar.addActionListener(reiniciarListener);  
        this.add(reiniciar);
        
        top10 = new JButton("TOP - 10");
        top10.setFont(new Font("Arial", Font.PLAIN, 14));
        top10.setForeground(Color.GRAY);
        top10.addActionListener(top10Listener);  
        this.add(top10);
        
        nuevoJugador = new JButton("CAMBIAR JUGADOR");
        nuevoJugador.setFont(new Font("Arial", Font.PLAIN, 14));
        nuevoJugador.setForeground(Color.GRAY);
        nuevoJugador.addActionListener(cambiarJugadorListener);  
        this.add(nuevoJugador);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
