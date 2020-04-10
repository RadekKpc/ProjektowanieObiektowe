package pl.agh.edu.dp.labirynth.doors;

import pl.agh.edu.dp.labirynth.rooms.Room;

public class BombedDoor extends Door {
    public BombedDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    @Override
    public void Enter(){
        System.out.println("Wchodzisz przez wybuchowe drzwi");
    }
}
