package pokemon;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PokemonManager {
    private Map<String, Pokemon> pokemonMap;
    private Set<String> userCollection;

    public PokemonManager(Map<String, Pokemon> map) {
        this.pokemonMap = map;
        this.userCollection = new HashSet<>();
    }
    public void loadPokemonData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar encabezado
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 9) continue;
                String name = data[0];
                String type1 = data[2];
                String type2 = data[3].isEmpty() ? null : data[3];
                String classification = data[4];
                double height = Double.parseDouble(data[5]);
                double weight = Double.parseDouble(data[6]);
                String abilities = data[7];

                pokemonMap.put(name, new Pokemon(name, type1, type2, classification, height, weight, abilities));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void addPokemonToCollection(String name) {
        if (pokemonMap.containsKey(name)) {
            if (!userCollection.contains(name)) {
                userCollection.add(name);
                System.out.println(name + " agregado a la colección.");
            } else {
                System.out.println("El Pokémon ya está en tu colección.");
            }
        } else {
            System.out.println("El Pokémon no existe en la base de datos.");
        }
    }

    public void showPokemonData(String name) {
        if (pokemonMap.containsKey(name)) {
            System.out.println(pokemonMap.get(name));
        } else {
            System.out.println("El Pokémon no existe.");
        }
    }

    public Set<String> getUserCollection() {
        return userCollection;
    }
    

    public void showUserCollectionSorted() {
        userCollection.stream()
            .map(pokemonMap::get)
            .sorted(Comparator.comparing(Pokemon::getType1))
            .forEach(System.out::println);
    }

    public void showAllPokemonSorted() {
        pokemonMap.values().stream()
            .sorted(Comparator.comparing(Pokemon::getType1))
            .forEach(System.out::println);
    }

    public void findPokemonByAbility(String ability) {
        pokemonMap.values().stream()
            .filter(p -> p.getAbilities().contains(ability))
            .forEach(System.out::println);
    }
    public Pokemon getPokemonData(String name) {
        return pokemonMap.get(name);
    }
    
    public List<String> getUserCollectionSorted() {
        return userCollection.stream()
            .sorted(Comparator.comparing(name -> pokemonMap.get(name).getType1()))
            .toList();
    }
}
