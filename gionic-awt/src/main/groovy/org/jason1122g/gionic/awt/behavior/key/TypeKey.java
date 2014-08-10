package org.jason1122g.gionic.awt.behavior.key;

import org.jason1122g.gionic.awt.behavior.template.AWTKey;

public class TypeKey extends AWTKey {

    @Override
    protected void of( int keyCode, char keyChar ) {
        getSimulator().keyType( keyCode, getTimes(), getModifier(), keyChar );
    }

}
