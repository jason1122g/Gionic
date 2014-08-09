package org.jason1122g.gionic.awt.behavior.path

import org.jason1122g.gionic.awt.simulator.AWTSimulator
import org.jason1122g.gionic.behavior.Path
import spock.lang.Specification

class MovePathTest extends Specification {

    AWTSimulator simulator;
    Path move;

    def setup(){
        simulator = Mock( AWTSimulator )
        move     = new MovePath().setSimulator( simulator )
    }

    def "call from() and to() to specify the move path"(){
        when:
            move.from( 0, 0 ).to( 1, 1 )
        then:
            1 * simulator.move( 0, 0 );
            1 * simulator.move( 1, 1 );
    }

    def "call to() continiously to specify a path"(){
        when:
            move.from( 0, 0 ).to( 1, 1 ).to( 2, 2 ).to( 3, 3 )
        then:
            1 * simulator.move( 0, 0 );
            1 * simulator.move( 1, 1 );
            1 * simulator.move( 2, 2 );
            1 * simulator.move( 3, 3 );
    }

    def "call inSomePath() to move in some path"(){
        when:
            move.inSomePath()
        then:
            1 * simulator.move( 0, 0 )
    }

}
