package backEnd;

import java.util.*;

import javax.swing.JTextArea;


public class AFD {

    private Set<Character> alphabet;
    private Set<String> etats;
    private String etatInitial;
    private Set<String> etatsFinaux;
    private Map<String, Map<Character, String>> transitions;
    public static JTextArea contenuTxtArea1 = new JTextArea();
    public static JTextArea contenuTxtArea2 = new JTextArea();
    public static JTextArea contenuTxtArea3 = new JTextArea();
    public static JTextArea contenuTxtArea4= new JTextArea();
    
    public AFD() {
        alphabet = new HashSet<Character>();
        etats = new HashSet<String>();
        etatInitial = "";
        etatsFinaux = new HashSet<String>();
        transitions = new HashMap<String, Map<Character, String>>();
   }
 
	public AFD(Set<Character> alphabet, Set<String> etats, String etatInitial, Set<String> etatsFinaux,
			Map<String, Map<Character, String>> transitions) {
		super();
		this.alphabet = alphabet;
		this.etats = etats;
		this.etatInitial = etatInitial;
		this.etatsFinaux = etatsFinaux;
		this.transitions = transitions;
	}

	public AFD(Set<Character> alphabet2, Set<Set<String>> partitionUnique,
			Map<String, Map<Character, String>> transitions2, String etatInitial2, Set<String> etatsFinaux2) {
		// TODO Auto-generated constructor stub
	}

	public void ajouterEtat(String etat) {
        etats.add(etat);
    }

    public void ajouterAlphabet(Character symbole) {
        alphabet.add(symbole);
    }

    public void setEtatInitial(String etat) {
        etatInitial = etat;
    }

    public void ajouterEtatFinal(String etat) {
        etatsFinaux.add(etat);
    }

    public void ajouterTransition(String etatDepart, Character symbole, String etatArrivee) {
        Map<Character, String> mapTransitions = transitions.get(etatDepart);
        if (mapTransitions == null) {
            mapTransitions = new HashMap<Character, String>();
            transitions.put(etatDepart, mapTransitions);
        }
        mapTransitions.put(symbole, etatArrivee);
    }

    
    public void printAutomate() {
    	String resultat="";
    	resultat="Alphabet: " + alphabet;
    	contenuTxtArea1.setText(contenuTxtArea1.getText()+resultat+"\n");
    	resultat="Etats: " + etats;
    	contenuTxtArea1.setText(contenuTxtArea1.getText()+resultat+"\n");
    	resultat="Etat initial: " + etatInitial;
    	contenuTxtArea1.setText(contenuTxtArea1.getText()+resultat+"\n");
    	resultat="Etats finaux: " + etatsFinaux;
    	contenuTxtArea1.setText(contenuTxtArea1.getText()+resultat+"\n");
    	resultat="Transitions: ";
    	contenuTxtArea1.setText(contenuTxtArea1.getText()+resultat+"\n");
    	
        System.out.println("Alphabet: " + alphabet);
        System.out.println("Etats: " + etats);
        System.out.println("Etat initial: " + etatInitial);
        System.out.println("Etats finaux: " + etatsFinaux);
        System.out.println("Transitions: ");

        for (Map.Entry<String, Map<Character, String>> entry : transitions.entrySet()) {
            String etatDepart = entry.getKey();
            Map<Character, String> mapTransitions = entry.getValue();

            for (Map.Entry<Character, String> transitionEntry : mapTransitions.entrySet()) {
                Character symbole = transitionEntry.getKey();
                String etatArrivee = transitionEntry.getValue();
                System.out.println(etatDepart + " - " + symbole + " -> " + etatArrivee);
                resultat=etatDepart + " - " + symbole + " -> " + etatArrivee;
                contenuTxtArea1.setText(contenuTxtArea1.getText()+resultat+"\n");
            }
        }
    }
    public void printAutomate1() {
    	String resultat="";
    	resultat="Alphabet: " + alphabet;
    	contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
    	resultat="Etats: " + etats;
    	contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
    	resultat="Etat initial: " + etatInitial;
    	contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
    	resultat="Etats finaux: " + etatsFinaux;
    	contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
    	resultat="Transitions: ";
    	contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
    	
        System.out.println("Alphabet: " + alphabet);
        System.out.println("Etats: " + etats);
        System.out.println("Etat initial: " + etatInitial);
        System.out.println("Etats finaux: " + etatsFinaux);
        System.out.println("Transitions: ");

        for (Map.Entry<String, Map<Character, String>> entry : transitions.entrySet()) {
            String etatDepart = entry.getKey();
            Map<Character, String> mapTransitions = entry.getValue();

            for (Map.Entry<Character, String> transitionEntry : mapTransitions.entrySet()) {
                Character symbole = transitionEntry.getKey();
                String etatArrivee = transitionEntry.getValue();
                System.out.println(etatDepart + " - " + symbole + " -> " + etatArrivee);
                resultat=etatDepart + " - " + symbole + " -> " + etatArrivee;
                contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
            }
        }
    }
    public void printAutomate3() {
    	String resultat="";
    	resultat="Alphabet: " + alphabet;
    	contenuTxtArea3.setText(contenuTxtArea3.getText()+resultat+"\n");
    	resultat="Etats: " + etats;
    	contenuTxtArea3.setText(contenuTxtArea3.getText()+resultat+"\n");
    	resultat="Etat initial: " + etatInitial;
    	contenuTxtArea3.setText(contenuTxtArea3.getText()+resultat+"\n");
    	resultat="Etats finaux: " + etatsFinaux;
    	contenuTxtArea3.setText(contenuTxtArea3.getText()+resultat+"\n");
    	resultat="Transitions: ";
    	contenuTxtArea3.setText(contenuTxtArea3.getText()+resultat+"\n");
    	
        System.out.println("Alphabet: " + alphabet);
        System.out.println("Etats: " + etats);
        System.out.println("Etat initial: " + etatInitial);
        System.out.println("Etats finaux: " + etatsFinaux);
        System.out.println("Transitions: ");

        for (Map.Entry<String, Map<Character, String>> entry : transitions.entrySet()) {
            String etatDepart = entry.getKey();
            Map<Character, String> mapTransitions = entry.getValue();

            for (Map.Entry<Character, String> transitionEntry : mapTransitions.entrySet()) {
                Character symbole = transitionEntry.getKey();
                String etatArrivee = transitionEntry.getValue();
                System.out.println(etatDepart + " - " + symbole + " -> " + etatArrivee);
                resultat=etatDepart + " - " + symbole + " -> " + etatArrivee;
                contenuTxtArea3.setText(contenuTxtArea3.getText()+resultat+"\n");
            }
        }
    }
    public void printAutomate4() {
    	String resultat="";
    	resultat="Alphabet: " + alphabet;
    	contenuTxtArea4.setText(contenuTxtArea4.getText()+resultat+"\n");
    	resultat="Etats: " + etats;
    	contenuTxtArea4.setText(contenuTxtArea4.getText()+resultat+"\n");
    	resultat="Etat initial: " + etatInitial;
    	contenuTxtArea4.setText(contenuTxtArea4.getText()+resultat+"\n");
    	resultat="Etats finaux: " + etatsFinaux;
    	contenuTxtArea4.setText(contenuTxtArea4.getText()+resultat+"\n");
    	resultat="Transitions: ";
    	contenuTxtArea3.setText(contenuTxtArea4.getText()+resultat+"\n");
    	
        System.out.println("Alphabet: " + alphabet);
        System.out.println("Etats: " + etats);
        System.out.println("Etat initial: " + etatInitial);
        System.out.println("Etats finaux: " + etatsFinaux);
        System.out.println("Transitions: ");

        for (Map.Entry<String, Map<Character, String>> entry : transitions.entrySet()) {
            String etatDepart = entry.getKey();
            Map<Character, String> mapTransitions = entry.getValue();

            for (Map.Entry<Character, String> transitionEntry : mapTransitions.entrySet()) {
                Character symbole = transitionEntry.getKey();
                String etatArrivee = transitionEntry.getValue();
                System.out.println(etatDepart + " - " + symbole + " -> " + etatArrivee);
                resultat=etatDepart + " - " + symbole + " -> " + etatArrivee;
                contenuTxtArea4.setText(contenuTxtArea4.getText()+resultat+"\n");
            }
        }
    }
    public boolean accepte(String mot) {
        String etatCourant = etatInitial;
        for (int i = 0; i < mot.length(); i++) {
            Character symbole = mot.charAt(i);
            Map<Character, String> mapTransitions = transitions.get(etatCourant);
            if (mapTransitions == null) {
                return false;
            }
            String etatSuivant = mapTransitions.get(symbole);
            if (etatSuivant == null) {
                return false;
            }
            etatCourant = etatSuivant;
        }
        return etatsFinaux.contains(etatCourant);
    }
    
    
    public Set<String> genererMots(int limiteLongueur) {
        Set<String> motsAcceptes = new HashSet<String>();
        genererMotsRecursif(etatInitial, "", limiteLongueur, motsAcceptes);
        return motsAcceptes;
    }

    private void genererMotsRecursif(String etatCourant, String motCourant, int limiteLongueur, Set<String> motsAcceptes) {
        if (etatsFinaux.contains(etatCourant)) {
            motsAcceptes.add(motCourant);
        }
        if (motCourant.length() < limiteLongueur) {
            Map<Character, String> mapTransitions = transitions.get(etatCourant);
            if (mapTransitions != null) {
                for (Map.Entry<Character, String> entry : mapTransitions.entrySet()) {
                    Character symbole = entry.getKey();
                    String etatSuivant = entry.getValue();
                    genererMotsRecursif(etatSuivant, motCourant + symbole, limiteLongueur, motsAcceptes);
                }
            }
        }
    }
    
    public Set<Character> getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(Set<Character> alphabet) {
		this.alphabet = alphabet;
	}

	public Map<String, Map<Character, String>> getTransitions() {
		return transitions;
	}

	public void setTransitions(Map<String, Map<Character, String>> transitions) {
		this.transitions = transitions;
	}
	
    public String getEtatInitial() {
		return etatInitial;
	}

	public Set<String> getEtatsFinaux() {
		return etatsFinaux;
	}

	public void setEtatsFinaux(Set<String> etatsFinaux) {
		this.etatsFinaux = etatsFinaux;
	}

	public Set<String> getEtats() {
		return etats;
	}

	public void setEtats(Set<String> etats) {
		this.etats = etats;
	}

	public Set<Set<String>> getSubsets(Set<String> etats) {
	    Set<Set<String>> partitions = new HashSet<Set<String>>();

	    if (etats.isEmpty()) {
	        partitions.add(new HashSet<String>());
	        return partitions;
	    }

	    String premierEtat = etats.iterator().next();
	    Set<String> resteEtats = new HashSet<String>(etats);
	    resteEtats.remove(premierEtat);

	    Set<Set<String>> sousPartitions = getSubsets(resteEtats);

	    for (Set<String> sousPartition : sousPartitions) {
	        Set<String> nouvellePartition = new HashSet<String>(sousPartition);
	        nouvellePartition.add(premierEtat);
	        partitions.add(nouvellePartition);
	        partitions.add(sousPartition);
	    }

	    return partitions;
	}
	
	
	public void minimiser() {
	    Set<String> etatsAccepteurs = new HashSet<>();
	    Set<String> etatsNonAccepteurs = new HashSet<>();
	    Map<String, Set<String>> partitionMap = new HashMap<>();
	    Set<Set<String>> partition = new HashSet<>();

	    // Initialisation de la partition P0
	    for (String etat : etats) {
	        if (etatsFinaux.contains(etat)) {
	            etatsAccepteurs.add(etat);
	        } else {
	            etatsNonAccepteurs.add(etat);
	        }
	    }

	    partition.add(etatsAccepteurs);
	    partition.add(etatsNonAccepteurs);

	    // Boucle principale de l'algorithme
	    while (true) {
	        Set<Set<String>> newPartition = new HashSet<>();

	        for (Set<String> part : partition) {
	            for (Character symbole : alphabet) {
	                Map<String, Set<String>> transitionsMap = new HashMap<>();

	                for (String etat : part) {
	                    Map<Character, String> etatTransitions = transitions.get(etat);
	                    if (etatTransitions != null) {
	                        String etatArrivee = etatTransitions.get(symbole);

	                        if (etatArrivee != null) {
	                            Set<String> transitionSet = transitionsMap.get(etatArrivee);

	                            if (transitionSet == null) {
	                                transitionSet = new HashSet<>();
	                                transitionsMap.put(etatArrivee, transitionSet);
	                            }

	                            transitionSet.add(etat);
	                        }
	                    }
	                }

	                for (Set<String> subset : transitionsMap.values()) {
	                    Set<Set<String>> subsets = getSubsets(subset);
	                    if (subsets != null) {
	                        newPartition.addAll(subsets);
	                    }
	                }
	            }
	        }

	        if (newPartition.equals(partition)) {
	            break;
	        }

	        partition = newPartition;
	    }

	    // Vérifier si une nouvelle minimisation est possible
	    boolean minimisationPossible = false;
	    for (Set<String> part : partition) {
	        if (part.size() > 1) {
	            minimisationPossible = true;
	            break;
	        }
	    }

	    if (minimisationPossible) {
	        // Mise à jour de la partitionMap
	        for (Set<String> part : partition) {
	            for (String etat : part) {
	                partitionMap.put(etat, part);
	            }
	        }

	        // Appel récursif pour minimiser l'automate résultant
	        Map<String, String> etatMinimiseMap = new HashMap<>();

	        for (Set<String> part : partition) {
	            String etatMinimise = null;
	            Iterator<String> iterator = part.iterator();
	            if (iterator.hasNext()) {
	                etatMinimise = iterator.next();
	            }

	            for (String etat : part) {
	                etatMinimiseMap.put(etat, etatMinimise);
	            }
	        }

	        Set<String> nouveauxEtats = new HashSet<>(etatMinimiseMap.values());
	        Map<String, Map<Character, String>> nouvellesTransitions = new HashMap<>();

	        for (String etat : nouveauxEtats) {
	            Map<Character, String> transitionMap = new HashMap<>();

	            Map<Character, String> etatTransitions = transitions.get(etatMinimiseMap.get(etat));
	            if (etatTransitions != null) {
	                for (Character symbole : alphabet) {
	                    String etatArrivee = etatTransitions.get(symbole);
	                    String nouvelEtatArrivee = etatMinimiseMap.get(etatArrivee);

	                    transitionMap.put(symbole, nouvelEtatArrivee);
	                }
	            }

	            nouvellesTransitions.put(etat, transitionMap);
	        }
	        etats = nouveauxEtats;
	        transitions = nouvellesTransitions;
	        etatInitial = etatMinimiseMap.get(etatInitial);

	        Set<String> nouveauxEtatsFinaux = new HashSet<>();

	        for (String etat : etatsFinaux) {
	            nouveauxEtatsFinaux.add(etatMinimiseMap.get(etat));
	        }

	        etatsFinaux = nouveauxEtatsFinaux;
	    }
	}

	
	public AFD complementaire() {
	    AFD complementaire = new AFD();
	    complementaire.setAlphabet(this.getAlphabet());

	    // ajouter les mêmes états que l'AFD original
	    for (String etat : this.getEtats()) {
	        complementaire.ajouterEtat(etat);
	    }

	    // l'état initial est également conservé
	    complementaire.setEtatInitial(this.getEtatInitial());

	    // les états finaux sont complémentés
	    for (String etat : this.getEtats()) {
	        if (!this.getEtatsFinaux().contains(etat)) {
	            complementaire.ajouterEtatFinal(etat);
	        }
	    }

	    // ajouter les mêmes transitions que l'AFD original en inversant les états finaux et non finaux
	    for (Map.Entry<String, Map<Character, String>> entry : this.getTransitions().entrySet()) {
	        String etatDepart = entry.getKey();
	        Map<Character, String> mapTransitions = entry.getValue();

	        for (Map.Entry<Character, String> transitionEntry : mapTransitions.entrySet()) {
	            Character symbole = transitionEntry.getKey();
	            String etatArrivee = transitionEntry.getValue();

	            // si l'état de départ n'est pas un état final dans l'AFD original, alors l'état d'arrivée doit être un état final dans le complémentaire
	            if (!this.getEtatsFinaux().contains(etatDepart)) {
	                complementaire.ajouterTransition(etatDepart, symbole, etatArrivee);
	                if (this.getEtatsFinaux().contains(etatArrivee)) {
	                    complementaire.ajouterEtatFinal(etatDepart);
	                }
	            }
	            // si l'état de départ est un état final dans l'AFD original, alors l'état d'arrivée ne doit pas être un état final dans le complémentaire
	            else {
	                if (!this.getEtatsFinaux().contains(etatArrivee)) {
	                    complementaire.ajouterTransition(etatDepart, symbole, etatArrivee);
	                }
	            }
	        }
	    }

	    return complementaire;
	}
	
	
	public void renommerEtats() {
		contenuTxtArea1.setText(contenuTxtArea1.getText()+"simplification d'automate"+"\n");
	    Set<String> etatsOriginaux = new HashSet<>(etats);
	    Map<String, String> correspondances = new HashMap<>();

	    int compteur = 0;
	    for (String etat : etatsOriginaux) {
	        String nouvelEtat = "q" + compteur;
	        correspondances.put(etat, nouvelEtat);
	        compteur++;
	    }

	    // Mise à jour de l'état initial
	    etatInitial = correspondances.get(etatInitial);

	    // Mise à jour des états finaux
	    Set<String> nouveauxEtatsFinaux = new HashSet<>();
	    for (String etatFinal : etatsFinaux) {
	        nouveauxEtatsFinaux.add(correspondances.get(etatFinal));
	    }
	    etatsFinaux = nouveauxEtatsFinaux;

	    // Mise à jour des transitions
	    Map<String, Map<Character, String>> nouvellesTransitions = new HashMap<>();
	    for (Map.Entry<String, Map<Character, String>> entry : transitions.entrySet()) {
	        String etatDepart = entry.getKey();
	        Map<Character, String> mapTransitions = entry.getValue();
	        Map<Character, String> nouvellesMapTransitions = new HashMap<>();

	        for (Map.Entry<Character, String> transitionEntry : mapTransitions.entrySet()) {
	            Character symbole = transitionEntry.getKey();
	            String etatArrivee = transitionEntry.getValue();
	            nouvellesMapTransitions.put(symbole, correspondances.get(etatArrivee));
	        }

	        nouvellesTransitions.put(correspondances.get(etatDepart), nouvellesMapTransitions);
	    }
	    transitions = nouvellesTransitions;

	    // Mise à jour de la liste des états
	    etats.clear();
	    etats.addAll(correspondances.values());
	}

	public AFND imageMiroir() {
	    AFND imageMiroir = new AFND();
	    imageMiroir.setAlphabet(this.getAlphabet());

	    // Ajouter les mêmes états que l'AFD original
	    for (String etat : this.getEtats()) {
	        imageMiroir.addState(etat);
	    }
	    
	    

	    // Les états finaux deviennent des états initiales dans l'image miroir
	    String debut=this.getEtatInitial();
	    for (String etat : this.getEtatsFinaux()) {
	        imageMiroir.addStartState(etat);
	    }
	    
	    // L'état initial devient un état final dans l'image miroir
	    imageMiroir.addFinalState(debut);
	    
	    // Ajouter les mêmes transitions que l'AFD original, mais inversées
	    for (Map.Entry<String, Map<Character, String>> entry : this.getTransitions().entrySet()) {
	        String etatDepart = entry.getKey();
	        Map<Character, String> mapTransitions = entry.getValue();

	        for (Map.Entry<Character, String> transitionEntry : mapTransitions.entrySet()) {
	            Character symbole = transitionEntry.getKey();
	            String etatArrivee = transitionEntry.getValue();

	            // Inverser l'état de départ et l'état d'arrivée
	            imageMiroir.addTransition(etatArrivee, symbole, etatDepart);
	        }
	    }

	    return imageMiroir;
	}

	
	public AFD Intersection(AFD afd1, AFD afd2) {
	    // Création d'un nouvel AFND pour l'union
	    AFND afndUnion = new AFND();

	    // Étape 1 : Union des alphabets
	    Set<Character> unionAlphabet = new HashSet<>(afd1.getAlphabet());
	    unionAlphabet.addAll(afd2.getAlphabet());
	    afndUnion.setAlphabet(unionAlphabet);

	    // Étape 2 : Ajouter les états de l'AFD 1 à l'AFND
	    for (String etat : afd1.getEtats()) {
	        afndUnion.addState(etat);
	    }

	    // Étape 3 : Ajouter les états de l'AFD 2 à l'AFND
	    for (String etat : afd2.getEtats()) {
	        afndUnion.addState(etat);
	    }

	    // Étape 4 : Ajouter les transitions de l'AFD 1 à l'AFND
	    for (Map.Entry<String, Map<Character, String>> entry : afd1.getTransitions().entrySet()) {
	        String etatDepart = entry.getKey();
	        Map<Character, String> transitions = entry.getValue();
	        for (Map.Entry<Character, String> transition : transitions.entrySet()) {
	            Character symbole = transition.getKey();
	            String etatArrivee = transition.getValue();
	            afndUnion.addTransition(etatDepart, symbole, etatArrivee);
	        }
	    }

	    // Étape 5 : Ajouter les transitions de l'AFD 2 à l'AFND
	    for (Map.Entry<String, Map<Character, String>> entry : afd2.getTransitions().entrySet()) {
	        String etatDepart = entry.getKey();
	        Map<Character, String> transitions = entry.getValue();
	        for (Map.Entry<Character, String> transition : transitions.entrySet()) {
	            Character symbole = transition.getKey();
	            String etatArrivee = transition.getValue();
	            afndUnion.addTransition(etatDepart, symbole, etatArrivee);
	        }
	    }

	    // Étape 6 : Ajouter un état initial avec une epsilon-transition vers les états initiaux des deux AFD
	    String etatInitialUnion = "q0";
	    afndUnion.addState(etatInitialUnion);
	    afndUnion.addStartState(etatInitialUnion);
	    afndUnion.addTransition(etatInitialUnion, null, afd1.getEtatInitial());
	    afndUnion.addTransition(etatInitialUnion, null, afd2.getEtatInitial());

	    // Étape 7 : Ajouter l'union des états finaux des deux AFD comme les états finaux de l'AFND
	    for (String etatFinal : afd1.getEtatsFinaux()) {
	        afndUnion.addFinalState(etatFinal);
	    }
	    for (String etatFinal : afd2.getEtatsFinaux()) {
	        afndUnion.addFinalState(etatFinal);
	    }

	    // Étape 8 : Déterminiser l'AFND
	    AFD afdUnion = afndUnion.determinize();

	    // Étape 9 : Retourner l'AFD union
	    return afdUnion;
	}

	
	
	

	
    
     

    
    //AFND U = a2.imageMiroir( );U.printAFND();
      
    
}