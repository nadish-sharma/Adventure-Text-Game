package game;
import enums.rl;
import gameobjects.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;

import static clojure.lang.Numbers.add;
import static game.Parse.runCommand;
import static enums.rl.*;

public class Game {
     Room room0;
     Room room1;
     Room room2;
     Room room3;
     Room room4;
     Room room5;
     // create empty list which will store items for each room
     private static Actor player;
     protected static HashMap<rl,Room> map = new HashMap<>();

     public Game() throws IOException {
          // create a game with rooms, items, and enemies added to the map
          createGame();
          // initially player's inventory is empty
          player = new Actor("Nadish", "A description of player", ROOM0, new ThingList(), 100, 15, 5);
          startGame();
     }

     private void createGame() {
          //create a vector to store enemies in each room
          Vector<Actor> room0EnemyList = new Vector<Actor>();
          Vector<Actor> room2EnemyList = new Vector<Actor>();
          Vector<Actor> room3EnemyList = new Vector<Actor>();
          Vector<Actor> room4EnemyList = new Vector<Actor>();
          Vector<Actor> room5EnemyList = new Vector<Actor>();

          //Add enemy to each room's enemy vector, some rooms have no enemies
          room0EnemyList.add(new Actor("Jacosta the Ghosta", "I shall annihilate all who stand in my ghostly path!",
          ROOM0, 50, 30));
          room2EnemyList.add(new Actor("Bane the Cruel Prince","I was born in darkness, moulded by it and " +
                  "i have come to consume the world. You, who challenge me, i will help you die today",
                  ROOM2, 130, 40));
          room3EnemyList.add(new Actor("Boar the Don of Jungle", "You, who desire to be shredded to pieces, " +
                  "shall face my sharp claws now!", ROOM3, 270, 70));
          room4EnemyList.add(new Actor("Elf the Chaos Being", "This village is mine to torment, you seek to save them, " +
                  "so i seek to destroy you!", ROOM4,300, 100));
          room5EnemyList.add(new Actor("Buu the BubbleGum King", "Buu Buu Buu! Buu defeat you!",
                  ROOM5, 700, 200));

          // create list of items for each room
          ThingList room0List = new ThingList();
          ThingList room1List = new ThingList();
          ThingList room2List = new ThingList();
          ThingList room3List = new ThingList();
          ThingList room4List = new ThingList();
          ThingList room5List = new ThingList();

          // add weapon and magic items to each room's list
          room0List.add(new Thing("Sword", "Sharp curved sword made by the blacksmiths' of Turtle Island",
                  0, 25));
          room1List.add(new Thing("Potion", "An exquisite blue health potion derived from Sanjeevni plant in" +
                  " Himalayas" , 100, 0));
          room2List.add(new Thing("Fang", "Rare black fang of extinct Valayrion " +
                  "dragons with immense attack power", 0, 50));
          room3List.add(new Thing("Spear", "Your best friend in jungle to fight powerful beasts",
                  0,140));
          room3List.add(new Thing("Chicken", "Wild chicken for meal to gain back your strength",
                  180,0));
          room4List.add(new Thing("Orange", "Citrus fruit grown in lost paradise with positive " +
                  "health benefits", 150, 0));
          room4List.add(new Thing("Apple", "Red sweet fruit with awesome healing properties ",
                  150, 0));
          room5List.add(new Thing("Candy", "Tastes weird but great for health",
                  700, 0));
          room5List.add(new Thing("Plasma", "A mysterious plasma gun from future which turns " +
                  "powerful beings to ashes", 0, 200));

          // add various rooms to a map
          room0 = new DungeanRoom("Dungean", "This is a dark place!", NOEXIT, ROOM1, NOEXIT, NOEXIT, room0List, room0EnemyList);
          room1 = new AsceticRoom("Ascetic's Hut", "I feel secure here", ROOM0, ROOM4, ROOM2, NOEXIT, room1List);
          room2 = new CaveRoom("Cave", "Something's hiding in here", NOEXIT, ROOM3, NOEXIT, ROOM1, room2List, room2EnemyList);
          room3 = new ForestRoom("Forest", "I bet i'd be eaten by a tiger", ROOM2, NOEXIT, NOEXIT, ROOM4, room3List, room3EnemyList);
          room4 = new ElfRoom("Elf Village", "Damn we got elves too, weird timeline", ROOM1, NOEXIT, ROOM3, ROOM5, room4List, room4EnemyList);
          room5 = new KingsmeadRoom("Kingsmead", "Majin Buu from DBZ the final boss? Don't make me a candy Buu Huu", NOEXIT, NOEXIT, NOEXIT, NOEXIT, room5List, room5EnemyList);

          // add rooms to the hashmap map with key as enums from rl file
          this.map.put(ROOM0,room0);
          this.map.put(ROOM1,room1);
          this.map.put(ROOM2,room2);
          this.map.put(ROOM3,room3);
          this.map.put(ROOM4,room4);
          this.map.put(ROOM5,room5);
          System.out.println(room0List.size());
     }
     private void startGame() throws IOException {
          System.out.println("Welcome to this adventure place");
          System.out.println("You start the game at " + map.get(player.getLoc()).getName());
          look();
          availableCommands();
     }
     public static void availableCommands() {
          System.out.println("Commands available are: ");
          System.out.println("take, drop, n, s, w, e, use, talk");
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
               userInput();
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
     private static void transferObject(Thing t, ThingList fromlist, ThingList tolist) {
          fromlist.remove(t);
          tolist.add(t);
     }
     public static String takeObject(String obname) {
          String retStr = "";
          Thing t = map.get(player.getLoc()).getThings().returnThisObject(obname);

          if (obname.equals("")) {
               obname = "nameless object"; // if no object specified
          }
          if (t == null) {
               retStr = "There is no " + obname + " here!";
          } else {
               int newHealth = 0;
               newHealth = player.getHealth() + (t).gethealthThingEffect();
               player.setHealth(newHealth);
               transferObject(t, map.get(player.getLoc()).getThings(), player.getThings());
               retStr = obname + " taken!" + "\nThe player stats are: \n" + "Health: " + player.getHealth();
          }
          return retStr;
     }

     static String dropObject(String obname) {
          String retStr = "";
          Thing t = player.getThings().returnThisObject(obname);

          if (obname.equals("")) {
               retStr = "You'll have to tell me which object you want to drop!"; // if no object specified
          } else if (t == null) {
               retStr = "You haven't got one of those!";
          } else {
               transferObject(t, player.getThings(), map.get(player.getLoc()).getThings());
               retStr = obname + " dropped!";
          }
          return retStr;
     }
     static void useObject(String obname) {
          int newPlayerHealth;
          int newEnemyHealth;
          String actorName = (map.get(player.getLoc()).getActor()).get(0).getName();
          Vector<Actor> roomEnemy = map.get(player.getLoc()).getActor();
          System.out.println((actorName));
          Thing item = player.getThings().returnThisObject(obname);
          System.out.println(item.getName());
          System.out.println(item.getAttackThingEffect());
          newEnemyHealth = roomEnemy.get(0).getHealth() - item.getAttackThingEffect();
          newPlayerHealth = player.getHealth() - roomEnemy.get(0).getAttackPower();
          if(newEnemyHealth > 0 && newPlayerHealth > 0) {
               player.setHealth(newPlayerHealth);
               roomEnemy.get(0).setHealth(newEnemyHealth);
               newEnemyHealth = roomEnemy.get(0).getHealth();
               System.out.println(player.getName() + " health: " + newPlayerHealth);
               System.out.println(roomEnemy.get(0).getName() + " health: " + newEnemyHealth);
          }
          else if(newEnemyHealth <= 0 && newPlayerHealth > 0) {
               System.out.println("You defeated " + actorName);
               System.out.println(player.getName() + " health: " + player.getHealth());
          }
          else if(newEnemyHealth > 0 && newPlayerHealth <= 0) {
               System.out.println("You were defeated as your health dropped to 0");
          }
          else {
               System.out.println("It was a draw");
          }
     }
}
