package Presentation;

import javax.swing.*;
import java.awt.*;

public class DeterministicAutomatonDrawing extends JPanel {

    private static final int NODE_RADIUS = 30;
    private static final int NODE_DISTANCE = 100;

    private String[] states;
    private String[] alphabet;
    private String initialState;
    private String[] finalStates;
    private String[][] transitions;

    public DeterministicAutomatonDrawing(String[] states, String[] alphabet, String initialState, String[] finalStates, String[][] transitions) {
        this.states = states;
        this.alphabet = alphabet;
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.transitions = transitions;

        int width = NODE_DISTANCE * (states.length + 1);
        int height = NODE_DISTANCE * 2;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Dessiner les états
        int y = getHeight() / 2;
        int x = NODE_DISTANCE;
        for (String state : states) {
            boolean isInitial = state.equals(initialState);
            boolean isFinal = containsState(finalStates, state);
            drawNode(g2d, x, y, state, isInitial, isFinal);
            x += NODE_DISTANCE;
        }

        // Dessiner les transitions
        for (String[] transition : transitions) {
            String fromState = transition[0];
            String toState = transition[1];
            String symbol = transition[2];
            int fromX = getNodeXPosition(fromState);
            int toX = getNodeXPosition(toState);
            drawArrow(g2d, fromX, y, toX, y, symbol);
        }
    }

    private void drawNode(Graphics2D g2d, int x, int y, String label, boolean isInitial, boolean isFinal) {
        g2d.setColor(Color.GRAY);
        if (isFinal) {
            g2d.drawOval(x - NODE_RADIUS - 5, y - NODE_RADIUS - 5, NODE_RADIUS * 2 + 10, NODE_RADIUS * 2 + 10);
        }
        g2d.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);

        if (isInitial) {
            int arrowSize = 10;
            int[] arrowX = { x - NODE_RADIUS - arrowSize, x - NODE_RADIUS - arrowSize, x - NODE_RADIUS };
            int[] arrowY = { y, y - arrowSize, y };
            g2d.setColor(Color.BLACK);
            g2d.fillPolygon(arrowX, arrowY, 3);
        }

        g2d.setColor(Color.WHITE);
        g2d.drawString(label, x - 5, y + 5);
    }

    private void drawArrow(Graphics2D g2d, int fromX, int fromY, int toX, int toY, String label) {
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(fromX + NODE_RADIUS, fromY, toX - NODE_RADIUS, toY);

        int arrowSize = 10;
        int dx = toX - fromX;
        int dy = toY - fromY;
        double angle = Math.atan2(dy, dx);
        int endX = toX - NODE_RADIUS - (int) (Math.cos(angle) * NODE_RADIUS);
        int endY = toY - (int) (Math.sin(angle) * NODE_RADIUS);

        g2d.setColor(Color.BLACK);
        g2d.fillPolygon(new int[]{endX, endX - arrowSize, endX - arrowSize}, new int[]{endY, endY - arrowSize / 2, endY + arrowSize / 2}, 3);

        g2d.setColor(Color.BLACK);
        g2d.drawString(label, (fromX + toX) / 2, fromY - 10);
    }
    
private int getNodeXPosition(String state) {
    return NODE_DISTANCE + (indexOfState(state) * NODE_DISTANCE);
}

private int indexOfState(String state) {
    for (int i = 0; i < states.length; i++) {
        if (states[i].equals(state)) {
            return i;
        }
    }
    return -1;
}

private boolean containsState(String[] array, String state) {
    for (String item : array) {
        if (item.equals(state)) {
            return true;
        }
    }
    return false;
}


}

