package main.Repository.Driver;

public class DriverPositionDTO {

    private String driverName;
    private int positionRaw; // Internal field to hold the numeric position

    // Constructor used by the JPQL query projection
    public DriverPositionDTO(String driverName, int positionRaw) {
        this.driverName = driverName;
        this.positionRaw = positionRaw;
    }

    public String getDriverName() {
        return driverName;
    }

    /**
     * Custom Getter for the API response.
     * Returns "DNF" if the raw position is 0, otherwise returns the position as a String.
     */
    public String getPosition() {
        if (this.positionRaw == 0) {
            return "DNF";
        }
        // Convert the numeric position to a string for the API response
        return String.valueOf(this.positionRaw);
    }
}