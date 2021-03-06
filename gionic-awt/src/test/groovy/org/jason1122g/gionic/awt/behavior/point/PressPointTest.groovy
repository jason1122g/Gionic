package org.jason1122g.gionic.awt.behavior.point

import org.jason1122g.gionic.awt.simulator.AWTSimulator
import org.jason1122g.gionic.behavior.Point
import spock.lang.Specification

import java.awt.event.MouseEvent

class PressPointTest extends Specification {

    AWTSimulator simulator;
    Point press;

    def setup(){
        simulator = Mock( AWTSimulator )
        press     = new PressPoint().setSimulator( simulator )
    }

    def "call at() to specify the press location"(){
        when:
            press.at( 10, 10 )
        then:
            1 * simulator.press( 10, 10, 1, 0 );
    }

    def "call forTimes() to specify the press times"(){
        when:
            press.forTimes( 3 ).at( 1, 2 )
        then:
            1 * simulator.press( 1, 2, 3, 0 )
    }

    def "call with() to specify the mouse button source"(){
        when:
            press.with( MouseEvent.BUTTON1 ).at( 3, 4 )
        then:
            1 * simulator.press( 3, 4, 1, MouseEvent.BUTTON1_DOWN_MASK )
    }

    def "call atSomeWhere() to press at some point"(){
        when:
            press.atSomeWhere()
        then:
            1 * simulator.press( _ as Integer, _ as Integer, 1, 0 )
    }

    def "forTimes() can also be applied to atSomeWhere()"(){
        when:
            press.forTimes( 5 ).atSomeWhere()
        then:
            1 * simulator.press( _ as Integer, _ as Integer, 5, 0 )
    }

}
