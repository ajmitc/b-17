package b17.view;

import b17.Model;

import javax.swing.*;

public class View {
    private Model model;
    private JFrame frame;

    public View( Model model, JFrame frame ) {
        this.model = model;
        this.frame = frame;
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
}
