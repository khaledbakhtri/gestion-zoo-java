import entities.Animal;
import entities.Zoo;
import entities.Aquatic;
import entities.Terrestrial;
import entities.Dolphin;
import entities.Penguin;

public class Main {
    public static void main(String[] args) {
        // Création des zoos
        Zoo zoo1 = new Zoo("Zoo National", "Tunis", 5);
        Zoo zoo2 = new Zoo("Parc Safari", "Sousse", 3);

        // Création des animaux
        Animal lion = new Animal("Félins", "Simba", 5, true);
        Animal elephant = new Animal("Éléphantidés", "Dumbo", 10, true);
        Animal parrot = new Animal("Psittacidés", "Rio", 2, false);
        Animal giraffe = new Animal("Giraffidés", "Spot", 7, true);

        // Test d'ajout d'animaux
        System.out.println("=== AJOUT D'ANIMAUX ===");
        zoo1.addAnimal(lion);
        zoo1.addAnimal(elephant);
        zoo1.addAnimal(parrot);

        zoo2.addAnimal(giraffe);

        // Test d'ajout du même animal
        zoo1.addAnimal(lion); // Doit échouer

        // Affichage des animaux
        zoo1.displayAnimals();
        zoo2.displayAnimals();

        // Test de recherche
        System.out.println("\n=== RECHERCHE D'ANIMAUX ===");
        int index = zoo1.searchAnimal("Simba");
        System.out.println("Simba trouvé à l'index: " + index);

        // Test de suppression
        System.out.println("\n=== SUPPRESSION D'ANIMAUX ===");
        zoo1.removeAnimal("Rio");
        zoo1.displayAnimals();

        // Test de comparaison
        System.out.println("\n=== COMPARAISON DES ZOOS ===");
        Zoo.comparerZoo(zoo1, zoo2);

        // Test de capacité
        System.out.println("\n=== TEST DE CAPACITÉ ===");
        System.out.println("Zoo1 plein? " + zoo1.isZooFull());
        System.out.println("Taux de remplissage: " + zoo1.getFillRate() + "%");

        // Test validation
        try {
            Animal invalidAnimal = new Animal("", "", -5, true);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation fonctionne: " + e.getMessage());
        }

        // === NOUVELLE HIÉRARCHIE D'ANIMAUX ===
        System.out.println("\n=== NOUVELLE HIÉRARCHIE D'ANIMAUX ===");
        
        // Instruction 21: Création d'instances avec constructeurs par défaut
        System.out.println("\n--- Création avec constructeurs par défaut ---");
        Aquatic aquaticAnimal = new Aquatic();
        Terrestrial terrestrialAnimal = new Terrestrial();
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();
        
        System.out.println("Instances créées avec succès!");
        
        // Instruction 22: Création avec constructeurs paramétrés
        System.out.println("\n--- Création avec constructeurs paramétrés ---");
        Aquatic aquatic1 = new Aquatic("Poissons", "Nemo", 2, false, "Océan");
        Terrestrial terrestrial1 = new Terrestrial("Mammifères", "Rex", 3, true, 4);
        Dolphin dolphin1 = new Dolphin("Cétacés", "Flipper", 8, true, "Océan", 35.5f);
        Penguin penguin1 = new Penguin("Oiseaux", "Pingu", 4, false, "Antarctique", 50.0f);
        
        // Instruction 23: Affichage avec toString() redéfinie
        System.out.println("\n--- Affichage des objets ---");
        System.out.println("Animal aquatique: " + aquatic1);
        System.out.println("Animal terrestre: " + terrestrial1);
        System.out.println("Dauphin: " + dolphin1);
        System.out.println("Pingouin: " + penguin1);
        
        // Instruction 24: Test de la méthode swim()
        System.out.println("\n--- Test de la méthode swim() ---");
        Aquatic aquaticSwim = new Aquatic("Poissons", "Swimmer", 1, false, "Mer");
        Dolphin dolphinSwim = new Dolphin("Cétacés", "Swimmy", 5, true, "Océan", 40.0f);
        Penguin penguinSwim = new Penguin("Oiseaux", "Swimmy", 3, false, "Antarctique", 30.0f);
        
        System.out.println("Appel swim() sur Aquatic:");
        aquaticSwim.swim();
        
        System.out.println("Appel swim() sur Dolphin:");
        dolphinSwim.swim();
        
        System.out.println("Appel swim() sur Penguin:");
        penguinSwim.swim();
        
        System.out.println("\n=== FIN DES TESTS ===");
    }
}