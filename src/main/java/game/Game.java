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

     private static Actor player;
     protected static HashMap<rl,Room> map = new HashMap<>();

     public Game() throws IOException {
          // create a player which starts the game at room 0
          createGame();
          player = new Actor("A name", "A description of player", map.get(ROOM0));
          startGame();
     }

     private void createGame() {
          // add various rooms to a map
          room0 = new Room1("Dungean", "This is a dark place!", rl.NOEXIT, rl.ROOM1,rl.NOEXIT,rl.NOEXIT);
          room1 = new Room1("Cave", "Darkness own home", rl.ROOM0,rl.ROOM4, rl.ROOM2,rl.NOEXIT);
          room2 = new Room2("Forest", "Here the wild animals and trees traverse", rl.NOEXIT,rl.ROOM3,rl.NOEXIT, rl.ROOM1);
          room3 = new Room1("ROOM3", "Darkness own home", rl.ROOM2, rl.NOEXIT, rl.NOEXIT, rl.ROOM4);
          room4 = new Room1("ROOM4", "Darkness own home", rl.ROOM1, rl.NOEXIT, rl.ROOM3, rl.ROOM5);
          room5 = new Room1("ROOM5", "Darkness own home", rl.NOEXIT, rl.ROOM4, rl.NOEXIT, rl.ROOM6);
          room6 = new Room1("ROOM6", "Darkness own home", rl.ROOM7, rl.NOEXIT, rl.ROOM5, rl.NOEXIT);
          room7 = new Room1("ROOM7", "Darkness own home", rl.NOEXIT, rl.ROOM6, rl.ROOM8, rl.NOEXIT);
          room8 = new Room1("ROOM8", "Darkness own home", rl.NOEXIT, rl.NOEXIT, rl.NOEXIT, rl.ROOM7);

          // added rooms to the hashmap map
          this.map.put(ROOM0,room0);
          this.map.put(ROOM1,room1);
          this.map.put(ROOM2,room2);
          this.map.put(ROOM3,room3);
          this.map.put(ROOM4,room4);
          this.map.put(ROOM5,room5);
          this.map.put(ROOM6,room6);
          this.map.put(ROOM7,room7);
          this.map.put(ROOM8,room8);

     }
     private void startGame() throws IOException {
          System.out.println("Welcome to this adventure place");
          System.out.println("You start the game at " + player.getLoc().getName());
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
               System.out.println("You are in " + player.getLoc().getName() + " which is " + player.getLoc().getDescription());
          } while(!("exit".equals(input)));

     }
     HashMap<rl, Room> getMap() {
          return map;
     }
     Actor getPlayer() {
          return player;
     }
     private static void look() {
          System.out.println("You are in the " + player.getLoc().getName() + ". It is a " + player.getLoc().getDescription());
          }

     public static void movePlayer(rl newPosition) {
          // if roomNumber = NOEXIT, display a special message, otherwise
          // display text (e.g. name and description of room)

          if (newPosition.equals(NOEXIT)) {
               System.out.println("No Exit in this direction!");
          } else {
               player.setLoc(map.get(newPosition));

               look();
             //  System.out.println("You are in room: " + player.getLoc().getName());
          }
     }
     public static void goN() {
          movePlayer(player.getLoc().getN());
     }

     public static void goS() { movePlayer(player.getLoc().getS()); }

     public static void goW() {
          movePlayer(player.getLoc().getW());
     }

     public static void goE() {
          movePlayer(player.getLoc().getE());
     }
}
