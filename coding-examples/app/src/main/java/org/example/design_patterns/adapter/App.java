package org.example.design_patterns.adapter;

public class App {
    public static void main(String[] args) {
        var cdPlayer = new CDPlayer();
        cdPlayer.play();

        var retroPlayerAdapter = new RetroPlayerAdapter();
        retroPlayerAdapter.play();
    }
}
