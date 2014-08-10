package org.jason1122g.gionic.awt.simulator;

import org.jason1122g.gionic.core.Simulator;

public interface AWTSimulator extends Simulator {

    public void click  ( int x, int y, int times, int mouseModifier );
    public void press  ( int x, int y, int times, int mouseModifier );
    public void release( int x, int y, int times, int mouseModifier );
    public void enter  ( int x, int y, int times, int mouseModifier );
    public void exit   ( int x, int y, int times, int mouseModifier );

    public void move   ( int x, int y );
    public void drag   ( int x, int y );

    public void keyPress  ( int keyCode, int times, int keyModifier );
    public void keyRelease( int keyCode, int times, int keyModifier );
    public void keyType   ( int keyCode, int times, int keyModifier );

}
