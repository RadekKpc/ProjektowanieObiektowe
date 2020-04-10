package pl.agh.edu.dp.gameplay;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.rooms.Room;

public class Player {

    private Room room;
    private Direction direction;
    private int health;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public Player(Direction startDirection, Room startRoom,int startHealth){
        room = startRoom;
        direction = startDirection;
        health = startHealth;
    }

    public void goAhead(){
        room.getSide(direction).Enter();
    }

    public void moveLeft(){
        direction = Direction.getNext(direction);
    }
    public void moveRigth(){
        direction = Direction.getBefore(direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
