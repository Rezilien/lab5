package agh.cs.lab2;

public class Car {
    private MapDirection direction;
    private Position position;
    private IWorldMap map;


    public Car(IWorldMap map, int x, int y) {
        this.map = map;
        this.position = new Position(x, y);
        this.direction = MapDirection.North;
    }

    public Position getPosition() {
        return this.position;
    }
    public MapDirection getDirection() {
        return this.direction;
    }

    public String toString() {
        switch (this.direction) {
            case North: return "^";
            case South: return "v";
            case East: return ">";
            case West: return "<";
            default: return "^";
        }
    }

    public void moveOptions(MoveDirection[] direction) {
        for (MoveDirection dir : direction) {
            this.move(dir);
        }
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case Right: this.direction = this.direction.next();
                break;
            case Left: this.direction = this.direction.previous();
                break;
            case Forward: run(1);
                break;
            case Backward: run(-1);
                break;
        }
    }

    public void run(int distance) {
        Position newPosition = this.position;
        switch (this.direction) {
            case North:
                newPosition = newPosition.add(new Position(0, distance));
                break;
            case East:
                newPosition = newPosition.add(new Position(distance, 0));
                break;
            case South:
                newPosition = newPosition.add(new Position(0, -distance));
                break;
            case West:
                newPosition = newPosition.add(new Position(-distance, 0));
                break;
            default: break;
        }
        if(map.canMoveTo(newPosition))
            this.position = newPosition;
    }
}