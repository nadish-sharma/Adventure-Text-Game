package gameobjects;

import gameobjects.Room;
import gameobjects.Room1;
import gameobjects.Room2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import static gameobjects.Parse.runCommand;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader in;
        String input;
        String output = "";
        in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Please enter");
            System.out.println("> ");
            input = in.readLine();
            output = runCommand(input);
            System.out.println("You entered '" + input + "'");
            System.out.println(output);
            //System.out.println((map.elementAt(Integer.parseInt(input))).getDescription());
        } while(!("exit".equals(input)));
    }
}