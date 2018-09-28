package b17;

import b17.view.View;

public class Controller {
    private Model model;
    private View view;

    public Controller( Model model, View view ) {
        this.model = model;
        this.view = view;
    }
}
