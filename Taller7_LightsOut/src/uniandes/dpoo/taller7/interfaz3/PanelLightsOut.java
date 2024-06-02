package uniandes.dpoo.taller7.interfaz3;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;

@SuppressWarnings("serial")
public class PanelLightsOut extends JPanel
{
	public static ButtonLights[][] botones;
    private Tablero tablero;

    public PanelLightsOut(int tamaño, int dificultad) {
        tablero = new Tablero(tamaño);
        tablero.desordenar(dificultad); // Desordenar con la dificultad especificada
        setLayout(new GridLayout(tamaño, tamaño));
        botones = new ButtonLights[tamaño][tamaño];

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                botones[i][j] = new ButtonLights(i, j, tablero);
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
