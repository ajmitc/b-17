package b17.view;

import b17.Model;

import javax.swing.*;
import java.awt.*;

public class View {
    private static final String MAINMENU = "mainmenu";
    private static final String GAME = "game";

    private Model model;
    private JFrame frame;

    private MainMenuPanel mainMenuPanel;
    private GamePanel gamePanel;

    public View( Model model, JFrame frame ) {
        this.model = model;
        this.frame = frame;

        mainMenuPanel = new MainMenuPanel(model, this);
        gamePanel = new GamePanel(model, this);

        this.frame.getContentPane().setLayout(new CardLayout());
        this.frame.getContentPane().add(mainMenuPanel, MAINMENU);
        this.frame.getContentPane().add(gamePanel, GAME);
    }

    public void refresh(){
        gamePanel.refresh();
    }

    public void showMainMenu(){
        CardLayout cardLayout = (CardLayout) this.frame.getContentPane().getLayout();
        cardLayout.show(this.frame.getContentPane(), MAINMENU);
    }

    public void showGame(){
        CardLayout cardLayout = (CardLayout) this.frame.getContentPane().getLayout();
        cardLayout.show(this.frame.getContentPane(), GAME);
    }

    public Model getModel() {
        return model;
    }

    public void setModel( Model model ) {
        this.model = model;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame( JFrame frame ) {
        this.frame = frame;
    }

    public MainMenuPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
