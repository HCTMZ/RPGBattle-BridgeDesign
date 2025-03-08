import javax.swing.*;
import java.awt.*;


public class CharacterCustomizationGUI extends JFrame {
    private Character character;  
    private JLabel characterImageLabel;
    private JLabel weaponImageLabel;

    public CharacterCustomizationGUI() {
        setTitle("Character Customization");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));

        //left panel
        JPanel characterPanel = new JPanel();
        characterPanel.setLayout(new BorderLayout());
        characterPanel.setBorder(BorderFactory.createTitledBorder("Select Character"));

        JPanel characterButtonPanel = new JPanel();
        characterButtonPanel.setLayout(new GridLayout(2, 1));

        JButton warriorButton = new JButton("Warrior");
        JButton mageButton = new JButton("Mage");

        warriorButton.addActionListener(e -> selectCharacter("Warrior"));
        mageButton.addActionListener(e -> selectCharacter("Mage"));

        characterButtonPanel.add(warriorButton);
        characterButtonPanel.add(mageButton);

        characterImageLabel = new JLabel();
        characterImageLabel.setHorizontalAlignment(JLabel.CENTER);

        characterPanel.add(characterButtonPanel, BorderLayout.NORTH);
        characterPanel.add(characterImageLabel, BorderLayout.CENTER);

        // Right Panel: Weapon Selection
        JPanel weaponPanel = new JPanel();
        weaponPanel.setLayout(new BorderLayout());
        weaponPanel.setBorder(BorderFactory.createTitledBorder("Select Weapon"));

        JPanel weaponButtonPanel = new JPanel();
        weaponButtonPanel.setLayout(new GridLayout(3, 1));

        JButton swordButton = new JButton("Sword");
        JButton staffButton = new JButton("Staff");
        JButton bowButton = new JButton("Bow");

        swordButton.addActionListener(e -> selectWeapon("Sword"));
        staffButton.addActionListener(e -> selectWeapon("Staff"));
        bowButton.addActionListener(e -> selectWeapon("Bow"));

        weaponButtonPanel.add(swordButton);
        weaponButtonPanel.add(staffButton);
        weaponButtonPanel.add(bowButton);

        weaponImageLabel = new JLabel();
        weaponImageLabel.setHorizontalAlignment(JLabel.CENTER);

        weaponPanel.add(weaponButtonPanel, BorderLayout.NORTH);
        weaponPanel.add(weaponImageLabel, BorderLayout.CENTER);

        mainPanel.add(characterPanel);
        mainPanel.add(weaponPanel);

        // Bottom Panel: Start Battle Button
        JPanel bottomPanel = new JPanel();
        JButton startBattleButton = new JButton("Start Battle");
        startBattleButton.addActionListener(e -> startBattle());

        bottomPanel.add(startBattleButton);

        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void selectCharacter(String characterType) {
        if (characterType.equals("Warrior")) {
            character = new Warrior(new Sword());
            characterImageLabel.setIcon(new ImageIcon("assets/warrior.png"));
        } else if (characterType.equals("Mage")) {
            character = new Mage(new Staff());
            characterImageLabel.setIcon(new ImageIcon("assets/mage.png"));
        }
    }

    private void selectWeapon(String weaponType) {
        if (character != null) {
            switch (weaponType) {
                case "Sword":
                    character.equipWeapon(new Sword());
                    weaponImageLabel.setIcon(new ImageIcon("assets/sword.png"));
                    break;
                case "Staff":
                    character.equipWeapon(new Staff());
                    weaponImageLabel.setIcon(new ImageIcon("assets/staff.png"));
                    break;
                case "Bow":
                    character.equipWeapon(new Bow());
                    weaponImageLabel.setIcon(new ImageIcon("assets/bow.png"));
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a character first!");
        }
    }

    private void startBattle() {
        if (character != null && character.weapon != null) {
            this.dispose();
            Battle battle = new Battle(character);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a character and weapon first!");
        }
    }
}