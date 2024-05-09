package com.findzach.mcessentials.content.command.impl.economy;

import com.findzach.mcessentials.content.command.Command;
import com.findzach.mcessentials.content.command.CommandInfo;
import com.findzach.mcessentials.content.command.CommandType;
import com.findzach.mcessentials.content.util.Messager;
import org.bukkit.command.CommandSender;

/**
 * @author: Zach Smith
 * @date: 3/30/2024
 * @time: 10:01 PM
 */
@CommandInfo(name = "pay", permission = "mcessentials.eco.pay", commandType = CommandType.COMMAND, description = "Pays a user money")
public class PayCommand implements Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Messager.send(sender, "&aSending money...");
    }
}
