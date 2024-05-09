package com.findzach.mcessentials.io.net.jetty;

import com.findzach.mcessentials.content.highscore.HighscoreManager;
import com.findzach.mcessentials.content.highscore.model.PlayerScore;
import com.findzach.mcessentials.content.highscore.model.Skill;
import com.findzach.mcessentials.content.highscore.model.calculation.TimePlayedCalculator;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Zach Smith
 * @date: 5/9/2024
 * @time: 3:18 PM
 */
public class DataFetchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Extract skill parameter from the request
        String skill = req.getParameter("skill");
        if (skill == null || skill.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // Fetch player data for the given skill
        List<PlayerScore> scores = getHighScoresForSkill(skill);
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(scores);

        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write(jsonResponse);
    }

    private List<PlayerScore> getHighScoresForSkill(String skill) {
        Skill foundSkill = HighscoreManager.getSkillByName(skill);
        if (foundSkill != null) {
            List<PlayerScore> response = HighscoreManager.getScoresFromSkill(foundSkill);
            if (response != null) {
                return response;
            }

        }

        return Arrays.asList(new PlayerScore("PlayerOne", 1500), new PlayerScore("PlayerTwo", 1300));
    }
}
