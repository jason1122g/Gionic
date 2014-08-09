package org.jason1122g.gionic.behavior;

public interface Path {

    public Path from( int x, int y );
    public Path to  ( int x, int y );
    public void endHere();
    public void inSomePath();

}
