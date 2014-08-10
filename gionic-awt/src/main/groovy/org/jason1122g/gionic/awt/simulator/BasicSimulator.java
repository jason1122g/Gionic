package org.jason1122g.gionic.awt.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * TODO TEST AND FINISH THIS
 */
abstract class BasicSimulator implements AWTSimulator {

    private Component eventTarget;

    private int currentModifier = 0;

    public BasicSimulator( Component eventTarget ){
        this.eventTarget = eventTarget;
    }

    @Override
    public void click( int x, int y, int times, int mouseModifier ) {
        for( int i = 0 ; i < times ; i ++ ){
            dispatchMouseEvent( MouseEvent.MOUSE_PRESSED , x, y, 1, mouseModifier );
            dispatchMouseEvent( MouseEvent.MOUSE_RELEASED, x, y, 1, mouseModifier );
            dispatchMouseEvent( MouseEvent.MOUSE_CLICKED , x, y, 1, mouseModifier );
        }
    }

    @Override
    public void press( int x, int y, int times, int mouseModifier ) {
        dispatchMouseEvent( MouseEvent.MOUSE_PRESSED, x, y, times, mouseModifier );
    }

    @Override
    public void release( int x, int y, int times, int mouseModifier ) {
        dispatchMouseEvent( MouseEvent.MOUSE_RELEASED, x, y, times, mouseModifier );
    }

    @Override
    public void enter( int x, int y, int times, int mouseModifier ) {
        dispatchMouseEvent( MouseEvent.MOUSE_ENTERED, x, y, times, mouseModifier );
    }

    @Override
    public void exit( int x, int y, int times, int mouseModifier ) {
        dispatchMouseEvent( MouseEvent.MOUSE_EXITED, x, y, times, mouseModifier );
    }
    
    @Override
    public void move( int x, int y ) {
        dispatchMouseEvent( MouseEvent.MOUSE_MOVED, x, y, 1, 0 );
    }

    @Override
    public void drag( int x, int y ) {
        dispatchMouseEvent( MouseEvent.MOUSE_DRAGGED, x, y, 1, 0 );
    }

    @Override
    public void keyPress  ( int keyCode, int times, int keyModifier, char keyChar ) {
        for( int i = 0 ; i < times ; i ++ ){
            dispatchKeyEvent( KeyEvent.KEY_PRESSED, keyCode, keyModifier, keyChar );
            switch ( keyCode ){
                case KeyEvent.VK_CONTROL:
                    currentModifier |= MouseEvent.CTRL_DOWN_MASK;  break;
                case KeyEvent.VK_SHIFT:
                    currentModifier |= MouseEvent.SHIFT_DOWN_MASK; break;
                case KeyEvent.VK_ALT:
                    currentModifier |= MouseEvent.ALT_DOWN_MASK;   break;
            }
        }
    }

    @Override
    public void keyRelease( int keyCode, int times, int keyModifier, char keyChar ) {
        for( int i = 0 ; i < times ; i ++ ){
            switch ( keyCode ){
                case KeyEvent.VK_CONTROL:
                    currentModifier ^= MouseEvent.CTRL_DOWN_MASK;  break;
                case KeyEvent.VK_SHIFT:
                    currentModifier ^= MouseEvent.SHIFT_DOWN_MASK; break;
                case KeyEvent.VK_ALT:
                    currentModifier ^= MouseEvent.ALT_DOWN_MASK;   break;
            }
            dispatchKeyEvent( KeyEvent.KEY_RELEASED, keyCode, keyModifier, keyChar );
        }
    }

    @Override
    public void keyType   ( int keyCode, int times, int keyModifier, char keyChar ) {
        for( int i = 0 ; i < times ; i ++ ){
            keyPress  ( keyCode, 1, keyModifier, keyChar );
            keyRelease( keyCode, 1, keyModifier, keyChar );
            dispatchKeyEvent( KeyEvent.KEY_TYPED, keyCode, keyModifier, keyChar );
        }
    }

    private void dispatchMouseEvent( final int eventID, final int x, final int y, final int times, final int mouseModifier ){
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                eventTarget.dispatchEvent( new MouseEvent( eventTarget, eventID, System.currentTimeMillis(),
                        currentModifier | mouseModifier, x, y, times, false ) );
            }
        } );
    }

    private void dispatchKeyEvent( final int eventID, final int keyCode, final int keyModifier, final char keyChar ){
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                eventTarget.dispatchEvent( new KeyEvent( eventTarget, eventID, System.currentTimeMillis(),
                        currentModifier | keyModifier, keyCode, keyChar ) );
            }
        } );
    }

}
