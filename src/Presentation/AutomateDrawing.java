package Presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class AutomateDrawing extends JPanel {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessiner les états de l'automate
        g.setColor(Color.GRAY);
        g.fillOval(50, 50, 100, 100); // État initial
        g.setColor(Color.GRAY);
        g.fillOval(250, 50, 100, 100); // État final
        
        // Dessiner les périmètres de cercle supplémentaires pour les états finaux
        g.setColor(Color.BLACK);
        g.drawOval(240, 40, 120, 120); // Périmètre extérieur
        g.drawOval(260, 60, 80 , 80); // Périmètre intérieu
        
        // Dessiner la flèche pointant vers l'état initial
        int[] arrowX = { 30, 40, 40 };
        int[] arrowY = { 100, 90, 110 };
        g.setColor(Color.BLACK);
        g.fillPolygon(arrowX, arrowY, 3);
        
        // Dessiner les transitions de l'automate
        g.setColor(Color.BLACK);
        g.drawLine(150, 100, 250, 100); // Transition entre les états initial et final

        // Dessiner les étiquettes des états
        g.setColor(Color.WHITE);
        g.drawString("q0", 90, 110); // Étiquette de l'état initial
        g.drawString("q1", 290, 110); // Étiquette de l'état final
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
}

