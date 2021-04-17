package net.jandie1505.healthmanager.commands;

import net.jandie1505.healthmanager.messages.Messages;
import net.jandie1505.healthmanager.main.Main;
import net.jandie1505.healthmanager.messages.SendMessage;
import net.jandie1505.healthmanager.tasks.TaskSaturationmode;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSaturationmode implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.saturationmode") || p.hasPermission("healthmanager.saturationmode.others")){
                    if(!TaskSaturationmode.checkSaturationIsEnabled(p)){
                        TaskSaturationmode.setSaturationEnabled(p);
                        SendMessage.defaultMessage(p,Messages.saturationModeEnabledMessage);
                    } else {
                        TaskSaturationmode.setSaturationDisabled(p);
                        SendMessage.defaultMessage(p,Messages.saturationModeDisabledMessage);
                    }
                } else {
                    SendMessage.defaultMessage(p,Messages.nopermission);
                }
            } else if(args.length == 1){
                if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.saturationmode.others")){
                    Player target = Bukkit.getPlayer(args[0]);
                    try {
                        if(target != null){
                            if(!TaskSaturationmode.checkSaturationIsEnabled(target)){
                                TaskSaturationmode.setSaturationEnabled(target);
                                SendMessage.defaultMessage(p,Messages.getSaturationModeEnabledOthersMessage(target.getName()));
                            } else {
                                TaskSaturationmode.setSaturationDisabled(target);
                                SendMessage.defaultMessage(p,Messages.getSaturationModeDisabledOthersMessage(target.getName()));
                            }
                        }
                    } catch(Exception e){
                        SendMessage.defaultMessage(p,Messages.wrongSyntax);
                    }
                } else {
                    SendMessage.defaultMessage(p,Messages.nopermission);
                }
            } else {
                SendMessage.defaultMessage(p,Messages.wrongSyntax);
            }
        }
        return true;
    }
}
