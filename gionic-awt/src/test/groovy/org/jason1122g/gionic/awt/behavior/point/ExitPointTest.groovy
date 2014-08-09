package org.jason1122g.gionic.awt.behavior.point

import org.jason1122g.gionic.awt.simulator.AWTSimulator
import org.jason1122g.gionic.behavior.Point
import spock.lang.Specification

class ExitPointTest extends Specification {


    AWTSimulator simulator;
    Point exit;

    def setup(){
        simulator = Mock( AWTSimulator )
        exit     = new ExitPoint().setSimulator( simulator )
    }

    def "call at() to specify the exit location"(){
        when:
            exit.at( 10, 10 )
        then:
            1 * simulator.exit( 10, 10, 1 );
    }

    def "call forTimes() to specify the exit times"(){
        when:
            exit.forTimes( 3 ).at( 1, 2 )
        then:
            1 * simulator.exit( 1, 2, 3)
    }

    def "call atSomeWhere() to exit at some point"(){
        when:
            exit.atSomeWhere()
        then:
            1 * simulator.exit( _ as Integer, _ as Integer, 1 )
    }

    def "forTimes() can also be applied to atSomeWhere()"(){
        when:
            exit.forTimes( 5 ).atSomeWhere()
        then:
            1 * simulator.exit( _ as Integer, _ as Integer, 5 )
    }
}
