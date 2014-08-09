package org.jason1122g.gionic.awt.simulator;

import org.jason1122g.gionic.awt.behavior.point.*;
import org.jason1122g.gionic.behavior.Key;
import org.jason1122g.gionic.behavior.Path;
import org.jason1122g.gionic.behavior.Point;

import java.awt.*;
/**
 * TODO TEST AND FINISH THIS
 */
public class RealSimulator extends BasicSimulator {

    private RealSimulator( Component eventTarget ){
        super( eventTarget );
    }

    public static RealSimulator control( Component eventTarge ){
        return new RealSimulator( eventTarge );
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
        return null;
    }

    @Override
    public Path drag() {
        return null;
    }

    @Override
    public Key keyPress() {
        return null;
    }

    @Override
    public Key keyRelease() {
        return null;
    }

    @Override
    public Key keyType() {
        return null;
    }

}
