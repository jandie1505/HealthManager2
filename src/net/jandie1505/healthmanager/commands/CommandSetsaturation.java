package net.jandie1505.healthmanager.commands;

import net.jandie1505.healthmanager.messages.Messages;
import net.jandie1505.healthmanager.main.Config;
import net.jandie1505.healthmanager.messages.ConsoleMessages;
import net.jandie1505.healthmanager.main.Main;
import net.jandie1505.healthmanager.messages.SendMessage;
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
                            SendMessage.defaultMessage(p,Messages.getSetsaturationMessage(target.getName(), setSaturation));
                            if(Config.sendMessagesToTarget){
                                SendMessage.defaultMessage(target,Messages.getSetsaturationTargetMessage(setSaturation));
                            }
                        } else {
                            SendMessage.defaultMessage(p,Messages.playernotfound);
                        }
                    } catch (Exception e){
                        SendMessage.defaultMessage(p,Messages.wrongSyntax);
                    }
                } else {
                    SendMessage.defaultMessage(p,Messages.wrongSyntax);
                }
            } else {
                SendMessage.defaultMessage(p,Messages.nopermission);
            }
        } else if(sender instanceof ConsoleCommandSender){
            if(args.length == 2){
                Player target = Bukkit.getPlayer(args[0]);
                try {
                    int setSaturation = Integer.parseInt(args[1]);
                    if(target != null) {
                        target.setSaturation(setSaturation);
                        ConsoleMessages.defaultMessage(Messages.getSetsaturationMessage(target.getName(), setSaturation));
                        if(Config.sendMessagesToTarget){
                            SendMessage.defaultMessage(target,Messages.getSetsaturationTargetMessage(setSaturation));
                        }
                    } else {
                        ConsoleMessages.defaultMessage(Messages.playernotfound);
                    }
                } catch(Exception e) {
                    ConsoleMessages.defaultMessage(Messages.wrongSyntax);
                }
            } else {
                ConsoleMessages.defaultMessage(Messages.wrongSyntax);
            }
        }
        return true;
    }
}
