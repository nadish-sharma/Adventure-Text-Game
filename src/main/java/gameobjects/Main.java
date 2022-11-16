package gameobjects;

import game.Game;
import game.Parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static game.Parse.runCommand;

public class Main extends Game{
    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output = "";


        new Game();
        System.out.println("What do you want to do?");
        in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("> ");
            try {
                input = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            output = Parse.runCommand(input);
            System.out.println(output);
        } while(!("q".equals(input)));

    }
}