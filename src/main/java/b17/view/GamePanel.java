package b17.view;

import b17.Model;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Model model;
    private View view;

    private MapBoard mapBoard;
    private CrewPlacementBoard crewPlacementBoard;
    private GermanFighterAttackBoard germanFighterAttackBoard;

    public GamePanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;

        mapBoard = new MapBoard(model, view);
        crewPlacementBoard = new CrewPlacementBoard(model, view);
        germanFighterAttackBoard = new GermanFighterAttackBoard(model, view);

        add(germanFighterAttackBoard, BorderLayout.CENTER);
        add(crewPlacementBoard, BorderLayout.EAST);
    }

    public void refresh(){

    }
}
