package com.findzach.mcessentials.command.impl.economy;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.Command;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.util.Messager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.CommandSender;

/**
 * @author: Zach Smith
 * @date: 3/30/2024
 * @time: 9:35 PM
 */
@CommandInfo(name = "balance", permission = "eco.balance", commandType = CommandType.COMMAND, description = "Check users money")
public class BalanceCommand implements Command {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Economy econ = MCEssentials.getInstance().getServer().getServicesManager().getRegistration(Economy.class).getProvider();

        Messager.send(sender, "&aBalance: &6" + econ.getBalance(sender.getName()) + " " + econ.currencyNamePlural());
    }
}
