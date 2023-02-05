package dev.valentinspac.proxy.service;

import dev.valentinspac.proxy.framework.MyCustomTransaction;
import dev.valentinspac.proxy.framework.TransactionalService;

import java.io.File;

@TransactionalService
public class PlayerService implements Playable, Seekable {

    @Override
    @MyCustomTransaction
    public void play(String filePath) {
        this.play(new File(filePath));
    }

    @Override
    @MyCustomTransaction("file")
    public void play(File song) {
        // Increment in DB number of plays for this song
        System.out.println("Playing song " + song.getName());
    }

    @Override
    @MyCustomTransaction("starting at")
    public void play(File song, int start) {
        // Increment in DB number of plays for this song
        System.out.println("Playing song " + song.getName() + " starting at " + start);
    }

    @Override
    @MyCustomTransaction("interval")
    public void play(File song, int start, int finish) {
        // Increment in DB number of plays for this song
        System.out.println("Playing song " + song.getName() + " starting at " + start + " till " + finish);
    }

    @Override
    public void seekTo(int position) {
        System.out.println("Seek to " + position);
    }
}
