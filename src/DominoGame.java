import java.util.Scanner;


class DominoGame {
    private final DominoSet dominoSet;
    private final Player player1;
    private final Player player2;
    private final Board board;
    private Player currentPlayer;
    private final Scanner scanner;
    private final StringBuilder log;

    public DominoGame() {
        this.dominoSet = new DominoSet();
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.board = new Board();
        this.currentPlayer = player1;
        this.scanner = new Scanner(System.in);
        this.log = new StringBuilder();
    }

    public void startGame() {
        dominoSet.shuffle();
        dominoSet.deal(player1, player2);
        log.append("Game started.\n");
    }

    public void processInput(String input) {
        if (input.toLowerCase().equals("exit")) {
            log.append("Game over.\n");
            scanner.close();
            return;
        }

        try {
            int tileIndex = Integer.parseInt(input);
            if (tileIndex < 0 || tileIndex >= currentPlayer.getHand().size()) {
                log.append("Invalid input. Try again.\n");
                return;
            }

            Domino tileToPlay = currentPlayer.getHand().get(tileIndex);
            if (currentPlayer.playTile(tileToPlay, board)) {
                log.append(currentPlayer.getName() + " played " + tileToPlay.toString() + ".\n");
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                log.append(currentPlayer.getName() + " cannot play " + tileToPlay.toString() + ".\n");
            }

            if (!currentPlayer.hasTiles()) {
                log.append(currentPlayer.getName() + " has no tiles to play!\n");
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        } catch (NumberFormatException e) {
            log.append("Invalid input. Try again.\n");
        }
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getLog() {
        return log.toString();
    }
}
