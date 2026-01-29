package com.revplay.service;

import java.util.List;
import com.revplay.dao.RecentlyPlayedDao;
import com.revplay.model.Song;

public class RecentlyPlayedService {

    private RecentlyPlayedDao dao = new RecentlyPlayedDao();

    public void addPlayedSong(int userId, int songId) {
        dao.addEntry(userId, songId);
    }

    public List<Song> getRecentSongs(int userId) {
        return dao.getRecentSongs(userId);
    }
}