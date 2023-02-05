package dev.valentinspac.proxy.service;

import java.io.File;

public interface Playable {
    void play(String song);
    void play(File song);
    void play(File song, int start);
    void play(File song, int start, int finish);
}
