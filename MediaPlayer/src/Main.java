public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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