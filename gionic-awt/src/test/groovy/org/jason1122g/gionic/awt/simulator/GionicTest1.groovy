package org.jason1122g.gionic.awt.simulator

import spock.lang.Specification

import javax.swing.*
import java.awt.*
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.util.List

class GionicTest1 extends Specification {

    Component    component
    Map< String, List<MouseEvent> > mouseEvent;

    def setup(){
        prepareContainers();
        prepareEventListeners();
    }

    private void prepareContainers(){
        mouseEvent = new HashMap<>()
        mouseEvent["click"]   = []
        mouseEvent["press"]   = []
        mouseEvent["release"] = []
        mouseEvent["enter"]   = []
        mouseEvent["exit"]    = []
    }

    private void prepareEventListeners(){
        component  = new JPanel()
        component.addMouseListener( new MouseListener() {
            @Override
            void mouseClicked( MouseEvent e ) {
                mouseEvent["click"]   << e
            }
            @Override
            void mousePressed( MouseEvent e ) {
                mouseEvent["press"]   << e
            }
            @Override
            void mouseReleased( MouseEvent e ) {
                mouseEvent["release"] << e
            }
            @Override
            void mouseEntered( MouseEvent e ) {
                mouseEvent["enter"]   << e
            }
            @Override
            void mouseExited( MouseEvent e ) {
                mouseEvent["exit"]    << e
            }
        })
    }

    def "click with correct button, repeat times and position"(){
        when:
            Gionic.control( component ).click().with( MouseEvent.BUTTON1 ).forTimes( 3 ).at( 10, 10 )
        then:
            mouseEvent["click"  ].size() == 3
            mouseEvent["press"  ].size() == 3
            mouseEvent["release"].size() == 3
        and:
            mouseEvent["click"][0].getButton()     == MouseEvent.BUTTON1
            mouseEvent["click"][0].getPoint()      == new Point( 10, 10 )
            mouseEvent["click"][0].getClickCount() == 1
        and:
            mouseEvent["click"][1].getClickCount() == 2
        and:
            mouseEvent["click"][2].getClickCount() == 3
    }


    def "press with correct button, repeat times and position"(){
        when:
            Gionic.control( component ).press().with( MouseEvent.BUTTON2 ).forTimes( 2 ).at( 20, 20 )
        then:
            mouseEvent["press"].size() == 2
        and:
            mouseEvent["press"][0].getButton()     == MouseEvent.BUTTON2
            mouseEvent["press"][0].getPoint()      == new Point( 20, 20 )
            mouseEvent["press"][0].getClickCount() == 1
        and:
            mouseEvent["press"][1].getButton()     == MouseEvent.BUTTON2
            mouseEvent["press"][1].getPoint()      == new Point( 20, 20 )
            mouseEvent["press"][1].getClickCount() == 2
    }

    def "release with correct button, repeat times and position"(){
        when:
            Gionic.control( component ).release().with( MouseEvent.BUTTON3 ).forTimes( 1 ).at( 30, 30 )
        then:
            mouseEvent["release"].size() == 1
        and:
            mouseEvent["release"][0].getButton()     == MouseEvent.BUTTON3
            mouseEvent["release"][0].getPoint()      == new Point( 30, 30 )
            mouseEvent["release"][0].getClickCount() == 1
    }

    def "enter with correct button, repeat times and position"(){
        when:
            Gionic.control( component ).enter().with( MouseEvent.BUTTON1 ).forTimes( 1 ).at( 40, 40 )
        then:
            mouseEvent["enter"].size() == 1
        and:
            mouseEvent["enter"][0].getButton()     == MouseEvent.BUTTON1
            mouseEvent["enter"][0].getPoint()      == new Point( 40, 40 )
            mouseEvent["enter"][0].getClickCount() == 1
    }

    def "exit with correct button, repeat times and position"(){
        when:
            Gionic.control( component ).exit().with( MouseEvent.BUTTON1 ).forTimes( 1 ).at( 50, 50 )
        then:
            mouseEvent["exit"].size() == 1
        and:
            mouseEvent["exit"][0].getButton()     == MouseEvent.BUTTON1
            mouseEvent["exit"][0].getPoint()      == new Point( 50, 50 )
            mouseEvent["exit"][0].getClickCount() == 1
    }

}
