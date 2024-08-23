package eu.minehome.lobby;

import org.bukkit.plugin.java.JavaPlugin;
import eu.minehome.lobby.commands.BuildCmd;
import eu.minehome.lobby.commands.SetSpawnCmd;
import eu.minehome.lobby.configfile.ConfigFile;
import eu.minehome.lobby.configfile.LocationFile;
import eu.minehome.lobby.configfile.MessagesFile;
import eu.minehome.lobby.listener.*;
import org.bukkit.Bukkit;
import com.google.gson.JsonArray;

import java.util.Objects;

public final class Lobby extends JavaPlugin {

    public static Lobby instance;
    private MessagesFile messagesFile;
    private ConfigFile configFile;
    private LocationFile locationFile;


    @Override
    public void onEnable() {

        createConfig();
        registerEvents();
        registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerEvents() {

        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BreakEvent(),this);
        Bukkit.getPluginManager().registerEvents(new PlaceEvent(),this);
        Bukkit.getPluginManager().registerEvents(new InteractEvent(),this);
        Bukkit.getPluginManager().registerEvents(new PlayerDamageEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InventarInteractEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LobbyInventoryEvent(), this);

    }
    private void registerCommands() {

        getCommand("build").setExecutor(new BuildCmd());
        getCommand("setspawn").setExecutor(new SetSpawnCmd());

    }

    private void createConfig(){
        instance = this;

        messagesFile = new MessagesFile();
        messagesFile.createFile();

        configFile = new ConfigFile();
        configFile.createFile();

        locationFile = new LocationFile();
        locationFile.createFile();

    }

    public MessagesFile getMessagesFile() {return messagesFile;}
    public ConfigFile getConfigFile() {
        return configFile;
    }
    public LocationFile getLocationFile() {return locationFile;}
    public static Lobby getInstance(){return instance;}
}
