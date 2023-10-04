package Presentation;

import backEnd.AFD;
import backEnd.AFND;
import javax.swing.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.List;
import java.util.HashMap;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Acceuill extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("  Veuillez saisir l'automate");
	private static JTextArea contenuTxtArea = new JTextArea();
	public static List<Character> alphabet;
	public static Set<String> etats;
	public static Set<String> etatInitials;
    public static Set<String> etatsFinaux;
    public static Map<String, Map<String, String>> transitions;
    private JTextField InputMot;
    public static AFND afnd=new AFND();
    private JTextField InputLongueurMot;
    public static AFD afd;
 
   
	public Acceuill() {
		//JButton openFileBtn = new JButton("ouvrir un fichier texte");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 80, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		
		contenuTxtArea.setBounds(31, 193, 406, 176);
		contentPane.add(contenuTxtArea);
		
		@SuppressWarnings("unchecked")
		JButton openFileBtn = new JButton("ouvrir un fichier texte");
		
		
		openFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc =new JFileChooser();
				int var =fc.showOpenDialog(null);
				if (var==0) {
					readFile(fc.getSelectedFile().getAbsolutePath());
				}
				
						}
			public static void readFile(String filepath) {
				
				etats = new HashSet<String>();
				List<Character> alphabet = new ArrayList<>();
		        etatInitials= new HashSet<String>();
		        etatsFinaux = new HashSet<String>();
		        transitions = new HashMap<>();
		      Map<String, String> tr1=new HashMap<>();
		        String e[];
		        List<Character> e1 = new ArrayList<>();
		        String cle=null;
				BufferedReader reader;
				FileReader in;
				String ligne;
				try {
					in=new FileReader(new File(filepath));
					reader=new BufferedReader(in);
					do {
						ligne=reader.readLine();
						if(ligne!=null) {
							contenuTxtArea.setText(contenuTxtArea.getText()+ligne+"\n");
						    e=ligne.split(",");
						    for (String s : e) {
						    	for (char s1 : s.toCharArray()) {
						    	 e1.add(s1);
						          }
						    }
						    if(alphabet.size() == 0) {
						       for (char s : e1) { 
						    	   alphabet.add(s);
						    	   afnd.addSymbol(s);
						           }
						    System.out.println("alphabet:"+alphabet); 
						    }
						    else if(etats.size()==0) {
						       for (String s : e) { 
						    	 etats.add(s);
						    	 afnd.addState(s);}
						    System.out.println("etats:"+etats); 
						    }
						    else if(etatInitials.size()==0) {
							       for (String s : e) { 
							    	   etatInitials.add(s);
							    	   afnd.addStartState(s);
							    	   }
							    System.out.println("etatInitials:"+etatInitials); 
							    }
						    else if(etatsFinaux.size()==0) {
							       for (String s : e) {
							    	   etatsFinaux.add(s);
							           afnd.addFinalState(s);
							           }
							    System.out.println("etatsFinaux:"+etatsFinaux); 
							    }
						    else {
						    	Map<String, String> tr=new HashMap<>();
						    	   // tr.put(e[1],e[2]);
						    		//transitions.put(e[0],tr);
						        
						    	char e2[]=e[1].toCharArray();
						    	afnd.addTransition(e[0], e2[0], e[2]);
						    	afnd.printAFND();
						    	System.out.println(e[0]+","+e[1]+","+e[2]);
					    		
						    		if (!transitions.containsKey(e[0] ) ) {
						    			if (!tr.containsKey(e[1])) {
							    			tr.put(e[1],e[2]);}
						    			
						    			
						    			     transitions.put(e[0], tr);
							    		}
						    		else {
						    			tr1=transitions.get(e[0]);
						    			tr1.put(e[1],e[2]);
						    			transitions.put(e[0], tr1);
						    		}
						    		
						    		System.out.println(transitions);
						    }
					
						}
						
						}while(ligne!=null);			
				}catch(IOException ex) {
					System.out.print("erreur");
				}
				 
				
			}
			
			
		});
        afd=afnd.determinize();
		lblNewLabel.setBounds(190, 31, 149, 26);
		contentPane.add(lblNewLabel);
		openFileBtn.setBounds(170, 89, 169, 21);
		contentPane.add(openFileBtn);
		
		
		JLabel lblNewLabel_1 = new JLabel("Contenu du Fichier");
		lblNewLabel_1.setBounds(31, 170, 142, 13);
		contentPane.add(lblNewLabel_1);
		JLabel TitreAcceptation = new JLabel("Test d'acceptation");
		TitreAcceptation.setBounds(170, 390, 142, 13);
		contentPane.add(TitreAcceptation);
		
		JButton btnNewButton = new JButton("Minimisation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JFrame frame = new JFrame("Automate");
//	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//	        AutomateDrawing automateDrawing = new AutomateDrawing();
//	        frame.getContentPane().add(automateDrawing);
//
//	        frame.pack();
//		        frame.setVisible(true);
//			String[] states = {"A", "B", "C"};
//		    String[] alphabet = {"0", "1"};
//			    String initialState = "A";
//			    String[] finalStates = {"C","B"};
//		    String[][] transitions = {{"A", "B", "0"}, {"B", "C", "1"}, {"C", "A", "0"}};
//
//		    SwingUtilities.invokeLater(() -> {
//		        JFrame frame = new JFrame("Automate déterministe");
//		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		        frame.getContentPane().add(new DeterministicAutomatonDrawing(states, alphabet, initialState, finalStates, transitions));
//		        frame.pack();
//			        frame.setLocationRelativeTo(null);
//		        frame.setVisible(true);
//			   });
//				SwingUtilities.invokeLater(new Runnable() {
//		            public void run() {
//		                new AutomateDrawer();
//		            }
//		        });
//				
//				AutomateExample automateExample = new AutomateExample();
//
//		        // Générer l'image de l'automate
//		        automateExample.generateAutomateImage(automateExample.AUTOMATE_DATA);
//
//		        // Afficher l'image de l'automate dans une fenêtre Swing
//		        EventQueue.invokeLater(() -> automateExample.afficherAutomateImage());
				
						afd=afnd.determinize();
						afd.minimiser();
						afd.printAutomate3();
						// Créer une fenêtre (JFrame) et ajouter la barre de défilement à son contenu
				        JFrame frame1 = new JFrame("minimisation d'automate");
				        frame1.getContentPane().add(AFD.contenuTxtArea3);
				        // Configurer la fenêtre
				        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				        frame1.setSize(400, 600);
				        frame1.setVisible(true);
				        frame1.setLocation(300, 200);
		                
					}
				});
		btnNewButton.setBounds(30, 600, 119, 21);
		contentPane.add(btnNewButton);
       ///////////////////////////////////////////
		JLabel AcceptationLabel=new JLabel();
		AcceptationLabel.setBounds(420, 420, 200, 19);
		contentPane.add(AcceptationLabel);
		JButton VerifierMotbtn = new JButton("Verifier");
		VerifierMotbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valeur = InputMot.getText();
				String v;
				System.out.println(afnd.accepts(valeur));
				
				if(afnd.accepts(valeur)==true) {
				v="Le mot est Acceptee";
				AcceptationLabel.setText("<html><font color='green'>"+v+"</font></html>");
				
				}else {
				v="Le mot n'est pas  Acceptee";	
				AcceptationLabel.setText("<html><font color='red'>"+v+"</font></html>");
				}	
			}
		});
		
		VerifierMotbtn.setBounds(300, 420, 96, 20);
		contentPane.add(VerifierMotbtn);
		/////////////////////////////////Generation/////////////////////////////
		JButton GenererMotbtn = new JButton("Géneration");
		GenererMotbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer longeur=Integer.parseInt(InputLongueurMot.getText());
				afd=afnd.determinize();
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
		        JFrame frame = new JFrame("Affichage des mots generés");
		        frame.getContentPane().add(scrollPane);

		        // Configurer la fenêtre
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.setSize(300, 200);
		        frame.setVisible(true);
		        frame.setLocation(300, 200);
			}
		});
		
		GenererMotbtn.setBounds(300, 520, 96, 19);
		contentPane.add(GenererMotbtn);
		/////////////////////////////////////////////////
		JButton btnDeterminiser = new JButton("Determinastion");
		btnDeterminiser.setBounds(155, 600, 128, 21);
		contentPane.add(btnDeterminiser);
		btnDeterminiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afd=afnd.determinize();
				afd.printAutomate();
				afd.renommerEtats();
				afd.printAutomate();
				 // Créer une fenêtre (JFrame) et ajouter la barre de défilement à son contenu
		        JFrame frame1 = new JFrame("AUTOMATE DETERMINESTE");
		        frame1.getContentPane().add(AFD.contenuTxtArea1);
		     // Configurer la fenêtre
		        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame1.setSize(400, 600);
		        frame1.setVisible(true);
		        frame1.setLocation(300, 200);
   
			}
		});
		
		/////////////////////////////////////////////////////
		
		JLabel lblNewLabel_2 = new JLabel("Entrez le mot");
		lblNewLabel_2.setBounds(31, 420, 108, 13);
		contentPane.add(lblNewLabel_2);
		
		InputMot= new JTextField();
		InputMot.setBounds(180, 420, 100, 19);
		contentPane.add(InputMot);
		InputMot.setColumns(10);
		////////////////////////////////////////////////
		JLabel lblNewLabel = new JLabel("entrez la longueur maximum des mots à generer: ");
		lblNewLabel.setBounds(150, 480, 300, 13);
		contentPane.add(lblNewLabel);
		
		InputLongueurMot= new JTextField();
		InputLongueurMot.setBounds(180, 520, 96, 19);
		contentPane.add(InputLongueurMot);
		InputLongueurMot.setColumns(10);
		//////////////////////////////////////////image///////////////////////////////
		JButton btnImageMiroir = new JButton("Image Miroir");
		btnImageMiroir.setBounds(290, 600, 128, 21);
		contentPane.add(btnImageMiroir);
		btnImageMiroir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afd=afnd.determinize();
				afnd=afd.imageMiroir();
				afnd.printAFND();
				// Créer une fenêtre (JFrame) et ajouter la barre de défilement à son contenu
		        JFrame frame1 = new JFrame("Image Miroir d'automate");
		        frame1.getContentPane().add(AFND.contenuTxtArea2);
		        // Configurer la fenêtre
		        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame1.setSize(400, 600);
		        frame1.setVisible(true);
		        frame1.setLocation(300, 200);
                
			}
		});
		
		////////////////////////////////////////////////////Complement////////////////////
		JButton btnComplement = new JButton("Complement");
		btnComplement.setBounds(420, 600, 128, 21);
		contentPane.add(btnComplement);
		btnComplement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afd=afnd.determinize();
				afd=afd.complementaire();
				afd.printAutomate1();
				// Créer une fenêtre (JFrame) et ajouter la barre de défilement à son contenu
		        JFrame frame1 = new JFrame("Complement d'automate");
		        frame1.getContentPane().add(AFD.contenuTxtArea2);
		        // Configurer la fenêtre
		        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame1.setSize(400, 600);
		        frame1.setVisible(true);
		        frame1.setLocation(300, 200);
                
			}
		});
		/////////////////////////////////Dessiner///////////////////////////////
		
		JButton btnDessiner = new JButton("Dessiner");
		btnDessiner .setBounds(500, 300, 128, 21);
		contentPane.add(btnDessiner);
		btnDessiner .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				            AutomateExample automateExample = new AutomateExample();
					        // Générer l'image de l'automate
					        automateExample.generateAutomateImage(automateExample.AUTOMATE_DATA);
					        // Afficher l'image de l'automate dans une fenêtre Swing
					        EventQueue.invokeLater(() -> automateExample.afficherAutomateImage());
              
			}
		});
///////////////////////////////////////union////////////////////////////////
            JButton btnUNION = new JButton("Intersection");
             btnUNION.setBounds(580, 600, 128, 21);
             contentPane.add(btnUNION);
             btnUNION.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
             // Créer une fenêtre (JFrame) et ajouter la barre de défilement à son contenu
             dispose();
             InterfaceUnion frame=new InterfaceUnion();
             frame.show();
             }
             });
	         }
	//////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuill frame = new Acceuill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
