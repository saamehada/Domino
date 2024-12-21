import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DominoGameGUI extends JFrame {
    private DominoGame game;
    private JTextArea boardArea;
    private JTextArea playerHandArea;
    private JTextField inputField;
    private JButton playButton;
    private JButton exitButton;
    private JTextArea logArea;

    public DominoGameGUI() {
        game = new DominoGame();
        game.startGame();

        setTitle("Domino Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        boardArea = new JTextArea();
        boardArea.setEditable(false);
        add(new JScrollPane(boardArea), BorderLayout.NORTH);

        playerHandArea = new JTextArea();
        playerHandArea.setEditable(false);
        add(new JScrollPane(playerHandArea), BorderLayout.CENTER);

        logArea = new JTextArea();
        logArea.setEditable(false);
        add(new JScrollPane(logArea), BorderLayout.EAST);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputPanel.add(inputField, BorderLayout.CENTER);

        playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                game.processInput(input);
                updateBoard();
                updatePlayerHand();
                updateLog();
                inputField.setText("");
            }
        });
        inputPanel.add(playButton, BorderLayout.EAST);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        inputPanel.add(exitButton, BorderLayout.WEST);

        add(inputPanel, BorderLayout.SOUTH);

        updateBoard();
        updatePlayerHand();
        updateLog();
    }

    private void updateBoard() {
        boardArea.setText("Board: " + game.getBoard().toString());
    }

    private void updatePlayerHand() {
        Player currentPlayer = game.getCurrentPlayer();
        List<Domino> hand = currentPlayer.getHand();
        StringBuilder handString = new StringBuilder();
        for (int i = 0; i < hand.size(); i++) {
            handString.append(i).append(": ").append(hand.get(i).toString()).append("\n");
        }
        playerHandArea.setText(currentPlayer.getName() + "'s Hand:\n" + handString.toString());
    }

    private void updateLog() {
        logArea.setText(game.getLog());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DominoGameGUI().setVisible(true);
            }
        });
    }
}
