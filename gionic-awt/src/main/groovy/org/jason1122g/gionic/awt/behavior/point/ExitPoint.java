package org.jason1122g.gionic.awt.behavior.point;

import org.jason1122g.gionic.awt.behavior.template.AWTPoint;

public class ExitPoint extends AWTPoint {
    @Override
    public void at( int x, int y ) {
        getSimulator().exit( x, y, getTimes(), getModifier() );
    }
}
