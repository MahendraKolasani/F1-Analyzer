package com;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Scanner;


@Component
public class Usecase1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of Grand Prix:");
        String name = sc.nextLine();

        String url = "jdbc:sqlite:/home/mahikolasani/Documents/Projects/F1 Analyzer/F1";

        try (Connection conn = DriverManager.getConnection(url)) {
            String racesQueryText = "SELECT * FROM races WHERE name='" + name + "'" + "ORDER BY year ASC";
            ResultSet racesRS = query(conn, racesQueryText);

            int raceId = 0;

            if (racesRS != null) {
                while (racesRS.next()) {
                    System.out.print("Year:" + racesRS.getInt("year"));

                    String lapsQuery = "SELECT * FROM results  WHERE raceId='" + racesRS.getInt("raceId") + "'" + "AND position='" + 1 + "'";
                    ResultSet lapsRS = query( conn , lapsQuery);

                    System.out.println(" ,Time taken to complete the race:" + lapsRS.getString("time"));
                }
            } else {
                System.out.println("Invalid year or round");
                return;
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
