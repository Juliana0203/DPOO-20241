package uniandes.dpoo.taller7.interfaz3;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PanelSuperior extends JPanel implements ActionListener
{
	//private InterfazLightsOut pantallaPrincipal;
	private JComboBox<String> opcionesTamano;
	private int intDificultad;
	
	public PanelSuperior(ActionListener actionListener) 
	{
		this.setLayout(new FlowLayout());

        JLabel tamano = new JLabel("Tama�o: ", JLabel.LEFT);
        tamano.setFont(new Font("Arial", Font.BOLD, 18));
        tamano.setForeground(Color.GRAY);

        this.add(tamano);
        
        JComboBox<String> opcionesTamano = new JComboBox<String>();
        opcionesTamano.setBackground(Color.WHITE);
        
        opcionesTamano.addItem("4x4");
        opcionesTamano.addItem("5x5");
        opcionesTamano.addItem("6x6");
        opcionesTamano.addItem("7x7");
        opcionesTamano.addItem("8x8");
        opcionesTamano.addItem("9x9");
        
        opcionesTamano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionListener.actionPerformed(e); 
            }
        });

        
        this.add(opcionesTamano);
        
        JLabel dificultad = new JLabel("Dificultad: ", JLabel.RIGHT);
        dificultad.setFont(new Font("Arial", Font.BOLD, 18));
        dificultad.setForeground(Color.GRAY);
        
        this.add(dificultad);
        
        JRadioButton dificil = new JRadioButton("Dif�cil");
        dificil.setFont(new Font("Arial", Font.PLAIN, 18));
        dificil.setForeground(Color.GRAY);
        
        this.add(dificil);
        
        JRadioButton medio = new JRadioButton("Medio");
        medio.setFont(new Font("Arial", Font.PLAIN, 18));
        medio.setForeground(Color.GRAY);
        
        this.add(medio);
        
        JRadioButton facil = new JRadioButton("F�cil");
        facil.setFont(new Font("Arial", Font.PLAIN, 18));
        facil.setForeground(Color.GRAY);
        
        this.add(facil);
        
        ButtonGroup grupoDificultad = new ButtonGroup();
        
        grupoDificultad.add(dificil);
        grupoDificultad.add(medio);
        grupoDificultad.add(facil); 
        
        facil.addActionListener(e -> {
            if (facil.isSelected()) {
                intDificultad = 10;
            }
        });

        medio.addActionListener(e -> {
            if (medio.isSelected()) {
                intDificultad = 20;
            }
        });

        dificil.addActionListener(e -> {
            if (dificil.isSelected()) {
                intDificultad = 30;
            }
        });
        
    
}
	
	public int getDificultad() {
        return intDificultad;
    }

	public String getTama�oSeleccionado() {
	    return (String) opcionesTamano.getSelectedItem();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
