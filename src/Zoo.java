package tn.esprit.gestionzoo.entities;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages;
    private int animalCount;

    public Zoo(String name, String city, int nbrCages) {
        setName(name); // Instruction 18: Validation du nom
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[nbrCages];
        this.animalCount = 0;
    }

    // Getters
    public Animal[] getAnimals() { return animals; }
    public String getName() { return name; }
    public String getCity() { return city; }
    public int getNbrCages() { return nbrCages; }
    public int getAnimalCount() { return animalCount; }

    // Setters avec validation (Instruction 18)
    public void setName(String name) {
        // Instruction 18: Le nom d'un Zoo ne doit pas être vide
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Erreur: Le nom du zoo ne peut pas être vide!");
            this.name = "Zoo Sans Nom"; // Valeur par défaut
        }
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Zoo{name='" + name + "', city='" + city + "', nbrCages=" + nbrCages + ", animaux=" + animalCount + "}";
    }

    // Instruction 17: Méthode addAnimal modifiée avec isZooFull()
    public boolean addAnimal(Animal animal) {
        // Instruction 17: Utilisation de isZooFull()
        if (isZooFull()) {
            System.out.println("Le zoo est plein! Impossible d'ajouter " + animal.getName());
            return false;
        }

        if (searchAnimal(animal) != -1) {
            System.out.println("L'animal " + animal.getName() + " existe déjà dans le zoo!");
            return false;
        }

        animals[animalCount] = animal;
        animalCount++;
        System.out.println("Animal " + animal.getName() + " ajouté avec succès!");
        return true;
    }

    public void displayAnimals() {
        System.out.println("\n=== ANIMAUX DU ZOO " + name + " ===");
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
        for (int i = 0; i < animalCount; i++) {
            if (animals[i] != null && animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("Animal " + animal.getName() + " non trouvé!");
            return false;
        }

        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        System.out.println("Animal " + animal.getName() + " supprimé avec succès!");
        return true;
    }

    // Instruction 15: Vérifier si le zoo est plein
    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    // Instruction 16: Comparer deux zoos
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount > z2.animalCount) {
            return z1;
        } else if (z2.animalCount > z1.animalCount) {
            return z2;
        } else {
            System.out.println("Les deux zoos ont le même nombre d'animaux!");
            return z1;
        }
    }
}