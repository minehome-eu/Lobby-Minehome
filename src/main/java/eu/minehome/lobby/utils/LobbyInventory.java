package eu.minehome.lobby.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class LobbyInventory {
    public static void SetLobbyInventory(Player p) {

        // Navigator
        ItemStack Navigator = new ItemStack(Material.COMPASS);
        ItemMeta NavigatorMeta = Navigator.getItemMeta();
        NavigatorMeta.setDisplayName("§b§lNavigator");
        Navigator.setItemMeta(NavigatorMeta);

        // PlayerHider
        ItemStack PlayerHider = new ItemStack(Material.BLAZE_ROD);
        ItemMeta PlayerHiderMeta = PlayerHider.getItemMeta();
        PlayerHiderMeta.setDisplayName("§b§lPlayerHider");
        PlayerHider.setItemMeta(PlayerHiderMeta);

        // LobbySwitcher
        ItemStack LobbySwitcher = new ItemStack(Material.NETHER_STAR);
        ItemMeta LobbySwitcherMeta = LobbySwitcher.getItemMeta();
        LobbySwitcherMeta.setDisplayName("§b§lLobbySwitcher");
        LobbySwitcher.setItemMeta(LobbySwitcherMeta);

        //ComingSoon
        ItemStack ComingSoon = new ItemStack(Material.BARRIER);
        ItemMeta ComingSoonMeta = ComingSoon.getItemMeta();
        ComingSoonMeta.setDisplayName("§b§lComingSoon");
        ComingSoon.setItemMeta(ComingSoonMeta);

        // Settings
        ItemStack Settings = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta playerheadmeta = (SkullMeta) Settings.getItemMeta();
        playerheadmeta.setOwner(p.getName());
        playerheadmeta.setDisplayName("§b§l" + p.getName());
        Settings.setItemMeta(playerheadmeta);

        // Give Player Lobby Inventory
        p.getInventory().setItem(0, Navigator);
        //p.getInventory().setItem(1, test);
        p.getInventory().setItem(2, PlayerHider);
        //p.getInventory().setItem(3, test);
        p.getInventory().setItem(4, LobbySwitcher);
        //p.getInventory().setItem(5, test);
        p.getInventory().setItem(6, ComingSoon);
        //p.getInventory().setItem(7, test);
        p.getInventory().setItem(8, Settings);
    }

}