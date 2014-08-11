package org.jason1122g.gionic.awt.simulator

import spock.lang.Specification

import java.awt.*
import java.awt.event.*

class GionicTest5 extends Specification {

    def "Gionic can control mouseAdapter events"(){
        given:
            MouseEvent mouseEvent = null
            def mouseAdapter = new MouseAdapter() {
                @Override
                void mouseClicked( MouseEvent e ) {
                    mouseEvent = e
                }
            }
        when:
            Gionic.control( mouseAdapter as MouseAdapter ).click().at( 30, 30 )
        then:
            mouseEvent.getPoint() == new Point( 30, 30 )
    }

    def "Gionic can control mouseListener events"(){
        given:
            MouseEvent mouseEvent = null
            def mouseAdapter = new MouseAdapter() {
                @Override
                void mouseClicked( MouseEvent e ) {
                    mouseEvent = e
                }
            }
        when:
            Gionic.control( (MouseListener) mouseAdapter ).click().at( 30, 30 )
        then:
            mouseEvent.getPoint() == new Point( 30, 30 )
    }

    def "Gionic can control mouseMotionListener events"(){
        given:
            MouseEvent mouseEvent = null
            def mouseMotionListener = new MouseMotionAdapter() {
                @Override
                void mouseMoved( MouseEvent e ) {
                    mouseEvent = e
                }
            }
        when:
            Gionic.control( mouseMotionListener ).move().from( 10, 10 ).to( 20, 20 )
        then:
            mouseEvent.getPoint() == new Point( 20, 20 )
    }

    def "Gionic can control keyListener events"(){
        given:
            KeyEvent keyEvent = null
            def keyListener = new KeyAdapter() {
                @Override
                void keyTyped( KeyEvent e ) {
                    keyEvent = e
                }
            }
        when:
            Gionic.control( keyListener ).keyType().of( 'a' as Character )
        then:
            keyEvent.getKeyChar() == 'a'
    }

}
