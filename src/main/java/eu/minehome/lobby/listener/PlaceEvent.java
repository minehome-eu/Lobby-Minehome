package eu.minehome.lobby.listener;

import eu.minehome.lobby.Lobby;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static eu.minehome.lobby.utils.Settings.*;

public class PlaceEvent implements Listener {

    private final FileConfiguration messagescfg = Lobby.getInstance().getMessagesFile().getMessagescfg();
    private final FileConfiguration configcfg = Lobby.getInstance().getConfigFile().getConfigcfg();

    String Prefix = messagescfg.getString("Lobby.Prefix");
    String LobbyWorld = configcfg.getString("Lobby.World");
    String NoBreakMsg = messagescfg.getString("Messages.NoBarking");
    @EventHandler
    public void OnPlaceEvent (BlockPlaceEvent e) {

        Player p = e.getPlayer();

        if(p.getWorld().getName().equals(LobbyWorld)) {
            if(p.hasPermission(BuildPerms) && p.getGameMode() == (GameMode.CREATIVE)){
                e.setCancelled(false);
            } else if (!p.hasPermission(BuildPerms) || p.getGameMode() != (GameMode.CREATIVE)) {
                e.setCancelled(true);
                p.sendMessage(Prefix + NoBreakMsg);
            }
        }
    }
}