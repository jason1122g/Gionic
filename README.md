## Gionic [![Build Status](https://travis-ci.org/jason1122g/Gionic.svg?branch=master)](https://travis-ci.org/jason1122g/Gionic)
Gionic-core: Include the core api
Gionic-awt : Include a simulator which simulator mouse, mouseMotion and key events

## To set a event dispatch target

- From Component
```
Component component = getComponentFromSomeWhere();
Simulator simulator = Gionic.control( component );
```

- From MouseListener, MouseMotionListener, KeyListener and MouseAdapter
```
MouseListener listener = getMouseListenerFromSomeWhere();
Simulator simulator    = Gionic.control( listener );
```

## To simulate some events

- ``` simulator.click().forTimes( 5 ).at( 10, 10 ) ```
- ``` simulator.press().atSomeWhere() ```
- ``` simulator.drag().from( 0,0 ).to( 5,5 ).endHere() ```
- ``` simulator.keyPress().of( MouseEvent.VK_CONTROL ) ```
- ``` simulator.keyType().of( 'A' ) ```
