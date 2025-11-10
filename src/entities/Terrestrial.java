package entities;

public class Terrestrial extends Animal implements Omnivore<Food> {
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

    // ✅ Implémentation des méthodes Omnivore
    @Override
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println(this.getName() + " mange de la viande avec ses " + nbrLegs + " pattes");
        } else {
            System.out.println(this.getName() + " ne peut pas manger cette nourriture comme viande");
        }
    }

    @Override
    public void eatPlant(Food plant) {
        if (plant == Food.PLANT || plant == Food.BOTH) {
            System.out.println(this.getName() + " mange des plantes avec ses " + nbrLegs + " pattes");
        } else {
            System.out.println(this.getName() + " ne peut pas manger cette nourriture comme plante");
        }
    }

    @Override
    public void eatPlantAndMeat(Food food) {
        if (food == Food.BOTH) {
            System.out.println(this.getName() + " mange un mélange de plantes et de viande (omnivore)");
        } else {
            System.out.println(this.getName() + " préfère manger les deux types ensemble");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Nombre de pattes: " + nbrLegs;
    }
}