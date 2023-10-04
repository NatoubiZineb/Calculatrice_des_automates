package Presentation;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.Renderer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

public class AutomateExample {

    public static final String AUTOMATE_DATA = "digraph G { " +
            "    A -> B [label=\"a\"];" +
            "    B -> C [label=\"b\"];" +
            "    C -> A [label=\"c\"];" +
            "}";

    public void generateAutomateImage(String automateData) {
        // Créer un objet Graphviz à partir de la chaîne de caractères représentant l'automate
        Graphviz graphviz = Graphviz.fromString(automateData);

        // Générer l'image de l'automate au format PNG
        Renderer renderer = graphviz.render(Format.PNG);
        try {
            // Enregistrer l'image dans un fichier
            renderer.toFile(new File("automate.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afficherAutomateImage() {
        // Charger l'image de l'automate
        ImageIcon imageIcon = new ImageIcon("automate.png");

        // Créer une étiquette pour afficher l'image
        JLabel imageLabel = new JLabel(imageIcon);

        // Créer une fenêtre et ajouter l'étiquette à son contenu
        JFrame frame = new JFrame("Automate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(imageLabel);
        frame.pack();
        frame.setVisible(true);
    }

    
}

