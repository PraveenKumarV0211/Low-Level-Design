package State;

import Entities.Player;
import Entities.Song;

public class StopState extends PlayerState{
    Player player;

    public StopState(Player player) {
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
}
