package com.findzach.mcessentials.content.highscore;

import com.findzach.mcessentials.content.highscore.model.PlayerScore;
import com.findzach.mcessentials.content.highscore.model.Scorable;
import com.findzach.mcessentials.content.highscore.model.Skill;
import com.findzach.mcessentials.content.highscore.model.calculation.DefaultCalculator;
import com.findzach.mcessentials.content.highscore.model.calculation.TimePlayedCalculator;
import com.findzach.mcessentials.content.highscore.model.calculation.UniqueItemCalculator;
import org.bukkit.Material;
import org.bukkit.Statistic;

import java.util.*;

/**
 * @author: Zach Smith
 * @date: 5/9/2024
 * @time: 3:40 PM
 *
 * Will satisfy our DataFetchServlet Player data
 */
public class HighscoreManager {

    public static final List<Skill> totalSkills = getTotalSkillList();

    public static final Map<Skill, Scorable> skillCalculator = new HashMap<>();

    static {
        skillCalculator.put(getSkillByName("play time"), new TimePlayedCalculator());
        skillCalculator.put(getSkillByName("Player Kills (PvP)"), new DefaultCalculator(Statistic.PLAYER_KILLS));
        skillCalculator.put(getSkillByName("Mob Kills (PvM)"), new DefaultCalculator(Statistic.MOB_KILLS));
        skillCalculator.put(getSkillByName("Player Deaths"), new DefaultCalculator(Statistic.DEATHS));


        skillCalculator.put(getSkillByName("Farming"), new UniqueItemCalculator(Statistic.MINE_BLOCK,
                Arrays.asList(Material.CACTUS, Material.WHEAT, Material.SUGAR_CANE, Material.PUMPKIN, Material.MELON)));


        skillCalculator.put(getSkillByName("Ranching"), new DefaultCalculator(Statistic.ANIMALS_BRED));


        skillCalculator.put(getSkillByName("Woodcutting"), new UniqueItemCalculator(Statistic.MINE_BLOCK,
                Arrays.asList(Material.OAK_LOG, Material.ACACIA_LOG, Material.DARK_OAK_LOG,
                        Material.BIRCH_LOG, Material.JUNGLE_LOG, Material.MANGROVE_LOG, Material.SPRUCE_LOG)));

        skillCalculator.put(getSkillByName("Mining"), new UniqueItemCalculator(Statistic.MINE_BLOCK,
                Arrays.asList(Material.STONE, Material.DEEPSLATE_DIAMOND_ORE,
                        Material.IRON_ORE, Material.DIRT, Material.DIAMOND_ORE, Material.COAL_ORE)));
    }

    private static List<Skill> getTotalSkillList() {
        List<Skill> skills = new ArrayList<>();

        skills.add(new Skill("Play Time", "Total hours spent in-game", "Total Hours"));
        skills.add(new Skill("Player Kills (PvP)", "Number of enemy players defeated in combat", "Total Kills"));
        skills.add(new Skill("Mob Kills (PvM)", "Number of hostile mobs defeated in combat", "Total Kills"));
        skills.add(new Skill("Player Deaths", "Number of times a player has died", "Total Deaths"));
        skills.add(new Skill("Farming", "Total crops harvested and seeds planted", "Total Crops"));
        skills.add(new Skill("Mining", "Total ores and gems mined", "Total Ores Mined"));
        skills.add(new Skill("Woodcutting", "Total trees felled", "Total Logs Gathered"));
        skills.add(new Skill("Ranching", "Total livestock bred and cared for", "Total Livestock"));

        return skills;
    }

    public static Skill getSkillByName(String displayName) {
        for (Skill skill: totalSkills) {
            if (skill.getDisplayName().equalsIgnoreCase(displayName)) {
                return skill;
            }
        }

        return null;
    }


    /**
     * Gets the scores from Skill
     * @param skill
     * @return
     */
    public static List<PlayerScore> getScoresFromSkill(Skill skill) {
        if (skillCalculator.containsKey(skill)) {
            Scorable calculator = skillCalculator.get(skill);

            return calculator != null ? calculator.calculateScore() : null;
        }

        return null;
    }

}
