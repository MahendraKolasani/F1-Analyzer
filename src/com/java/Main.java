package com.java;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = sc.nextInt();
        System.out.print("Enter the round number: ");
        int round = sc.nextInt();
        System.out.println("Year:" + year);
        System.out.println("Round no:" + round);

        String url = "jdbc:sqlite:/home/mahikolasani/Documents/Projects/F1 Analyzer/F1";
        try (Connection conn = DriverManager.getConnection(url)) {
            String racesQueryText = "SELECT * FROM races WHERE year=" + year + " AND round=" + round + " LIMIT 1";
            ResultSet racesRS = query(conn, racesQueryText);

            int raceId = 0;

            if (racesRS != null) {
                if (racesRS.next()) {
                    System.out.println(racesRS.getString("name"));
                    System.out.println(racesRS.getString("date"));
                    raceId = racesRS.getInt("raceId");
                }
            } else {
                System.out.println("Invalid year or round");
                return;
            }

            String constructorStandingsQueryText = """
                SELECT
                    constructors.name AS constructor,
                    constructor_standings.position AS position
                FROM constructor_standings
                LEFT JOIN  constructors
                ON constructor_standings.constructorId = constructors.constructorId
                WHERE raceId=
                """ + raceId + " " + "ORDER BY position ASC";
            ResultSet constructorStandingsRS = query(conn, constructorStandingsQueryText);

            if (constructorStandingsRS != null) {
                while (constructorStandingsRS.next()) {
                    System.out.print("constructor: " + constructorStandingsRS.getString("constructor"));
                    System.out.println(", position: " + constructorStandingsRS.getString("position"));
                }
            } else {
                System.out.println("Invalid year or round");
                return;
            }


        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    static ResultSet query(Connection conn, String queryText) {
        try {
            if (conn != null) {
                System.out.println("Connected to SQLite DB!");

                Statement stmt = conn.createStatement();
                return stmt.executeQuery(queryText);

            }
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
        return null;
    }
}

