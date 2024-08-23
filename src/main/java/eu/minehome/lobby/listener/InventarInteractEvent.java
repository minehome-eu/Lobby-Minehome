package eu.minehome.lobby.listener;

import eu.minehome.lobby.Lobby;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class InventarInteractEvent implements Listener {

    private final FileConfiguration configcfg = Lobby.getInstance().getConfigFile().getConfigcfg();

    String LobbyWorld = configcfg.getString("Lobby.World");

    @EventHandler
    public void SwitchItem (PlayerItemHeldEvent e) {
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals(LobbyWorld)) {
            if (configcfg.getBoolean("Sounds.ItemSwitchSound")){
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 5, 5);
            }

        }

    }

    @EventHandler
    public void PlayerDropItem(PlayerDropItemEvent e){
        if (e.getPlayer().getWorld().getName().equals(LobbyWorld)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void PlayerPickupItem(PlayerPickupItemEvent e){
        if (e.getPlayer().getWorld().getName().equals(LobbyWorld)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void EntityPickupItem(EntityPickupItemEvent e){
        if (e.getEntity().getWorld().getName().equals(LobbyWorld)){
            e.setCancelled(true);
        }
    }

}
