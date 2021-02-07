package b17.view;

import b17.Model;

import javax.swing.*;

public class GermanFighterAttackBoard extends JPanel {
    private static final String BOARD_IMAGE_NAME = "fighter_attack_board.png";

    private Model model;
    private View view;

    public GermanFighterAttackBoard(Model model, View view){
        super();
        this.model = model;
        this.view = view;
    }
}
