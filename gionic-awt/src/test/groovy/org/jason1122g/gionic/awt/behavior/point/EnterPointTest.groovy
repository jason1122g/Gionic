package org.jason1122g.gionic.awt.behavior.point

import org.jason1122g.gionic.awt.simulator.AWTSimulator
import org.jason1122g.gionic.behavior.Point
import spock.lang.Specification

class EnterPointTest extends Specification {

    AWTSimulator simulator;
    Point enter;

    def setup(){
        simulator = Mock( AWTSimulator )
        enter     = new EnterPoint().setSimulator( simulator )
    }

    def "call at() to specify the press location"(){
        when:
            enter.at( 10, 10 )
        then:
            1 * simulator.enter( 10, 10, 1 );
    }

    def "call forTimes() to specify the press times"(){
        when:
            enter.forTimes( 3 ).at( 1, 2 )
        then:
            1 * simulator.enter( 1, 2, 3)
    }

    def "call atSomeWhere() to press at some point"(){
        when:
            enter.atSomeWhere()
        then:
            1 * simulator.enter( _ as Integer, _ as Integer, 1 )
    }

    def "forTimes() can also be applied to atSomeWhere()"(){
        when:
            enter.forTimes( 5 ).atSomeWhere()
        then:
            1 * simulator.enter( _ as Integer, _ as Integer, 5 )
    }
}
