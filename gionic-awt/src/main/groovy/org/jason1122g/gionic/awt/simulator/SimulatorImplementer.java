package org.jason1122g.gionic.awt.simulator;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

abstract class SimulatorImplementer implements AWTSimulator {

    private Component eventTarget;

    private int currentModifier = 0;
    private int popupMenuTriggerEventID;

    public SimulatorImplementer( Component eventTarget ){
        this.eventTarget = eventTarget;
        this.popupMenuTriggerEventID = ( System.getProperty("os.name").toLowerCase().contains( "win" ) ? MouseEvent.MOUSE_RELEASED : MouseEvent.MOUSE_PRESSED );
    }

    @Override
    public void click( int x, int y, int repeatTimes, int mouseModifier ) {
        for( int clickTimes = 1 ; clickTimes <= repeatTimes ; clickTimes ++ ) {
            dispatchMouseEvent( MouseEvent.MOUSE_PRESSED , x, y, clickTimes, mouseModifier );
            dispatchMouseEvent( MouseEvent.MOUSE_RELEASED, x, y, clickTimes, mouseModifier );
            dispatchMouseEvent( MouseEvent.MOUSE_CLICKED , x, y, clickTimes, mouseModifier );
        }
    }

    @Override
    public void press( int x, int y, int repeatTimes, int mouseModifier ) {
        for( int clickTimes = 1 ; clickTimes <= repeatTimes ; clickTimes ++ ) {
            dispatchMouseEvent( MouseEvent.MOUSE_PRESSED, x, y, clickTimes, mouseModifier );
        }
    }

    @Override
    public void release( int x, int y, int repeatTimes, int mouseModifier ) {
        for( int clickTimes = 1 ; clickTimes <= repeatTimes ; clickTimes ++ ) {
            dispatchMouseEvent( MouseEvent.MOUSE_RELEASED, x, y, clickTimes, mouseModifier );
        }
    }

    @Override
    public void enter( int x, int y, int repeatTimes, int mouseModifier ) {
        for( int clickTimes = 1 ; clickTimes <= repeatTimes ; clickTimes ++ ) {
            dispatchMouseEvent( MouseEvent.MOUSE_ENTERED, x, y, clickTimes, mouseModifier );
        }
    }

    @Override
    public void exit( int x, int y, int repeatTimes, int mouseModifier ) {
        for( int clickTimes = 1 ; clickTimes <= repeatTimes ; clickTimes ++ ) {
            dispatchMouseEvent( MouseEvent.MOUSE_EXITED, x, y, clickTimes, mouseModifier );
        }
    }
    
    @Override
    public void move( int x, int y ) {
        dispatchMouseEvent( MouseEvent.MOUSE_MOVED, x, y, 1, 0 );
    }

    @Override
    public void drag( int x, int y ) {
        dispatchMouseEvent( MouseEvent.MOUSE_DRAGGED, x, y, 1, MouseEvent.BUTTON1_DOWN_MASK );
    }

    @Override
    public void keyPress  ( int keyCode, int times, int keyModifier, char keyChar ) {
        for( int i = 0 ; i < times ; i ++ ) {
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
        for( int i = 0 ; i < times ; i ++ ) {
            switch ( keyCode ) {
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
        for( int i = 0 ; i < times ; i ++ ) {
            keyPress  ( keyCode, 1, keyModifier, keyChar );
            keyRelease( keyCode, 1, keyModifier, keyChar );
            dispatchKeyEvent( KeyEvent.KEY_TYPED, keyCode, keyModifier, keyChar );
        }
    }

    private void dispatchMouseEvent( final int eventID, final int x, final int y, final int clickTimes, final int mouseModifier ){
        eventTarget.dispatchEvent( new MouseEvent( eventTarget, eventID, System.currentTimeMillis(),
                currentModifier | mouseModifier, x, y, clickTimes,
                isPopupMenuFlag( eventID, mouseModifier ), getButtonID( mouseModifier ) ) );
    }

    private int getButtonID( int mouseModifier ){
        if( ( mouseModifier & MouseEvent.BUTTON1_DOWN_MASK ) != 0 ){
            return MouseEvent.BUTTON1;
        }else if ( ( mouseModifier & MouseEvent.BUTTON2_DOWN_MASK ) != 0 ){
            return MouseEvent.BUTTON2;
        }else if ( ( mouseModifier & MouseEvent.BUTTON3_DOWN_MASK ) != 0 ){
            return MouseEvent.BUTTON3;
        }else{
            return MouseEvent.NOBUTTON;
        }
    }

    private boolean isPopupMenuFlag( int eventID, int mouseModifier ){
        return ( eventID == popupMenuTriggerEventID && ( mouseModifier & MouseEvent.BUTTON2_DOWN_MASK ) != 0 );
    }

    private void dispatchKeyEvent( final int eventID, final int keyCode, final int keyModifier, final char keyChar ){
        KeyEvent keyEvent = new KeyEvent( eventTarget, eventID, System.currentTimeMillis(),
                currentModifier | keyModifier, 0, keyChar );
        keyEvent.setKeyCode( keyCode );
        KeyboardFocusManager.getCurrentKeyboardFocusManager().redispatchEvent( eventTarget, keyEvent );
    }

}
