package com.java;

import java.sql.*;
import java.util.Scanner;

public class Usecase4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter driver's forename:");
        String fn = sc.nextLine();
        System.out.print("Enter driver's surname:");
        String sn = sc.nextLine();
        System.out.print("Enter the year: ");
        int year = sc.nextInt();
        System.out.print("Enter the round number: ");
        int round = sc.nextInt();
        System.out.println("Driver name:" + fn + sn);
        System.out.println("Year:" + year);
        System.out.println("Round no:" + round);

        String url = "jdbc:sqlite:/home/mahikolasani/Documents/Projects/F1 Analyzer/F1";
        try (Connection conn = DriverManager.getConnection(url)) {
            String driversQueryText = "SELECT driverId FROM drivers WHERE forename='" + fn + "' AND surname='" + sn + "'";
            ResultSet did = query(conn, driversQueryText);
            int did1 = 0;
            if (did != null) {
                if (did.next()) {
                    System.out.println("driver id:" + did.getInt("driverId"));
                    did1 = did.getInt("driverId");
                }
            } else {
                System.out.println("Invalid year or round");
                return;
            }

            String racesQueryText = "SELECT * FROM races WHERE year=" + year + " AND round=" + round + " LIMIT 1";
            ResultSet racesRS = query(conn, racesQueryText);

            int raceId = 0;

            if (racesRS != null) {
                if (racesRS.next()) {
                    System.out.println(racesRS.getString("name"));
                    System.out.println(racesRS.getString("date"));
                    raceId = racesRS.getInt("raceId");
                }
            }

            String lapTimesQuery = "SELECT * FROM lap_times WHERE raceId='" + raceId + "'AND driverId='" + did1 + "'";
            ResultSet lapRS = query(conn , lapTimesQuery);

            if (lapRS != null){
                while(lapRS.next()){
                    System.out.print( "lap:" + lapRS.getInt("lap"));
                    System.out.println( ",time:" + lapRS.getString("time"));
                }
            }


        }catch (SQLException e) {
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
