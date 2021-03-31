package commands;

import main.*;
import messages.ChatMessages;
import messages.ConsoleMessages;
import messages.PlaceholderMessages;
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
                p.sendMessage(ChatMessages.stateMessage1);
                p.sendMessage(ChatMessages.stateMessage2);
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
                            for(int i = 0;i<=12;i++){
                                p.sendMessage(ChatMessages.helpMessage[i]);
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
                            ChatMessages.load();
                            PlaceholderMessages.load();
                            p.sendMessage(ChatMessages.prefix + "Reload complete");
                        }

                    } else if(sender instanceof ConsoleCommandSender) {
                        Config.load();
                        ChatMessages.load();
                        ConsoleMessages.defaultMessage("Reload complete");
                    }
                    break;
                case "reset":
                    if(sender instanceof Player){
                        Player p = (Player) sender;
                        if(!Main.ignoreop && p.isOp() || p.hasPermission("healthmanager.reset")){
                            p.sendMessage(ChatMessages.wrongSyntax);
                        } else {
                            p.sendMessage(ChatMessages.nopermission);
                        }
                    }
                default:

                    if(sender instanceof Player){
                        Player p = (Player) sender;
                        p.sendMessage(ChatMessages.commandNotFound);
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
                                    tasks.TaskSaturationmode.resetPlayer(target);
                                    tasks.TaskGodmode.resetPlayer(target);
                                    p.sendMessage(ChatMessages.getPlayerreset(target.getName()));
                                    if(Config.sendMessagesToTarget){
                                        target.sendMessage(ChatMessages.playerresettarget);
                                    }
                                } else {
                                    p.sendMessage(ChatMessages.playernotfound);
                                }
                            } catch(Exception e){
                                p.sendMessage(ChatMessages.wrongSyntax);
                            }
                        }
                    }
                    break;
                default:
                    if(sender instanceof Player){
                        Player p = (Player) sender;
                        p.sendMessage(ChatMessages.commandNotFound);
                    } else if(sender instanceof ConsoleCommandSender) {
                        ConsoleMessages.defaultMessage("Command not found");
                    }
                    break;
            }
        }




        return true;
    }
}
