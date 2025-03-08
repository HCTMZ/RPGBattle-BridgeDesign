import javax.swing.*;
import java.awt.*;

class Battle extends JFrame {
    private Character player;
    private JLabel playerImageLabel;
    private JLabel enemyImageLabel;
    private JLabel playerHPLabel;
    private JLabel enemyHPLabel;
    private JTextArea battleLog;
    private JButton attackButton;
    private Character enemy;

    public Battle(Character player) {
        this.player = player;
        this.enemy = new Enemy(new Staff());
        setTitle("Turn-Based Battle");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
        playerHPLabel = new JLabel("HP: " + player.getHP(), JLabel.CENTER);
        playerImageLabel = new JLabel(new ImageIcon("assets/" + player.getClass().getSimpleName().toLowerCase() + ".png"));
        playerImageLabel.setHorizontalAlignment(JLabel.CENTER);
        playerPanel.add(playerHPLabel);
        playerPanel.add(playerImageLabel);

        JPanel enemyPanel = new JPanel();
        enemyPanel.setLayout(new BoxLayout(enemyPanel, BoxLayout.Y_AXIS));
        enemyHPLabel = new JLabel("HP: " + enemy.getHP(), JLabel.CENTER);
        enemyImageLabel = new JLabel(new ImageIcon("assets/enemy.png"));
        enemyImageLabel.setHorizontalAlignment(JLabel.CENTER);
        enemyPanel.add(enemyHPLabel);
        enemyPanel.add(enemyImageLabel);

        JPanel battlePanel = new JPanel();
        battlePanel.setLayout(new GridLayout(1, 2)); // Side-by-side layout
        battlePanel.add(playerPanel);
        battlePanel.add(enemyPanel);

        battleLog = new JTextArea(10, 50);
        battleLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(battleLog);

        attackButton = new JButton("Attack!");
        attackButton.addActionListener(e -> attackEnemy());

        // Add components to frame
        add(battlePanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.NORTH);
        add(attackButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void attackEnemy() {
        // Player attacks enemy
        enemy.setHP(enemy.getHP() - player.weapon.getDamage());
        battleLog.append("Player attacks with " + player.weapon.getName() + "!\n");
        battleLog.append("Enemy HP: " + enemy.getHP() + "\n\n");

        updateHPLabels(); // Update HP display

        if (enemy.getHP() <= 0) {
            battleLog.append("Enemy defeated!\n");
            attackButton.setEnabled(false);
            return;
        }

        // Enemy attacks player
        player.setHP(player.getHP() - enemy.weapon.getDamage());
        battleLog.append("Enemy attacks back!\n");
        battleLog.append("Player HP: " + player.getHP() + "\n\n");

        updateHPLabels(); // Update HP display

        if (player.getHP() <= 0) {
            battleLog.append("Player defeated!\n");
            attackButton.setEnabled(false);
        }
    }

    private void updateHPLabels() {
        playerHPLabel.setText("HP: " + player.getHP());
        enemyHPLabel.setText("HP: " + enemy.getHP());
    }
}
