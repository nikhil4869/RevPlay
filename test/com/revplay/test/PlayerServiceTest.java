package com.revplay.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revplay.service.PlayerService;
import com.revplay.service.RecentlyPlayedService;
import com.revplay.service.SongService;

public class PlayerServiceTest {

    @Mock
    private SongService songService;

    @Mock
    private RecentlyPlayedService recentService;

    private PlayerService playerService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        playerService = new PlayerService(songService, recentService);
        playerService.setUser(1); 
    }


    @Test
    public void testPlaySong() {
        playerService.playSong(10);

        assertTrue(playerService.isPlaying());
        verify(songService).incrementPlayCount(10);
        verify(recentService).addPlayedSong(1, 10);
    }


    @Test
    public void testPauseSong() {
        playerService.playSong(10); 
        playerService.pauseSong();

        // state test
        playerService.resumeSong(); 
        verify(songService).incrementPlayCount(10);
    }


    @Test
    public void testResumeSongWhenPaused() {
        playerService.playSong(10);
        playerService.pauseSong();
        playerService.resumeSong();

        assertTrue(playerService.isPlaying());
    }


    @Test
    public void testStopSong() {
        playerService.playSong(10);
        playerService.stopSong();

        assertFalse(playerService.isPlaying());
    }


    @Test
    public void testPauseWithoutPlaying() {
        playerService.pauseSong();

        assertFalse(playerService.isPlaying());
        verifyZeroInteractions(songService);
    }
}
