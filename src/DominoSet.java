import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DominoSet {
    private List<Domino> tiles;

    public DominoSet() {
        this.tiles = generateDominoSet();
    }

    private List<Domino> generateDominoSet() {
        List<Domino> dominoSet = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                dominoSet.add(new Domino(i, j));
            }
        }
        return dominoSet;
    }

    public void shuffle() {
        Collections.shuffle(tiles);
    }

    public void deal(Player player1, Player player2) {
        player1.setHand(new ArrayList<>(tiles.subList(0, 7)));
        player2.setHand(new ArrayList<>(tiles.subList(7, 14)));
        this.tiles = new ArrayList<>(tiles.subList(14, tiles.size())); // Остальные домино остаются в колоде
    }
}