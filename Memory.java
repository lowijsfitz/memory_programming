// Java program using label (swing)
// to display the message “GFG WEB Site Click”
import javax.swing.*;

// Main class


class Memory {
    void Start_game () {
        
    }
    MemoryCard[][] InitGrid (int r, int c) {
        MemoryCard[][] CardGrid = new MemoryCard[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                CardGrid[i][j].setIdentifier(1);
                CardGrid[i][j].setVisible(false);
            }
        }
        return CardGrid;
    }
    // Main driver method
    public static void main(String[] args)
    {
        // Creating instance of JFrame
        JFrame frame = new JFrame();

        // Creating instance of JButton
        JButton button = new JButton("Nu echt doen en ik ook");

        // x axis, y axis, width, height
        button.setBounds(150, 200, 220, 50);

        // adding button in JFrame
        frame.add(button);

        // 400 width and 500 height
        frame.setSize(500, 600);

        // using no layout managers
        frame.setLayout(null);

        // making the frame visible
        frame.setVisible(true);
    }
}