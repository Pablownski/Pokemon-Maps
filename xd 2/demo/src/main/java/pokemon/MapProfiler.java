package pokemon;
import java.util.*;

public class MapProfiler {
    public static void profileAll() {
        System.out.println("\nProfiling HashMap...");
        profile(new HashMap<>());

        System.out.println("\nProfiling TreeMap...");
        profile(new TreeMap<>());

        System.out.println("\nProfiling LinkedHashMap...");
        profile(new LinkedHashMap<>());
    }

    private static void profile(Map<String, Pokemon> map) {
        long startTime, endTime;

        startTime = System.nanoTime();
        new PokemonManager(map).loadPokemonData("pokemon_data_pokeapi.csv");
        endTime = System.nanoTime();
        System.out.println("Tiempo de carga: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        map.get("Pikachu");
        endTime = System.nanoTime();
        System.out.println("Tiempo de búsqueda: " + (endTime - startTime) + " ns");
    }
}
