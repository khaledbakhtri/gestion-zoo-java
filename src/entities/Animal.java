package entities;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal() {
    }

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        setName(name); // Added validation
        setAge(age);
        this.isMammal = isMammal;
    }

    // Getters
    public String getFamily() { return family; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isMammal() { return isMammal; }

    // Setters avec validation
    public void setFamily(String family) {
        if (family != null && !family.trim().isEmpty()) {
            this.family = family;
        } else {
            throw new IllegalArgumentException("La famille ne peut pas être vide!");
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Le nom ne peut pas être vide!");
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("L'âge ne peut pas être négatif! Age donné: " + age);
        }
    }

    public void setMammal(boolean mammal) {
        isMammal = mammal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return name != null && name.equals(animal.name);
    }

    @Override
    public String toString() {
        return String.format("Animal{Famille: '%s', Nom: '%s', Âge: %d, Mammifère: %s}",
                family, name, age, isMammal ? "Oui" : "Non");
    }
}