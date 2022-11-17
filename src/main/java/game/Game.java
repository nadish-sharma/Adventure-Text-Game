package game;
import enums.rl;
import gameobjects.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

import static clojure.lang.Numbers.add;
import static enums.rl.*;
import static java.lang.Thread.*;

public class Game {
     Room room0;
     Room room1;
     Room room2;
     Room room3;
     Room room4;
     Room room5;
     // create empty list which will store items for each room
     private static Actor player;
     protected static HashMap<rl, Room> map = new HashMap<>();

     public Game() throws IOException {
          // create a game with rooms, items, and enemies added to the map
          createGame();
          // initially player's inventory is empty
          player = new Actor("Nadish", "A description of player", ROOM0, new ThingList(), 100, 15, 5);
          startGame();
     }

     private void createGame() {
          //create a vector to store enemies in each room
          Vector<Actor> room0EnemyList = new Vector<>();
          Vector<Actor> room1EnemyList = new Vector<>();
          Vector<Actor> room2EnemyList = new Vector<>();
          Vector<Actor> room3EnemyList = new Vector<>();
          Vector<Actor> room4EnemyList = new Vector<>();
          Vector<Actor> room5EnemyList = new Vector<>();

          //Add enemy to each room's enemy vector, some rooms have no enemies
          room0EnemyList.add(new Actor("Jacosta the Ghosta", "I shall annihilate all who stand in my ghostly path!",
                  ROOM0, 50, 30));
          room2EnemyList.add(new Actor("Bane the Cruel Prince", "I was born in darkness, moulded by it and " +
                  "i have come to consume the world. You, who challenge me, i will help you die today",
                  ROOM2, 130, 40));
          room3EnemyList.add(new Actor("Boar the Don of Jungle", "You, who desire to be shredded to pieces, " +
                  "shall face my sharp claws now!", ROOM3, 270, 70));
          room4EnemyList.add(new Actor("Elf the Chaos Being", "This village is mine to torment, you seek to save them, " +
                  "so i seek to destroy you!", ROOM4, 300, 100));
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
                  " Himalayas", 100, 0));
          room2List.add(new Thing("Fang", "Rare black fang of extinct Valayrion " +
                  "dragons with immense attack power", 0, 50));
          room3List.add(new Thing("Spear", "Your best friend in jungle to fight powerful beasts",
                  0, 140));
          room3List.add(new Thing("Chicken", "Wild chicken for meal to gain back your strength",
                  180, 0));
          room4List.add(new Thing("Orange", "Citrus fruit grown in lost paradise with positive " +
                  "health benefits", 150, 0));
          room4List.add(new Thing("Apple", "Red sweet fruit with awesome healing properties ",
                  150, 0));
          room5List.add(new Thing("Candy", "Tastes weird but great for health",
                  700, 0));
          room5List.add(new Thing("Plasma", "A mysterious plasma gun from future which turns " +
                  "powerful beings to ashes", 0, 200));

          // add various rooms to a map
          room0 = new DungeanRoom("Dungean", "This is a dark place!",
                  NOEXIT, ROOM1, NOEXIT, NOEXIT, room0List, room0EnemyList, NOEXIT);

          room1 = new AsceticRoom("Ascetic's Hut", "I feel secure here",
                  ROOM0, NOEXIT, ROOM2, NOEXIT, room1List, room1EnemyList, ROOM0);

          room2 = new CaveRoom("Cave", "Something's hiding in here",
                  NOEXIT, ROOM3, NOEXIT, ROOM1, room2List, room2EnemyList, ROOM1);

          room3 = new ForestRoom("Forest", "I bet i'd be eaten by a tiger",
                  ROOM2, NOEXIT, NOEXIT, ROOM4, room3List, room3EnemyList, ROOM2);

          room4 = new ElfRoom("Elf Village", "Damn we got elves too, weird timeline",
                  NOEXIT, NOEXIT, ROOM3, ROOM5, room4List, room4EnemyList, ROOM3);

          room5 = new KingsmeadRoom("Kingsmead", "Majin Buu from DBZ the final boss? Don't make me a candy Buu Huu",
                  NOEXIT, NOEXIT, NOEXIT, NOEXIT, room5List, room5EnemyList, ROOM4);

          // add rooms to the hashmap map with key as enums from rl file
          map.put(ROOM0, room0);
          map.put(ROOM1, room1);
          map.put(ROOM2, room2);
          map.put(ROOM3, room3);
          map.put(ROOM4, room4);
          map.put(ROOM5, room5);
          System.out.println(room0List.size());
     }

     private void startGame() throws IOException {
          System.out.println("--------------------Welcome to this adventure place--------------------\n");
          System.out.println("You will find many monsters to defeat, \ncool weapons to wield" +
                  " and some health perks to keep you going\n");
          System.out.println("Set the name of your player now: ");
          String name = "";
          BufferedReader in;
          in = new BufferedReader(new InputStreamReader(System.in));
          System.out.println("> ");
          name = in.readLine();
          player.setName(name);
          System.out.println("You start the game at " + map.get(player.getLoc()).getName());
          look();
          availableCommands();
     }
     public void retreat() {

     }

     public static void availableCommands() {
          System.out.println("Commands available are: ");
          System.out.println("take, drop, n, s, w, e, use, retreat");
     }

     public HashMap<rl, Room> getMap() {
          return map;
     }

     public static Room getCurrentRoom() {
          return map.get(player.getLoc());
     }
     public static Actor getCurrentActor() {
          if(getCurrentRoom().getActor().size() != 0)
               return getCurrentRoom().getActor().get(0);
          else
               return null;
     }

     public static Actor getPlayer() {
          return player;
     }

     private static void look() {
          //System.out.println("Room Name : " + map.get(player.getLoc()).getName() + "\nRoom Description : " + map.get(player.getLoc()).getDescription());
          System.out.println(map.get(player.getLoc()).describe());
     }
     private static void lookEnemy() {
          System.out.println(map.get(player.getLoc()).describeEnemy());
     }
     private static void lookItems() {
          System.out.println(map.get(player.getLoc()).describeItems());
     }

     public static void movePlayer(rl newPosition) {
          // if roomNumber = NOEXIT, display a special message, otherwise
          // display text (e.g. name and description of room)

          if (newPosition.equals(NOEXIT)) {
               System.out.println("No Exit in this direction!");
          } else {
               player.setLoc(newPosition);
               look();
          }
     }

     public static void goN() {
          movePlayer(getCurrentRoom().getN());
          availableCommands();
     }

     public static void goS() {
          movePlayer(getCurrentRoom().getS());
          availableCommands();
     }

     public static void goW() {
          movePlayer(getCurrentRoom().getW());
          availableCommands();
     }

     public static void goE() {
          movePlayer(getCurrentRoom().getE());
          availableCommands();
     }
     public static void inventoryStatus() {
          System.out.println("\nYou have these items in inventory:");
          for (Thing t : player.getThings()) {
               if (t.getAttackThingEffect() > 0)
                    System.out.println(t.getName() + ": attack power : " + t.getAttackThingEffect());
               if (t.gethealthThingEffect() > 0)
                    System.out.println(t.getName() + ": health nourishment : " + t.gethealthThingEffect());
          }
     }

     private static void transferObject(Thing t, ThingList fromlist, ThingList tolist) {
          fromlist.remove(t);
          tolist.add(t);
     }

     public static void takeObject(String obname) {
          Thing t = getCurrentRoom().getThings().returnThisObject(obname);

          if (obname.equals("")) {
               obname = "nameless object"; // if no object specified
          }
          if (t == null) {
               System.out.println("There is no " + obname + " here!");
          } else {
               int newHealth;
               newHealth = player.getHealth() + (t).gethealthThingEffect();
               player.setHealth(newHealth);
               transferObject(t, getCurrentRoom().getThings(), player.getThings());
               System.out.println(obname + " taken!\n" + player.getName() + " health : " + player.getHealth());
               inventoryStatus();
               System.out.println();
               if(Objects.nonNull(getCurrentActor())) {
                    try {
                         sleep(3000);
                    } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                    }
                    for(int i = 3; i >= 1; i--) {
                         System.out.println(i);
                         try {
                              sleep(1000);
                         } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                         }
                    }
               lookEnemy();
               } else {
                         System.out.println("It seems there are no enemies in this room.\n" +
                                 "You can try moving to other rooms using direction commands\n\n");
                    }
               }
               availableCommands();
     }


     static void dropObject(String obname) {
          Thing t = player.getThings().returnThisObject(obname);

          if (obname.equals("")) {
               System.out.println("You'll have to tell me which object you want to drop!"); // if no object specified
          } else if (t == null) {
               System.out.println("You haven't got one of those!");
          } else {
               int newHealth;
               newHealth = player.getHealth() - (t).gethealthThingEffect();
               player.setHealth(newHealth);
               transferObject(t, player.getThings(), getCurrentRoom().getThings());
               System.out.println(obname + " dropped!\n" + player.getName() + " health : " + player.getHealth());
               inventoryStatus();
               lookItems();
          }
     }

     static void useObject(String obname) {
          int newPlayerHealth;
          int newEnemyHealth;
          if (Objects.nonNull(getCurrentActor())) {
               String actorName = getCurrentActor().getName();
               Vector<Actor> roomEnemy = map.get(player.getLoc()).getActor();
               if(Objects.nonNull(player.getThings().returnThisObject(obname))) {
                    Thing item = player.getThings().returnThisObject(obname);
                    System.out.println(item.getName());
                    newEnemyHealth = roomEnemy.get(0).getHealth() - item.getAttackThingEffect();
                    newPlayerHealth = player.getHealth() - roomEnemy.get(0).getAttackPower();
                    if (roomEnemy.get(0).getHealth() > 0) {
                         if (newEnemyHealth > 0 && newPlayerHealth > 0) {
                              player.setHealth(newPlayerHealth);
                              roomEnemy.get(0).setHealth(newEnemyHealth);
                              newEnemyHealth = roomEnemy.get(0).getHealth();
                              System.out.println(player.getName() + " health: " + newPlayerHealth);
                              System.out.println(roomEnemy.get(0).getName() + " health: " + newEnemyHealth);
                         } else if (newEnemyHealth <= 0 && newPlayerHealth > 0) {
                              System.out.println("\nYou defeated " + actorName + "\n");
                              player.setHealth(newPlayerHealth);
                              roomEnemy.get(0).setHealth(0);
                              System.out.println(player.getName() + "your health is : " + player.getHealth());
                              inventoryStatus();
                              System.out.println("You can try moving to other rooms using direction commands");
                         } else if (newEnemyHealth > 0 && newPlayerHealth <= 0) {
                              player.setHealth(0);
                              System.out.println("\nYou were defeated as your health dropped to 0");
                              getCurrentRoom().lossHelp();
                         } else {
                              System.out.println("\nIt was a draw");
                         }
                    } else {
                         System.out.println("\nThere is no enemy to use " + item.getName() + " on.");
                    }
               } else {
                    System.out.println("\nYou can't use this item");
               }
               if(player.getHealth() > 0) {
                    availableCommands();
               }
          }
          else {
               System.out.println("You cannot use health item, its effect applies to player automatically when you take it." +
                       " If you drop the health item then its effect will go away");
          }
     }
}
