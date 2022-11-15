package game;
import enums.rl;
import gameobjects.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import static game.Parse.runCommand;
import static enums.rl.*;

public class Game {
     Room room0;
     Room room1;
     Room room2;
     Room room3;
     Room room4;
     Room room5;
     Room room6;
     Room room7;
     Room room8;
     // create empty list which will store items for each room

     private static Actor player;
     private Actor enemy;
     protected static HashMap<rl,Room> map = new HashMap<>();

     public Game() throws IOException {
          // create a player which starts the game at room 0
          createGame();
          // initially player's inventory is empty
          player = new Actor("A name", "A description of player", ROOM0, new ThingList());
          startGame();
     }

     private void createGame() {
          ThingList room0List = new ThingList();
          ThingList room1List = new ThingList();
          ThingList room2List = new ThingList();
          ThingList room3List = new ThingList();
          ThingList room4List = new ThingList();
          ThingList room5List = new ThingList();
          ThingList room6List = new ThingList();
          ThingList room7List = new ThingList();
          ThingList room8List = new ThingList();

          // add items to each room's list
          room0List.add(new Items("Spinach", "A leafy vegetable to increase arm strength"));
          room0List.add(new Items("Spinach", "A leafy vegetable to increase arm strength"));
          room1List.add(new Items("Mahagony", "A mighty tree of the mountains"));
          room2List.add(new Items("Mango", "The king of fruits is citrus in taste"));
          room3List.add(new Items("Spinach", "A leafy vegetable to increase arm strength"));
          room4List.add(new Items("Spinach", "A leafy vegetable to increase arm strength"));
          room0List.add(new Items("Spinach", "A leafy vegetable to increase arm strength"));
          room1List.add(new Items("Mahagony", "A mighty tree of the mountains"));
          room2List.add(new Items("Mango", "The king of fruits is citrus in taste"));
          room3List.add(new Items("Spinach", "A leafy vegetable to increase arm strength"));
          room4List.add(new Items("Spinach", "A leafy vegetable to increase arm strength"));room0List.add(new Items("Spinach", "A leafy vegetable to increase arm strength"));
          room1List.add(new Items("Mahagony", "A mighty tree of the mountains"));
          room2List.add(new Items("Mango", "The king of fruits is citrus in taste"));
          room3List.add(new Items("Spinach", "A leafy vegetable to increase arm strength"));
          room4List.add(new Items("Spinach", "A leafy vegetable to increase arm strength"));

          // add various rooms to a map
          room0 = new Room1("Dungean", "This is a dark place!", NOEXIT, ROOM1, NOEXIT, NOEXIT, room0List);
          room1 = new Room1("Cave", "Darkness own home", ROOM0, ROOM4, ROOM2, NOEXIT, room1List);
          room2 = new Room2("Forest", "Here the wild animals and trees traverse", NOEXIT, ROOM3, NOEXIT, ROOM1, room2List);
          room3 = new Room1("ROOM3", "Darkness own home", ROOM2, NOEXIT, NOEXIT, ROOM4, room3List);
          room4 = new Room1("ROOM4", "Darkness own home", ROOM1, NOEXIT, ROOM3, ROOM5, room4List);
          room5 = new Room1("ROOM5", "Darkness own home", NOEXIT, ROOM4, NOEXIT, ROOM6, room5List);
          room6 = new Room1("ROOM6", "Darkness own home", ROOM7, NOEXIT, ROOM5, NOEXIT, room6List);
          room7 = new Room1("ROOM7", "Darkness own home", NOEXIT, ROOM6, ROOM8, NOEXIT, room7List);
          room8 = new Room1("ROOM8", "Darkness own home", NOEXIT, NOEXIT, NOEXIT, ROOM7, room8List);

          // add rooms to the hashmap map with key as enums from rl file
          this.map.put(ROOM0,room0);
          this.map.put(ROOM1,room1);
          this.map.put(ROOM2,room2);
          this.map.put(ROOM3,room3);
          this.map.put(ROOM4,room4);
          this.map.put(ROOM5,room5);
          this.map.put(ROOM6,room6);
          this.map.put(ROOM7,room7);
          this.map.put(ROOM8,room8);

          System.out.println(room0List.size());
     }
     private void startGame() throws IOException {
          System.out.println("Welcome to this adventure place");
          System.out.println("You start the game at " + map.get(player.getLoc()).getName());
          System.out.println("Where do you want to go?");
          System.out.println("Enter n, s, w or e");
          BufferedReader in;
          String input;
          String output = "";
          in = new BufferedReader(new InputStreamReader(System.in));
          // run the commands until "q" is entered to quit the game
          do {
               System.out.println("> ");
               input = in.readLine();
               output = runCommand(input);
               System.out.println(output);
              // System.out.println("You are in " + player.getLoc().getName() + " which is " + player.getLoc().getDescription());
          } while(!("exit".equals(input)));

     }

     HashMap<rl, Room> getMap() {
          return map;
     }
     Actor getPlayer() {
          return player;
     }
     private static void look() {
          //System.out.println("Room Name : " + map.get(player.getLoc()).getName() + "\nRoom Description : " + map.get(player.getLoc()).getDescription());
          System.out.println((map.get(player.getLoc())).describe());
          }

     public static void movePlayer(rl newPosition) {
          // if roomNumber = NOEXIT, display a special message, otherwise
          // display text (e.g. name and description of room)

          if (newPosition.equals(NOEXIT)) {
               System.out.println("No Exit in this direction!");
          } else {
               player.setLoc(newPosition);
               look();
             //  System.out.println("You are in room: " + player.getLoc().getName());
          }
     }
     public static void goN() {
          movePlayer(map.get(player.getLoc()).getN());
     }

     public static void goS() {
          movePlayer(map.get(player.getLoc()).getS()); }

     public static void goW() {
          movePlayer(map.get(player.getLoc()).getW());
     }

     public static void goE() {
          movePlayer(map.get(player.getLoc()).getE());
     }
}
