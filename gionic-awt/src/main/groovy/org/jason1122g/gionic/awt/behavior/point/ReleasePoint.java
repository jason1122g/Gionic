package org.jason1122g.gionic.awt.behavior.point;

import org.jason1122g.gionic.awt.behavior.template.AWTPoint;

public class ReleasePoint extends AWTPoint {

    @Override
    public void at( int x, int y ) {
        getSimulator().release( x, y, getTimes(), getModifier() );
    }

}
