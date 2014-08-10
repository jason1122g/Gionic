package org.jason1122g.gionic.awt.behavior.key

import org.jason1122g.gionic.awt.simulator.AWTSimulator
import org.jason1122g.gionic.behavior.Key
import spock.lang.Specification

import java.awt.event.KeyEvent

class PressKeyTest extends Specification {

    AWTSimulator simulator;
    Key press;

    def setup(){
        simulator = Mock( AWTSimulator )
        press     = new PressKey().setSimulator( simulator )
    }

    def "of( int ) is used for keys like ctrl, shift, alt...etc"(){
        when:
            press.of( KeyEvent.VK_SHIFT )
        then:
            1 * simulator.keyPress( KeyEvent.VK_SHIFT, 1, 0 )
    }

    def "of( char ) is used for Alphabet inputs"(){
        when:
            press.of( 'a' as Character )
        then:
            1 * simulator.keyPress( KeyEvent.VK_A, 1, 0 )
    }

    def "of( char ) can also handle uppercase"(){
        when:
            press.of( 'A' as Character )
        then:
            1 * simulator.keyPress( KeyEvent.VK_A, 1, KeyEvent.SHIFT_DOWN_MASK )
    }

    def "of( char ) with incorrect char will throw exception"(){
        when:
            press.of( 0 as Character )
        then:
            thrown( IllegalArgumentException )
    }

    def "forTimes() can specify the repeat times"(){
        when:
            press.forTimes( 3 ).of( 'a' as Character )
        then:
            1 * simulator.keyPress( KeyEvent.VK_A, 3, 0 )
    }

    def "ofSomeKey() can use the default key"(){
        when:
            press.ofSomeKey()
        then:
            1 * simulator.keyPress( _ as Integer, 1, 0 )
    }

}
