package Presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import backEnd.AFD;
import backEnd.AFND;

public class InterfaceUnion extends JFrame{
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("  Veuillez saisir l'automate");
	private static JTextArea contenuTxtArea = new JTextArea();
	public static List<Character> alphabet;
	public static Set<String> etats;
	public static Set<String> etatInitials;
    public static Set<String> etatsFinaux;
    public static Map<String, Map<String, String>> transitions;
    public static AFND afnd1=new AFND();
    public static AFD afd1=new AFD();
 
   
	public InterfaceUnion() {
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
						    	   afnd1.addSymbol(s);
						           }
						    System.out.println("alphabet:"+alphabet); 
						    }
						    else if(etats.size()==0) {
						       for (String s : e) { 
						    	 etats.add(s);
						    	 afnd1.addState(s);}
						    System.out.println("etats:"+etats); 
						    }
						    else if(etatInitials.size()==0) {
							       for (String s : e) { 
							    	   etatInitials.add(s);
							    	   afnd1.addStartState(s);
							    	   }
							    System.out.println("etatInitials:"+etatInitials); 
							    }
						    else if(etatsFinaux.size()==0) {
							       for (String s : e) {
							    	   etatsFinaux.add(s);
							           afnd1.addFinalState(s);
							           }
							    System.out.println("etatsFinaux:"+etatsFinaux); 
							    }
						    else {
						    	Map<String, String> tr=new HashMap<>();
						    	   // tr.put(e[1],e[2]);
						    		//transitions.put(e[0],tr);
						        
						    	char e2[]=e[1].toCharArray();
						    	afnd1.addTransition(e[0], e2[0], e[2]);
						    	afnd1.printAFND();
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

		lblNewLabel.setBounds(190, 31, 149, 26);
		contentPane.add(lblNewLabel);
		openFileBtn.setBounds(170, 89, 169, 21);
		contentPane.add(openFileBtn);
		////////////////////////////////:union////////////////////////////
		JButton btnUnion = new JButton("Intercetion");
		btnUnion .setBounds(500, 300, 128, 21);
		contentPane.add(btnUnion);
		btnUnion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				            afd1=afnd1.determinize();
				            afd1=afd1.Intersection(afd1, Acceuill.afd);
				            afd1.printAutomate4();
				            JFrame frame1 = new JFrame("Intersection");
					        frame1.getContentPane().add(AFD.contenuTxtArea4);
					        // Configurer la fenêtre
					        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					        frame1.setSize(400, 600);
					        frame1.setVisible(true);
					        frame1.setLocation(300, 200);	            
			}
		});
	}

}
