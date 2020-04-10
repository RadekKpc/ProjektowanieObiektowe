package pl.agh.edu.dp.labirynth.rooms;

public class EnchantedRoom extends Room {

    public EnchantedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter(){
        System.out.println("To jest magiczny pokoj");
    }
}
