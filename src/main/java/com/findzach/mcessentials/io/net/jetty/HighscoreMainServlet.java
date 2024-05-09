package com.findzach.mcessentials.io.net.jetty;

import com.findzach.mcessentials.MCEssentials;
import com.findzach.mcessentials.content.highscore.HighscoreManager;
import com.findzach.mcessentials.content.highscore.model.Skill;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 * @author: Zach Smith
 * @date: 3/31/2024
 * @time: 12:14 AM
 */
public class HighscoreMainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        File highscoresFile = new File(MCEssentials.getInstance().getDataFolder(), "highscores/index.html");

        if (!highscoresFile.exists()) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("File not found.");
            return;
        }

        // Fetch skills
        List<Skill> skills = HighscoreManager.totalSkills;
        Gson gson = new Gson();
        String jsonSkills = gson.toJson(skills);

        // Read the HTML template into a String
        String htmlContent = new String(Files.readAllBytes(highscoresFile.toPath()), StandardCharsets.UTF_8);

        // Inject skills JSON into the HTML
        //String fullContent = htmlContent.replace("<script id=\"skillsDataPlaceholder\"></script>", "<script>var skillsData = " + jsonSkills + ";</script>");
        String fullContent = htmlContent.replace("<script id=\"skillsDataPlaceholder\"></script>", "<script>var skillsData = " + jsonSkills + ";</script>");

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write(fullContent);
    }


}