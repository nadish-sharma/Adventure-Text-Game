package gameobjects;

import game.Game;
import game.Parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static game.Parse.runCommand;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output = "";
        Game game = new Game();
        in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("> ");
            input = in.readLine();
            output = Parse.runCommand(input);
            System.out.println("You entered '" + input + "'");
            System.out.println(output);
            //System.out.println((map.elementAt(Integer.parseInt(input))).getDescription());
        } while (!("exit".equals(input)));


    }
}