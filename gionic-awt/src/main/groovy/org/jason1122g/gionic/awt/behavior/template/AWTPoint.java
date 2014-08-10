package org.jason1122g.gionic.awt.behavior.template;

import org.jason1122g.gionic.awt.behavior.template.abstracts.AWTContainer;
import org.jason1122g.gionic.awt.behavior.template.abstracts.AWTModifiers;
import org.jason1122g.gionic.awt.behavior.template.abstracts.AWTTimer;
import org.jason1122g.gionic.awt.simulator.AWTSimulator;
import org.jason1122g.gionic.behavior.Point;

import java.awt.event.MouseEvent;

public abstract class AWTPoint implements Point, AWTTimer, AWTModifiers, AWTContainer {

    private int times = 1;
    private int mouseModifier = 0;
    private AWTSimulator simulator;

    @Override
    public Point forTimes( int times ) {
        this.times = times;
        return this;
    }

    @Override
    public Point with( int mouseButton ) {
        switch ( mouseButton ){
            case MouseEvent.BUTTON1:
                mouseModifier |= MouseEvent.BUTTON1_DOWN_MASK; break;
            case MouseEvent.BUTTON2:
                mouseModifier |= MouseEvent.BUTTON2_DOWN_MASK; break;
            case MouseEvent.BUTTON3:
                mouseModifier |= MouseEvent.BUTTON3_DOWN_MASK; break;
        }
        return this;
    }

    @Override
    public void atSomeWhere() {
        this.at( 0, 0 );
    }

    @Override
    public int getTimes(){
        return times;
    }

    @Override
    public AWTSimulator getSimulator() {
        return simulator;
    }

    public int getModifier(){
        return mouseModifier;
    }

    public AWTPoint setSimulator( AWTSimulator simulator ) {
        this.simulator = simulator;
        return this;
    }


}
