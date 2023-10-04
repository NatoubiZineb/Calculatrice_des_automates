package backEnd;

import java.util.*;

import javax.swing.JTextArea;

public class AFND {
	


	private Set<String> states;
	private Set<Character> alphabet;
	private Map<String, Map<Character, Set<String>>> transitions;
	private Set<String> startStates;
	private Set<String> finalStates;
	 public static JTextArea contenuTxtArea2 = new JTextArea();

	public AFND() {
		this.states = new HashSet<>();
		this.alphabet = new HashSet<>();
		this.transitions = new HashMap<>();
		this.startStates = new HashSet<>();
		this.finalStates = new HashSet<>();
	}
	
	public AFND(Set<String> states, Set<Character> alphabet, Map<String, Map<Character, Set<String>>> transitions,
			Set<String> startStates, Set<String> finalStates) {
		super();
		this.states = states;
		this.alphabet = alphabet;
		this.transitions = transitions;
		this.startStates = startStates;
		this.finalStates = finalStates;
	}
	

	public Set<String> getStates() {
		return states;
	}

	public void setStates(Set<String> states) {
		this.states = states;
	}

	public Set<Character> getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(Set<Character> alphabet) {
		this.alphabet = alphabet;
	}

	public Map<String, Map<Character, Set<String>>> getTransitions() {
		return transitions;
	}

	public void setTransitions(Map<String, Map<Character, Set<String>>> transitions) {
		this.transitions = transitions;
	}

	public Set<String> getStartStates() {
		return startStates;
	}

	public void setStartStates(Set<String> startStates) {
		this.startStates = startStates;
	}

	public Set<String> getFinalStates() {
		return finalStates;
	}

	public void setFinalStates(Set<String> finalStates) {
		this.finalStates = finalStates;
	}

	public void addState(String state) {
		this.states.add(state);
	}

	public void addSymbol(Character symbol) {
		this.alphabet.add(symbol);
	}

	public void addTransition(String from, Character symbol, String to) {
		if (!this.transitions.containsKey(from)) {
			this.transitions.put(from, new HashMap<Character, Set<String>>());
		}
		if (!this.transitions.get(from).containsKey(symbol)) {
			this.transitions.get(from).put(symbol, new HashSet<String>());
		}
		this.transitions.get(from).get(symbol).add(to);
	}

	public void addStartState(String startState) {
		this.startStates.add(startState);
	}

	public void addFinalState(String finalState) {
		this.finalStates.add(finalState);
	}

	

	private Set<String> getEpsilonClosure(Set<String> states) {
		Set<String> closure = new HashSet<>();
		Stack<String> stack = new Stack<>();
		closure.addAll(states);
		stack.addAll(states);

		while (!stack.isEmpty()) {
			String state = stack.pop();
			if (transitions.containsKey(state) && transitions.get(state).containsKey(null)) {
				Set<String> epsilonStates = transitions.get(state).get(null);
				for (String epsilonState : epsilonStates) {
					if (!closure.contains(epsilonState)) {
						closure.add(epsilonState);
						stack.push(epsilonState);
					}
				}
			}
		}
		return closure;
	}
	
	
	public AFD determinize() {
	    // Création d'un nouvel AFD
	    AFD afd = new AFD();
	    afd.setAlphabet(getAlphabet());

	    List<Set<String>> dStates = new ArrayList<>();
	    Set<String> initialSet = getEpsilonClosure(startStates);
	    if (!initialSet.isEmpty()) {
	        dStates.add(initialSet);
	        String initialState = setToString(initialSet);
	        afd.ajouterEtat(initialState);
	        afd.setEtatInitial(initialState);
	        
	    }

	    // Traitement de tous les états du nouvel AFD
	    for (int i = 0; i < dStates.size(); i++) {
	        Set<String> dState = dStates.get(i);
	        if (dState.isEmpty()) {
	            continue;
	        }

	        // Ajout de toutes les transitions pour chaque symbole de l'alphabet
	        for (char symbol : alphabet) {
	            Set<String> nextSet = new HashSet<>();
	            for (String state : dState) {
	                if (transitions.containsKey(state) && transitions.get(state).containsKey(symbol)) {
	                    Set<String> destinationStates = transitions.get(state).get(symbol);
	                    if (destinationStates != null) {
	                        nextSet.addAll(destinationStates);
	                    }
	                }
	            }
	            Set<String> epsilonClosure = getEpsilonClosure(nextSet);
	            String nextState = setToString(epsilonClosure);
	            if (!dStates.contains(epsilonClosure) && nextState != null && !nextState.isEmpty()) {
	                dStates.add(epsilonClosure);
	                afd.ajouterEtat(nextState);
	            }
	            if (nextState != null && !nextState.isEmpty()) {
	                afd.ajouterTransition(setToString(dState), symbol, String.join("",nextState));
	            }

	            // Ajout de l'état final du nouvel AFD si l'ensemble contient un état final de l'AFND
	            if (!Collections.disjoint(epsilonClosure, finalStates) && !afd.getEtatsFinaux().contains(nextState)) {
	                afd.ajouterEtatFinal(nextState);
	                
	            }
	        }
	    }

	    return afd;
	}

	private String setToString(Set<String> set) {if (set.isEmpty()) {
	    return "";
	} else {
	    return "{" + String.join(",", set) + "}";
	}}
	
	public void printAFND() {
		String resultat="";
	    System.out.println("States:"+states);
	    resultat="States:"+states;
	    contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
	    System.out.println("Alphabet:"+alphabet);
	    resultat="Alphabet:"+alphabet;
	    contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
	    System.out.println("Transitions:");
	    resultat="Transitions:";
	    contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
	    System.out.println("From\tSymbol\tTo");
	    resultat="From\tSymbol\tTo";
	    contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
	    for (String from : transitions.keySet()) {
	        for (Character symbol : transitions.get(from).keySet()) {
	            for (String to : transitions.get(from).get(symbol)) {
	                System.out.println(from + "\t" + symbol + "\t" + to);
	                resultat=from + "\t" + symbol + "\t" + to;
	                contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
	            }
	        }
	    }
	    System.out.println("Start states:"+startStates);
	    resultat="Start states:"+startStates;
	    contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
	    System.out.println("Final states:"+finalStates);
	    resultat="Final states:"+finalStates;
	    contenuTxtArea2.setText(contenuTxtArea2.getText()+resultat+"\n");
	}

	public boolean accepts(String input) {
		Set<String> currentStates = new HashSet<>();
		currentStates.addAll(getEpsilonClosure(startStates));

		for (char symbol : input.toCharArray()) {
			Set<String> nextStates = new HashSet<>();
			for (String state : currentStates) {
				if (transitions.containsKey(state) && transitions.get(state).containsKey(symbol)) {
					nextStates.addAll(transitions.get(state).get(symbol));
				}
			}
			currentStates = getEpsilonClosure(nextStates);
		}

		for (String state : currentStates) {
			if (finalStates.contains(state)) {
				return true;
			}
		}
		return false;
	}
	
	}