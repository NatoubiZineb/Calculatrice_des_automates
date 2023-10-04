package Presentation;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import backEnd.AFD;

public class Generisation extends JFrame {
	private JPanel contentPane;
	private JTextField InputLongueurMot;
	public static AFD afd;
	public Generisation() throws HeadlessException {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("entrez la longueur des mots à generer par l'automate ");
		lblNewLabel.setBounds(31, 50, 500, 13);
		contentPane.add(lblNewLabel);
		
		InputLongueurMot= new JTextField();
		InputLongueurMot.setBounds(202, 60, 96, 19);
		contentPane.add(InputLongueurMot);
		InputLongueurMot.setColumns(10);
		
		JButton GenererMotbtn = new JButton("Génerer");
		GenererMotbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer longeur=Integer.parseInt(InputLongueurMot.getText());
				afd=Acceuill.afnd.determinize();
				System.out.println(afd.genererMots(longeur));
				// Créer un modèle de liste (DefaultListModel) pour contenir les éléments de l'ensemble
		        DefaultListModel<String> model = new DefaultListModel<>();
		        for (String element : afd.genererMots(longeur)) {
		            model.addElement(element);
		        }

		        // Créer un composant de liste (JList) avec le modèle de liste
		        JList<String> list = new JList<>(model);

		        // Créer une barre de défilement (JScrollPane) pour la liste
		        JScrollPane scrollPane = new JScrollPane(list);

		        // Créer une fenêtre (JFrame) et ajouter la barre de défilement à son contenu
		        JFrame frame = new JFrame("Affichage d'un Set");
		        frame.getContentPane().add(scrollPane);

		        // Configurer la fenêtre
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setSize(300, 200);
		        frame.setVisible(true);
		    }
			 
		});
		
		GenererMotbtn.setBounds(200, 150, 96, 19);
		contentPane.add(GenererMotbtn);
		
		
	}
	
}
