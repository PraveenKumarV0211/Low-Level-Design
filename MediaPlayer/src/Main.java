import Entities.Player;
import Entities.Song;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Song> playlist = new ArrayList<>();
        playlist.add(new Song(1, "Shape of You", 4));
        playlist.add(new Song(2, "Blinding Lights", 3));
        playlist.add(new Song(3, "Bohemian Rhapsody", 6));
        playlist.add(new Song(4, "Hotel California", 7));

        Player player = new Player(1, playlist);

        System.out.println("=== Initial State (Stopped) ===");
        System.out.println("State: " + player.getCurrentState().getClass().getSimpleName());

        System.out.println("\n=== Play a song from Stopped ===");
        player.play(playlist.get(0));
        System.out.println("State: " + player.getCurrentState().getClass().getSimpleName());

        System.out.println("\n=== Pause the song ===");
        player.pause();
        System.out.println("State: " + player.getCurrentState().getClass().getSimpleName());
        System.out.println("\n=== Resume/Play from Paused ===");
        player.play(playlist.get(0));
        System.out.println("State: " + player.getCurrentState().getClass().getSimpleName());

        System.out.println("\n=== Switch track while Playing ===");
        player.play(playlist.get(2));
        System.out.println("State: " + player.getCurrentState().getClass().getSimpleName());
        System.out.println("Current song index: " + player.getCurrentSongIndex());

        System.out.println("\n=== Skip Forward ===");
        player.next();
        System.out.println("Current song index: " + player.getCurrentSongIndex());

        System.out.println("\n=== Skip Backward ===");
        player.previous();
        System.out.println("Current song index: " + player.getCurrentSongIndex());
        System.out.println("\n=== Stop the player ===");
        player.stop();
        System.out.println("State: " + player.getCurrentState().getClass().getSimpleName());

        System.out.println("\n=== Try pause in Stopped state ===");
        player.pause();

        System.out.println("\n=== Try next in Stopped state ===");
        player.next();
    }
}

/*
So we are going to design a media player:


A list of songs initialy,
a user can select a song to play
when a user selects another song to play tht song should be player
if a song is playing and another song is selected the new song should be playing,
once the duration of song ends, the next song can be player, or if it is the end of album it can trasition to stop state
user can select backward and forward to skip songs in list,


Playsong()
goforward()
goBackward()
pauseSong()
stopSong()

Playing State

Pause State

Stop State

Song:
name,
duration,

Player:
int id;
List<Songs>
state
cuurentSongId




 */