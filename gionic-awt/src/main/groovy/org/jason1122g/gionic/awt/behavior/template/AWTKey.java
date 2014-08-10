package org.jason1122g.gionic.awt.behavior.template;

import org.jason1122g.gionic.awt.behavior.template.abstracts.AWTContainer;
import org.jason1122g.gionic.awt.behavior.template.abstracts.AWTModifiers;
import org.jason1122g.gionic.awt.behavior.template.abstracts.AWTTimer;
import org.jason1122g.gionic.awt.simulator.AWTSimulator;
import org.jason1122g.gionic.behavior.Key;

import static java.awt.event.KeyEvent.*;

public abstract class AWTKey implements Key, AWTTimer, AWTModifiers, AWTContainer {

    private int times = 1;
    private int keyModifier = 0;
    private AWTSimulator simulator;

    @Override
    public Key forTimes( int times ) {
        this.times = times;
        return this;
    }

    @Override
    public void ofSomeKey() {
        this.of( 'a' );
    }

    protected abstract void of( int keyCode, char keyChar );

    @Override
    public void of( int keyCode ) {
        of( keyCode, (char) keyCode );
    }

    @Override
    public void of( char keyChar ) {
        switch ( keyChar ) {
            case 'a' : of( VK_A, keyChar ); break;
            case 'b' : of( VK_B, keyChar ); break;
            case 'c' : of( VK_C, keyChar ); break;
            case 'd' : of( VK_D, keyChar ); break;
            case 'e' : of( VK_E, keyChar ); break;
            case 'f' : of( VK_F, keyChar ); break;
            case 'g' : of( VK_G, keyChar ); break;
            case 'h' : of( VK_H, keyChar ); break;
            case 'i' : of( VK_I, keyChar ); break;
            case 'j' : of( VK_J, keyChar ); break;
            case 'k' : of( VK_K, keyChar ); break;
            case 'l' : of( VK_L, keyChar ); break;
            case 'm' : of( VK_M, keyChar ); break;
            case 'n' : of( VK_N, keyChar ); break;
            case 'o' : of( VK_O, keyChar ); break;
            case 'p' : of( VK_P, keyChar ); break;
            case 'q' : of( VK_Q, keyChar ); break;
            case 'r' : of( VK_R, keyChar ); break;
            case 's' : of( VK_S, keyChar ); break;
            case 't' : of( VK_T, keyChar ); break;
            case 'u' : of( VK_U, keyChar ); break;
            case 'v' : of( VK_V, keyChar ); break;
            case 'w' : of( VK_W, keyChar ); break;
            case 'x' : of( VK_X, keyChar ); break;
            case 'y' : of( VK_Y, keyChar ); break;
            case 'z' : of( VK_Z, keyChar ); break;
            case 'A' : shiftModifier().of( VK_A, keyChar ); break;
            case 'B' : shiftModifier().of( VK_B, keyChar ); break;
            case 'C' : shiftModifier().of( VK_C, keyChar ); break;
            case 'D' : shiftModifier().of( VK_D, keyChar ); break;
            case 'E' : shiftModifier().of( VK_E, keyChar ); break;
            case 'F' : shiftModifier().of( VK_F, keyChar ); break;
            case 'G' : shiftModifier().of( VK_G, keyChar ); break;
            case 'H' : shiftModifier().of( VK_H, keyChar ); break;
            case 'I' : shiftModifier().of( VK_I, keyChar ); break;
            case 'J' : shiftModifier().of( VK_J, keyChar ); break;
            case 'K' : shiftModifier().of( VK_K, keyChar ); break;
            case 'L' : shiftModifier().of( VK_L, keyChar ); break;
            case 'M' : shiftModifier().of( VK_M, keyChar ); break;
            case 'N' : shiftModifier().of( VK_N, keyChar ); break;
            case 'O' : shiftModifier().of( VK_O, keyChar ); break;
            case 'P' : shiftModifier().of( VK_P, keyChar ); break;
            case 'Q' : shiftModifier().of( VK_Q, keyChar ); break;
            case 'R' : shiftModifier().of( VK_R, keyChar ); break;
            case 'S' : shiftModifier().of( VK_S, keyChar ); break;
            case 'T' : shiftModifier().of( VK_T, keyChar ); break;
            case 'U' : shiftModifier().of( VK_U, keyChar ); break;
            case 'V' : shiftModifier().of( VK_V, keyChar ); break;
            case 'W' : shiftModifier().of( VK_W, keyChar ); break;
            case 'X' : shiftModifier().of( VK_X, keyChar ); break;
            case 'Y' : shiftModifier().of( VK_Y, keyChar ); break;
            case 'Z' : shiftModifier().of( VK_Z, keyChar ); break;
            case '`' : of( VK_BACK_QUOTE, keyChar ); break;
            case '0' : of( VK_0, keyChar ); break;
            case '1' : of( VK_1, keyChar ); break;
            case '2' : of( VK_2, keyChar ); break;
            case '3' : of( VK_3, keyChar ); break;
            case '4' : of( VK_4, keyChar ); break;
            case '5' : of( VK_5, keyChar ); break;
            case '6' : of( VK_6, keyChar ); break;
            case '7' : of( VK_7, keyChar ); break;
            case '8' : of( VK_8, keyChar ); break;
            case '9' : of( VK_9, keyChar ); break;
            case '-' : of( VK_MINUS, keyChar ); break;
            case '=' : of( VK_EQUALS, keyChar ); break;
            case '~' : shiftModifier().of( VK_BACK_QUOTE, keyChar ); break;
            case '!' : of( VK_EXCLAMATION_MARK, keyChar ); break;
            case '@' : of( VK_AT, keyChar ); break;
            case '#' : of( VK_NUMBER_SIGN, keyChar ); break;
            case '$' : of( VK_DOLLAR, keyChar ); break;
            case '%' : shiftModifier().of( VK_5, keyChar ); break;
            case '^' : of( VK_CIRCUMFLEX, keyChar ); break;
            case '&' : of( VK_AMPERSAND, keyChar ); break;
            case '*' : of( VK_ASTERISK, keyChar ); break;
            case '(' : of( VK_LEFT_PARENTHESIS, keyChar ); break;
            case ')' : of( VK_RIGHT_PARENTHESIS, keyChar ); break;
            case '_' : of( VK_UNDERSCORE, keyChar ); break;
            case '+' : of( VK_PLUS, keyChar ); break;
            case '\t': of( VK_TAB, keyChar ); break;
            case '\n': of( VK_ENTER, keyChar ); break;
            case '[' : of( VK_OPEN_BRACKET, keyChar ); break;
            case ']' : of( VK_CLOSE_BRACKET, keyChar ); break;
            case '\\': of( VK_BACK_SLASH, keyChar ); break;
            case '{' : shiftModifier().of( VK_OPEN_BRACKET, keyChar ); break;
            case '}' : shiftModifier().of( VK_CLOSE_BRACKET, keyChar ); break;
            case '|' : shiftModifier().of( VK_BACK_SLASH, keyChar ); break;
            case ';' : of( VK_SEMICOLON, keyChar ); break;
            case ':' : of( VK_COLON, keyChar ); break;
            case '\'': of( VK_QUOTE, keyChar ); break;
            case '"' : of( VK_QUOTEDBL, keyChar ); break;
            case ',' : of( VK_COMMA, keyChar ); break;
            case '<' : of( VK_LESS, keyChar ); break;
            case '.' : of( VK_PERIOD, keyChar ); break;
            case '>' : of( VK_GREATER, keyChar ); break;
            case '/' : of( VK_SLASH, keyChar ); break;
            case '?' : shiftModifier().of( VK_SLASH, keyChar ); break;
            case ' ' : of( VK_SPACE, keyChar ); break;
            default:
                throw new IllegalArgumentException( "Cannot type character " + keyChar );
        }
    }

    private AWTKey shiftModifier(){
        keyModifier |= SHIFT_DOWN_MASK;
        return this;
    }

    @Override
    public int getTimes(){
        return times;
    }

    @Override
    public AWTSimulator getSimulator() {
        return simulator;
    }

    @Override
    public int getModifier() {
        return keyModifier;
    }

    public AWTKey setSimulator( AWTSimulator simulator ) {
        this.simulator = simulator;
        return this;
    }

}
