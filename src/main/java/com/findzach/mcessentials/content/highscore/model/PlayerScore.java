package com.findzach.mcessentials.content.highscore.model;

/**
 * @author: Zach Smith
 * @date: 5/9/2024
 * @time: 2:58 PM
 */
public class PlayerScore {
    private String name;
    private Object score;

    public PlayerScore(String name, Object score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public Object getScore() {
        return this.score;
    }
}
