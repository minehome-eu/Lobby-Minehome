package eu.minehome.lobby.configfile;

import eu.minehome.lobby.Lobby;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LocationFile {
    private final File file = new File(Lobby.getInstance().getDataFolder().getPath(), "locations.yml");
    private final FileConfiguration locationcfg = YamlConfiguration.loadConfiguration(file);

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
        locationcfg.options().copyDefaults(true);
        // Add all toggen function

        save();
    }

    public void save() {
        try {
            locationcfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getLocationcfg() {
        return locationcfg;
    }
}
