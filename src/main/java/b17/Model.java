package b17;

import b17.game.Game;

public class Model {
    private boolean exit;
    private Game game;

    public Model() {
        this.exit = false;
        this.game = null;
    }

    public void updateGame() {

    }

    public boolean shouldExit() {
        return exit;
    }

    public void setExit( boolean exit ) {
        this.exit = exit;
    }

    public Game getGame() {
        return game;
    }

    public void setGame( Game game ) {
        this.game = game;
    }
}
