package eu.minehome.lobby.listener;

import eu.minehome.lobby.Lobby;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;



public class QuitEvent implements Listener {

    private final FileConfiguration configcfg = Lobby.getInstance().getConfigFile().getConfigcfg();
    String LobbyWorld = configcfg.getString("Lobby.World");

    @EventHandler
    public void playerQuit (PlayerQuitEvent p) {
        if (p.getPlayer().getWorld().getName().equals(LobbyWorld)){
            p.setQuitMessage(null);
        }
    }
}