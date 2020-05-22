package pl.edu.agh.to.lab4;

public class Student extends Suspect {

    private int index;

    public Student(String firstName, String lastName, int age,int index) {
        super(firstName, lastName, age);
        this.index = index;
    }

    @Override
    boolean canBeAccused(){
        return true;
    }

}
