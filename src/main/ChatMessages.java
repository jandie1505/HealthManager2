package main;

import org.apache.commons.text.StringSubstitutor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Map;

public class ChatMessages {
    static FileConfiguration config = Main.getPlugin().getConfig();

    public static String prefix;
    public static String nopermission;
    public static String commandNotFound;
    public static String wrongSyntax;
    public static String playernotfound;

    public static String playerreset;
    public static String playerresettarget;

    public static String stateMessage1;
    public static String stateMessage2;

    public static String helpMessage[] = new String[13];


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






    public static void load(){
        prefix = config.getString("prefix");
        nopermission = ChatMessages.prefix + config.getString("nopermission");
        commandNotFound = ChatMessages.prefix + config.getString("commandnotfound");
        wrongSyntax = ChatMessages.prefix + config.getString("wrongsyntax");
        playernotfound = ChatMessages.prefix + config.getString("playernotfound");

        playerreset = ChatMessages.prefix + config.getString("playerreset");
        playerresettarget = ChatMessages.prefix + config.getString("playerresettarget");

        stateMessage1 = ChatMessages.prefix + "§6HealthManager2 (" + Main.version + ") by jandie1505";
        stateMessage2 = ChatMessages.prefix + "§eUse /healthmanager help for more information";

        helpMessage[0] = ChatMessages.prefix + "§eHealthManager2 Help:";
        helpMessage[1] = ChatMessages.prefix + "§7/healthmanager - Status command";
        helpMessage[2] = ChatMessages.prefix + "§7/heal ([Player]) - Heal yourself (or a specific player)";
        helpMessage[3] = ChatMessages.prefix + "§7/sethealth [Player] [Amount] - Set the health level of a specific player";
        helpMessage[4] = ChatMessages.prefix + "§7/setmaxhealth [Player] [Amount] - Set the max health level of a specific player";
        helpMessage[5] = ChatMessages.prefix + "§7/gethealth [Player] - See the health level of a specific player";
        helpMessage[6] = ChatMessages.prefix + "§7/feed ([Player]) - Feed yourself (or a specific player)";
        helpMessage[7] = ChatMessages.prefix + "§7/sethunger [Player] - Set the food level of a specific player";
        helpMessage[8] = ChatMessages.prefix + "§7/gethunger [Player] - Get the food level of a specific player";
        helpMessage[9] = ChatMessages.prefix + "§7/setsaturation [Player] - Set the saturation level of a specific player";
        helpMessage[10] = ChatMessages.prefix + "§7/getsaturation [Player] - Get the saturation level of a specific player";
        helpMessage[11] = ChatMessages.prefix + "§7/saturation ([Player]) - Turn on/off saturation mode for yourself (or a specific player)";
        helpMessage[12] = ChatMessages.prefix + "§7/god ([Player]) - Turn on/off god mode for yourself (or a specific player)";

        healmessage = ChatMessages.prefix + config.getString("healmessage");
        healmessageothers = ChatMessages.prefix + config.getString("healmessageothers");

        sethealthMessage = ChatMessages.prefix + config.getString("sethealthmessage");
        sethealthTargetMessage = ChatMessages.prefix + config.getString("sethealthtargetmessage");

        sethungerMessage = ChatMessages.prefix + config.getString("sethungermessage");
        sethungerTargetMessage = ChatMessages.prefix + config.getString("sethungertargetmessage");

        gethealthMessage = ChatMessages.prefix + config.getString("gethealthmessage");

        gethungerMessage = ChatMessages.prefix + config.getString("gethungermessage");

        setmaxhealthMessage = ChatMessages.prefix + config.getString("setmaxhealthmessage");
        setmaxhealthTargetMessage = ChatMessages.prefix + config.getString("setmaxhealthtargetmessage");

        getmaxhealthMessage = ChatMessages.prefix + config.getString("getmaxhealthmessage");

        setsaturationMessage = ChatMessages.prefix + config.getString("setsaturationmessage");
        setsaturationTargetMessage = ChatMessages.prefix + config.getString("setsaturationtargetmessage");

        getsaturationMessage = ChatMessages.prefix + config.getString("getsaturationmessage");

        feedMessage = ChatMessages.prefix + config.get("feedmessage");
        feedMessageOthers = ChatMessages.prefix + config.get("feedmessageothers");

        saturationModeEnabledMessage = ChatMessages.prefix + config.get("saturationmodeenabledmessage");
        saturationModeDisabledMessage = ChatMessages.prefix + config.get("saturationmodedisabledmessage");
        saturationModeEnabledOthersMessage = ChatMessages.prefix + config.get("saturationmodeenableothersmessage");
        saturationModeDisabledOthersMessage = ChatMessages.prefix + config.get("saturationmodedisableothersmessage");
    }
}
