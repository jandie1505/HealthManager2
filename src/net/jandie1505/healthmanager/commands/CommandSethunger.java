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
                            SendMessage.defaultMessage(p,Messages.getSethungerMessage(target.getName(), setHunger));
                            if(Config.sendMessagesToTarget){
                                SendMessage.defaultMessage(target,Messages.getSethungerTargetMessage(setHunger));
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
                    int setHunger = Integer.parseInt(args[1]);
                    if(target != null){
                        target.setFoodLevel(setHunger);
                        ConsoleMessages.noPrefixMessage(Messages.getSethungerMessage(target.getName(), setHunger));
                        if(Config.sendMessagesToTarget){
                            SendMessage.defaultMessage(target,Messages.getSethungerTargetMessage(setHunger));
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
