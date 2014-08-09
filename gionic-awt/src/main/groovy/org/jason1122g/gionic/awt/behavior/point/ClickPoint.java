package org.jason1122g.gionic.awt.behavior.point;

import org.jason1122g.gionic.awt.behavior.abstracts.AWTPoint;

public class ClickPoint extends AWTPoint {

    @Override
    public void at( int x, int y ) {
        getSimulator().click( x, y, getTimes() );
    }

}
