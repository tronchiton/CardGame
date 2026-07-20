package Visual;

import BoardGame.Write.Write;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Pantalla de menu principal. Muestra la imagen de fondo (Assets/UI/MainMenu.png),
 * un selector de numero de jugadores y un boton para arrancar la partida.
 */
public class MainMenuUI extends JPanel {

    private static final int MIN_JUGADORES = 2;
    private static final int MAX_JUGADORES = 6;

    private int jugadores = 2;
    private final Image fondo;
    private JLabel contadorLabel;

    public MainMenuUI() {
        this.setLayout(null);
        this.setBounds(0, 0, 1920, 1080);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);

        fondo = new ImageIcon("Assets/UI/MainMenu.png").getImage();

        construirTitulo();
        construirSelectorJugadores();
        construirBotonJugar();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        // Nearest neighbor para mantener el estilo pixel-art al escalar la imagen pequena a pantalla completa
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2D.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }

    private void construirTitulo() {
        JLabel titulo = new JLabel("PELEA DE CASTILLOS", SwingConstants.CENTER);
        titulo.setFont(Write.loadFont("pixel", 60));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(0, 200, 1920, 90);
        this.add(titulo);
    }

    private void construirSelectorJugadores() {
        JLabel etiqueta = new JLabel("JUGADORES", SwingConstants.CENTER);
        etiqueta.setFont(Write.loadFont("pixel", 26));
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setBounds(810, 560, 300, 40);
        this.add(etiqueta);

        contadorLabel = new JLabel(String.valueOf(jugadores), SwingConstants.CENTER);
        contadorLabel.setFont(Write.loadFont("pixel", 40));
        contadorLabel.setForeground(Color.WHITE);
        contadorLabel.setBounds(920, 610, 80, 60);
        this.add(contadorLabel);

        JButton menos = crearBotonPaso("-", -1);
        menos.setBounds(800, 615, 60, 50);
        this.add(menos);

        JButton mas = crearBotonPaso("+", 1);
        mas.setBounds(1060, 615, 60, 50);
        this.add(mas);
    }

    private void construirBotonJugar() {
        JButton jugar = new JButton("JUGAR");
        estilizarBoton(jugar, 30);
        jugar.setBounds(860, 730, 200, 70);
        jugar.addActionListener(e -> Main.startGame(jugadores));
        this.add(jugar);
    }

    private JButton crearBotonPaso(String texto, int delta) {
        JButton boton = new JButton(texto);
        estilizarBoton(boton, 28);
        boton.addActionListener(e -> {
            jugadores = Math.max(MIN_JUGADORES, Math.min(MAX_JUGADORES, jugadores + delta));
            contadorLabel.setText(String.valueOf(jugadores));
        });
        return boton;
    }

    private void estilizarBoton(JButton boton, float tamanoFuente) {
        boton.setFont(Write.loadFont("pixel", tamanoFuente));
        boton.setForeground(Color.WHITE);
        boton.setBackground(new Color(60, 40, 25));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);

        Color base = boton.getBackground();
        Color hover = base.brighter();

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(base);
            }
        });
    }
}