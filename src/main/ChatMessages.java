package main;

import org.bukkit.configuration.file.FileConfiguration;

public class ChatMessages {
    static FileConfiguration config = Main.getPlugin().getConfig();

    public static String prefix;
    public static String nopermission;
    public static String stateMessage1;
    public static String stateMessage2;
    public static String playernotfound;
    public static String healmessage;
    public static String healmessageothers;

    public static void load(){
        prefix = config.getString("prefix");
        nopermission = config.getString("nopermission");
        stateMessage1 = "§6HealthManager2 (" + Main.version + ") by jandie1505";
        stateMessage2 = "§eUse /healthmanager help for more information";
        healmessage = config.getString("healmessage");
        healmessageothers = config.getString("healmessageothers");
        playernotfound = config.getString("playernotfound");
    }
}
