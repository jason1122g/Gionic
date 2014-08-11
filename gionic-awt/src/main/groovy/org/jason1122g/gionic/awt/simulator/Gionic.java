package org.jason1122g.gionic.awt.simulator;

import org.jason1122g.gionic.core.Simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Gionic extends SimulatorDistributor {

    private Gionic( Component eventTarget ){
        super( eventTarget );
    }

    public static Simulator control( Component eventTarget ){
        return new Gionic( eventTarget );
    }

    public static Simulator control( MouseAdapter mouseAdapter ){
        Component component = generateComponent();
        component.addMouseListener      ( mouseAdapter );
        component.addMouseMotionListener( mouseAdapter );
        return control( component );
    }

    public static Simulator control( MouseListener mouseListener ){
        Component component = generateComponent();
        component.addMouseListener( mouseListener );
        return control( component );
    }

    public static Simulator control( MouseMotionListener mouseMotionListener ){
        Component component = generateComponent();
        component.addMouseMotionListener( mouseMotionListener );
        return control( component );
    }

    public static Simulator control( KeyListener keyListener ){
        Component component = generateComponent();
        component.addKeyListener( keyListener );
        return control( component );
    }

    private static Component generateComponent(){
        return new JPanel();
    }

}
