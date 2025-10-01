package main.Repository;

public class ConstructorPositionDTO {
    private String constructorName;
    private int position;

    // Constructor used by the JPQL query (SELECT new ...)
    public ConstructorPositionDTO(String constructorName, int position) {
        this.constructorName = constructorName;
        this.position = position;
    }

    // Getters (needed for JSON serialization)
    public String getConstructorName() {
        return constructorName;
    }

    public int getPosition() {
        return position;
    }
}