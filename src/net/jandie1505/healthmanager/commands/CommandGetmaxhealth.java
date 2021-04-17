package net.jandie1505.healthmanager.commands;

import net.jandie1505.healthmanager.messages.Messages;
import net.jandie1505.healthmanager.messages.ConsoleMessages;
import net.jandie1505.healthmanager.main.Main;
import net.jandie1505.healthmanager.messages.SendMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandGetmaxhealth implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.setmaxhealth")){
                if(args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    try {
                        if(target != null){
                            SendMessage.defaultMessage(p,Messages.getGetmaxhealthMessage(target.getName(), (int) target.getMaxHealth()));
                        }
                    } catch(Exception e) {
                        SendMessage.defaultMessage(p,Messages.wrongSyntax);
                    }
                } else {
                    SendMessage.defaultMessage(p,Messages.wrongSyntax);
                }
            } else {
                SendMessage.defaultMessage(p,Messages.nopermission);
            }
        } else if(sender instanceof ConsoleCommandSender){
            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                try {
                    if(target != null){
                        ConsoleMessages.noPrefixMessage(Messages.getGetmaxhealthMessage(target.getName(), (int) target.getMaxHealth()));
                    }
                } catch(Exception e) {
                    ConsoleMessages.noPrefixMessage(Messages.wrongSyntax);
                }
            } else {
                ConsoleMessages.noPrefixMessage(Messages.wrongSyntax);
            }
        }
        return true;
    }
}
