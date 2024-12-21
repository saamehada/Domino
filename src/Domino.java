class Domino {
    private int firstSide;
    private int secondSide;

    public Domino(int firstSide, int secondSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }

    @Override
    public String toString() {
        return "[" + firstSide + "|" + secondSide + "]";
    }

    public int getFirstSide() {
        return firstSide;
    }

    public int getSecondSide() {
        return secondSide;
    }
}