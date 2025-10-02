package main.Service;

import java.util.List;

import java.util.List;

public class RaceResultsResponse {
    private final String raceName;
    private final String date;
    private final List<DriverPositionDTO> results;

    // Constructor removes circuitName
    public RaceResultsResponse(String raceName, String date, List<DriverPositionDTO> results) {
        this.raceName = raceName;
        this.date = date;
        this.results = results;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getDate() {
        return date;
    }

    public List<DriverPositionDTO> getResults() {
        return results;
    }
}