package commands;

import main.ChatMessages;
import main.Config;
import main.ConsoleMessages;
import main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.ExecutionException;

public class CommandSethealth implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.sethealth")){
                if(args.length == 2){
                    Player target = Bukkit.getPlayer(args[0]);
                    try {
                        int setHealth = Integer.parseInt(args[1]);
                        if(target != null){
                            target.setHealth(setHealth);
                            p.sendMessage(ChatMessages.sethealthMessage);
                            if(Config.sendMessagesToTarget){
                                target.sendMessage(ChatMessages.sethealthTargetMessage);
                            }
                        } else {
                            p.sendMessage(ChatMessages.playernotfound);
                        }
                    } catch (Exception e){
                        p.sendMessage(ChatMessages.wrongSyntax);
                    }
                } else {
                    p.sendMessage(ChatMessages.wrongSyntax);
                }
            } else {
                p.sendMessage(ChatMessages.nopermission);
            }
        } else if(sender instanceof ConsoleCommandSender){
            ConsoleMessages.defaultMessage("This command must be executed by a player");
        }
        return true;
    }
}
