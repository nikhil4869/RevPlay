package com.revplay.service;

public class PlayerService {

    private int currentSongId = -1;
    private boolean isPlaying = false;
    private boolean isPaused = false;

    private SongService songService = new SongService();
    private RecentlyPlayedService recentService = new RecentlyPlayedService();
    private int currentUserId;

    public void playSong(int songId) {

        isPlaying = true;
        isPaused = false;

        System.out.println("🎵 Playing Song ID: " + songId);

        // 🔥 increment play count
        songService.incrementPlayCount(songId);

        // 🔥 save in recently played
        recentService.addPlayedSong(currentUserId, songId);
    }

    public void pauseSong() {
        if (!isPlaying) {
            System.out.println("No song is playing.");
            return;
        }
        isPaused = true;
        System.out.println("⏸ Song Paused.");
    }

    public void resumeSong() {
        if (isPlaying && isPaused) {
            isPaused = false;
            System.out.println("▶ Song Resumed.");
        } else {
            System.out.println("Song is not paused.");
        }
    }

    public void stopSong() {
        isPlaying = false;
        isPaused = false;
        currentSongId = -1;
        System.out.println("⏹ Song Stopped.");
    }

    public boolean isPlaying() { return isPlaying; }
    
    public void setUser(int userId) {
        this.currentUserId = userId;
    }

    
}
