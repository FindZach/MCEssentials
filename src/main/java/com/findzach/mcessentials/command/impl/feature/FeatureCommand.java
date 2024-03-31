package com.findzach.mcessentials.command.impl.feature;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.command.Command;
import com.findzach.mcessentials.command.CommandInfo;
import com.findzach.mcessentials.command.CommandType;
import com.findzach.mcessentials.feature.Feature;
import com.findzach.mcessentials.feature.FeatureManager;
import com.findzach.mcessentials.feature.FeatureType;
import com.findzach.mcessentials.util.Messager;
import org.bukkit.command.CommandSender;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */

@CommandInfo(name = "feature", permission = "essentials.feature", description = "Basic Feature Commands", commandType = CommandType.COMMAND)
public class FeatureCommand implements Command {

    public static FeatureManager featureManager = MCEssentials.getInstance().getFeatureManager();

    @Override
    public void execute(CommandSender sender, String[] args) {
        for (FeatureType featureType: FeatureType.values()) {
            Feature feature = featureManager.getFeature(featureType);

            if (feature != null) {
                Messager.send(sender, "&eFeature: " + feature.getFeatureType() + " Enabled? " + feature.isEnabled());
            }
        }
        Messager.send(sender, "&eWe're back baby!");
    }
}
