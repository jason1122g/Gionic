package org.jason1122g.gionic.core;

import org.jason1122g.gionic.keyboard.keyPressable;
import org.jason1122g.gionic.keyboard.keyReleasable;
import org.jason1122g.gionic.keyboard.keyTypable;
import org.jason1122g.gionic.mouse.*;
import org.jason1122g.gionic.mouse.motion.draggable;
import org.jason1122g.gionic.mouse.motion.moveable;

public interface Simulator extends clickable, pressable, releasable, enterable,
        exitable, draggable, moveable, keyPressable, keyReleasable, keyTypable {


}
