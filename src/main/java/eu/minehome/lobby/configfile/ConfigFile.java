package eu.minehome.lobby.configfile;

import eu.minehome.lobby.Lobby;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigFile {
    private final File file = new File(Lobby.getInstance().getDataFolder().getPath(), "config.yml");
    private final FileConfiguration configcfg = YamlConfiguration.loadConfiguration(file);

    public void createFile() {
        if (!file.exists()) {
            try {
                file.getParentFile().mkdir();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        addDefault();
    }

    private void addDefault() {
        configcfg.options().copyDefaults(true);
        // Add all toggen function
        configcfg.addDefault("Lobby.World", "world");

        configcfg.addDefault("Sound.JoinSound", true);
        configcfg.addDefault("Sounds.ItemSwitchSound", true);



        save();
    }

    public void save() {
        try {
            configcfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfigcfg() {
        return configcfg;
    }
}