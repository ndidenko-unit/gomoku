import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private int sideLength;

    private GameArea gameArea;
    private InfoBox infoBox;

    public GameView(int sideLength, int boardSize) {
        super();
        this.sideLength = sideLength;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(sideLength - 40, sideLength));

        initGameArea(boardSize);
        initInfoBox(sideLength, 40);
    }

    private void initGameArea(int boardSize) {
        gameArea = new GameArea(sideLength - 40, boardSize);
        gameArea.setPreferredSize(new Dimension(sideLength, sideLength - 40));
        gameArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(gameArea);
    }

    private void initInfoBox(int boxWidth, int boxHeight) {
        infoBox = new InfoBox();
        infoBox.setPreferredSize(new Dimension(boxWidth, boxHeight));
        add(infoBox);
    }

    public GameArea getGameArea() {
        return gameArea;
    }

    public InfoBox getInfoBox() {
        return infoBox;
    }
}
