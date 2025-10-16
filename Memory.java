// Java program using label (swing)
// to display the message “GFG WEB Site Click”
import java.util.Random;
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
    int level = 1;

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
        startButton.addActionListener(e -> startLevel());
        frame.add(startButton);

        frame.setVisible(true);
    }

    void allDone() {
        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel finalLabel = new JLabel("Congragiulations, you have completed all levels!");
        finalLabel.setBounds(325, 50, 300, 50);
        frame.add(finalLabel);

    }

    void startLevel() {
        if (level > 6) {
            allDone();
            return;
        }
        frame.getContentPane().removeAll();
        frame.repaint();

        JLabel welcomeLabel = new JLabel("You are currently at level " + level);
        welcomeLabel.setBounds(325, 50, 150, 50);
        frame.add(welcomeLabel);

        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(300, 350, 200, 100);
        continueButton.addActionListener(e -> playLevel());
        frame.add(continueButton);

        frame.revalidate();
        frame.repaint();
    }
    
    void playLevel () {
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

        int r = rcList[level - 1][0];
        int c = rcList[level - 1][1];
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
        if (gameGrid[curR][curC].isRevealed()) {
            System.out.println("already chosen");
            return;
        }
        gameGrid[curR][curC].setRevealed(true);
        frame.repaint();
        if (firstChosen) {
            prevC = curC;
            prevR = curR;
            firstChosen = false;
        } else if (gameGrid[curR][curC].getIdentifier() == gameGrid[prevR][prevC].getIdentifier()) {
            firstChosen = true;
        } else {
            frame.setEnabled(false);
            Timer timer = new Timer(1000, e -> {
                gameGrid[prevR][prevC].setRevealed(false);
                gameGrid[curR][curC].setRevealed(false);
                frame.setEnabled(true);
            
            });
            timer.setRepeats(false);
            timer.start();
            firstChosen = true;
        }
        boolean checkIncomplete = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!gameGrid[i][j].isRevealed()) {
                    checkIncomplete = true;
                }
            }
        }
        if (!checkIncomplete) {
            level++;
            startLevel();
        }
    }
    
    memoryCard[][] initGrid (int r, int c) {
        memoryCard[][] cardGrid = new memoryCard[r][c];
        int numSets = (r * c) / 2;
        // Create an array with pairs of identifiers
        String[] pictures = new String[] {
            "apple.png", "bananas.png", "cherries.png", "fruit.png",
            "grapes.png", "lemon.png", "orange.png", "pear.png",
            "pineapple.png", "strawberry.png", "lime.png", "peach.png", 
            "kiwi.png", "blueberry.png", "raspberry.png", "mango.png",
            "vegetables_crate.png", "dragonfruit.png"
        };

        int[] identifiers = new int[r * c];
        for (int i = 0; i < numSets; i++) {
            identifiers[2 * i] = i + 1;     // First occurrence
            identifiers[2 * i + 1] = i + 1; // Second occurrence
        }

        // Shuffle the identifiers array
        Random random = new Random();
        for (int i = identifiers.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Swap identifiers[i] and identifiers[j]
            int temp = identifiers[i];
            identifiers[i] = identifiers[j];
            identifiers[j] = temp;
        }
        int identInd = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int curIdent = identifiers[identInd++];
                cardGrid[i][j] = new memoryCard(pictures[curIdent - 1], false, curIdent);
            }
        }
        return cardGrid;
    }
    // Main driver method
    
    public static void main(String[] args) {
        Memory memoryGame = new Memory();
        memoryGame.startGame();
    }
}