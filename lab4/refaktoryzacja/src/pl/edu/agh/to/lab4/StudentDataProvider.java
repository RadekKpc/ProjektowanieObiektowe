package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StudentDataProvider implements SuspectAggreagate{

    private Collection<Student> students = new ArrayList<Student>();

    public StudentDataProvider(Collection<Student> students) {
        this.students = students;
    }

    public StudentDataProvider(){
        students.add(new Student("Janusz","Polak",23,22222));
        students.add(new Student("Jan","Polak",23,22222));
    }

    @Override
    public Iterator<? extends Suspect> iterator() {
        return students.iterator();
    }
}
