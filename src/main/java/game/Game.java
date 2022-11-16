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
     Room room6;
     Room room7;
     Room room8;
     // create empty list which will store items for each room
     private static Actor player;
     protected static HashMap<rl,Room> map = new HashMap<>();

     public Game() throws IOException {
          // create a game with rooms, items, and enemies added to the map
          createGame();
          // initially player's inventory is empty
          player = new Actor("A name", "A description of player", ROOM0, new ThingList(), 100, 15, 5);
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
          ROOM0, 50, 10));
          room2EnemyList.add(new Actor("Bane the Cruel Prince","I was born in darkness, moulded by it and " +
                  "i have come to consume the world. You, who challenge me, i will help you die today",
                  ROOM2, 65, 25));
          room3EnemyList.add(new Actor("Boar the Don of Jungle", "You, who desire to be shredded to pieces, " +
                  "shall face my sharp claws now!", ROOM3, 200, 35));
          room4EnemyList.add(new Actor("Elf the Chaos Being", "This village is mine to torment, you seek to save them, " +
                  "so i seek to destroy you!", ROOM4,300, 65));
          room5EnemyList.add(new Actor("Buu the BubbleGum King", "Buu Buu Buu! Buu defeat you!",
                  ROOM5, 500, 100));

          // create list of items for each room
          ThingList room0List = new ThingList();
          ThingList room1List = new ThingList();
          ThingList room2List = new ThingList();
          ThingList room3List = new ThingList();
          ThingList room4List = new ThingList();
          ThingList room5List = new ThingList();
      //    ThingList room6List = new ThingList();
       //   ThingList room7List = new ThingList();
        //  ThingList room8List = new ThingList();

          // add weapon and magic items to each room's list
          room0List.add(new WeaponItem("Sword", "Sharp curved sword made by the blacksmiths' of Turtle Island", true, 20));
         // room0List.add(new WeaponItem("", "Sharp curved sword made by the blacksmiths' of Turtle Island", true, 20));
          room1List.add(new MagicItem("Potion", "An exquisite blue health potion derived from Sanjeevni plant in" +
                  " Himalayas", true , 30));
          room2List.add(new WeaponItem("Fang", "Rare black fang of extinct Valayrion " +
                  "dragons with immense attack power",true, 50));
          room3List.add(new WeaponItem("Spear", "Your best friend in jungle to fight powerful beasts",
                  true, 70));
          room4List.add(new MagicItem("Orange", "Citrus fruit grown in lost paradise with positive " +
                  "health benefits", true, 100));
          room5List.add(new MagicItem("Plasma", "A mysterious plasma gun from future which turns " +
                  "powerful beings to ashes", true, 150));

          // add various rooms to a map
          room0 = new DungeanRoom("Dungean", "This is a dark place!", NOEXIT, ROOM1, NOEXIT, NOEXIT, room0List, room0EnemyList);
          room1 = new AsceticRoom("Ascetic's Hut", "I feel secure here", ROOM0, ROOM4, ROOM2, NOEXIT, room1List);
          room2 = new CaveRoom("Cave", "Something's hiding in here", NOEXIT, ROOM3, NOEXIT, ROOM1, room2List, room2EnemyList);
          room3 = new ForestRoom("Forest", "I bet i'd be eaten by a tiger", ROOM2, NOEXIT, NOEXIT, ROOM4, room3List, room3EnemyList);
          room4 = new ElfRoom("Elf Village", "Damn we got elves too, weird timeline", ROOM1, NOEXIT, ROOM3, ROOM5, room4List, room4EnemyList);
          room5 = new KingsmeadRoom("Kingsmead", "Majin Buu from DBZ the final boss? Don't make me a candy Buu Huu", NOEXIT, NOEXIT, NOEXIT, NOEXIT, room5List, room5EnemyList);
         // room6 = new DungeanRoom("ROOM6", "Darkness own home", ROOM7, NOEXIT, ROOM5, NOEXIT, room6List, room0EnemyList);
        //  room7 = new DungeanRoom("ROOM7", "Darkness own home", NOEXIT, ROOM6, ROOM8, NOEXIT, room7List, room0EnemyList);
        //  room8 = new DungeanRoom("ROOM8", "Darkness own home", NOEXIT, NOEXIT, NOEXIT, ROOM7, room8List, room0EnemyList);

          // add rooms to the hashmap map with key as enums from rl file
          this.map.put(ROOM0,room0);
          this.map.put(ROOM1,room1);
          this.map.put(ROOM2,room2);
          this.map.put(ROOM3,room3);
          this.map.put(ROOM4,room4);
          this.map.put(ROOM5,room5);
         // this.map.put(ROOM6,room6);
         // this.map.put(ROOM7,room7);
         // this.map.put(ROOM8,room8);
          System.out.println(room0List.size());
     }
     private void startGame() throws IOException {
          System.out.println("Welcome to this adventure place");
          System.out.println("You start the game at " + map.get(player.getLoc()).getName());
          look();
          userInput();
     }
     public static void availableCommands() {
          System.out.println("Commands available are: ");
          System.out.println("take, drop, n, s, w, e, use, talk");
     }
     public static void userInput() {
          availableCommands();
          System.out.println("What do you want to do?");
          BufferedReader in;
          String input;
          String output = "";
          in = new BufferedReader(new InputStreamReader(System.in));
          do {
               System.out.println("> ");
               try {
                    input = in.readLine();
               } catch (IOException e) {
                    throw new RuntimeException(e);
               }
               output = runCommand(input);
               System.out.println(output);
               // System.out.println("You are in " + player.getLoc().getName() + " which is " + player.getLoc().getDescription());
          } while(!("q".equals(input)));
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
               transferObject(t, map.get(player.getLoc()).getThings(), player.getThings());
               if(t.getClass().getName().equals("MagicItem")) {
                    int newHealth = 0;
                    newHealth = player.getHealth() + (t).getEffect();
                    player.setHealth(newHealth);
               }
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
          String retStr = "";
          int effectOfObject;
          int newHealth;
          String actorName = (map.get(player.getLoc()).getActor()).get(0).getName();
          Vector<Actor> roomEnemy = map.get(player.getLoc()).getActor();
          System.out.println((actorName));
          Thing item = player.getThings().returnThisObject(obname);
          effectOfObject = roomEnemy.get(0).getHealth() - item.getEffect();
          if(effectOfObject > 0) {
               roomEnemy.get(0).setHealth(effectOfObject);
               newHealth = roomEnemy.get(0).getHealth();
               System.out.println(roomEnemy.get(0).getName() + " health dropped to " + newHealth);
          }
          else {
               System.out.println("You defeated " + actorName);
          }
     }
}
