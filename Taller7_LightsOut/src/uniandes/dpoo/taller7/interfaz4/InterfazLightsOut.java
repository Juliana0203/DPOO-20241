package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

@SuppressWarnings("serial")
public class InterfazLightsOut extends JFrame 
{
    private PanelSuperior panelSuperior;
    private PanelDerecho panelDerecho;
    private PanelInferior panelInferior;

    private PanelLightsOut panelTablero;
    private int tamañoActual;
    private int dificultadActual;
    private Top10 top10Registros;
    private Tablero tableroActual;
    private String jugadorActual = "Juanito";
    private Map<String, Integer> jugadasPorJugador;

    public InterfazLightsOut() 
    {
    	
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

        panelDerecho = new PanelDerecho(
        		e -> {
        	        inicializarTablero(tamañoActual, dificultadActual);
        	        reiniciarJugadas();
        	    },
        	    e -> tableroActual.reiniciar(),
        	    e -> mostrarTop10(),
        	    e -> cambiarJugador()
        	);
        
        
        panelDerecho.setVisible(true);
        add(panelDerecho, BorderLayout.EAST);

        panelInferior = new PanelInferior();
        panelInferior.setVisible(true);
        add(panelInferior, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        jugadorActual = "Juanito";
        jugadasPorJugador = new HashMap<>();
        
    }
    
    
    private void cambiarJugador() {
        String nuevoNombre = JOptionPane.showInputDialog("Ingrese nuevo nombre:");
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            jugadorActual = nuevoNombre;
            jugadasPorJugador.putIfAbsent(jugadorActual, 0); // Inicializa a 0 si es un jugador nuevo
            panelInferior.setNombreJugador(jugadorActual);
            panelInferior.setJugadas(jugadasPorJugador.get(jugadorActual));
        }
    }

    public void incrementarJugadas() {
        int jugadas = jugadasPorJugador.getOrDefault(jugadorActual, 0);
        jugadasPorJugador.put(jugadorActual, jugadas + 1);
        panelInferior.setJugadas(jugadas + 1);
    }


    private void inicializarTablero(int tamaño, int dificultad) {
        if (panelTablero != null) {
            remove(panelTablero);
        }
        Tablero tablero = new Tablero(tamaño);
        tablero.desordenar(dificultad); // Dificultad seleccionada
        panelTablero = new PanelLightsOut(tamaño, dificultad, this);
        add(panelTablero, BorderLayout.CENTER);
        pack();
        repaint();
    }
    
    private void reiniciarJugadas() {
        jugadasPorJugador.put(jugadorActual, 0);
        panelInferior.setJugadas(0);
    }
    
    private void mostrarTop10() {
        if (top10Registros == null) {
            // Si top10Registros no está inicializado, no se puede mostrar nada
            return;
        }

        // Cargar los registros desde el archivo (si no se han cargado ya)
        if (top10Registros.darRegistros().isEmpty()) {
            File archivo = new File("top10.txt");
            top10Registros.cargarRecords(archivo);
        }

        if (top10Registros.darRegistros().isEmpty()) {
            // Si la lista de registros está vacía, mostrar un mensaje
            JOptionPane.showMessageDialog(this, "No hay jugadores en el top 10.", "Top 10 Vacío", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JDialog dialog = new JDialog(this, "Top 10 Jugadores", true);
        dialog.setSize(300, 400);
        dialog.setLayout(new BorderLayout());

        JTextArea areaTop10 = new JTextArea();
        for (RegistroTop10 registro : top10Registros.darRegistros()) {
            areaTop10.append(registro.toString() + "\n");
        }
        areaTop10.setEditable(false);
        dialog.add(new JScrollPane(areaTop10), BorderLayout.CENTER);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazLightsOut());
    }
}



