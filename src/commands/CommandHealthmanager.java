package commands;

import main.ChatMessages;
import main.ConsoleMessages;
import main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHealthmanager implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player p = (Player) sender;
        if(args.length == 0){
            if(sender instanceof Player){
                p.sendMessage(ChatMessages.stateMessage1);
                p.sendMessage(ChatMessages.stateMessage2);
            } else {
                ConsoleMessages.defaultMessage("HealthManager2 by jandie1505");
                ConsoleMessages.defaultMessage("Version: " + Main.version);
                ConsoleMessages.defaultMessage("Website: jandie1505.net");
                ConsoleMessages.defaultMessage("Use /healthmanager help for more info");
            }
        } else if(args.length == 1){
            switch (args[0]){
                case "help":
                    if(sender instanceof Player){
                        for(int i = 0;i<=12;i++){
                            p.sendMessage(ChatMessages.helpMessage[i]);
                        }
                    } else {
                        ConsoleMessages.helpMessage();
                    }
                    break;
                default:

                    if(sender instanceof Player){
                        p.sendMessage(ChatMessages.commandNotFound);
                    } else {
                        ConsoleMessages.defaultMessage("Command not found");
                    }
            }
        }




        return true;
    }
}
