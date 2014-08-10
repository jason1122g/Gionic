package org.jason1122g.gionic.awt.behavior.path;

import org.jason1122g.gionic.awt.behavior.template.AWTPath;
import org.jason1122g.gionic.behavior.Path;

public class MovePath extends AWTPath {

    @Override
    public Path from( int x, int y ) {
        return to( x, y );
    }

    @Override
    public Path to( int x, int y ) {
        getSimulator().move( x, y );
        return this;
    }

    @Override
    public void endHere() {

    }

}
