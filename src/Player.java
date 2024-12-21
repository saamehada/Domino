import java.util.ArrayList;
import java.util.List;

class Player {
    private final String name;
    private List<Domino> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public boolean playTile(Domino tile, Board board) {
        if (board.getTiles().isEmpty()) {
            board.getTiles().add(tile);
            System.out.println(name + " положил " + tile.toString() + " на пустую доску.");
        } else {
            Domino lastTile = board.getTiles().get(board.getTiles().size() - 1);
            if (board.compareTiles(lastTile, tile)) {
                board.getTiles().add(tile);
                System.out.println(name + " положил " + tile.toString() + " на доску.");
            } else {
                System.out.println(name + " не может положить " + tile.toString() + ".");
                return false;
            }
        }
        hand.remove(tile);
        return true;
    }

    public boolean hasTiles() {
        return !hand.isEmpty();
    }

    public List<Domino> getHand() {
        return hand;
    }

    public void setHand(List<Domino> hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }
}