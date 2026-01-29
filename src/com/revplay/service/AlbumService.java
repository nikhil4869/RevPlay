package com.revplay.service;

import java.util.Date;
import java.util.List;
import com.revplay.dao.AlbumDao;
import com.revplay.model.Album;

public class AlbumService {

    private AlbumDao albumDao = new AlbumDao();

    // ðŸ’¿ Create album
    public boolean createAlbum(int artistId, String name, Date releaseDate) {
        Album album = new Album();
        album.setArtistId(artistId);
        album.setAlbumName(name);
        album.setReleaseDate(releaseDate);
        return albumDao.createAlbum(album);
    }

    // ðŸ“‚ View artist albums
    public List<Album> viewMyAlbums(int artistId) {
        return albumDao.getAlbumsByArtist(artistId);
    }

    // âœ� Update album
    public boolean updateAlbum(int albumId, String name) {
        return albumDao.updateAlbum(albumId, name);
    }

    // â�Œ Delete album (also deletes songs via DAO)
    public boolean deleteAlbum(int albumId) {
        return albumDao.deleteAlbum(albumId);
    }
    
    public int findAlbumIdByName(String name) {
        return albumDao.getAlbumIdByName(name);
    }
}
