package org.jason1122g.gionic.awt.behavior.key

import org.jason1122g.gionic.awt.simulator.AWTSimulator
import org.jason1122g.gionic.behavior.Key
import spock.lang.Specification

import java.awt.event.KeyEvent

class ReleaseKeyTest extends Specification {

    AWTSimulator simulator;
    Key release;

    def setup(){
        simulator = Mock( AWTSimulator )
        release   = new ReleaseKey().setSimulator( simulator )
    }

    def "of( int ) is used for keys like ctrl, shift, alt...etc"(){
        when:
            release.of( KeyEvent.VK_SHIFT )
        then:
            1 * simulator.keyRelease( KeyEvent.VK_SHIFT, 1, 0 )
    }

    def "of( char ) is used for Alphabet inputs"(){
        when:
            release.of( 'a' as Character )
        then:
            1 * simulator.keyRelease( KeyEvent.VK_A, 1, 0 )
    }

    def "of( char ) can also handle uppercase"(){
        when:
            release.of( 'A' as Character )
        then:
            1 * simulator.keyRelease( KeyEvent.VK_A, 1, KeyEvent.SHIFT_DOWN_MASK )
    }

    def "of( char ) with incorrect char will throw exception"(){
        when:
            release.of( 0 as Character )
        then:
            thrown( IllegalArgumentException )
    }

    def "forTimes() can specify the repeat times"(){
        when:
            release.forTimes( 3 ).of( 'a' as Character )
        then:
            1 * simulator.keyRelease( KeyEvent.VK_A, 3, 0 )
    }

    def "ofSomeKey() can use the default key"(){
        when:
            release.ofSomeKey()
        then:
            1 * simulator.keyRelease( _ as Integer, 1, 0 )
    }
}
