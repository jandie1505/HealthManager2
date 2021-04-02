package net.jandie1505.healthmanager.main;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    static FileConfiguration config = Main.getPlugin().getCustomConfig();

    public static boolean ignoreOp;
    public static boolean sendMessagesToTarget;
    public static boolean placeholderapi;

    public static void load(){
        ignoreOp = config.getBoolean("ignoreop");
        sendMessagesToTarget = config.getBoolean("sendmessagestotarget");
        placeholderapi = config.getBoolean("placeholderapi");
    }
}
