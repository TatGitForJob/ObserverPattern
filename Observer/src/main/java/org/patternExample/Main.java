package org.patternExample;

import org.patternExample.subscribers.Developer;
import org.patternExample.subscribers.GameReviewer;
import org.patternExample.subscribers.Gamer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Gamer firstPlayer = new Gamer("first player"), secondPlayer = new Gamer("second player");
        var reviewer = new GameReviewer();
        var developer = new Developer();
        var notificator = new NewGameNotificator();
        notificator.AddSubscriber(firstPlayer);
        notificator.AddSubscriber(secondPlayer);
        notificator.AddSubscriber(reviewer);
        notificator.AddSubscriber(developer);
        ArrayList<String> firstAchievementsList = new ArrayList<>(), secondAchievementsList = new ArrayList<>();
        firstAchievementsList.add("hot stuff");
        firstAchievementsList.add("First emerald");
        firstAchievementsList.add("Shower me with diamonds");
        secondAchievementsList.add("Russenya medal");
        secondAchievementsList.add("Bomber");
        Game firstGame = new Game("Minecraft", firstAchievementsList,
                "Minecraft is coolest game in the world!", "documentation"),
                secondGame = new Game("World of Tanks ", secondAchievementsList,
                        "Potato", "The most popular game in male community ");
        notificator.ReleaseNewGame(firstGame);
        System.out.println("\n\n\nNew Release\n\n\n");
        notificator.ReleaseNewGame(secondGame);
    }
}