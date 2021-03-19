package commands;

import main.ChatMessages;
import main.Config;
import main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.heal") || p.hasPermission("healthmanager.heal.others")){
                    int maxHealth = (int) p.getMaxHealth();
                    p.setHealth(maxHealth);
                    p.setFoodLevel(20);
                    p.setSaturation(20);
                    p.sendMessage(ChatMessages.healmessage);
                } else {
                    p.sendMessage(ChatMessages.nopermission);
                }
            } else if(args.length == 1){
                if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.heal.others")){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        int maxhealth = (int) target.getMaxHealth();
                        target.setHealth(maxhealth);
                        target.setFoodLevel(20);
                        target.setSaturation(20);
                        if(Config.sendMessagesToTarget){
                            target.sendMessage(ChatMessages.healmessage);
                        }
                        p.sendMessage(ChatMessages.healmessageothers);
                    } else {
                        p.sendMessage(ChatMessages.playernotfound);
                    }
                } else {
                    p.sendMessage(ChatMessages.nopermission);
                }
            }


        }
        return false;
    }
}
