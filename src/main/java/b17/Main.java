package b17;

import b17.view.View;

import javax.swing.*;

public class Main {

    public static void main( String... args ) {
        JFrame frame = new JFrame();
        frame.setTitle( "B-17 Queen of the Skies" );
        frame.setSize( 800, 600 );
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

        Model model = new Model();
        View view = new View( model, frame );
        new Controller( model, view );

        frame.setVisible( true );
    }
}
