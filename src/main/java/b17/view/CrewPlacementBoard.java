package b17.view;

import b17.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CrewPlacementBoard extends JPanel {
    private static final String PLACEMENT_IMAGE_NAME = "placement_board.png";

    private Model model;
    private View view;
    private BufferedImage boardImage;

    public CrewPlacementBoard(Model model, View view){
        super();
        this.model = model;
        this.view = view;

        boardImage = ImageUtil.get(PLACEMENT_IMAGE_NAME);
    }

    public void paintComponent(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;

        g.drawImage(boardImage, 0, 0, null);
    }
}
