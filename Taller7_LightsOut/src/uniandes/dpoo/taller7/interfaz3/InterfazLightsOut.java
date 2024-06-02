package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import uniandes.dpoo.taller7.modelo.Tablero;

@SuppressWarnings("serial")
public class InterfazLightsOut extends JFrame 
{
    private PanelSuperior panelSuperior;
    private PanelDerecho panelDerecho;
    private PanelInferior panelInferior;

    private PanelLightsOut panelTablero;
    private int tamañoActual;
    private int dificultadActual;

    public InterfazLightsOut() {
        setTitle("Juego Lights Out");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 700);
        setVisible(true);
        setResizable(true);

        setLayout(new BorderLayout());
        
        tamañoActual = 4; // Tamaño por defecto
        dificultadActual = 10;
        inicializarTablero(tamañoActual,dificultadActual);

        panelSuperior = new PanelSuperior(e -> {
            String tamañoSeleccionado = panelSuperior.getTamañoSeleccionado();
            int tamaño = Integer.parseInt(tamañoSeleccionado.split("x")[0]);
            int dificultad = panelSuperior.getDificultad();
            inicializarTablero(tamaño,dificultad);
        });

        panelSuperior.setVisible(true);
        add(panelSuperior, BorderLayout.NORTH);

        panelDerecho = new PanelDerecho();
        panelDerecho.setVisible(true);
        add(panelDerecho, BorderLayout.EAST);

        panelInferior = new PanelInferior();
        panelInferior.setVisible(true);
        add(panelInferior, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarTablero(int tamaño, int dificultad) {
        if (panelTablero != null) {
            remove(panelTablero);
        }
        Tablero tablero = new Tablero(tamaño);
        tablero.desordenar(dificultad); // Dificultad seleccionada
        panelTablero = new PanelLightsOut(tamaño, dificultad);
        add(panelTablero, BorderLayout.CENTER);
        pack();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazLightsOut());
    }
}



