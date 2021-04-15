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

public class CommandSetsaturation implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.setsaturation")){
                if(args.length == 2){
                    Player target = Bukkit.getPlayer(args[0]);
                    try {
                        int setSaturation = Integer.parseInt(args[1]);
                        if(target != null){
                            target.setSaturation(setSaturation);
                            p.sendMessage(ChatMessages.getSetsaturationMessage(target.getName(), setSaturation));
                            if(Config.sendMessagesToTarget){
                                target.sendMessage(ChatMessages.getSetsaturationTargetMessage(setSaturation));
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
            if(args.length == 2){
                Player target = Bukkit.getPlayer(args[0]);
                try {
                    int setSaturation = Integer.parseInt(args[1]);
                    if(target != null) {
                        target.setSaturation(setSaturation);
                        ConsoleMessages.noPrefixMessage(ChatMessages.getSetsaturationMessage(target.getName(), setSaturation));
                        if(Config.sendMessagesToTarget){
                            target.sendMessage(ChatMessages.getSetsaturationTargetMessage(setSaturation));
                        }
                    } else {
                        ConsoleMessages.noPrefixMessage(ChatMessages.playernotfound);
                    }
                } catch(Exception e) {
                    ConsoleMessages.noPrefixMessage(ChatMessages.wrongSyntax);
                }
            } else {
                ConsoleMessages.noPrefixMessage(ChatMessages.wrongSyntax);
            }
        }
        return true;
    }
}
