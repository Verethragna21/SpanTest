package com.channels.span;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //This map is to distribute the points
    public static Map<String, Integer> distributedPoints = new HashMap<>();

    public static void main(String[] args) {
        //Reading terminal input
        Scanner scanner = new Scanner(System.in);

        System.out.print("please insert file path: ");
        String filePath = scanner.next();

        readFile(filePath);
    }

    /**
     * Method on charge to read required file with game results.
     */
    public static void readFile(String pathFile) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(pathFile));
            String line = reader.readLine();

            //Reading all the records inside games file
            while (line != null) {
                getGameResults(line);

                //Reading next line in file
                line = reader.readLine();
            }

            //Closing the reader
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        //Now printing the final game results
        for (Map.Entry<String, Integer> entry : distributedPoints.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue() + " pts");
        }

    }

    public static void getGameResults(String gameResult) {
        //it's required to split the string using the comma as delimiter
        List<String> separatedStrings = Arrays.asList(gameResult.split(","));

        Map<String, Integer> mapGames = new HashMap<>();

        //This loop is to split the name and the result into a map
        for (String s : separatedStrings) {

            //Getting just the club name
            String clubName = s.substring(0, s.length()-1);

            //Getting the points obtained in game
            Integer winningPoints = Integer.valueOf(s.substring(s.length()-1));

            //Storing key, value map to handling later.
            mapGames.put(clubName.trim(), winningPoints);
        }

        //Now that we have divided the string records, we need to validate the games result,
        //And compare the results to assign points
        Iterator<Map.Entry<String, Integer>> it = mapGames.entrySet().iterator();

        //Comparing the amount of goals in each game match
        while (it.hasNext()) {
            Map.Entry entry = it.next();
            String primaryKey = (String) entry.getKey();
            Integer primaryValue = (Integer) entry.getValue();

            //Retrieving second element in temp map to compare with first map record
            if (it.hasNext()) {
                entry = it.next();
                String secondaryKey = (String) entry.getKey();
                Integer secondaryValue = (Integer) entry.getValue();

                //In this block, a validation is performed to determine which team win, lost, or tie
                if (primaryValue == secondaryValue) {

                    //retrieving and distributing points according to game results
                    Integer primaryTeamPoints = distributedPoints.getOrDefault(primaryKey, 0);
                    Integer secondaryTeamPoints = distributedPoints.getOrDefault(secondaryKey, 0);

                    distributedPoints.put(primaryKey, primaryTeamPoints + 1);
                    distributedPoints.put(secondaryKey, secondaryTeamPoints + 1);
                }

                if (primaryValue > secondaryValue) {
                    Integer primaryTeamPoints = distributedPoints.getOrDefault(primaryKey, 0);
                    distributedPoints.put(primaryKey, primaryTeamPoints + 3);
                }

                if (primaryValue < secondaryValue) {
                    Integer secondaryTeamPoints = distributedPoints.getOrDefault(secondaryKey, 0);
                    distributedPoints.put(secondaryKey, secondaryTeamPoints + 3);
                }

            }
        }

    }

}
