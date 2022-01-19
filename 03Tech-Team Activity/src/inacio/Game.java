package inacio;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;



public class Game {

    Player player;

    public Game(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void saveGame(String filename) {
        Gson gson = new Gson();
        String playerData = gson.toJson(player);
        try(Writer w = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(filename), "UTF-8"))) {
            w.write(playerData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Game loadGame(String filename){
        String gameData = null;

        // Loading files with a specified encoding is easier than saving them.
        try{
            byte[] encoded = Files.readAllBytes(Paths.get(filename));
            gameData = new String(encoded, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize our player back from the json string to a class instance.
        Gson gson = new Gson();
        Player savedPlayer = gson.fromJson(gameData, Player.class);

        // Create a new game with the player we just deserialized.
        Game newGame = new Game(savedPlayer);

        return newGame;
    }
}
