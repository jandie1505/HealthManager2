# HealthManager 2
Health Manager 2 is a Minecraft plugin that lets you view and edit health, hunger, saturation, and maximum lives.
You can also enable a god and saturation mode.
## Commands and Permissions
 
| Commands | Permissions | Description |
|--|--|--|
| /healthmanager | No Permission | Status Command |
| /healthmanager help | healthmanager.help | List Commands |
| /healthmanager reload | healthmanager.reload | Reload Config |
| /healthmanager reset [Player] | healthmanager.reset | Reset modifiers of a specific player |
| /heal | healthmanager.heal | Heal (and feed) yourself |
| /heal [Player] | healthmanager.heal.others | Heal (and feed) a specific player |
| /sethealth [Player] [Amount] | healthmanager.sethealth | Set the health of a specific player |
| /setmaxhealth [Player] [Amount] | healthmanager.setmaxhealth | Set the max health of a specific player 
| /gethealth [Player] | healthmanager.gethealth | See the health of a specific player |
| /getmaxhealth [Player] | healthmanager.getmaxhealth | See the max health of a specific player |
| /feed | healthmanager.feed | Feed yourself |
| /feed [Player] | healthmanager.feed.others | Feed a specific player |
| /sethunger [Player] [Amount] | healthmanager.sethunger | Set the food level of a specific player |
| /gethunger [Player] | healthmanager.gethunger | See the food level of a specific player |
| /setsaturation [Player] | healthmanager.setsaturation | Set the saturation of a specific player |
| /getsaturation [Player] | healthmanager.getsaturation | Get the saturation level of a specific player |
| /saturation | healthmanager.saturation | Turn on/off the saturation mode for yourself |
| /saturation [Player] | healthmanager.saturation.others | Turn on/off the saturation mode for a specific player |
| /god | healthmanager.god | Turn on/off the god mode for yourself |
| /god [Player] |healthmanager.god.others  | Turn on/off the god mode for a specific player |
## God mode and saturation mode
The Godmode makes you invulnerable.
Saturation mode makes sure you don't lose hunger.
## PlaceholderAPI-Support
You can use the following placeholders:
| Placeholder  | Value  |
|--|--|
| %healthmanager_health% | Player Health  |
| %healthmanager_maxhealth% | Max Player Health  |
| %healthmanager_foodlevel% | Player Food Level  |
| %healthmanager_saturationlevel% | Player Saturation Level  |
| %healthmanager_godmode% | Player Godmode State (On/Off)  |
| %healthmanager_saturationmode% | Player Saturationmode State (On/Off)  |

The content of the placeholder can be changed in the config.
## Config
The config.yml is located in the Folder <Plugins Folder>/HealthManager2/config.yml.
The config is explained in the config.yml file.
## Download
The Download will be available at the releases page and on spigotmc.org when the plugin is finished.
