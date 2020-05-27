package pl.edu.agh.internetshop;

public class NameStrategy implements SearchStrategy{

    String lastName;

    public NameStrategy(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean filter(OrderLog o) {

        return o.order.getShipment().getRecipientAddress().getName().equals(lastName);

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
