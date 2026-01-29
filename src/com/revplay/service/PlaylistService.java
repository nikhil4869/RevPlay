package com.revplay.service;

import java.util.*;
import com.revplay.model.Song;

import com.revplay.dao.PlaylistDao;
import com.revplay.model.Playlist;

public class PlaylistService {

    private PlaylistDao dao = new PlaylistDao();

    public boolean create(int userId, String name, String desc, String privacy) {
        Playlist p = new Playlist();
        p.setUserId(userId);
        p.setName(name);
        p.setDescription(desc);
        p.setPrivacy(privacy);
        return dao.createPlaylist(p);
    }

    public List<Playlist> getMine(int userId) {
        return dao.getUserPlaylists(userId);
    }

    public boolean addSong(int pid, int sid) { return dao.addSong(pid, sid); }
    public boolean removeSong(int pid, int sid) { return dao.removeSong(pid, sid); }
    public boolean delete(int id) { return dao.deletePlaylist(id); }
    
    public boolean update(int id, String name, String desc, String privacy) {
        return dao.updatePlaylist(id, name, desc, privacy);
    }
    
    public List<Song> getSongsInPlaylist(int playlistId) {
        return dao.getSongsInPlaylist(playlistId);
    }


}
