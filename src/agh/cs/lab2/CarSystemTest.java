package agh.cs.lab2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarSystemTest {
    @Test
    public void testOptionsParser(){
        MoveDirection[] sampleDir = new MoveDirection[]{MoveDirection.Forward, MoveDirection.Backward, MoveDirection.Left,
                MoveDirection.Right, MoveDirection.Forward, MoveDirection.Backward, MoveDirection.Left, MoveDirection.Right};
        String[] sampleString = new String[]{"f", "backward", "l", "right", "forward", "b", "left", "r"};
        OptionsParser op = new OptionsParser();
        assertEquals(sampleDir, op.parse(sampleString));
    }
}