package org.jason1122g.gionic.awt.behavior.point

import org.jason1122g.gionic.awt.simulator.AWTSimulator
import org.jason1122g.gionic.behavior.Point
import spock.lang.Specification

import java.awt.event.MouseEvent

class EnterPointTest extends Specification {

    AWTSimulator simulator;
    Point enter;

    def setup(){
        simulator = Mock( AWTSimulator )
        enter     = new EnterPoint().setSimulator( simulator )
    }

    def "call at() to specify the enter location"(){
        when:
            enter.at( 10, 10 )
        then:
            1 * simulator.enter( 10, 10, 1, 0 );
    }

    def "call forTimes() to specify the enter times"(){
        when:
            enter.forTimes( 3 ).at( 1, 2 )
        then:
            1 * simulator.enter( 1, 2, 3, 0 )
    }

    def "call with() to specify the mouse button source"(){
        when:
            enter.with( MouseEvent.BUTTON1 ).at( 3, 4 )
        then:
            1 * simulator.enter( 3, 4, 1, MouseEvent.BUTTON1_DOWN_MASK )
    }

    def "call atSomeWhere() to enter at some point"(){
        when:
            enter.atSomeWhere()
        then:
            1 * simulator.enter( _ as Integer, _ as Integer, 1, 0 )
    }

    def "forTimes() can also be applied to atSomeWhere()"(){
        when:
            enter.forTimes( 5 ).atSomeWhere()
        then:
            1 * simulator.enter( _ as Integer, _ as Integer, 5, 0 )
    }
}
