package game;

import gameobjects.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static game.Game.getCurrentRoom;
import static game.Game.useObject;

public class Parse {

    //Method to split an input string into a list of words using regular expression
    public static List<String> wordList(String input) {
        String delims = "[ \t,.:;?!\"']+";
        List<String> strlist = new ArrayList<>();
        String[] words = input.split(delims);
        for (String word : words) {
            strlist.add(word);
        }
        return strlist;
    }
    //Categorises a word list into allowed nouns and verbs
    private static void parseCommand(List<String> wordlist) {
        String verb;
        String noun = "";
        List<String> commands = new ArrayList<>(Arrays.asList("take", "drop", "n", "s", "w", "e","use", "retreat"));
        List<String> obj = new ArrayList<>(Arrays.asList("Sword", "Potion", "Fang", "Spear", "Orange", "Apple", "Plasma"));
        if(!(wordlist.size() > 0 && wordlist.size() <= 2)) {
            System.out.println("Maximum 2 words are allowed");
        } else {
            verb = wordlist.get(0);
            if(wordlist.size() == 2) {
                noun = wordlist.get(1);
            }
            if(!commands.contains(verb)) {
                System.out.println(verb + " is not a known verb");
            }
            else if(obj.contains(noun)) {
                System.out.println(noun + " is not a known noun");
            } else {
                switch (verb) {
                    case "take":
                        Game.takeObject(noun);
                        break;
                    case "drop":
                        Game.dropObject(noun);
                        break;
                    case "n":
                        Game.goN();
                        break;
                    case "s":
                        Game.goS();
                        break;
                    case "w":
                        Game.goW();
                        break;
                    case "e":
                        Game.goE();
                        break;
                    case "use":
                        useObject(noun);
                        break;
                    case "retreat":
                        Game.movePlayer(getCurrentRoom().getPreviousRoom());
                }
            }

        }
    }
    //Method to convert the input string to lower case and trim it
    //Calls wordList command to split the string into individual words
    // Calls parseCommand method to make sense of the word List
    public static void runCommand(String inputStr) {
        List<String> wl;
        String lowStr = inputStr.trim().toLowerCase();
        if(!lowStr.equals("q")) {
            if(lowStr.equals("")) {
                System.out.println("you must enter a command");
            } else {
                wl = wordList(lowStr);
                parseCommand(wl);
            }
        }
    }
}
