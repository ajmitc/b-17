package b17.view;

import b17.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainMenuPanel extends JPanel {
    private Model model;
    private View view;

    private BufferedImage coverImage;
    private JButton btnNewCampaign;
    private JButton btnNewMission;
    private JButton btnExit;

    public MainMenuPanel(Model model, View view){
        super(new GridLayout(1, 2));
        this.model = model;
        this.view = view;

        btnNewCampaign = new JButton("New Campaign");
        btnNewMission = new JButton("New Mission");
        btnExit = new JButton("Exit");

        coverImage = ImageUtil.get("cover.jpg");
        add(new JLabel(new ImageIcon(coverImage)));

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.PAGE_AXIS));
        btnPanel.add(btnNewMission);
        btnPanel.add(btnExit);
    }

    public JButton getBtnNewCampaign() {
        return btnNewCampaign;
    }

    public JButton getBtnNewMission() {
        return btnNewMission;
    }

    public JButton getBtnExit() {
        return btnExit;
    }
}
