package net.jandie1505.healthmanager.commands;

import net.jandie1505.healthmanager.messages.ChatMessages;
import net.jandie1505.healthmanager.main.Main;
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
                        p.sendMessage(ChatMessages.saturationModeEnabledMessage);
                    } else {
                        TaskSaturationmode.setSaturationDisabled(p);
                        p.sendMessage(ChatMessages.saturationModeDisabledMessage);
                    }
                } else {
                    p.sendMessage(ChatMessages.nopermission);
                }
            } else if(args.length == 1){
                if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.saturationmode.others")){
                    Player target = Bukkit.getPlayer(args[0]);
                    try {
                        if(target != null){
                            if(!TaskSaturationmode.checkSaturationIsEnabled(target)){
                                TaskSaturationmode.setSaturationEnabled(target);
                                p.sendMessage(ChatMessages.getSaturationModeEnabledOthersMessage(target.getName()));
                            } else {
                                TaskSaturationmode.setSaturationDisabled(target);
                                p.sendMessage(ChatMessages.getSaturationModeDisabledOthersMessage(target.getName()));
                            }
                        }
                    } catch(Exception e){
                        p.sendMessage(ChatMessages.wrongSyntax);
                    }
                } else {
                    p.sendMessage(ChatMessages.nopermission);
                }
            } else {
                p.sendMessage(ChatMessages.wrongSyntax);
            }
        }
        return true;
    }
}
