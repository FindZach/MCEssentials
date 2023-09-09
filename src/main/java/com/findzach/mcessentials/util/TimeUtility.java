package com.findzach.mcessentials.util;

import com.findzach.mcessentials.MCEssentials;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class TimeUtility {

    public enum Time {
        DAY(0),
        NIGHT(1200),
        AFTERNOON(600);

        private int timeValue;

        Time(int timeValue) {
            this.timeValue = timeValue;
        }

        public int getTimeValue() {
            return timeValue;
        }
    }

    public static String setTime(Time time, World world) {
        String response = "Unable to set the time for the selected world";
        if (world != null) {
            world.setTime(time.getTimeValue());
            response = "Successfully set the time to " + time.name();
        }
        return response;
    }
}
