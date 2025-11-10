package entities;

public class Penguin extends Aquatic {
    protected float swimmingDepth;

    public Penguin() {
        super();
    }

    // ✅ Must declare throws InvalidAgeException
    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) throws InvalidAgeException {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    public float getSwimmingDepth() {
        return swimmingDepth;
    }

    public void setSwimmingDepth(float swimmingDepth) {
        if (swimmingDepth >= 0) {
            this.swimmingDepth = swimmingDepth;
        } else {
            throw new IllegalArgumentException("La profondeur de nage ne peut pas être négative!");
        }
    }

    // ✅ Redéfinition de la méthode eatMeat pour un comportement spécifique
    @Override
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT) {
            System.out.println(this.getName() + " (pingouin) mange du poisson à une profondeur de " + swimmingDepth + " mètres");
        } else {
            System.out.println(this.getName() + " (pingouin) ne mange que de la viande (poisson) - pas de " + meat);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Profondeur de nage: " + swimmingDepth + " mètres";
    }
}