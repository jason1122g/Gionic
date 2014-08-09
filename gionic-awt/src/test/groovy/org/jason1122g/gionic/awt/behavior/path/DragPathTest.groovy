package org.jason1122g.gionic.awt.behavior.path

import org.jason1122g.gionic.awt.simulator.AWTSimulator
import org.jason1122g.gionic.behavior.Path
import spock.lang.Specification

class DragPathTest extends Specification {

    AWTSimulator simulator;
    Path drag;

    def setup(){
        simulator = Mock( AWTSimulator )
        drag     = new DragPath().setSimulator( simulator )
    }

    def "call from(), to(), endHere() to specify the drag path"(){
        when:
            drag.from( 0, 0 ).to( 1, 1 ).endHere()
        then:
            1 * simulator.press( 0, 0 , 1);
            1 * simulator.drag ( 0, 0 );
            1 * simulator.drag ( 1, 1 );
            1 * simulator.release( 1, 1, 1 );
    }

    def "call to() coniniously to specify a path"(){
        when:
            drag.from( 0, 0 ).to( 1, 1 ).to( 2, 2 ).endHere()
        then:
            1 * simulator.press( 0, 0 , 1);
            1 * simulator.drag ( 0, 0 );
            1 * simulator.drag ( 1, 1 );
            1 * simulator.drag ( 2, 2 );
            1 * simulator.release( 2, 2, 1 );
    }

    def "call inSomePath() to drag in some path"(){
        when:
            drag.inSomePath()
        then:
            1 * simulator.press  ( 0 ,0 ,1 )
            1 * simulator.drag   ( 0, 0 )
            1 * simulator.drag   ( 1, 1 )
            1 * simulator.release( 1, 1, 1 )
    }

}
