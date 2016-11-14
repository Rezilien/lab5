package agh.cs.lab2;

import java.util.Arrays;
public class CarSystem {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.add(new Car(map,0,0));
        map.add(new Car(map,3,4));
        map.run(directions);
        String s=map.toString();
        System.out.print(s);
    }
}
