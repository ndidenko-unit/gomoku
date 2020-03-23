public class GameSettings {
    public enum FirstMove {
        HUMAN, COMPUTER
    }

    private FirstMove firstMove;
    private int difficulty;

    public GameSettings(FirstMove firstMove, int difficulty) {
        this.firstMove = firstMove;
        this.difficulty = difficulty;
    }

    public FirstMove getFirstMove() {
        return firstMove;
    }

    public int getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return "Depth: " + difficulty + " First move: " + firstMove.name().toLowerCase();
    }
}
