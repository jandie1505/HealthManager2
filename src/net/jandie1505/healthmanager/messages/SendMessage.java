package net.jandie1505.healthmanager.messages;

import org.bukkit.entity.Player;

public class SendMessage {
    public static void defaultMessage(Player player, String message){
        if(!message.equals("") && message != null){
            player.sendMessage(Messages.prefix + message);
        }
    }
    public static void MessageWithoutPrefix(Player player, String message){
        if(!message.equals("") && message != null){
            player.sendMessage(message);
        }
    }
}
