package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AutomateDrawer extends JFrame {
    private JButton drawButton;

    public AutomateDrawer() {
        super("Automate Drawer");

        drawButton = new JButton("Dessiner");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer les données de l'automate
                // Appeler l'API en ligne pour le dessin
                // Afficher le résultat dans la fenêtre graphique
            }
        });

        JPanel panel = new JPanel();
        panel.add(drawButton);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
}
