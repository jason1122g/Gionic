package org.jason1122g.gionic.behavior;

public interface Point {

    public Point forTimes( int times );
    public Point with    ( int mouseButton );
    public void  at      ( int x, int y );
    public void  atSomeWhere();

}
