package pokemon;
public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private String classification;
    private double height;
    private double weight;
    private String abilities;

    public Pokemon(String name, String type1, String type2, String classification, double height, double weight, String abilities) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
    }

    public String getName() { return name; }
    public String getType1() { return type1; }
    public String getAbilities() { return abilities; }
    public String getClassification () { return classification;}

    @Override
    public String toString() {
        return name + " (" + type1 + (type2 != null ? ", " + type2 : "") + ") - " + classification +
               ", Altura: " + height + "m, Peso: " + weight + "kg, Habilidades: " + abilities;
    }
}
