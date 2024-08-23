package eu.minehome.lobby.listener;

import eu.minehome.lobby.Lobby;
import eu.minehome.lobby.utils.LobbyInventory;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static eu.minehome.lobby.utils.Settings.LobbySetSpawn;


public class JoinEvent implements Listener {

    private final FileConfiguration configcfg = Lobby.getInstance().getConfigFile().getConfigcfg();
    private final FileConfiguration messagescfg = Lobby.getInstance().getMessagesFile().getMessagescfg();
    private final FileConfiguration locationcfg = Lobby.getInstance().getLocationFile().getLocationcfg();

    String ActionBarVer = messagescfg.getString("Version");
    String Prefix = messagescfg.getString("Lobby.Prefix");
    String NoSpawn = messagescfg.getString("Messages.NoSpawm");
    String LobbyWorld = configcfg.getString("Lobby.World");


    String SpawnWorld  = locationcfg.getString("Spawn.World");
    double SpawnX = locationcfg.getDouble("Spawn.X");
    double SpawnY = locationcfg.getDouble("Spawn.Y");
    double SpawnZ = locationcfg.getDouble("Spawn.Z");
    float SpawnYaw = (float) locationcfg.getDouble("Spawn.Yaw");
    float SpawnPitch = (float) locationcfg.getDouble("Spawn.Pitch");



    @EventHandler
    public void playerJoin (PlayerJoinEvent e) {

        Player p = e.getPlayer();

        if (p.getWorld().getName().equals(LobbyWorld)){

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (!p.isOnline()) {
                        cancel(); // this cancels it when they leave
                    }
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ActionBarVer));
                }
            }.runTaskTimer(Lobby.getInstance() /*<-- your plugin instance*/, 5L, 5L); // again, may be running faster than needed

            e.getPlayer().setGameMode(GameMode.ADVENTURE);
            e.getPlayer().setHealth(20);
            e.getPlayer().setFoodLevel(20);
            LobbyInventory.SetLobbyInventory(p);
            e.setJoinMessage(null);

            World spawnWorld = Bukkit.getWorld(SpawnWorld);
            if (spawnWorld != null){
                Location SpawnLocation = new Location( spawnWorld, SpawnX, SpawnY, SpawnZ, SpawnYaw, SpawnPitch);
                p.teleport(SpawnLocation);
            } else{
                p.sendMessage("test");
            }

            if (configcfg.getBoolean("Sound.JoinSound")){
                e.getPlayer().playSound(e.getPlayer().getLocation(), (Sound.ENTITY_PLAYER_LEVELUP), 3, 3);
            }

        }

    }

}