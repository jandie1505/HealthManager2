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
                            SendMessage.defaultMessage(p,Messages.getSethealthMessage(target.getName(), setHealth));
                            if(Config.sendMessagesToTarget){
                                SendMessage.defaultMessage(target,Messages.getSethealthTargetMessage(setHealth));
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
                    int setHealth = Integer.parseInt(args[1]);
                    if(target != null){
                        target.setHealth(setHealth);
                        ConsoleMessages.defaultMessage(Messages.getSethealthMessage(target.getName(), setHealth));
                        if(Config.sendMessagesToTarget){
                            SendMessage.defaultMessage(target,Messages.getSethealthTargetMessage(setHealth));
                        }
                    } else {
                        ConsoleMessages.defaultMessage(Messages.playernotfound);
                    }
                } catch(Exception e){
                    ConsoleMessages.defaultMessage(Messages.wrongSyntax);
                }
            } else {
                ConsoleMessages.defaultMessage(Messages.wrongSyntax);
            }
        }
        return true;
    }
}
