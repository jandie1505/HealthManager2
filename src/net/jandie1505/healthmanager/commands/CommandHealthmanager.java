package net.jandie1505.healthmanager.commands;

import net.jandie1505.healthmanager.messages.Messages;
import net.jandie1505.healthmanager.messages.ConsoleMessages;
import net.jandie1505.healthmanager.messages.PlaceholderMessages;
import net.jandie1505.healthmanager.main.Config;
import net.jandie1505.healthmanager.main.Main;
import net.jandie1505.healthmanager.messages.SendMessage;
import net.jandie1505.healthmanager.tasks.TaskGodmode;
import net.jandie1505.healthmanager.tasks.TaskSaturationmode;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandHealthmanager implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(args.length == 0){
            if(sender instanceof Player){
                Player p = (Player) sender;
                SendMessage.defaultMessage(p,Messages.stateMessage1);
                SendMessage.defaultMessage(p,Messages.stateMessage2);
            } else if(sender instanceof ConsoleCommandSender) {
                ConsoleMessages.defaultMessage("HealthManager2 by jandie1505");
                ConsoleMessages.defaultMessage("Version: " + Main.version);
                ConsoleMessages.defaultMessage("Website: jandie1505.net");
                ConsoleMessages.defaultMessage("Use /healthmanager help for more info");
            }
        } else if(args.length == 1){
            switch (args[0]){
                case "help":
                    if(sender instanceof Player){
                        Player p = (Player) sender;
                        if(p.hasPermission("healthmanager.help")){
                            for(int i = 0; i< Messages.helpMessage.length; i++){
                                SendMessage.defaultMessage(p,Messages.helpMessage[i]);
                            }
                        }
                    } else if(sender instanceof ConsoleCommandSender) {
                        ConsoleMessages.helpMessage();
                    }
                    break;
                case "reload":
                    if(sender instanceof Player){
                        Player p = (Player) sender;
                        if(p.hasPermission("healthmanager.reload")){
                            Config.load();
                            Messages.load();
                            PlaceholderMessages.load();
                            SendMessage.defaultMessage(p,Messages.prefix + "Reload complete");
                        }

                    } else if(sender instanceof ConsoleCommandSender) {
                        Config.load();
                        Messages.load();
                        ConsoleMessages.defaultMessage("Reload complete");
                    }
                    break;
                case "reset":
                    if(sender instanceof Player){
                        Player p = (Player) sender;
                        if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.reset")){
                            SendMessage.defaultMessage(p,Messages.wrongSyntax);
                        } else {
                            SendMessage.defaultMessage(p,Messages.nopermission);
                        }
                    }
                default:

                    if(sender instanceof Player){
                        Player p = (Player) sender;
                        SendMessage.defaultMessage(p,Messages.commandNotFound);
                    } else if(sender instanceof ConsoleCommandSender) {
                        ConsoleMessages.defaultMessage("Command not found");
                    }
                    break;
            }
        } else if(args.length == 2){
            switch (args[0]){
                case "reset":
                    if(sender instanceof Player){
                        Player p = (Player) sender;
                        if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.reset")){
                            Player target = Bukkit.getPlayer(args[1]);
                            try {
                                if(target != null){
                                    target.resetMaxHealth();
                                    TaskSaturationmode.resetPlayer(target);
                                    TaskGodmode.resetPlayer(target);
                                    SendMessage.defaultMessage(p,Messages.getPlayerreset(target.getName()));
                                    if(Config.sendMessagesToTarget){
                                        SendMessage.defaultMessage(target,Messages.playerresettarget);
                                    }
                                } else {
                                    SendMessage.defaultMessage(p,Messages.playernotfound);
                                }
                            } catch(Exception e){
                                SendMessage.defaultMessage(p,Messages.wrongSyntax);
                            }
                        }
                    }
                    break;
                default:
                    if(sender instanceof Player){
                        Player p = (Player) sender;
                        SendMessage.defaultMessage(p,Messages.commandNotFound);
                    } else if(sender instanceof ConsoleCommandSender) {
                        ConsoleMessages.defaultMessage("Command not found");
                    }
                    break;
            }
        }




        return true;
    }
}
