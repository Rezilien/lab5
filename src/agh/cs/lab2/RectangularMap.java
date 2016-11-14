package agh.cs.lab2;


import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    private List<Car> cars = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
    }

    public boolean canMoveTo(Position position){
        if(position.x<0 || position.y<0 || position.x>=width || position.y>=height)
            return false;
        if(isOccupied(position))
            return false;
        return true;
    }

    public boolean add(Car car){
        if(this.isOccupied(car.getPosition()))
            return false;
        cars.add(car);
        return true;
    }

    public void run(MoveDirection[] directions){
        for(int i=0;i<directions.length;i++){
            cars.get(i%cars.size()).move(directions[i]);
        }
    }

    public boolean isOccupied(Position position){
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).getPosition().equals(position))
                return true;
        }
        return false;
    }

    public Object objectAt(Position position){
        for(int i=0;i<cars.size();i++)
            if(cars.get(i).getPosition().equals(position))
                return cars.get(i);
        return null;
    }

    @Override
    public String toString(){
        MapVisualizer mapVisualizer= new MapVisualizer();
        Position bottomLeft= new Position(0,0);
        Position upperRight= new Position(width-1,height-1);
        return mapVisualizer.dump(this, bottomLeft, upperRight);
    }
}
