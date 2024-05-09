package com.findzach.mcessentials.content.command;

import org.bukkit.command.CommandSender;

/**
 * @author Zach <zach@findzach.com>
 * @since 9/9/2023
 */
public interface SubCommand {
    void execute(CommandSender sender, String subCommand, String[] args);

    default String getName() {
        return this.getClass().getAnnotation(CommandInfo.class).name();
    }

    default String getPermission() {
        return this.getClass().getAnnotation(CommandInfo.class).permission();
    }

    default String getDescription() {
        return this.getClass().getAnnotation(CommandInfo.class).description();
    }
}
