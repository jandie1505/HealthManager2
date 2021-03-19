package main;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    static FileConfiguration config = Main.getPlugin().getConfig();

    public static boolean ignoreOp;
    public static boolean sendMessagesToTarget;


    public static void load(){
        ignoreOp = config.getBoolean("ignoreop");
        sendMessagesToTarget = config.getBoolean("sendmessagestotarget");
    }
}
