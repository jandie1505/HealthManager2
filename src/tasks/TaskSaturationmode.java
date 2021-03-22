package tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TaskSaturationmode {
    private static Map<Player, Boolean> saturationEnabled = new HashMap<Player, Boolean>();

    public static void run(){
        for(Player p : Bukkit.getOnlinePlayers()){
            try {
                if(saturationEnabled.get(p)){
                    setSaturationState(p);
                }
            } catch(Exception ignored){}
        }
    }

    private static void setSaturationState(Player player){
        player.setFoodLevel(20);
        player.setSaturation(20);
    }

    public static void setSaturationEnabled(Player player){
        saturationEnabled.put(player, true);
    }

    public static void setSaturationDisabled(Player player){
        saturationEnabled.put(player, false);
    }

    public static boolean checkSaturationIsEnabled(Player player) {
        try {
            if (saturationEnabled.get(player)) {
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
            saturationEnabled.remove(player);
        } catch(Exception ignore){}
    }
}
