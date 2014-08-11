package org.jason1122g.gionic.awt.simulator;

import org.jason1122g.gionic.awt.behavior.key.PressKey;
import org.jason1122g.gionic.awt.behavior.key.ReleaseKey;
import org.jason1122g.gionic.awt.behavior.key.TypeKey;
import org.jason1122g.gionic.awt.behavior.path.DragPath;
import org.jason1122g.gionic.awt.behavior.path.MovePath;
import org.jason1122g.gionic.awt.behavior.point.*;
import org.jason1122g.gionic.behavior.Key;
import org.jason1122g.gionic.behavior.Path;
import org.jason1122g.gionic.behavior.Point;

import java.awt.*;

abstract class SimulatorDistributor extends SimulatorImplementer {

    protected SimulatorDistributor( Component eventTarget ){
        super( eventTarget );
    }

    @Override
    public Point click() {
        return new ClickPoint().setSimulator( this );
    }

    @Override
    public Point press() {
        return new PressPoint().setSimulator( this );
    }

    @Override
    public Point release() {
        return new ReleasePoint().setSimulator( this );
    }

    @Override
    public Point enter() {
        return new EnterPoint().setSimulator( this );
    }

    @Override
    public Point exit() {
        return new ExitPoint().setSimulator( this );
    }

    @Override
    public Path move() {
        return new MovePath().setSimulator( this );
    }

    @Override
    public Path drag() {
        return new DragPath().setSimulator( this );
    }

    @Override
    public Key keyPress() {
        return new PressKey().setSimulator( this );
    }

    @Override
    public Key keyRelease() {
        return new ReleaseKey().setSimulator( this );
    }

    @Override
    public Key keyType() {
        return new TypeKey().setSimulator( this );
    }

}
