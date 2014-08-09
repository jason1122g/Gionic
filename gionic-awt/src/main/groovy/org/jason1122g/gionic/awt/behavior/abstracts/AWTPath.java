package org.jason1122g.gionic.awt.behavior.abstracts;

import org.jason1122g.gionic.awt.simulator.AWTSimulator;
import org.jason1122g.gionic.behavior.Path;

public abstract class AWTPath implements Path {

    private AWTSimulator simulator;
    @Override
    public void inSomePath() {
        from( 0, 0 ).to( 1, 1 );
    }

    public AWTSimulator getSimulator() {
        return simulator;
    }

    public AWTPath setSimulator( AWTSimulator simulator ) {
        this.simulator = simulator;
        return this;
    }
}
