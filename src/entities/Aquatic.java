package entities;

public class Aquatic extends Animal implements Carnivore<Food> {
    protected String habitat;

    public Aquatic() {
        super();
    }

    // ✅ Must declare throws InvalidAgeException
    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) throws InvalidAgeException {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void swim() {
        System.out.println("This aquatic animal is swimming.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Habitat: " + habitat;
    }

    // ✅ Implémentation de la méthode de l'interface Carnivore
    @Override
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println(this.getName() + " mange de la viande dans son habitat: " + this.habitat);
        } else {
            System.out.println(this.getName() + " ne peut pas manger cette nourriture (carnivore)");
        }
    }
}
