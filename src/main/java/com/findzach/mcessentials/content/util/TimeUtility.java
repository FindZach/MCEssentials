package com.findzach.mcessentials.content.util;

import com.findzach.mcessentials.MCEssentials;
import org.bukkit.World;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class TimeUtility {

    public enum Time {
        DAY(0),
        NIGHT(14000),
        AFTERNOON(6000);

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
            response = MCEssentials.getInstance().getMessage("basic.time-change").replaceAll("%time%", time.name().toLowerCase());
        }
        return response;
    }
}
