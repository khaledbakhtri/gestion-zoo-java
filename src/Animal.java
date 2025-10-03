package tn.esprit.gestionzoo.entities;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal() {
    }

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age); // Instruction 18: Validation de l'âge
        this.isMammal = isMammal;
    }

    // Getters
    public String getFamily() { return family; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isMammal() { return isMammal; }

    // Setters avec validation (Instruction 18)
    public void setFamily(String family) {
        this.family = family;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        // Instruction 18: Un animal ne peut pas avoir un âge négatif
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Erreur: L'âge ne peut pas être négatif! Age donné: " + age);
            this.age = 0; // Valeur par défaut
        }
    }

    public void setMammal(boolean mammal) {
        isMammal = mammal;
    }

    // Méthode equals pour comparer les animaux
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return name.equals(animal.name);
    }

    @Override
    public String toString() {
        return "Animal{family='" + family + "', name='" + name + "', age=" + age + ", isMammal=" + isMammal + "}";
    }
}