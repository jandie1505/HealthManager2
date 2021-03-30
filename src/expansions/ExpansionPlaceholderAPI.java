package expansions;

import main.PlaceholderMessages;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class ExpansionPlaceholderAPI extends PlaceholderExpansion {

    @Override
    public String getIdentifier() {
        return "healthmanager";
    }

    @Override
    public String getAuthor() {
        return "jandie1505";
    }

    @Override
    public String getVersion() {
        return "2.1";
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player p, String params) {
        if(p != null){
            if(params.equals("health")){
                return PlaceholderMessages.getHealth(p);
            }
            if(params.equals("maxhealth")){
                return PlaceholderMessages.getMaxHealth(p);
            }
            if(params.equals("foodlevel")){
                return PlaceholderMessages.getFoodLevel(p);
            }
            if(params.equals("saturationlevel")){
                return PlaceholderMessages.getSaturationLevel(p);
            }
            if(params.equals("godmode")){
                return PlaceholderMessages.getGodmode(p);
            }
            if(params.equals("saturationmode")){
                return PlaceholderMessages.getSaturationmode(p);
            }
        } else {
            return "";
        }
        return "";
    }
}
