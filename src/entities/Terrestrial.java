package entities;

public class Terrestrial extends Animal {
    protected int nbrLegs;

    public Terrestrial() {
        super();
    }

    // ✅ Must declare throws InvalidAgeException
    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) throws InvalidAgeException {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }

    public int getNbrLegs() {
        return nbrLegs;
    }

    public void setNbrLegs(int nbrLegs) {
        if (nbrLegs >= 0) {
            this.nbrLegs = nbrLegs;
        } else {
            throw new IllegalArgumentException("Le nombre de pattes ne peut pas être négatif!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Nombre de pattes: " + nbrLegs;
    }
}
