package com.findzach.mcessentials.command.impl.economy;

import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.command.SubCommand;
import com.findzach.mcessentials.util.Messager;
import org.bukkit.command.CommandSender;

/**
 * @author: Zach Smith
 * @date: 3/30/2024
 * @time: 10:07 PM
 */
@CommandInfo(name = "pay <player>", permission = "essentials.eco.pay", description = "Economy Pay Player", commandType = CommandType.SUB_COMMAND)
public class PayOtherCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String subCommand, String[] args) {
        try {
            String playerName = args[0];
            double amountToPay = Double.valueOf(args[1]);

            Messager.send(sender, "&e&lPaying Other... Subcommand: " + args[0] + " - " + args[1]);
            Messager.send(sender, "&e&lPaying " + playerName + " Amount: " + amountToPay);
        } catch (Exception e) {
            Messager.send(sender, "&aInvalid Command Usage: &c/pay {username} {amount}");
        }

    }
}
