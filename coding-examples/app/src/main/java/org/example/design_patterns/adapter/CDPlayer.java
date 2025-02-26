package org.example.design_patterns.adapter;

public class CDPlayer implements MusicPlayer {
    @Override
    public void play() {
        System.out.println("CD Player - play");
    }
}
