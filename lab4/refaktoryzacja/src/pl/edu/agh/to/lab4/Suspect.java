package pl.edu.agh.to.lab4;

public abstract class Suspect {

    protected String firstName;
    protected String lastName;
    protected int Age = 20;

    public Suspect(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        Age = age;
    }
    public Suspect(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String firstName(){
        return this.firstName;
    }
    public String lastName(){
        return this.lastName;
    }
    public String display() {
        return this.firstName() + " " + this.lastName();
    }
    boolean canBeAccused(){
        return true;
    }

    public int getAge() {
        return Age;
    }
}
