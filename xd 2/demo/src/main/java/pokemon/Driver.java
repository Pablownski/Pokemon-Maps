package pokemon;
import java.util.Map;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Bienvenido al programa de gestión de Pokémon");
        
        // Selección de tipo de Mapa
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de Map a utilizar:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea pendiente

        Map<String, Pokemon> pokemonMap = MapFactory.createMap(choice);
        PokemonManager manager = new PokemonManager(pokemonMap);
        manager.loadPokemonData("pokemon_data_pokeapi.csv");

        // Menú de opciones
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar Pokémon a la colección");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar colección ordenada por Type1");
            System.out.println("4. Mostrar todos los Pokémon ordenados por Type1");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Ejecutar profiler de rendimiento");
            System.out.println("7. Salir");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 7.");
                scanner.next(); // Descartar entrada incorrecta
                continue;
            }

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea pendiente

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del Pokémon:");
                    String nameToAdd = scanner.nextLine();
                    manager.addPokemonToCollection(nameToAdd);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del Pokémon:");
                    String nameToShow = scanner.nextLine();
                    manager.showPokemonData(nameToShow);
                    break;
                case 3:
                    manager.showUserCollectionSorted();
                    break;
                case 4:
                    manager.showAllPokemonSorted();
                    break;
                case 5:
                    System.out.println("Ingrese la habilidad a buscar:");
                    String ability = scanner.nextLine();
                    manager.findPokemonByAbility(ability);
                    break;
                case 6:
                    MapProfiler.profileAll();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
