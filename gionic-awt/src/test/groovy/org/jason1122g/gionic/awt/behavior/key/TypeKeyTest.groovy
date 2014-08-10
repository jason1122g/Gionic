package org.jason1122g.gionic.awt.behavior.key

import org.jason1122g.gionic.awt.simulator.AWTSimulator
import org.jason1122g.gionic.behavior.Key
import spock.lang.Specification

import java.awt.event.KeyEvent

class TypeKeyTest extends Specification {

    AWTSimulator simulator;
    Key type;

    def setup(){
        simulator = Mock( AWTSimulator )
        type      = new TypeKey().setSimulator( simulator )
    }

    def "of( int ) is used for keys like ctrl, shift, alt...etc"(){
        when:
            type.of( KeyEvent.VK_SHIFT )
        then:
            1 * simulator.keyType( KeyEvent.VK_SHIFT, 1, 0, _ as Character )
    }

    def "of( char ) is used for Alphabet inputs"(){
        when:
            type.of( 'a' as Character )
        then:
            1 * simulator.keyType( KeyEvent.VK_A, 1, 0, 'a' as Character )
    }

    def "of( char ) can also handle uppercase"(){
        when:
            type.of( 'A' as Character )
        then:
            1 * simulator.keyType( KeyEvent.VK_A, 1, KeyEvent.SHIFT_DOWN_MASK, 'A' as Character )
    }

    def "of( char ) with incorrect char will throw exception"(){
        when:
            type.of( 0 as Character )
        then:
            thrown( IllegalArgumentException )
    }

    def "forTimes() can specify the repeat times"(){
        when:
            type.forTimes( 3 ).of( '?' as Character )
        then:
            1 * simulator.keyType( KeyEvent.VK_SLASH, 3, KeyEvent.SHIFT_DOWN_MASK, '?' as Character )
    }

    def "ofSomeKey() can use the default key"(){
        when:
            type.ofSomeKey()
        then:
            1 * simulator.keyType( _ as Integer, 1, 0, _ as Character )
    }
}
