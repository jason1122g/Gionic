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

    @Override
    public void of( char keyCode ) {
        switch ( keyCode ) {
            case 'a' : of( VK_A ); break;
            case 'b' : of( VK_B ); break;
            case 'c' : of( VK_C ); break;
            case 'd' : of( VK_D ); break;
            case 'e' : of( VK_E ); break;
            case 'f' : of( VK_F ); break;
            case 'g' : of( VK_G ); break;
            case 'h' : of( VK_H ); break;
            case 'i' : of( VK_I ); break;
            case 'j' : of( VK_J ); break;
            case 'k' : of( VK_K ); break;
            case 'l' : of( VK_L ); break;
            case 'm' : of( VK_M ); break;
            case 'n' : of( VK_N ); break;
            case 'o' : of( VK_O ); break;
            case 'p' : of( VK_P ); break;
            case 'q' : of( VK_Q ); break;
            case 'r' : of( VK_R ); break;
            case 's' : of( VK_S ); break;
            case 't' : of( VK_T ); break;
            case 'u' : of( VK_U ); break;
            case 'v' : of( VK_V ); break;
            case 'w' : of( VK_W ); break;
            case 'x' : of( VK_X ); break;
            case 'y' : of( VK_Y ); break;
            case 'z' : of( VK_Z ); break;
            case 'A' : shiftModifier(); of( VK_A ); break;
            case 'B' : shiftModifier(); of( VK_B ); break;
            case 'C' : shiftModifier(); of( VK_C ); break;
            case 'D' : shiftModifier(); of( VK_D ); break;
            case 'E' : shiftModifier(); of( VK_E ); break;
            case 'F' : shiftModifier(); of( VK_F ); break;
            case 'G' : shiftModifier(); of( VK_G ); break;
            case 'H' : shiftModifier(); of( VK_H ); break;
            case 'I' : shiftModifier(); of( VK_I ); break;
            case 'J' : shiftModifier(); of( VK_J ); break;
            case 'K' : shiftModifier(); of( VK_K ); break;
            case 'L' : shiftModifier(); of( VK_L ); break;
            case 'M' : shiftModifier(); of( VK_M ); break;
            case 'N' : shiftModifier(); of( VK_N ); break;
            case 'O' : shiftModifier(); of( VK_O ); break;
            case 'P' : shiftModifier(); of( VK_P ); break;
            case 'Q' : shiftModifier(); of( VK_Q ); break;
            case 'R' : shiftModifier(); of( VK_R ); break;
            case 'S' : shiftModifier(); of( VK_S ); break;
            case 'T' : shiftModifier(); of( VK_T ); break;
            case 'U' : shiftModifier(); of( VK_U ); break;
            case 'V' : shiftModifier(); of( VK_V ); break;
            case 'W' : shiftModifier(); of( VK_W ); break;
            case 'X' : shiftModifier(); of( VK_X ); break;
            case 'Y' : shiftModifier(); of( VK_Y ); break;
            case 'Z' : shiftModifier(); of( VK_Z ); break;
            case '`' : of( VK_BACK_QUOTE ); break;
            case '0' : of( VK_0 ); break;
            case '1' : of( VK_1 ); break;
            case '2' : of( VK_2 ); break;
            case '3' : of( VK_3 ); break;
            case '4' : of( VK_4 ); break;
            case '5' : of( VK_5 ); break;
            case '6' : of( VK_6 ); break;
            case '7' : of( VK_7 ); break;
            case '8' : of( VK_8 ); break;
            case '9' : of( VK_9 ); break;
            case '-' : of( VK_MINUS ); break;
            case '=' : of( VK_EQUALS ); break;
            case '~' : shiftModifier(); of( VK_BACK_QUOTE ); break;
            case '!' : of( VK_EXCLAMATION_MARK ); break;
            case '@' : of( VK_AT ); break;
            case '#' : of( VK_NUMBER_SIGN ); break;
            case '$' : of( VK_DOLLAR ); break;
            case '%' : shiftModifier(); of( VK_5 ); break;
            case '^' : of( VK_CIRCUMFLEX ); break;
            case '&' : of( VK_AMPERSAND ); break;
            case '*' : of( VK_ASTERISK ); break;
            case '(' : of( VK_LEFT_PARENTHESIS ); break;
            case ')' : of( VK_RIGHT_PARENTHESIS ); break;
            case '_' : of( VK_UNDERSCORE ); break;
            case '+' : of( VK_PLUS ); break;
            case '\t': of( VK_TAB ); break;
            case '\n': of( VK_ENTER ); break;
            case '[' : of( VK_OPEN_BRACKET ); break;
            case ']' : of( VK_CLOSE_BRACKET ); break;
            case '\\': of( VK_BACK_SLASH ); break;
            case '{' : shiftModifier(); of( VK_OPEN_BRACKET ); break;
            case '}' : shiftModifier(); of( VK_CLOSE_BRACKET ); break;
            case '|' : shiftModifier(); of( VK_BACK_SLASH ); break;
            case ';' : of( VK_SEMICOLON ); break;
            case ':' : of( VK_COLON ); break;
            case '\'': of( VK_QUOTE ); break;
            case '"' : of( VK_QUOTEDBL ); break;
            case ',' : of( VK_COMMA ); break;
            case '<' : of( VK_LESS ); break;
            case '.' : of( VK_PERIOD ); break;
            case '>' : of( VK_GREATER ); break;
            case '/' : of( VK_SLASH ); break;
            case '?' : shiftModifier(); of( VK_SLASH ); break;
            case ' ' : of( VK_SPACE ); break;
            default:
                throw new IllegalArgumentException( "Cannot type character " + keyCode );
        }
    }

    private void shiftModifier(){
        keyModifier |= SHIFT_DOWN_MASK;
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
