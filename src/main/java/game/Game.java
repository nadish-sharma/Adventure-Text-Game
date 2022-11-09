package game;

import gameobjects.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import static gameobjects.Parse.runCommand;

public class Game {
     private Actor player;
     private Vector<Room> map = new Vector<Room>();

     public Game() {
          createGame();
          startGame();
     }
     private void createGame() {
          // add various rooms to a map
          this.map.add(new Room1("Dungean", "This is a dark place!", 1,2,-1,-1));
          this.map.add(new Room1("Cave", "Darkness own home", -1,-1,0,-1));
          this.map.add(new Room2("Forest", "Here the wild animals and trees traverse", 0,-1,-1,3));
          // create a player which starts the game at room 0
          player = new Actor("A name", "A description of player", map.get(0) );
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
          } while(!("exit".equals(input)));

     }
     Vector<Room> getMap() {
          return map;
     }
     Actor getPlayer() {
          return player;
     }
     private void look() {
          System.out.println("You are in the " + player.getLoc().getName() + ". It is a " + player.getLoc().getDescription());
          }

     private void movePlayer(Direction dir) {
          // if roomNumber = NOEXIT, display a special message, otherwise
          // display text (e.g. name and description of room)
          if (moveTo(player, dir) == Direction.NOEXIT) {
               showStr("No Exit!");
          } else {
               look();
          }
     }
     }

}
