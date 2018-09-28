package b17;

import b17.view.View;

public class GameLoop {

    public static void run( Model model, View view ) {
        while( !model.shouldExit() ) {
            model.updateGame();
        }
    }

    private GameLoop() {}
}
