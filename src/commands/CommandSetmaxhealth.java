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

public class CommandSetmaxhealth implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.setmaxhealth")){
                if(args.length == 2){
                    Player target = Bukkit.getPlayer(args[0]);
                    try {
                        int newHealth = Integer.parseInt(args[1]);
                        if(target != null){
                            target.setMaxHealth(newHealth);
                            p.sendMessage(ChatMessages.getSetmaxhealthMessage(target.getName(), newHealth));
                            if(Config.sendMessagesToTarget){
                                target.sendMessage(ChatMessages.getSetmaxhealthTargetMessage(newHealth));
                            }
                        }
                    } catch(Exception e) {
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