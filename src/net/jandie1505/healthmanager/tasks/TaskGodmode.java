package net.jandie1505.healthmanager.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TaskGodmode {
    private static Map<Player, Boolean> godmodeEnabled = new HashMap<Player, Boolean>();

    public static void run(){
        for(Player p : Bukkit.getOnlinePlayers()){
            try {
                if(godmodeEnabled.get(p)){
                    p.setInvulnerable(true);
                } else {
                    p.setInvulnerable(false);
                }
            } catch(Exception ignore){}
        }
    }

    public static void setGodmodeEnabled(Player player){
        godmodeEnabled.put(player, true);
    }

    public static void setGodmodeDisabled(Player player){
        godmodeEnabled.put(player, false);
    }

    public static boolean checkGodmodeIsEnabled(Player player) {
        try {
            if (godmodeEnabled.get(player)) {
                return true;
            } else {
                return false;
            }
        } catch(Exception ignore){
            return false;
        }
    }

    public static void resetPlayer(Player player){
        try {
            setGodmodeDisabled(player);
            godmodeEnabled.remove(player);
            player.setInvulnerable(false);
        } catch(Exception ignore){}
    }
}
