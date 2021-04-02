package net.jandie1505.healthmanager.commands;

import net.jandie1505.healthmanager.messages.ChatMessages;
import net.jandie1505.healthmanager.main.Config;
import net.jandie1505.healthmanager.messages.ConsoleMessages;
import net.jandie1505.healthmanager.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandSethunger implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.sethunger")){
                if(args.length == 2){
                    Player target = Bukkit.getPlayer(args[0]);
                    try {
                        int setHunger = Integer.parseInt(args[1]);
                        if(target != null){
                            target.setFoodLevel(setHunger);
                            p.sendMessage(ChatMessages.getSethungerMessage(target.getName(), setHunger));
                            if(Config.sendMessagesToTarget){
                                target.sendMessage(ChatMessages.getSethungerTargetMessage(setHunger));
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