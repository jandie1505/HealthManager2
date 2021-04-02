package net.jandie1505.healthmanager.commands;

import net.jandie1505.healthmanager.messages.ChatMessages;
import net.jandie1505.healthmanager.main.Main;
import net.jandie1505.healthmanager.tasks.TaskGodmode;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGod implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.godmode") || p.hasPermission("healthmanager.godmode.others")){
                    if(!TaskGodmode.checkGodmodeIsEnabled(p)){
                        TaskGodmode.setGodmodeEnabled(p);
                        p.sendMessage(ChatMessages.godmodeEnabledMessage);
                    } else {
                        TaskGodmode.setGodmodeDisabled(p);
                        p.sendMessage(ChatMessages.godmodeDisabledMessage);
                    }
                } else {
                    p.sendMessage(ChatMessages.nopermission);
                }
            } else if(args.length == 1){
                if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.godmode.others")){
                    Player target = Bukkit.getPlayer(args[0]);
                    try {
                        if(target != null){
                            if(!TaskGodmode.checkGodmodeIsEnabled(target)){
                                TaskGodmode.setGodmodeEnabled(target);
                                p.sendMessage(ChatMessages.getGodmodeEnabledOthersMessage(target.getName()));
                            } else {
                                TaskGodmode.setGodmodeDisabled(target);
                                p.sendMessage(ChatMessages.getGodmodeDisabledOthersMessage(target.getName()));
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
