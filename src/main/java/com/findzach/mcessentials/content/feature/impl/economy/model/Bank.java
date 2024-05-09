package com.findzach.mcessentials.content.feature.impl.economy.model;

import java.util.UUID;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
public class Bank {

    private final UUID ownerUUID;

    private double balance;

    public Bank(UUID uuid) {
        this.ownerUUID = uuid;
    }


}
