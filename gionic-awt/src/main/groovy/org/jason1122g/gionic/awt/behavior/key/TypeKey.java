package org.jason1122g.gionic.awt.behavior.key;

import org.jason1122g.gionic.awt.behavior.template.AWTKey;

public class TypeKey extends AWTKey {

    @Override
    public void of( int keyCode ) {
        getSimulator().keyType( keyCode, getTimes(), getModifier() );
    }

}
