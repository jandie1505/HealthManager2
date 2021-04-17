package net.jandie1505.healthmanager.commands;

import net.jandie1505.healthmanager.messages.Messages;
import net.jandie1505.healthmanager.main.Main;
import net.jandie1505.healthmanager.messages.ConsoleMessages;
import net.jandie1505.healthmanager.messages.SendMessage;
import net.jandie1505.healthmanager.tasks.TaskGodmode;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandGod implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.godmode") || p.hasPermission("healthmanager.godmode.others")){
                    if(!TaskGodmode.checkGodmodeIsEnabled(p)){
                        TaskGodmode.setGodmodeEnabled(p);
                        SendMessage.defaultMessage(p,Messages.godmodeEnabledMessage);
                    } else {
                        TaskGodmode.setGodmodeDisabled(p);
                        SendMessage.defaultMessage(p,Messages.godmodeDisabledMessage);
                    }
                } else {
                    SendMessage.defaultMessage(p,Messages.nopermission);
                }
            } else if(args.length == 1){
                if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.godmode.others")){
                    Player target = Bukkit.getPlayer(args[0]);
                    try {
                        if(target != null){
                            if(!TaskGodmode.checkGodmodeIsEnabled(target)){
                                TaskGodmode.setGodmodeEnabled(target);
                                SendMessage.defaultMessage(p,Messages.getGodmodeEnabledOthersMessage(target.getName()));
                            } else {
                                TaskGodmode.setGodmodeDisabled(target);
                                SendMessage.defaultMessage(p,Messages.getGodmodeDisabledOthersMessage(target.getName()));
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
        } else if(sender instanceof ConsoleCommandSender){
            if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                try {
                    if(target != null){
                        if(!TaskGodmode.checkGodmodeIsEnabled(target)){
                            TaskGodmode.setGodmodeEnabled(target);
                            ConsoleMessages.noPrefixMessage(Messages.getGodmodeEnabledOthersMessage(target.getName()));
                        } else {
                            TaskGodmode.setGodmodeDisabled(target);
                            ConsoleMessages.noPrefixMessage(Messages.getGodmodeDisabledOthersMessage(target.getName()));
                        }
                    } else {
                        ConsoleMessages.noPrefixMessage(Messages.playernotfound);
                    }
                } catch(Exception e){
                    ConsoleMessages.noPrefixMessage(Messages.wrongSyntax);
                }
            }

        }
        return true;
    }
}
