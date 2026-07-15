package State;

import Entities.Song;

public abstract class PlayerState {
    public void playSong(Song song) {
        System.out.println("This operation is not supported now");
    }

    public void pauseSong() {
        System.out.println("This operation is not supported now");
    }

    public void skipForward() {
        System.out.println("This operation is not supported now");
    }

    public void skipBackward() {
        System.out.println("This operation is not supported now");
    }

    public void stopSong() {
        System.out.println("This operation is not supported now");
    }
}
