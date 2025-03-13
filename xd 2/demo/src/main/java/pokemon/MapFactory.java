package pokemon;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {
    public static Map<String, Pokemon> createMap(int choice) {
        switch (choice) {
            case 1: return new HashMap<>();
            case 2: return new TreeMap<>();
            case 3: return new LinkedHashMap<>();
            default:
                System.out.println("Opción no válida. Usando HashMap por defecto.");
                return new HashMap<>();
        }
    }
}
