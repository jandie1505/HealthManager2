package main;

import org.apache.commons.text.StringSubstitutor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import tasks.TaskGodmode;
import tasks.TaskSaturationmode;

import java.util.Map;

public class PlaceholderMessages {
    private static FileConfiguration config = Main.getPlugin().getConfig();

    private static String health;
    private static String maxHealth;
    private static String foodLevel;
    private static String saturationLevel;

    private static String godmodeOn;
    private static String godmodeOff;

    private static String saturationmodeOn;
    private static String saturationmodeOff;



    public static String getHealth(Player player) {
        String message;
        String result;
        String playerName = player.getName();
        message = health;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "LIVES", String.valueOf((int) player.getHealth())
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }
    public static String getMaxHealth(Player player){
        String message;
        String result;
        String playerName = player.getName();
        message = maxHealth;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "MAXHEALTH", String.valueOf((int) player.getMaxHealth())
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }
    public static String getFoodLevel(Player player){
        String message;
        String result;
        String playerName = player.getName();
        message = foodLevel;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "FOODLEVEL", String.valueOf((int) player.getFoodLevel())
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }
    public static String getSaturationLevel(Player player){
        String message;
        String result;
        String playerName = player.getName();
        message = saturationLevel;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "SATURATIONLEVEL", String.valueOf((int) player.getSaturation())
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getGodmode(Player player){
        if(TaskGodmode.checkGodmodeIsEnabled(player)){
            return godmodeOn;
        } else {
            return godmodeOff;
        }
    }

    public static String getSaturationmode(Player player){
        if(TaskSaturationmode.checkSaturationIsEnabled(player)){
            return saturationmodeOn;
        } else {
            return saturationmodeOff;
        }
    }



    public static void load(){
        health = config.getString("PlaceholderHealth");
        maxHealth = config.getString("PlaceholderMaxhealth");
        foodLevel = config.getString("PlaceholderFoodlevel");
        saturationLevel = config.getString("PlaceholderSaturationlevel");

        godmodeOn = config.getString("PlaceholderGodmodeEnabled");
        godmodeOff = config.getString("PlaceholderGodmodeDisabled");

        saturationmodeOn = config.getString("PlaceholderSaturationmodeEnabled");
        saturationmodeOff = config.getString("PlaceholderSaturationmodeDisabled");
    }
}
