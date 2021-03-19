package main;

import commands.CommandHeal;
import commands.CommandHealthmanager;
import commands.CommandSethealth;
import commands.CommandSethunger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    public static String version = "2.0";

    private static Main plugin;

    public static boolean ignoreop;

    public void onEnable(){
        plugin = this;
        Config.load();
        ChatMessages.load();
        ignoreop = Config.ignoreOp;

        Objects.requireNonNull(getCommand("healthmanager")).setExecutor(new CommandHealthmanager());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new CommandHeal());
        Objects.requireNonNull(getCommand("sethealth")).setExecutor(new CommandSethealth());
        Objects.requireNonNull(getCommand("sethunger")).setExecutor(new CommandSethunger());

        ConsoleMessages.defaultMessage("HealthManager2 was successfully enabled");
    }

    public static Main getPlugin(){
        return plugin;
    }

}
