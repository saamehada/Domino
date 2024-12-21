import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

class Board {
    private final List<Domino> tiles;

    public Board() {
        this.tiles = new ArrayList<>();
    }

    public boolean compareTiles(Domino tile1, Domino tile2) {
        return (tile1.getFirstSide() == tile2.getFirstSide() ||
                tile1.getFirstSide() == tile2.getSecondSide() ||
                tile1.getSecondSide() == tile2.getFirstSide() ||
                tile1.getSecondSide() == tile2.getSecondSide());
    }

    @Override
    public String toString() {
        return tiles.stream().map(Domino::toString).collect(Collectors.joining(" "));
    }

    public List<Domino> getTiles() {
        return tiles;
    }
}