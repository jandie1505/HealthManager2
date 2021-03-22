package main;

import commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {
    public static String version = "2.0";

    private static Main plugin;

    public static boolean ignoreop;

    private int mainTask;

    public void onEnable(){
        plugin = this;
        Config.load();
        ChatMessages.load();
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

        ConsoleMessages.defaultMessage("HealthManager2 was successfully enabled");

        mainTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                tasks.TaskSaturationmode.run();
            }
        }, 0, 1);
    }

    public static Main getPlugin(){
        return plugin;
    }

}
