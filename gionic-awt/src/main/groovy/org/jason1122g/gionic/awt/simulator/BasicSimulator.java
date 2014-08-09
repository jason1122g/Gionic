package org.jason1122g.gionic.awt.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * TODO TEST AND FINISH THIS
 */
abstract class BasicSimulator implements AWTSimulator {

    private Component eventTarget;

    private int eventState = 0;
    private int keyModifier;

    public BasicSimulator( Component eventTarget ){
        this.eventTarget = eventTarget;
    }

    @Override
    public void click( int x, int y, int times ) {
        if( times > 0 ){
            for( int i = 0 ; i < times ; i ++ ){
                dispatchMouseEvent( MouseEvent.MOUSE_PRESSED , x, y, 1 );
                dispatchMouseEvent( MouseEvent.MOUSE_RELEASED, x, y, 1 );
                dispatchMouseEvent( MouseEvent.MOUSE_CLICKED , x, y, 1 );
            }
            eventState = MouseEvent.MOUSE_CLICKED;
        }
    }

    @Override
    public void press( int x, int y, int times ) {
        if( times > 0 ){

            if( eventState == MouseEvent.MOUSE_PRESSED ){
                dispatchMouseEvent( MouseEvent.MOUSE_RELEASED, x, y, 1 );
            }
            click( x, y, times - 1 );
            dispatchMouseEvent( MouseEvent.MOUSE_PRESSED, x, y, 1 );

            eventState = MouseEvent.MOUSE_PRESSED;
        }
    }

    @Override
    public void release( int x, int y, int times ) {
        if ( times > 0 ){

            if( eventState == MouseEvent.MOUSE_PRESSED ){
                dispatchMouseEvent( MouseEvent.MOUSE_RELEASED, x, y, 1 );
                click( x, y, times - 1 );
            }else{
                click( x, y, times );
            }

            eventState = MouseEvent.MOUSE_RELEASED;
        }
    }

    @Override
    public void enter( int x, int y, int times ) {
        if( times > 0 ){

            if( eventState == MouseEvent.MOUSE_ENTERED ){
                dispatchMouseEvent( MouseEvent.MOUSE_EXITED, x, y, 1 );
            }
            enterExit( x, y, times - 1 );
            dispatchMouseEvent( MouseEvent.MOUSE_ENTERED, x, y, 1 );

            eventState = MouseEvent.MOUSE_ENTERED;
        }
    }

    @Override
    public void exit( int x, int y, int times ) {
        if( times > 0 ){

            if( eventState == MouseEvent.MOUSE_ENTERED ){
                dispatchMouseEvent( MouseEvent.MOUSE_EXITED, x, y, 1 );
                enterExit( x, y, times - 1 );
            }else{
                enterExit( x, y, times );
            }

            eventState = MouseEvent.MOUSE_EXITED;
        }
    }

    private void enterExit( int x, int y, int times ){
        for( int i = 0 ; i < times ; i ++ ){
            dispatchMouseEvent( MouseEvent.MOUSE_ENTERED, x, y, 1 );
            dispatchMouseEvent( MouseEvent.MOUSE_EXITED, x, y, 1 );
        }
    }
    
    @Override
    public void move( int x, int y ) {
        dispatchMouseEvent( MouseEvent.MOUSE_MOVED, x, y, 1 );
    }

    @Override
    public void drag( int x, int y ) {
        dispatchMouseEvent( MouseEvent.MOUSE_DRAGGED, x, y, 1 );
    }

    public Component getEventTarget(){
        return eventTarget;
    }

    private void dispatchMouseEvent( final int eventID, final int x, final int y, final int times ){
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                eventTarget.dispatchEvent( new MouseEvent( eventTarget, eventID, System.currentTimeMillis(),
                        keyModifier, x, y, times, false ) );
            }
        } );
    }
}
