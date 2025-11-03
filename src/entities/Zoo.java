package entities;

import entities.ZooFullException;
import entities.InvalidAgeException;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages;
    private int animalCount;

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        setCity(city);
        if (nbrCages <= 0) {
            throw new IllegalArgumentException("Le nombre de cages doit être positif");
        }
        this.nbrCages = nbrCages;
        this.animals = new Animal[nbrCages];
        this.animalCount = 0;
    }

    // Getters
    public Animal[] getAnimals() {
        Animal[] activeAnimals = new Animal[animalCount];
        System.arraycopy(animals, 0, activeAnimals, 0, animalCount);
        return activeAnimals;
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public int getNbrCages() { return nbrCages; }
    public int getAnimalCount() { return animalCount; }

    // Setters avec validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Erreur: Le nom du zoo ne peut pas être vide!");
        }
    }

    public void setCity(String city) {
        if (city != null && !city.trim().isEmpty()) {
            this.city = city;
        } else {
            throw new IllegalArgumentException("Erreur: La ville du zoo ne peut pas être vide!");
        }
    }

    @Override
    public String toString() {
        return String.format("Zoo '%s' à %s - Cages: %d, Animaux: %d",
                name, city, nbrCages, animalCount);
    }

    // Instruction 32–34 compliant version
    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        if (animal == null) {
            throw new IllegalArgumentException("L'animal ne peut pas être null!");
        }

        if (isZooFull()) {
            throw new ZooFullException("Le zoo est plein! Impossible d'ajouter " + animal.getName());
        }

        if (animal.getAge() < 0) {
            throw new InvalidAgeException("L'âge de l'animal " + animal.getName() + " ne peut pas être négatif!");
        }

        if (searchAnimal(animal) != -1) {
            System.out.println("❌ L'animal " + animal.getName() + " existe déjà dans le zoo!");
            return;
        }

        animals[animalCount] = animal;
        animalCount++;
        System.out.println("✅ Animal " + animal.getName() + " ajouté avec succès!");
    }

    public void displayAnimals() {
        System.out.println("\n=== ANIMAUX DU ZOO " + name.toUpperCase() + " ===");
        if (animalCount == 0) {
            System.out.println("Aucun animal dans le zoo.");
            return;
        }
        for (int i = 0; i < animalCount; i++) {
            System.out.println((i+1) + ". " + animals[i]);
        }
        System.out.println("Total: " + animalCount + " animaux");
    }

    public int searchAnimal(Animal animal) {
        if (animal == null) return -1;
        for (int i = 0; i < animalCount; i++) {
            if (animals[i] != null && animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }

    // Recherche par nom
    public int searchAnimal(String animalName) {
        if (animalName == null || animalName.trim().isEmpty()) return -1;
        for (int i = 0; i < animalCount; i++) {
            if (animals[i] != null && animals[i].getName().equalsIgnoreCase(animalName.trim())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("❌ Animal " + animal.getName() + " non trouvé!");
            return false;
        }

        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        System.out.println("✅ Animal " + animal.getName() + " supprimé avec succès!");
        return true;
    }

    // Suppression par nom
    public boolean removeAnimal(String animalName) {
        int index = searchAnimal(animalName);
        if (index == -1) {
            System.out.println("❌ Animal '" + animalName + "' non trouvé!");
            return false;
        }

        String removedName = animals[index].getName();
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        System.out.println("✅ Animal '" + removedName + "' supprimé avec succès!");
        return true;
    }

    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1 == null || z2 == null) {
            throw new IllegalArgumentException("Les zoos ne peuvent pas être null");
        }

        if (z1.animalCount > z2.animalCount) {
            System.out.println("🏆 " + z1.getName() + " a plus d'animaux (" + z1.animalCount + " vs " + z2.animalCount + ")");
            return z1;
        } else if (z2.animalCount > z1.animalCount) {
            System.out.println("🏆 " + z2.getName() + " a plus d'animaux (" + z2.animalCount + " vs " + z1.animalCount + ")");
            return z2;
        } else {
            System.out.println("🤝 Les deux zoos ont le même nombre d'animaux: " + z1.animalCount);
            return z1;
        }
    }

    public double getFillRate() {
        return (double) animalCount / nbrCages * 100;
    }
}
