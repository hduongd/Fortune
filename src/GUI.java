import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI implements ActionListener {
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    private Board board;
    private Player player;

    public GUI() {
        initGame();

        // GUI Stuff
        frame = new JFrame();

        JButton button = new JButton("Advance");
        button.addActionListener(this);

        label = new JLabel("Start");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Fortune Game");
        frame.pack();
        frame.setVisible(true);
    }

    private void initGame() {
        board = new Board();
        try {
            board.init();
        } catch (IOException e) {
            System.err.println(e);
        }

        player = new Player();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.advance(1);
        label.setText(board.getTileInfo(player.getPosition()));
    }
    public static void main(String[] args) {
        new GUI();
    }
}
