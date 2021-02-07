package b17.view;

import b17.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapBoard extends JPanel {
    private static final String MAP_IMAGE_NAME = "strategic_movement_board-wood2-horz.png";
    private static final String B17_IMAGE_NAME = "B17 Position.png";

    private Model model;
    private View view;
    private BufferedImage mapImage;
    private BufferedImage b17Image;

    public MapBoard(Model model, View view){
        super();
        this.model = model;
        this.view = view;

        mapImage = ImageUtil.get(MAP_IMAGE_NAME);
        b17Image = ImageUtil.get(B17_IMAGE_NAME);
    }

    public void paintComponent(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;

        g.drawImage(mapImage, 0, 0, null);
        g.drawImage(b17Image, 0, 0, null);
    }
}
