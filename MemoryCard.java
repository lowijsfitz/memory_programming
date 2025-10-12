import javax.swing.JButton;

public class memoryCard extends JButton {
    private String pictureFileName;
    private boolean revealed;
    private int identifier;

    public memoryCard(String pictureFileName, boolean revealed, int identifier) {
        super();
        this.pictureFileName = pictureFileName;
        this.revealed = revealed;
        this.identifier = identifier;
        updateAppearance();
    }

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
        updateAppearance();
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
        updateAppearance();
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
        updateAppearance();
    }

    // Update the button's appearance based on visibility
    private void updateAppearance() {
        if (revealed) {
            setText(String.valueOf(identifier));
            // Optionally set an icon using pictureFileName
            // setIcon(new ImageIcon(pictureFileName));
        } else {
            setText(""); // Hide identifier when not visible
            setIcon(null);
        }
    }
}