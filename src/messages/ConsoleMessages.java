package messages;

public class ConsoleMessages {
    public static String[] helpMessage = new String[13];
    private static int i = 0;

    public static void defaultMessage(String message){
        System.out.println("[HealthManager2] " + message);
    }

    public static void helpMessage(){
        helpMessage[0] = "HealthManager2 Help:";
        helpMessage[1] = "/healthmanager - Status command";
        helpMessage[2] = "/heal ([Player]) - Heal yourself (or a specific player)";
        helpMessage[3] = "/sethealth [Player] [Amount] - Set the health level of a specific player";
        helpMessage[4] = "/setmaxhealth [Player] [Amount] - Set the max health level of a specific player";
        helpMessage[5] = "/gethealth [Player] - See the health level of a specific player";
        helpMessage[6] = "/feed ([Player]) - Feed yourself (or a specific player)";
        helpMessage[7] = "/sethunger [Player] - Set the food level of a specific player";
        helpMessage[8] = "/gethunger [Player] - Get the food level of a specific player";
        helpMessage[9] = "/setsaturation [Player] - Set the saturation level of a specific player";
        helpMessage[10] = "/getsaturation [Player] - Get the saturation level of a specific player";
        helpMessage[11] = "/saturation ([Player]) - Turn on/off saturation mode for yourself (or a specific player)";
        helpMessage[12] = "/god ([Player]) - Turn on/off god mode for yourself (or a specific player)";

        i = 0;
        for(i=0; i<=12; i++){
            System.out.println("[HealthManager2] " + helpMessage[i]);
        }

    }
}
