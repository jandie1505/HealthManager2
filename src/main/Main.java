package main;

import commands.CommandHeal;
import commands.CommandHealthmanager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static String version = "2.0";

    private static Main plugin;
    public static boolean ignoreop;

    public void onEnable(){
        plugin = this;
        Config.load();
        ChatMessages.load();
        ignoreop = Config.ignoreOp;
        getCommand("healthmanager").setExecutor(new CommandHealthmanager());
        getCommand("heal").setExecutor(new CommandHeal());
        ConsoleMessages.defaultMessage("HealthManager2 was successfully enabled");
    }

    public static Main getPlugin(){
        return plugin;
    }

}
