package net.jandie1505.healthmanager.messages;

import net.jandie1505.healthmanager.main.Main;
import org.apache.commons.text.StringSubstitutor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Map;

public class Messages {
    static FileConfiguration config = Main.getPlugin().getCustomConfig();

    public static String prefix;
    public static String nopermission;
    public static String commandNotFound;
    public static String wrongSyntax;
    public static String playernotfound;

    public static String playerreset;
    public static String playerresettarget;

    public static String stateMessage1;
    public static String stateMessage2;

    public static String[] helpMessage = new String[16];


    public static String healmessage;
    public static String healmessageothers;

    public static String sethealthMessage;
    public static String sethealthTargetMessage;

    public static String sethungerMessage;
    public static String sethungerTargetMessage;

    public static String gethealthMessage;

    public static String gethungerMessage;

    public static String setmaxhealthMessage;
    public static String setmaxhealthTargetMessage;

    public static String getmaxhealthMessage;

    public static String setsaturationMessage;
    public static String setsaturationTargetMessage;

    public static String getsaturationMessage;

    public static String feedMessage;
    public static String feedMessageOthers;

    public static String saturationModeEnabledMessage;
    public static String saturationModeDisabledMessage;
    public static String saturationModeEnabledOthersMessage;
    public static String saturationModeDisabledOthersMessage;

    public static String godmodeEnabledMessage;
    public static String godmodeDisabledMessage;
    public static String godmodeEnabledOthersMessage;
    public static String godmodeDisabledOthersMessage;



    public static String getPlayerreset(String playerName){
        String message;
        String result;
        message = playerreset;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getHealMessageOthers(String playerName){
        String message;
        String result;
        message = healmessageothers;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getSethealthMessage(String playerName, int lives){
        String message;
        String result;
        message = sethealthMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "LIVES", String.valueOf(lives)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }
    public static String getSethealthTargetMessage(int lives){
        String message;
        String result;
        message = sethealthTargetMessage;
        Map<String, String> replacementStrings = Map.of(
                "LIVES", String.valueOf(lives)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getSethungerMessage(String playerName, int foodLevel){
        String message;
        String result;
        message = sethungerMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "FOODLEVEL", String.valueOf(foodLevel)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }
    public static String getSethungerTargetMessage(int foodLevel){
        String message;
        String result;
        message = sethungerTargetMessage;
        Map<String, String> replacementStrings = Map.of(
                "FOODLEVEL", String.valueOf(foodLevel)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getGethealthMessage(String playerName, int lives){
        String message;
        String result;
        message = gethealthMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "LIVES", String.valueOf(lives)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getGethungerMessage(String playerName, int foodLevel){
        String message;
        String result;
        message = gethungerMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "FOODLEVEL", String.valueOf(foodLevel)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getSetmaxhealthMessage(String playerName, int maxHealth){
        String message;
        String result;
        message = setmaxhealthMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "MAXHEALTH", String.valueOf(maxHealth)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }
    public static String getSetmaxhealthTargetMessage(int maxHealth){
        String message;
        String result;
        message = setmaxhealthTargetMessage;
        Map<String, String> replacementStrings = Map.of(
                "MAXHEALTH", String.valueOf(maxHealth)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getGetmaxhealthMessage(String playerName, int maxHealth){
        String message;
        String result;
        message = getmaxhealthMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "MAXHEALTH", String.valueOf(maxHealth)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getSetsaturationMessage(String playerName, int saturationLevel){
        String message;
        String result;
        message = setsaturationMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "SATURATIONLEVEL", String.valueOf(saturationLevel)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }
    public static String getSetsaturationTargetMessage(int saturationLevel){
        String message;
        String result;
        message = setsaturationTargetMessage;
        Map<String, String> replacementStrings = Map.of(
                "SATURATIONLEVEL", String.valueOf(saturationLevel)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getGetsaturationMessage(String playerName, int saturationLevel){
        String message;
        String result;
        message = getsaturationMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName,
                "SATURATIONLEVEL", String.valueOf(saturationLevel)
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getFeedMessageOthers(String playerName){
        String message;
        String result;
        message = feedMessageOthers;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getSaturationModeEnabledOthersMessage(String playerName){
        String message;
        String result;
        message = saturationModeEnabledOthersMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }
    public static String getSaturationModeDisabledOthersMessage(String playerName){
        String message;
        String result;
        message = saturationModeDisabledOthersMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }

    public static String getGodmodeEnabledOthersMessage(String playerName){
        String message;
        String result;
        message = godmodeEnabledOthersMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }
    public static String getGodmodeDisabledOthersMessage(String playerName){
        String message;
        String result;
        message = godmodeDisabledOthersMessage;
        Map<String, String> replacementStrings = Map.of(
                "PLAYER", playerName
        );
        StringSubstitutor sub = new StringSubstitutor(replacementStrings, "{", "}");
        result = sub.replace(message);
        return result;
    }



    public static void load(){
        prefix = config.getString("prefix");
        nopermission = config.getString("nopermission");
        commandNotFound = config.getString("commandnotfound");
        wrongSyntax = config.getString("wrongsyntax");
        playernotfound = config.getString("playernotfound");

        playerreset = config.getString("playerreset");
        playerresettarget = config.getString("playerresettarget");

        stateMessage1 = "§6HealthManager2 (" + Main.version + ") by jandie1505";
        stateMessage2 = "§eUse /healthmanager help for more information";

        helpMessage[0] = Messages.prefix + "§eHealthManager2 Help:";
        helpMessage[1] = Messages.prefix + "§7/healthmanager - Status command";
        helpMessage[2] = Messages.prefix + "§7/healthmanager help - Help command";
        helpMessage[3] = Messages.prefix + "§7/healthmanager reload - Reload config";
        helpMessage[4] = Messages.prefix + "§7/healthmanager reset <Player> - Reset all modifiers of healthmanager for a specific player";
        helpMessage[5] = Messages.prefix + "§7/heal ([Player]) - Heal yourself (or a specific player)";
        helpMessage[6] = Messages.prefix + "§7/sethealth [Player] [Amount] - Set the health level of a specific player";
        helpMessage[7] = Messages.prefix + "§7/setmaxhealth [Player] [Amount] - Set the max health level of a specific player";
        helpMessage[8] = Messages.prefix + "§7/gethealth [Player] - See the health level of a specific player";
        helpMessage[9] = Messages.prefix + "§7/feed ([Player]) - Feed yourself (or a specific player)";
        helpMessage[10] = Messages.prefix + "§7/sethunger [Player] - Set the food level of a specific player";
        helpMessage[11] = Messages.prefix + "§7/gethunger [Player] - Get the food level of a specific player";
        helpMessage[12] = Messages.prefix + "§7/setsaturation [Player] - Set the saturation level of a specific player";
        helpMessage[13] = Messages.prefix + "§7/getsaturation [Player] - Get the saturation level of a specific player";
        helpMessage[14] = Messages.prefix + "§7/saturation ([Player]) - Turn on/off saturation mode for yourself (or a specific player)";
        helpMessage[15] = Messages.prefix + "§7/god ([Player]) - Turn on/off god mode for yourself (or a specific player)";

        healmessage = config.getString("healmessage");
        healmessageothers = config.getString("healmessageothers");

        sethealthMessage = config.getString("sethealthmessage");
        sethealthTargetMessage = config.getString("sethealthtargetmessage");

        sethungerMessage = config.getString("sethungermessage");
        sethungerTargetMessage = config.getString("sethungertargetmessage");

        gethealthMessage = config.getString("gethealthmessage");

        gethungerMessage = config.getString("gethungermessage");

        setmaxhealthMessage = config.getString("setmaxhealthmessage");
        setmaxhealthTargetMessage = config.getString("setmaxhealthtargetmessage");

        getmaxhealthMessage = config.getString("getmaxhealthmessage");

        setsaturationMessage = config.getString("setsaturationmessage");
        setsaturationTargetMessage = config.getString("setsaturationtargetmessage");

        getsaturationMessage = config.getString("getsaturationmessage");

        feedMessage = config.getString("feedmessage");
        feedMessageOthers = config.getString("feedmessageothers");

        saturationModeEnabledMessage = config.getString("saturationmodeenabledmessage");
        saturationModeDisabledMessage = config.getString("saturationmodedisabledmessage");
        saturationModeEnabledOthersMessage = config.getString("saturationmodeenableothersmessage");
        saturationModeDisabledOthersMessage = config.getString("saturationmodedisableothersmessage");

        godmodeEnabledMessage = config.getString("godmodeenabledmessage");
        godmodeDisabledMessage = config.getString("godmodedisabledmessage");
        godmodeEnabledOthersMessage = config.getString("godmodeenabledothersmessage");
        godmodeDisabledOthersMessage = config.getString("godmodedisabledothersmessage");
    }
}
