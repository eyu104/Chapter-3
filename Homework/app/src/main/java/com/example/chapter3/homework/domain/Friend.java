package com.example.chapter3.homework.domain;

/**
 * @author z'
 * @version 1.0
 * @description:
 */
public class Friend {
    private String name;
    private boolean online;

    public Friend(String name, boolean online) {
        this.name = name;
        this.online = online;
    }

    public String getName() {
        return name;
    }

    public boolean isOnline() {
        return online;
    }
}
