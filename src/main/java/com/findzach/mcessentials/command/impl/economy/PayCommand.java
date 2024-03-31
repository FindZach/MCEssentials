package com.findzach.mcessentials.command.impl.economy;

import com.findzach.mcessentials.command.Command;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.util.Messager;
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
