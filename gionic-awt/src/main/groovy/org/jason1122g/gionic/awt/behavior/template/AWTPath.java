package org.jason1122g.gionic.awt.behavior.template;

import org.jason1122g.gionic.awt.behavior.template.abstracts.AWTContainer;
import org.jason1122g.gionic.awt.simulator.AWTSimulator;
import org.jason1122g.gionic.behavior.Path;

public abstract class AWTPath implements Path, AWTContainer {

    private AWTSimulator simulator;

    @Override
    public void inSomePath() {
        from( 0, 0 ).to( 1, 1 ).endHere();
    }

    @Override
    public AWTSimulator getSimulator() {
        return simulator;
    }

    public AWTPath setSimulator( AWTSimulator simulator ) {
        this.simulator = simulator;
        return this;
    }
}
