package org.jason1122g.gionic.awt.simulator

import spock.lang.Specification

import javax.swing.*
import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.util.List

class GionicTest4 extends Specification {

    Component    component
    Map< String, List<MouseEvent> > mouseEvent;

    def setup(){
        prepareContainers();
        prepareEventListeners();
    }

    private void prepareContainers(){
        mouseEvent = new HashMap<>()
        mouseEvent["click"]   = []
    }

    private void prepareEventListeners(){
        component  = new JPanel()
        component.addMouseListener( new MouseAdapter() {
            @Override
            void mouseClicked( MouseEvent e ) {
                mouseEvent["click"]   << e
            }
        })
    }

    def "release with correct button, repeat times and position"(){
        given:
            def simulator = Gionic.control( component )
        when:
            simulator.keyPress().of( KeyEvent.VK_CONTROL )
            simulator.click().at( 30, 30 )
        then:
            mouseEvent["click"].size() == 1
        and:
            mouseEvent["click"][0].getPoint() == new Point( 30, 30 )
            mouseEvent["click"][0].isControlDown()
    }

}
