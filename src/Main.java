import entities.Animal;
import entities.Zoo;
import entities.Aquatic;
import entities.Terrestrial;
import entities.Dolphin;
import entities.Penguin;
import entities.ZooFullException;
import entities.InvalidAgeException;
import entities.Food; // ✅ Nouvel import

public class Main {
    public static void main(String[] args) {
        try {
            // Création des zoos
            Zoo zoo1 = new Zoo("Zoo National", "Tunis", 3); // ✅ réduit à 3 cages (Instruction 33)
            Zoo zoo2 = new Zoo("Parc Safari", "Sousse", 3);

            // Création des animaux
            Animal lion = new Animal("Félins", "Simba", 5, true);
            Animal elephant = new Animal("Éléphantidés", "Dumbo", 10, true);
            Animal parrot = new Animal("Psittacidés", "Rio", 2, false);
            Animal giraffe = new Animal("Giraffidés", "Spot", 7, true);

            // === TEST D'AJOUT D'ANIMAUX AVEC EXCEPTIONS ===
            System.out.println("=== AJOUT D'ANIMAUX ===");
            try {
                zoo1.addAnimal(lion);
                System.out.println("Nombre d'animaux: " + zoo1.getAnimalCount());

                zoo1.addAnimal(elephant);
                System.out.println("Nombre d'animaux: " + zoo1.getAnimalCount());

                zoo1.addAnimal(parrot);
                System.out.println("Nombre d'animaux: " + zoo1.getAnimalCount());

                // Essayer d'ajouter un 4e animal -> ZooFullException
                zoo1.addAnimal(giraffe);
                System.out.println("Nombre d'animaux: " + zoo1.getAnimalCount());

            } catch (ZooFullException | InvalidAgeException e) {
                System.out.println("⚠️ Exception : " + e.getMessage());
            }

            // Test d'un animal avec âge négatif
            try {
                Animal invalidAgeAnimal = new Animal("Canidés", "Ghost", -3, true);
                zoo2.addAnimal(invalidAgeAnimal);
            } catch (InvalidAgeException e) {
                System.out.println("⚠️ Exception : " + e.getMessage());
            } catch (ZooFullException e) {
                System.out.println("⚠️ Zoo plein : " + e.getMessage());
            }

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

            // === NOUVELLE HIÉRARCHIE D'ANIMAUX ===
            System.out.println("\n=== NOUVELLE HIÉRARCHIE D'ANIMAUX ===");

            // Création avec constructeurs par défaut
            System.out.println("\n--- Création avec constructeurs par défaut ---");
            Aquatic aquaticAnimal = new Aquatic();
            Terrestrial terrestrialAnimal = new Terrestrial();
            Dolphin dolphin = new Dolphin();
            Penguin penguin = new Penguin();
            System.out.println("Instances créées avec succès!");

            // Création avec constructeurs paramétrés
            System.out.println("\n--- Création avec constructeurs paramétrés ---");
            Aquatic aquatic1 = new Aquatic("Poissons", "Nemo", 2, false, "Océan");
            Terrestrial terrestrial1 = new Terrestrial("Mammifères", "Rex", 3, true, 4);
            Dolphin dolphin1 = new Dolphin("Cétacés", "Flipper", 8, true, "Océan", 35.5f);
            Penguin penguin1 = new Penguin("Oiseaux", "Pingu", 4, false, "Antarctique", 50.0f);

            // Affichage avec toString()
            System.out.println("\n--- Affichage des objets ---");
            System.out.println("Animal aquatique: " + aquatic1);
            System.out.println("Animal terrestre: " + terrestrial1);
            System.out.println("Dauphin: " + dolphin1);
            System.out.println("Pingouin: " + penguin1);

            // Test de la méthode swim()
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

            // === TESTS DES INTERFACES ALIMENTAIRES (INSTRUCTIONS 35-38) ===
            System.out.println("\n" + "=".repeat(50));
            System.out.println("=== TESTS DES INTERFACES ALIMENTAIRES ===");
            System.out.println("=".repeat(50));

            // Création des objets pour tester les interfaces
            Aquatic shark = new Aquatic("Poissons", "Requin", 5, false, "Océan");
            Penguin penguinTest = new Penguin("Oiseaux", "Pingouin Royal", 3, false, "Antarctique", 50.0f);
            Terrestrial bear = new Terrestrial("Mammifères", "Ours", 8, true, 4);
            Terrestrial monkey = new Terrestrial("Primates", "Singe", 6, true, 2);

            // Test de l'Aquatic (Carnivore)
            System.out.println("\n--- Test Requin (Carnivore) ---");
            shark.eatMeat(Food.MEAT);
            shark.eatMeat(Food.PLANT);
            shark.eatMeat(Food.BOTH);

            // Test du Penguin (Carnivore spécialisé)
            System.out.println("\n--- Test Pingouin (Carnivore spécialisé) ---");
            penguinTest.eatMeat(Food.MEAT);
            penguinTest.eatMeat(Food.PLANT);
            penguinTest.eatMeat(Food.BOTH);

            // Test du Terrestrial (Omnivore)
            System.out.println("\n--- Test Ours (Omnivore) ---");
            bear.eatMeat(Food.MEAT);
            bear.eatPlant(Food.PLANT);
            bear.eatPlantAndMeat(Food.BOTH);

            // Tests supplémentaires avec différents scénarios
            System.out.println("\n--- Tests supplémentaires ---");
            bear.eatMeat(Food.BOTH);
            bear.eatPlant(Food.BOTH);
            bear.eatPlantAndMeat(Food.MEAT);

            // Test avec un autre omnivore
            System.out.println("\n--- Test Singe (Omnivore) ---");
            monkey.eatMeat(Food.MEAT);
            monkey.eatPlant(Food.PLANT);
            monkey.eatPlantAndMeat(Food.BOTH);

            // Test du polymorphisme
            System.out.println("\n--- Test Polymorphisme ---");
            System.out.println("Via interface Carnivore:");
            entities.Carnivore<Food> carnivore = shark;
            carnivore.eatMeat(Food.MEAT);

            carnivore = penguinTest;
            carnivore.eatMeat(Food.MEAT);

            // Test avec animaux dans le zoo
            System.out.println("\n--- Tests avec animaux du zoo ---");
            try {
                zoo2.addAnimal(shark);
                zoo2.addAnimal(bear);
                zoo2.addAnimal(penguinTest);

                System.out.println("Animaux dans zoo2:");
                zoo2.displayAnimals();

            } catch (ZooFullException | InvalidAgeException e) {
                System.out.println("⚠️ Exception lors de l'ajout au zoo: " + e.getMessage());
            }

            System.out.println("\n=== FIN DES TESTS ===");

        } catch (Exception e) {
            System.out.println("⚠️ Erreur inattendue : " + e.getMessage());
            e.printStackTrace();
        }
    }
}