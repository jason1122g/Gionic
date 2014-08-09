package org.jason1122g.gionic.awt.behavior.abstracts;

import org.jason1122g.gionic.awt.simulator.AWTSimulator;
import org.jason1122g.gionic.behavior.Point;

public abstract class AWTPoint implements Point {

    private int times = 1;
    private AWTSimulator simulator;

    @Override
    public Point forTimes( int times ) {
        this.times = times;
        return this;
    }

    @Override
    public void atSomeWhere() {
        this.at( 0, 0 );
    }

    public int getTimes(){
        return times;
    }

    public AWTSimulator getSimulator() {
        return simulator;
    }

    public AWTPoint setSimulator( AWTSimulator simulator ) {
        this.simulator = simulator;
        return this;
    }


}
