package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SYSTÈME DE GESTION DE ZOO AVEC PACKAGES ===");

        // Instruction 18: Test validation nom zoo
        System.out.println("\n--- INSTRUCTION 18: VALIDATION DES DONNÉES ---");
        Zoo zooVide = new Zoo("", "Test", 5); // Doit afficher erreur
        System.out.println("Zoo créé: " + zooVide);

        // Instruction 18: Test validation âge animal
        Animal animalAgeNegatif = new Animal("Test", "TestAnimal", -5, true); // Doit afficher erreur
        System.out.println("Animal créé: " + animalAgeNegatif);

        // Création du zoo principal
        Zoo myZoo = new Zoo("Safari Park", "Tunis", 3);

        // Création des animaux avec âges variés
        Animal lion = new Animal("Félins", "Lion", 5, true);
        Animal elephant = new Animal("Éléphantidés", "Éléphant", 10, true);
        Animal crocodile = new Animal("Reptiles", "Crocodile", 3, false);
        Animal giraffe = new Animal("Giraffidés", "Girafe", 7, true);

        System.out.println("\n--- INSTRUCTION 17: AJOUT AVEC VÉRIFICATION CAPACITÉ ---");

        // Ajout d'animaux
        myZoo.addAnimal(lion);
        myZoo.addAnimal(elephant);
        myZoo.addAnimal(crocodile);

        // Instruction 17: Test de la méthode addAnimal avec isZooFull
        System.out.println("\n→ Test d'ajout avec zoo plein:");
        boolean result = myZoo.addAnimal(giraffe); // Doit échouer
        System.out.println("Résultat de l'ajout: " + result);

        // Affichage des animaux
        myZoo.displayAnimals();

        // Test des setters avec validation
        System.out.println("\n→ Test des setters avec validation:");
        lion.setAge(-2); // Doit afficher erreur
        myZoo.setName(""); // Doit afficher erreur

        System.out.println("\nÂge du lion après tentative négative: " + lion.getAge());
        System.out.println("Nom du zoo après tentative vide: " + myZoo.getName());

        // Création d'un deuxième zoo pour comparaison
        Zoo zoo2 = new Zoo("City Zoo", "Sfax", 5);
        zoo2.addAnimal(new Animal("Oiseaux", "Aigle", 2, false));

        System.out.println("\n--- COMPARAISON DES ZOOS ---");
        System.out.println("Zoo 1: " + myZoo);
        System.out.println("Zoo 2: " + zoo2);

        Zoo zooPlusGrand = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("Zoo avec le plus d'animaux: " + zooPlusGrand.getName());

        scanner.close();

        System.out.println("\n=== PROGRAMME TERMINÉ AVEC SUCCÈS ===");
    }
}