// Java program using label (swing)
// to display the message “GFG WEB Site Click”
import javax.swing.*;

// Main class


class Memory {
    // To use the same frame for both, you should update the frame's contents instead of creating a new JFrame each time.
    // Store the frame as a class field and reuse it.

    JFrame frame;
    memoryCard[][] gameGrid;
    boolean firstChosen = true;
    int prevC;
    int prevR;

    void startGame() {
        frame = new JFrame("Memory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to Memory!");
        welcomeLabel.setBounds(340, 50, 120, 50);
        frame.add(welcomeLabel);

        JButton startButton = new JButton("Start");
        startButton.setBounds(300, 350, 200, 100);
        startButton.addActionListener(e -> startLevel(1));
        frame.add(startButton);

        frame.setVisible(true);
    }

    void startLevel(int level) {
        frame.getContentPane().removeAll();
        frame.repaint();

        JLabel welcomeLabel = new JLabel("You are currently at level " + level);
        welcomeLabel.setBounds(325, 50, 150, 50);
        frame.add(welcomeLabel);

        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(300, 350, 200, 100);
        continueButton.addActionListener(e -> playLevel(level));
        frame.add(continueButton);

        frame.revalidate();
        frame.repaint();
    }
    
    void playLevel (int level) {
        int[][] rcList = {
            {2, 2},
            {2, 4},
            {4, 4},
            {4, 5},
            {5, 6},
            {6, 6}
        };
        
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        int r = rcList[level][0];
        int c = rcList[level][1];
        int buttonWidth = 100;
        int buttonHeight = 100;
        int startX = 50;
        int startY = 50;
        int gap = 10;
        
        gameGrid = initGrid(r, c);
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                memoryCard card = gameGrid[i][j];
                int x = startX + j * (buttonWidth + gap);
                int y = startY + i * (buttonHeight + gap);
                card.setBounds(x, y, buttonWidth, buttonHeight);
                final int curR = i;
                final int curC = j;
                card.addActionListener(e -> cardChosen(curR, curC, r, c));
                frame.add(card);
            }
        }
        frame.revalidate();
        frame.repaint();
        
    }

    

    void cardChosen(int curR, int curC, int r, int c) {
        if (gameGrid[curR][curC].isRevealed()){
            System.out.println("already chosen");
            return;
        }
        gameGrid[curR][curC].setRevealed(true);
        if (firstChosen) {
            prevC = curC;
            prevR = curR;
            firstChosen = false;
        } else {
            firstChosen = true;
        }
        
        
        return;
    }
    
    memoryCard[][] initGrid (int r, int c) {
        memoryCard[][] cardGrid = new memoryCard[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cardGrid[i][j] = new memoryCard("image.png", false, 3);
            }
        }
        return cardGrid;
    }
    // Main driver method
    
    public static void main(String[] args)
    {
        Memory memoryGame = new Memory();
        memoryGame.startGame();
        /* 
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
        */
    }
}