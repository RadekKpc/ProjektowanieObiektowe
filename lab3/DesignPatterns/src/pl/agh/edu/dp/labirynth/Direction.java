package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public static Direction getOpposite(Direction d){
        switch (d){
            case East:
                return West;
            case West:
                return East;
            case North:
                return South;
            case South:
                return North;
        }
        return null;
    }

    public static Direction getBefore(Direction d){
        switch (d){
            case East:
                return South;
            case West:
                return North;
            case North:
                return East;
            case South:
                return West;
        }
        return null;
    }

    public static Direction getNext(Direction d){
        return  Direction.getOpposite(Direction.getBefore(d));
    }
}