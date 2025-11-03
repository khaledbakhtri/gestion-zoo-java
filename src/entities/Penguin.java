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

    @Override
    public String toString() {
        return super.toString() + ", Profondeur de nage: " + swimmingDepth + " mètres";
    }
}
