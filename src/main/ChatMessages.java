package main;

import org.bukkit.configuration.file.FileConfiguration;

public class ChatMessages {
    static FileConfiguration config = Main.getPlugin().getConfig();

    public static String prefix;
    public static String nopermission;
    public static String commandNotFound;
    public static String wrongSyntax;
    public static String playernotfound;

    public static String stateMessage1;
    public static String stateMessage2;

    public static String helpMessage[] = new String[13];


    public static String healmessage;
    public static String healmessageothers;

    public static String sethealthMessage;
    public static String sethealthTargetMessage;

    public static String sethungerMessage;
    public static String sethungerTargetMessage;

    public static void load(){
        prefix = config.getString("prefix");
        nopermission = ChatMessages.prefix + config.getString("nopermission");
        commandNotFound = ChatMessages.prefix + config.getString("commandnotfound");
        wrongSyntax = ChatMessages.prefix + config.getString("wrongsyntax");
        playernotfound = ChatMessages.prefix + config.getString("playernotfound");

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
    }
}
