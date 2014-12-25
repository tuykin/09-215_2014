package ru.kpfu.disciplines.db.gtf.helpers;

import java.lang.reflect.Field;

public class GamedevTypes {
    private GamedevTypes getThis() {
        return this;
    }

    public static final String[] Platforms = {"", "PC", "Mobile", "Game Console"};

    public static final String[] Positions  = {"", "Animator", "Assistant Producer", "Audio Engineer", "Creative Director",
            "External Producer", "Game Designer", "Game Programmer", "Games Artist", "Lead Artist", "Lead Programmer",
            "Level Editor", "Marketing Executive", "Marketing Manager", "Product Manager", "Producer",
            "Public Relations Officer", "QA Tester", "Technical Artist"};

    // общий жанр(глобальный)
    public static final String[] GlobalGenre = {"", "Action", "Adventure", "Fighting", "Racing", "RPG", "Simulation",
            "Sport", "Strategy", "Parlor", "MMO", "Misc"};

    // поджанры
    public static final String[] Action = {"", "Action RPG", "Dungeon crawl", "Fighting", "First-person shooter",
            "Fixed Third Person Shooter", "Hack & Slash", "Light gun", "MMOFPS", "Platformer", "Rail shooter",
            "Run and Gun", "Shmup", "Shooter", "Side-scrolling shooter", "Stealth action", "Survival horror",
            "Third-person action", "Third-person shooter", "Vehicular combat"};
    public static final String[] Adventure = {"", "2D platformer", "3D platformer","Action-adventure", "Dungeon crawl",
            "Eroge", "Interactive fiction", "Metroidvania", "Open world", "Platformer", "Point & click adventure",
            "Roguelike", "Sandbox", "Text adventure", "Visual novel"};
    public static final String[] Fighting = {"", "2D fighter", "3D fighter", "Beat 'em up", "Boxing", "Hack & Slash",
            "Versus fighting", "Wrestling"};
    public static final String[] Racing = {"", "Arcade racer", "Futuristic racer", "Kart racer", "MMOR", "Simulation racer"};
    public static final String[] RPG = {"", "Action RPG", "Alternate Reality", "Console RPG", "Dungeon crawl", "MMOG",
            "MMORPG", "PC RPG", "Roguelike", "Strategy RPG", "Tactical RPG"};
    public static final String[] Simulation = {"", "Flight simulation", "Train simulation", "Life simulation", "MMOS",
            "Open-ended simulation", "Simulation racer", "Simulation sport", "Virtual pet"};
    public static final String[] Sport = {"", "Arcade sport", "Extreme sport", "Racing", "Simulation sport", "Soccer",
            "Statistical sport"};
    public static final String[] Strategy = {"", "4XS", "Man-to-man wargame", "MMORTS", "MOBA", "Real-time strategy",
            "Real-time tactics", "Strategy RPG", "Tactical RPG", "Tower defense", "Turn-based strategy",
            "Turn-based tactics", "Wargaming"};
    public static final String[] Parlor = {"", "Edutainment", "Microgame", "Music game", "Party game", "Puzzle"};
    public static final String[] MMO = {"", "MMORPG", "MMOFPS", "MMORTS", "MMOCB", "MMOCMS", "MMOSS", "MMOR"};
    public static final String[] Misc = {"", "Board game", "Browser-based", "Cutscene", "Eroge", "Movie-based game",
            "Non-linear", "Pinball", "Side-scroller"};

    // метод для получения переменной поджанра по названию строкового типа
    public static String[] getGenre(String str) {
        for(Field field : GamedevTypes.class.getFields()) {
            if(field.getName().equals(str)) {
                try {
                    return (String[])field.get(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}