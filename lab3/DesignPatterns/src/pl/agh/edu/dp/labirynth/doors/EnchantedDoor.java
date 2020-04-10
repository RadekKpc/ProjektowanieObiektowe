package pl.agh.edu.dp.labirynth.doors;

import pl.agh.edu.dp.gameplay.MazeGame;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.Wall;

public class EnchantedDoor extends Door {

    public EnchantedDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    @Override
    public void Enter(){
        MazeGame.getInstance().setCommunicat("Przeszedles przez magiczne drzwi!");
        MazeGame.getInstance().changePlayerRoom(getRoom1(),getRoom2());
    }

}
