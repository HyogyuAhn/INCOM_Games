package incom.hyogyu.gui;

import incom.hyogyu.gui.games.DodgeMasterPanel;
import incom.hyogyu.gui.games.MemoryGamePanel;
import incom.hyogyu.gui.games.SnakeGamePanel;

import javax.swing.*;
import java.awt.*;

public class GUIManager {
    private final JFrame frame;
    private final CardLayout cardLayout;
    private final JPanel mainPanel;
    private final SnakeGamePanel snakeGame;
    private final DodgeMasterPanel dodgeMaster;
    private final MemoryGamePanel memoryGame;
    private final MainMenuPanel mainMenu;

    public GUIManager() {
        frame = new JFrame("[INCOM] 동아리 박람회");
        frame.setSize(1366, 768);
        frame.setResizable(false);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        mainMenu = new MainMenuPanel(this);
        snakeGame = new SnakeGamePanel(this);
        dodgeMaster = new DodgeMasterPanel(this);
        memoryGame = new MemoryGamePanel(this);

        mainPanel.add(mainMenu, "MainMenu");
        mainPanel.add(snakeGame, "SnakeGame");
        mainPanel.add(dodgeMaster, "DodgeMaster");
        mainPanel.add(memoryGame, "MemoryGame");

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void switchTo(String panelName) {
        snakeGame.stopGame();
        dodgeMaster.stopGame();
        memoryGame.stopGame();

        cardLayout.show(mainPanel, panelName);
        if (panelName.equals("SnakeGame")) {
            snakeGame.startGame();
        } else if (panelName.equals("DodgeMaster")) {
            dodgeMaster.startGame();
        } else if (panelName.equals("MemoryGame")) {
            memoryGame.startGame();
        }
    }

}
