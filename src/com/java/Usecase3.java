package com.java;

import java.sql.*;
import java.util.Scanner;

public class Usecase3 {
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

            String driversQueryText = "SELECT * FROM results WHERE raceId='" + raceId + "'" + "ORDER BY position ASC" ;
            ResultSet did = query(conn, driversQueryText);

            int did1 = 0;
            did1 = did.getInt("driverId");
            if (did != null) {
                while (did.next()) {
                    int position = did.getInt("position");
                    if (position == 1 || position == 2 || position == 3) {
                        String infQueryText = "SELECT * FROM drivers WHERE driverId='" + did.getInt("driverId") + "'";
                        ResultSet inf = query(conn, infQueryText);

                        System.out.print("Position:" + position );
                        System.out.println(",Driver:" + inf.getString("driverRef"));
                    }
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
                Statement stmt = conn.createStatement();
                return stmt.executeQuery(queryText);

            }
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
        return null;
    }
}

