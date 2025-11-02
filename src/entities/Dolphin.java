package entities;

public class Dolphin extends Aquatic {
    protected float swimmingSpeed;

    public Dolphin() {
        super();
    }

    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) {
        super(family, name, age, isMammal, habitat);
        this.swimmingSpeed = swimmingSpeed;
    }

    public float getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(float swimmingSpeed) {
        if (swimmingSpeed >= 0) {
            this.swimmingSpeed = swimmingSpeed;
        } else {
            throw new IllegalArgumentException("La vitesse de nage ne peut pas être négative!");
        }
    }

    @Override
    public void swim() {
        System.out.println("This dolphin is swimming.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Vitesse de nage: " + swimmingSpeed + " km/h";
    }
}
