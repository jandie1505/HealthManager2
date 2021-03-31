package commands;

import messages.ChatMessages;
import main.Main;
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
                    if(!tasks.TaskGodmode.checkGodmodeIsEnabled(p)){
                        tasks.TaskGodmode.setGodmodeEnabled(p);
                        p.sendMessage(ChatMessages.godmodeEnabledMessage);
                    } else {
                        tasks.TaskGodmode.setGodmodeDisabled(p);
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
                            if(!tasks.TaskGodmode.checkGodmodeIsEnabled(target)){
                                tasks.TaskGodmode.setGodmodeEnabled(target);
                                p.sendMessage(ChatMessages.getGodmodeEnabledOthersMessage(target.getName()));
                            } else {
                                tasks.TaskGodmode.setGodmodeDisabled(target);
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
