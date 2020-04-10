package pl.agh.edu.dp.labirynth.rooms;

public class BombedRoom extends Room {

    public BombedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter(){
        System.out.println("Masz 15s na podejcie decyzji!");
    }
}
