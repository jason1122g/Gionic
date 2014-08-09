package org.jason1122g.gionic.awt.behavior.point

import org.jason1122g.gionic.awt.simulator.AWTSimulator
import org.jason1122g.gionic.behavior.Point
import spock.lang.Specification

class ClickPointTest extends Specification{

    AWTSimulator simulator;
    Point   click;

    def setup(){
        simulator = Mock( AWTSimulator )
        click     = new ClickPoint().setSimulator( simulator )
    }

    def "call at() to specify the click location"(){
        when:
            click.at( 10, 10 )
        then:
            1 * simulator.click( 10, 10, 1 );
    }

    def "call forTimes() to specify the click times"(){
        when:
            click.forTimes( 3 ).at( 1, 2 )
        then:
            1 * simulator.click( 1, 2, 3)
    }

    def "call atSomeWhere() to click at some point"(){
        when:
            click.atSomeWhere()
        then:
            1 * simulator.click( _ as Integer, _ as Integer, 1 )
    }

    def "forTimes() can also be applied to atSomeWhere()"(){
        when:
            click.forTimes( 5 ).atSomeWhere()
        then:
            1 * simulator.click( _ as Integer, _ as Integer, 5 )
    }

}
