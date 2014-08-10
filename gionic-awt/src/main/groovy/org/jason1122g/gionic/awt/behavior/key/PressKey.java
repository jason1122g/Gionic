package org.jason1122g.gionic.awt.behavior.key;

import org.jason1122g.gionic.awt.behavior.template.AWTKey;

public class PressKey extends AWTKey {

    @Override
    protected void of( int keyCode, char keyChar ) {
        getSimulator().keyPress( keyCode, getTimes(), getModifier(), keyChar );
    }

}
