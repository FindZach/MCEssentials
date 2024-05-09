package com.findzach.mcessentials.content.util;

import java.util.List;
import java.util.Random;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/10/2023
 */
public class Utility {
    private static final Random RANDOM = new Random();

    public static String getRandomString(List<String> list) {
        int randomIndex = RANDOM.nextInt(list.size());
        return list.get(randomIndex);
    }
}
