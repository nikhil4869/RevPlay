package com.revplay.service;

import java.util.Date;
import java.util.List;
import com.revplay.dao.SongDao;
import com.revplay.model.Song;

public class SongService {

    private SongDao songDao = new SongDao();

    // ================= UPLOAD SONG =================
    public boolean uploadSong(String title, String genre, double duration,
                              Date releaseDate, int artistId, int albumId) {

        Song song = new Song();
        song.setTitle(title);
        song.setGenre(genre);
        song.setDuration(duration);
        song.setReleaseDate(releaseDate);
        song.setArtistId(artistId);
        song.setAlbumId(albumId);

        return songDao.addSong(song);
    }

    // ================= ARTIST SONGS =================
    public List<Song> viewMySongs(int artistId) {
        return songDao.getSongsByArtist(artistId);
    }

    // ================= ALBUM SONGS =================
    public List<Song> viewSongsByAlbum(int albumId) {
        return songDao.getSongsByAlbum(albumId);
    }

    public List<Song> getSongsByAlbumId(int albumId) {
        return songDao.getSongsByAlbum(albumId);
    }

    // ================= UPDATE SONG =================
    public boolean updateSong(int songId, String title, String genre,
                              double dur, Date date) {

        Song s = new Song();
        s.setSongId(songId);
        s.setTitle(title);
        s.setGenre(genre);
        s.setDuration(dur);
        s.setReleaseDate(date);

        return songDao.updateSong(s);
    }

    // ================= DELETE SONG =================
    public boolean deleteSong(int songId) {
        return songDao.deleteSong(songId);
    }

    // ================= PLAY COUNT =================
    public int getPlayCount(int songId) {
        return songDao.getPlayCount(songId);
    }

    public void incrementPlayCount(int songId) {
        songDao.incrementPlayCount(songId);
    }

    // ================= FAVORITES COUNT =================
    public int getFavoritesCount(int songId) {
        return songDao.getFavoritesCount(songId);
    }

    // ================= ALL SONGS =================
    public List<Song> viewAllSongs() {
        return songDao.getAllSongs();
    }

    // ================= SONG EXISTS =================
    public boolean songExists(int songId) {
        List<Song> songs = songDao.getAllSongs();
        for (Song s : songs) {
            if (s.getSongId() == songId)
                return true;
        }
        return false;
    }

    // =====================================================
    // 🔥 NEW BROWSING FEATURES
    // =====================================================

    // 🎵 Browse by Genre
    public List<Song> getSongsByGenre(String genre) {
        return songDao.getSongsByGenre(genre);
    }

    // 🎤 Browse by Artist Name
    public List<Song> getSongsByArtistName(String artistName) {
        return songDao.getSongsByArtistName(artistName);
    }

    // 💿 Browse by Album Name
    public List<Song> getSongsByAlbumName(String albumName) {
        return songDao.getSongsByAlbumName(albumName);
    }

    // 🔍 Search by Song Title
    public List<Song> searchSongsByTitle(String title) {
        return songDao.searchSongsByTitle(title);
    }
}