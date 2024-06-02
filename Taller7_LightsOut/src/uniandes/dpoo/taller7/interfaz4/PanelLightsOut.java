package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;

@SuppressWarnings("serial")
public class PanelLightsOut extends JPanel 
{
	public static ButtonLights[][] botones;
    private Tablero tablero;

    private InterfazLightsOut interfaz;

    public PanelLightsOut(int tamaño, int dificultad, InterfazLightsOut interfaz) 
    {
        tablero = new Tablero(tamaño);
        tablero.desordenar(dificultad); // Desordenar con la dificultad especificada
        setLayout(new GridLayout(tamaño, tamaño));
        botones = new ButtonLights[tamaño][tamaño];

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                botones[i][j] = new ButtonLights(i, j, tablero, interfaz);
                
                
                add(botones[i][j]);
            }
        }
    }

    public static ButtonLights[][] getBotones() {
        return botones;
    }

    public void actualizarTablero() {
        for (int i = 0; i < PanelLightsOut.getBotones().length; i++) {
            for (int j = 0; j < PanelLightsOut.getBotones()[i].length; j++) {
                PanelLightsOut.getBotones()[i][j].repaint();
            }
        }
        if (tablero.tableroIluminado()) {
            JOptionPane.showMessageDialog(null, "¡Felicidades! Has iluminado todas las luces.");
        }
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
