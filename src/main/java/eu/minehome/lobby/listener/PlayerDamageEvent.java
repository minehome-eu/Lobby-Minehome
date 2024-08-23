package eu.minehome.lobby.listener;

import eu.minehome.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class PlayerDamageEvent implements Listener {

    private final FileConfiguration configcfg = Lobby.getInstance().getConfigFile().getConfigcfg();

    String LobbyWorld = configcfg.getString("Lobby.World");

    @EventHandler
    public void onPlayerFood (FoodLevelChangeEvent e){
        if (e.getEntity().getWorld().getName().equals(LobbyWorld)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerEntityDamage (EntityDamageEvent e){
        if (e.getEntity().getWorld().getName().equals(LobbyWorld)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDamageByBlockEvent (EntityDamageByBlockEvent e){
        if (e.getEntity().getWorld().getName().equals(LobbyWorld)){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerDamageByBlockEvent (EntityDamageByEntityEvent e){
        if (e.getEntity().getWorld().getName().equals(LobbyWorld)){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerItemDamageEvent (PlayerItemDamageEvent e){
        if (e.getPlayer().getWorld().getName().equals(LobbyWorld)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onMobDamagePlayer(EntityDamageByEntityEvent e) {
        if (e.getEntity().getWorld().getName().equals(LobbyWorld)){
            if (e.getEntity() instanceof Player) {
                if (e.getDamager() instanceof LivingEntity && !(e.getDamager() instanceof Player)) {
                    e.setCancelled(true);
                }
            }
        }
    }

}
