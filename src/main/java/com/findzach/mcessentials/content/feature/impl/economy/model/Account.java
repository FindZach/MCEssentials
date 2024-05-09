package com.findzach.mcessentials.content.feature.impl.economy.model;

import java.util.UUID;

/**
 * @author: Zach Smith
 * @date: 3/30/2024
 * @time: 9:55 PM
 */
public class Account {

    private final UUID uuid;
    private double balance;

    public Account(UUID uuid) {
        this.uuid = uuid;
    }
}
