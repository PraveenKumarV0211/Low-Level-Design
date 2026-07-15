package Entities;

import State.PlayerState;
import State.StopState;

import java.util.List;

public class Player {
    private int id;
    private List<Song> songslist;
    private PlayerState currentState;
    private int currentSongIndex;

    public Player(int id, List<Song> songslist) {
        this.id = id;
        this.songslist = songslist;
        this.currentState = new StopState(this);
        this.currentSongIndex = 0;
    }

    public void play(Song song) {
        currentState.playSong(song);
    }

    public void pause() {
        currentState.pauseSong();
    }

    public void stop() {
        currentState.stopSong();
    }

    public void next() {
        currentState.skipForward();
    }

    public void previous() {
        currentState.skipBackward();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public List<Song> getSongslist() { return songslist; }
    public void setSongslist(List<Song> songslist) { this.songslist = songslist; }
    public PlayerState getCurrentState() { return currentState; }
    public void setCurrentState(PlayerState currentState) { this.currentState = currentState; }
    public int getCurrentSongIndex() { return currentSongIndex; }
    public void setCurrentSongIndex(int currentSongIndex) { this.currentSongIndex = currentSongIndex; }
}