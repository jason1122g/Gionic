package org.jason1122g.gionic.awt.simulator

import spock.lang.Specification

import javax.swing.*
import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.util.List

class GionicTest3 extends Specification {

    Component    component
    Map< String, List<KeyEvent> > keyEvent;

    def setup(){
        prepareContainers();
        prepareEventListeners();
    }

    private void prepareContainers(){
        keyEvent = new HashMap<>()
        keyEvent["keyType"]     = []
        keyEvent["keyPress"]    = []
        keyEvent["keyRelease"]  = []
    }

    private void prepareEventListeners(){
        component  = new JPanel()
        component.addKeyListener( new KeyListener() {
            @Override
            void keyTyped( KeyEvent e ) {
                keyEvent["keyType"]    << e
            }
            @Override
            void keyPressed( KeyEvent e ) {
                keyEvent["keyPress"]   << e
            }
            @Override
            void keyReleased( KeyEvent e ) {
                keyEvent["keyRelease"] << e
            }
        })
    }

    def "keyPress with correct keyChar and keyCode"(){
        when:
            Gionic.control( component ).keyPress().forTimes( 3 ).of( '?' as Character )
        then:
            keyEvent["keyPress"].size() == 3
        and:
            keyEvent["keyPress"][0].getKeyCode() == KeyEvent.VK_SLASH
            keyEvent["keyPress"][0].getKeyChar() == '?'
    }

    def "keyRelease with correct keyChar and keyCode"(){
        when:
            Gionic.control( component ).keyRelease().forTimes( 2 ).of( '|' as Character )
        then:
            keyEvent["keyRelease"].size() == 2
        and:
            keyEvent["keyRelease"][0].getKeyCode() == KeyEvent.VK_BACK_SLASH
            keyEvent["keyRelease"][0].getKeyChar() == '|'
    }

    def "keyType with correct keyChar and keyCode"(){
        when:
            Gionic.control( component ).keyType().forTimes( 2 ).of( 'a' as Character )
        then:
            keyEvent["keyPress"  ].size() == 2
            keyEvent["keyRelease"].size() == 2
            keyEvent["keyType"   ].size() == 2
        and:
            keyEvent["keyPress"][0].getKeyCode()   == KeyEvent.VK_A
            keyEvent["keyPress"][0].getKeyChar()   == 'a'
        and:
            keyEvent["keyType"][0].getKeyCode()    == KeyEvent.VK_A
            keyEvent["keyType"][0].getKeyChar()    == 'a'
        and:
            keyEvent["keyRelease"][0].getKeyCode() == KeyEvent.VK_A
            keyEvent["keyRelease"][0].getKeyChar() == 'a'
    }

}
