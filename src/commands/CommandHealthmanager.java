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
        if(sender instanceof Player){
            Player p = (Player) sender;
            p.sendMessage(ChatMessages.stateMessage1);
            p.sendMessage(ChatMessages.stateMessage2);
        } else {
            ConsoleMessages.defaultMessage("HealthManager2 by jandie1505");
            ConsoleMessages.defaultMessage("Version: " + Main.version);
            ConsoleMessages.defaultMessage("Website: jandie1505.net");
            ConsoleMessages.defaultMessage("Use /healthmanager help for more info");
        }


        return false;
    }
}
