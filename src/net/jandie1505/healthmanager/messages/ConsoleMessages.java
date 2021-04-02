package net.jandie1505.healthmanager.messages;

public class ConsoleMessages {
    public static String[] helpMessage = new String[16];
    private static int i = 0;

    public static void defaultMessage(String message){
        System.out.println("[HealthManager2] " + message);
    }

    public static void helpMessage(){
        helpMessage[0] = "HealthManager2 Help:";
        helpMessage[1] = "/healthmanager - Status command";
        helpMessage[2] = "/healthmanager help - Help command";
        helpMessage[3] = "/healthmanager reload - Reload config (Won't reload PlaceholderAPI support option in config)";
        helpMessage[4] = "/healthmanager reset <Player> - Reset all modifiers of healthmanager for a specific player";
        helpMessage[5] = "/heal ([Player]) - Heal yourself (or a specific player)";
        helpMessage[6] = "/sethealth [Player] [Amount] - Set the health level of a specific player";
        helpMessage[7] = "/setmaxhealth [Player] [Amount] - Set the max health level of a specific player";
        helpMessage[8] = "/gethealth [Player] - See the health level of a specific player";
        helpMessage[9] = "/feed ([Player]) - Feed yourself (or a specific player)";
        helpMessage[10] = "/sethunger [Player] - Set the food level of a specific player";
        helpMessage[11] = "/gethunger [Player] - Get the food level of a specific player";
        helpMessage[12] = "/setsaturation [Player] - Set the saturation level of a specific player";
        helpMessage[13] = "/getsaturation [Player] - Get the saturation level of a specific player";
        helpMessage[14] = "/saturation ([Player]) - Turn on/off saturation mode for yourself (or a specific player)";
        helpMessage[15] = "/god ([Player]) - Turn on/off god mode for yourself (or a specific player)";

        i = 0;
        for(i=0; i<helpMessage.length; i++){
            System.out.println("[HealthManager2] " + helpMessage[i]);
        }

    }
}
