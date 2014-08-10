package org.jason1122g.gionic.awt.behavior.key;

import org.jason1122g.gionic.awt.behavior.template.AWTKey;

public class ReleaseKey extends AWTKey {

    @Override
    protected void of( int keyCode, char keyChar ) {
        getSimulator().keyRelease( keyCode, getTimes(), getModifier(), keyChar );
    }

}
