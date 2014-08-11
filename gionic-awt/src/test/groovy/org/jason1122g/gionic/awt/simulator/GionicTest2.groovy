package org.jason1122g.gionic.awt.simulator

import spock.lang.Specification

import javax.swing.*
import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionListener
import java.util.List

class GionicTest2 extends Specification {

    Component    component
    Map< String, List<MouseEvent> > mouseEvent;

    def setup(){
        prepareContainers();
        prepareEventListeners();
    }

    private void prepareContainers(){
        mouseEvent = new HashMap<>()
        mouseEvent["move"]    = []
        mouseEvent["drag"]    = []
        mouseEvent["press"]   = []
        mouseEvent["release"] = []
    }

    private void prepareEventListeners(){
        component  = new JPanel()
        component.addMouseMotionListener( new MouseMotionListener() {
            @Override
            void mouseMoved( MouseEvent e ) {
                mouseEvent["move"]   << e
            }
            @Override
            void mouseDragged( MouseEvent e ) {
                mouseEvent["drag"]   << e
            }
        })
        component.addMouseListener( new MouseAdapter() {
            @Override
            void mousePressed( MouseEvent e ) {
                mouseEvent["press"]   << e
            }
            @Override
            void mouseReleased( MouseEvent e ) {
                mouseEvent["release"] << e
            }
        })
    }

    def "move with correct trigger order"(){
        when:
            Gionic.control( component ).move().from( 10, 10 ).to( 20, 20 ).to( 30, 30 ).endHere()
        then:
            mouseEvent["move"].size() == 3
        and:
            mouseEvent["move"][0].getPoint() == new Point( 10, 10 )
            mouseEvent["move"][1].getPoint() == new Point( 20, 20 )
            mouseEvent["move"][2].getPoint() == new Point( 30, 30 )
    }

    def "drag with correct trigger order"(){
        when:
            Gionic.control( component ).drag().from( 100, 100 ).to( 200, 200 ).to( 300, 300 ).endHere()
        then:
            mouseEvent["press"  ].size() == 1
            mouseEvent["drag"   ].size() == 3
            mouseEvent["release"].size() == 1
        and:
            mouseEvent["drag"   ][0].getButton() == MouseEvent.BUTTON1
        and:
            mouseEvent["press"  ][0].getPoint() == new Point( 100, 100 )
            mouseEvent["drag"   ][0].getPoint() == new Point( 100, 100 )
            mouseEvent["drag"   ][1].getPoint() == new Point( 200, 200 )
            mouseEvent["drag"   ][2].getPoint() == new Point( 300, 300 )
            mouseEvent["release"][0].getPoint() == new Point( 300, 300 )
    }

}
