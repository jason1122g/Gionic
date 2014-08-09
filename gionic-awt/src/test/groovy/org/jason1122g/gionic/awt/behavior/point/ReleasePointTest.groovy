package org.jason1122g.gionic.awt.behavior.point

import org.jason1122g.gionic.awt.simulator.AWTSimulator
import org.jason1122g.gionic.behavior.Point
import spock.lang.Specification

class ReleasePointTest extends Specification {

    AWTSimulator simulator;
    Point release;

    def setup(){
        simulator = Mock( AWTSimulator )
        release     = new ReleasePoint().setSimulator( simulator )
    }

    def "call at() to specify the release location"(){
        when:
            release.at( 10, 10 )
        then:
            1 * simulator.release( 10, 10, 1 );
    }

    def "call forTimes() to specify the release times"(){
        when:
            release.forTimes( 3 ).at( 1, 2 )
        then:
            1 * simulator.release( 1, 2, 3)
    }

    def "call atSomeWhere() to release at some point"(){
        when:
            release.atSomeWhere()
        then:
            1 * simulator.release( _ as Integer, _ as Integer, 1 )
    }

    def "forTimes() can also be applied to atSomeWhere()"(){
        when:
            release.forTimes( 5 ).atSomeWhere()
        then:
            1 * simulator.release( _ as Integer, _ as Integer, 5 )
    }
}
