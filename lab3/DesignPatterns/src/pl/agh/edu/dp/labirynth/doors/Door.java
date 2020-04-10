package pl.agh.edu.dp.labirynth.doors;

import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.rooms.Room;

public class Door extends MapSite {
    private Room room1;
    private Room room2;

    public Door(Room r1, Room r2){
        this.room1 = r1;
        this.room2 = r2;
    }


    @Override
    public void Enter(){

    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room1 = room2;
    }

    public Room getNextRoom(Room r){
        if(r == room1)return room2;
        return  room1;
    }
}
