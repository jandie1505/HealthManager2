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

public class CommandFeed implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                if (!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.feed") || p.hasPermission("healthmanager.feed.others")) {
                    p.setFoodLevel(20);
                    p.setSaturation(20);
                    p.sendMessage(ChatMessages.feedMessage);
                } else {
                    p.sendMessage(ChatMessages.nopermission);
                }
            } else if (args.length == 1) {
                if (!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.feed.others")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.setFoodLevel(20);
                        target.setSaturation(20);
                        if (Config.sendMessagesToTarget) {
                            target.sendMessage(ChatMessages.feedMessage);
                        }
                        p.sendMessage(ChatMessages.getFeedMessageOthers(p.getName()));
                    } else {
                        p.sendMessage(ChatMessages.playernotfound);
                    }
                } else {
                    p.sendMessage(ChatMessages.nopermission);
                }
            }


        } else if (sender instanceof ConsoleCommandSender) {
            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    target.setFoodLevel(20);
                    target.setSaturation(20);
                    if (Config.sendMessagesToTarget) {
                        target.sendMessage(ChatMessages.feedMessage);
                    }
                    ConsoleMessages.noPrefixMessage(ChatMessages.getFeedMessageOthers(target.getName()));
                } else {
                    ConsoleMessages.noPrefixMessage(ChatMessages.playernotfound);
                }
            } else {
                ConsoleMessages.noPrefixMessage(ChatMessages.wrongSyntax);
            }
        }
        return true;
    }
}
