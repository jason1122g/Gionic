package org.jason1122g.gionic.awt.behavior.key;

import org.jason1122g.gionic.awt.behavior.template.AWTKey;

public class ReleaseKey extends AWTKey {

    @Override
    public void of( int keyCode ) {
        getSimulator().keyRelease( keyCode, getTimes(), getModifier() );
    }

}
