package eu.minehome.lobby.listener;

import eu.minehome.lobby.Lobby;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import static eu.minehome.lobby.utils.Settings.BuildPerms;

public class ProtectEvent implements Listener {

    private final FileConfiguration messagescfg = Lobby.getInstance().getMessagesFile().getMessagescfg();
    private final FileConfiguration configcfg = Lobby.getInstance().getConfigFile().getConfigcfg();

    String Prefix = messagescfg.getString("Lobby.Prefix");
    String LobbyWorld = configcfg.getString("Lobby.World");
    String NoBreakMsg = messagescfg.getString("Messages.NoBarking");

    @EventHandler
    public void OnBreakEvent (BlockBreakEvent e) {
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

    @EventHandler
    public void BucketEmptyEvent(PlayerBucketEmptyEvent e){
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

    @EventHandler
    public void BucketEmptyEvent(PlayerBucketFillEvent e){
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

    @EventHandler
    public void ItemMoveEvent(InventoryClickEvent e){
        if (e.getWhoClicked().getWorld().getName().equals(LobbyWorld)){
            if (e.getWhoClicked() instanceof Player){
                Player p = (Player) e.getWhoClicked();
                if (p.hasPermission(BuildPerms) && p.getGameMode() == (GameMode.CREATIVE)){
                    e.setCancelled(false);
                } else if (!p.hasPermission(BuildPerms) || p.getGameMode() != (GameMode.CREATIVE)) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void ItemSwapHandEvent(PlayerSwapHandItemsEvent e){
        if (e.getPlayer().getWorld().getName().equals(LobbyWorld)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        Player p = (Player) e.getPlayer();
        
        if (e.getPlayer().getWorld().getName().equals(LobbyWorld)){
            if (p.hasPermission(BuildPerms) && p.getGameMode().equals(GameMode.CREATIVE)){
                e.setCancelled(false);
            } else if (!p.hasPermission(BuildPerms) || p.getGameMode() != (GameMode.CREATIVE)) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    Block clickedBlock = e.getClickedBlock();
                    if (clickedBlock != null &&
                            (clickedBlock.getType() == Material.ACACIA_DOOR ||
                                    clickedBlock.getType() == Material.BIRCH_DOOR ||
                                    clickedBlock.getType() == Material.DARK_OAK_DOOR ||
                                    clickedBlock.getType() == Material.JUNGLE_DOOR ||
                                    clickedBlock.getType() == Material.WOOD_DOOR||
                                    clickedBlock.getType() == Material.WOODEN_DOOR||
                                    clickedBlock.getType() == Material.SPRUCE_DOOR||


                                    clickedBlock.getType() == Material.IRON_DOOR ||
                                    clickedBlock.getType() == Material.TRAP_DOOR ||

                                    clickedBlock.getType() == Material.SPRUCE_FENCE_GATE ||
                                    clickedBlock.getType() == Material.BIRCH_FENCE_GATE ||
                                    clickedBlock.getType() == Material.JUNGLE_FENCE_GATE ||
                                    clickedBlock.getType() == Material.DARK_OAK_FENCE_GATE )){
                        e.setCancelled(true);
                    }
                }
            }

        }


    }
}
