package com.revplay.service;

import java.util.List;                 // ✅ CORRECT
import com.revplay.dao.FavoriteDao;
import com.revplay.model.Song;         // ✅ YOU MISSED THIS IMPORT

public class FavoriteService {

    private FavoriteDao favoriteDao = new FavoriteDao();

    public boolean add(int userId, int songId) {
        return favoriteDao.addFavorite(userId, songId);
    }

    public boolean remove(int userId, int songId) {
        return favoriteDao.removeFavorite(userId, songId);
    }

    // ✅ THIS METHOD WAS CORRECT, just needed proper imports
    public List<Song> getFavorites(int userId) {
        return favoriteDao.getUserFavorites(userId);
    }
}
