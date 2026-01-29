package com.revplay.service;

import com.revplay.dao.ArtistDao;
import com.revplay.model.Artist;

public class ArtistService {

    private ArtistDao artistDao = new ArtistDao();

    public boolean createProfile(int userId, String bio, String genre, String social) {

        if (artistDao.profileExists(userId)) {
            return false; // already exists
        }

        Artist artist = new Artist();
        artist.setUserId(userId);
        artist.setBio(bio);
        artist.setGenre(genre);
        artist.setSocialLinks(social);

        return artistDao.createProfile(artist);
    }

    public boolean updateProfile(int userId, String bio, String genre, String social) {

        Artist artist = new Artist();
        artist.setUserId(userId);
        artist.setBio(bio);
        artist.setGenre(genre);
        artist.setSocialLinks(social);

        return artistDao.updateProfile(artist);
    }

    public Artist getProfile(int userId) {
        return artistDao.getArtistByUser(userId);
    }
    
    public boolean profileExists(int userId) {
        return artistDao.profileExists(userId);
    }

}
