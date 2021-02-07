package b17;

import b17.game.Game;

public class Model {
    private Game game;

    public Model() {
        this.game = null;
    }

    public void updateGame() {

    }

    public Game getGame() {
        return game;
    }

    public void setGame( Game game ) {
        this.game = game;
    }
}
