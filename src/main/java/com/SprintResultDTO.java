package com;

public class SprintResultDTO {

    private final int round;
    private final String driverName;
    private final int position;
    private final int grid;
    private final int points;

    public SprintResultDTO(int round, String driverName, int position, int grid, int points) {
        this.round = round;
        this.driverName = driverName;
        this.position = position;
        this.grid = grid;
        this.points = points;
    }

    public int getRound() {
        return round;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getPosition() {
        return position;
    }

    public int getGrid() {
        return grid;
    }

    public int getPoints() {
        return points;
    }
}

