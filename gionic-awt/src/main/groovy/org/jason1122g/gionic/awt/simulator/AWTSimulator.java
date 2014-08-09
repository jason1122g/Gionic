package org.jason1122g.gionic.awt.simulator;

import org.jason1122g.gionic.core.Simulator;

import java.awt.*;

public interface AWTSimulator extends Simulator {

    public void click  ( int x, int y, int times );
    public void press  ( int x, int y, int times );
    public void release( int x, int y, int times );
    public void enter  ( int x, int y, int times );
    public void exit   ( int x, int y, int times );

    public void move   ( int x, int y );
    public void drag   ( int x, int y );

    public Component getEventTarget();

}
