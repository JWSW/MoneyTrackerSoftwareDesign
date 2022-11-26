package PersonData;

public class Person {
    private String name;
    private double schuld;

    public Person(String name) {
        this.name = name;
        this.schuld = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSchuld() {
        return schuld;
    }

    public void setSchuld(double schuld) {
        this.schuld = schuld;
    }

    @Override
    public String toString() {
        return name + " has a dept of " + schuld;
    }
}

