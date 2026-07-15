package State;

import Entities.Player;
import Entities.Song;

public class PlayingState extends PlayerState {

    Player player;

    public PlayingState(Player player) {
        this.player = player;
    }

    @Override
    public void playSong(Song song) {
        if (player.getSongslist().contains(song)) {
            System.out.println("Currently playing song " + song.getName());
            player.setCurrentSongIndex(player.getSongslist().indexOf(song));
            player.setCurrentState(new PlayingState(player));
        } else {
            System.out.println("Song is not in playlist");
        }
    }

    @Override
    public void pauseSong() {
        player.setCurrentState(new PauseState(player));
    }

    @Override
    public void skipForward() {
        int currentSong = player.getCurrentSongIndex();
        if (currentSong + 1 < player.getSongslist().size()) {
            System.out.println("Forward to next song");
            playSong(player.getSongslist().get(currentSong + 1));
        }
    }

    @Override
    public void skipBackward() {
        int currentSong = player.getCurrentSongIndex();
        if (currentSong - 1 >= 0) {
            System.out.println("Playing Prev song");
            playSong(player.getSongslist().get(currentSong - 1));
        }
    }

    @Override
    public void stopSong() {
        player.setCurrentState(new StopState(player));
    }


}
