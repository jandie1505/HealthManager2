package main;

import commands.*;
import expansions.ExpansionPlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    public static String version = "2.0";

    private static Main plugin;

    public static boolean ignoreop;

    public static boolean PAPIenabled;

    private int mainTask;

    public void onEnable(){
        plugin = this;
        Config.load();
        ChatMessages.load();
        PlaceholderMessages.load();
        ignoreop = Config.ignoreOp;

        Objects.requireNonNull(getCommand("healthmanager")).setExecutor(new CommandHealthmanager());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new CommandHeal());
        Objects.requireNonNull(getCommand("sethealth")).setExecutor(new CommandSethealth());
        Objects.requireNonNull(getCommand("sethunger")).setExecutor(new CommandSethunger());
        Objects.requireNonNull(getCommand("gethealth")).setExecutor(new CommandGethealth());
        Objects.requireNonNull(getCommand("gethunger")).setExecutor(new CommandGethunger());
        Objects.requireNonNull(getCommand("setmaxhealth")).setExecutor(new CommandSetmaxhealth());
        Objects.requireNonNull(getCommand("getmaxhealth")).setExecutor(new CommandGetmaxhealth());
        Objects.requireNonNull(getCommand("setsaturation")).setExecutor(new CommandSetsaturation());
        Objects.requireNonNull(getCommand("getsaturation")).setExecutor(new CommandGetsaturation());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new CommandFeed());
        Objects.requireNonNull(getCommand("saturationmode")).setExecutor(new CommandSaturationmode());
        Objects.requireNonNull(getCommand("god")).setExecutor(new CommandGod());

        ConsoleMessages.defaultMessage("HealthManager2 was successfully enabled");

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            PAPIenabled = true;
        } else {
            PAPIenabled = false;
        }

        if(Config.placeholderapi && PAPIenabled){
            new ExpansionPlaceholderAPI().register();
            ConsoleMessages.defaultMessage("PlaceholderAPI Support enabled");
        } else if(Config.placeholderapi && !PAPIenabled) {
            ConsoleMessages.defaultMessage("PlaceholderAPI Support enabled but it was not found");
        } else {
            ConsoleMessages.defaultMessage("PlaceholderAPI Support disabled");
        }

        mainTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                tasks.TaskSaturationmode.run();
                tasks.TaskGodmode.run();
            }
        }, 0, 1);
    }

    public static Main getPlugin(){
        return plugin;
    }

}
