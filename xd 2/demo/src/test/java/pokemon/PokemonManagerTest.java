package pokemon;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokemonManagerTest {
    private PokemonManager manager;
    private Map<String, Pokemon> testMap;

    @BeforeEach
    void setUp() {
        testMap = new HashMap<>();
        manager = new PokemonManager(testMap);
        
        // Cargar datos desde el archivo CSV
        manager.loadPokemonData("pokemon_data_pokeapi.csv");
    }

    @Test
    void testAgregarPokemonACollection() {
        manager.addPokemonToCollection("Pikachu");
        assertTrue(manager.getUserCollection().contains("Pikachu"));

        // Intentamos agregar de nuevo (no debería duplicarse)
        manager.addPokemonToCollection("Pikachu");
        assertEquals(1, manager.getUserCollection().size());
    }

    @Test
    void testAgregarPokemonNoExistente() {
        manager.addPokemonToCollection("Dinosaurio");
        assertFalse(manager.getUserCollection().contains("Dinosaurio"));
    }

    @Test
    void testMostrarDatosDePokemon() {
        Pokemon pikachu = manager.getPokemonData("Pikachu");
        assertNotNull(pikachu);
        assertEquals("Pikachu", pikachu.getName());
        assertEquals("Electric", pikachu.getType1());
        assertNotNull(pikachu.getClassification());
    }
}