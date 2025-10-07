import javax.swing.JButton;

public class memoryCard extends JButton {
    private String pictureFileName;
    private boolean visible;
    private int identifier;

    public memoryCard (String pictureFileName, boolean visible, int identifier) {
        this.pictureFileName = pictureFileName;
        this.visible = visible;
        this.identifier = identifier;
    }

    // Getter and Setter for pictureFileName
    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    // Getter and Setter for visible
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    // Getter and Setter for identifier
    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
}
