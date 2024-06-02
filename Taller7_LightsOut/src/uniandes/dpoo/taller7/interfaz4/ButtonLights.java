package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uniandes.dpoo.taller7.modelo.Tablero;

@SuppressWarnings("serial")

public class ButtonLights extends JPanel implements MouseListener
{
	private int fila;
	private int columna;
	private Tablero tablero;
	private InterfazLightsOut interfaz;

    public ButtonLights(int fila, int columna, Tablero tablero, InterfazLightsOut interfaz) {
        
    	this.fila = fila;
        this.columna = columna;
        this.tablero = tablero;
        this.interfaz = interfaz;
        setPreferredSize(new Dimension(50, 50)); // Tamaño de la casilla
        setBackground(Color.GRAY); // Color por defecto
        addMouseListener(this); // Agregar el MouseListener a la casilla
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (tablero.darTablero()[fila][columna]) {
            g.setColor(Color.YELLOW); // Casilla encendida
        } else {
            g.setColor(Color.GRAY); // Casilla apagada
        }
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tablero.jugar(fila, columna);
        tablero.salvar_tablero();
        actualizarTablero();
        interfaz.incrementarJugadas();
    }

    private void actualizarTablero() {
        for (int i = 0; i < PanelLightsOut.botones.length; i++) {
            for (int j = 0; j < PanelLightsOut.botones[i].length; j++) {
            	PanelLightsOut.botones[i][j].repaint();
            }
        }
        if (tablero.tableroIluminado()) {
            JOptionPane.showMessageDialog(null, "¡Felicidades! Has iluminado todas las luces.");
        }
    }
    
    

    // Métodos del MouseListener que no se utilizan pero se deben implementar
    
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
