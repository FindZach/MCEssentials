package com.findzach.mcessentials.command.impl.gamemode.other;

import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.SubCommand;
import org.bukkit.command.CommandSender;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
@CommandInfo(name = "gms <player>", permission = "essentials.gms.other", description = "Applies Survival mode to the selected player", commandType = CommandType.SUB_COMMAND)
public class SetSurvivalCommand implements SubCommand {
    @Override
    public void execute(CommandSender sender, String subCommand, String[] args) {

    }
}
