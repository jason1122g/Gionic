package org.jason1122g.gionic.awt.behavior.path;

import org.jason1122g.gionic.awt.behavior.template.AWTPath;
import org.jason1122g.gionic.behavior.Path;

import java.awt.*;

public class DragPath extends AWTPath {

    private Point point;

    @Override
    public Path from( int x, int y ) {
        getSimulator().press( x, y, 1, 0 );
        getSimulator().drag( x, y );
        return this;
    }

    @Override
    public Path to( int x, int y ) {
        getSimulator().drag( x, y );
        point = new Point( x, y );
        return this;
    }

    @Override
    public void endHere() {
        getSimulator().release( point.x, point.y, 1, 0 );
    }

}
