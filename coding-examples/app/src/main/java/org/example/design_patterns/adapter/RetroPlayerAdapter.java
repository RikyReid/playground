package org.example.design_patterns.adapter;

class RetroPlayerAdapter implements MusicPlayer {
    private RetroPlayer retroPlayer = new RetroPlayer();

    @Override
    public void play() {
        retroPlayer.playButton();
    }
}
