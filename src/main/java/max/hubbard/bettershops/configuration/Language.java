package max.hubbard.bettershops.configuration;

import max.hubbard.bettershops.Core;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class Language {

    public static HashMap<String, YamlConfiguration> configs = new HashMap<String, YamlConfiguration>();
    public static HashMap<String, File> files = new HashMap<String, File>();

    public static YamlConfiguration getConfig(String file) {
        return configs.get(file);
    }

    public static Core pl;

    public static File getFile(String file) {
        return files.get(file);
    }

    public static String getString(String file, String s) {
        if (configs.containsKey(file)) {
            return configs.get(file).getString(s).replaceAll("&", "§").replaceAll("»", "»");
        } else {
            File f = new File(Bukkit.getPluginManager().getPlugin("BetterShops").getDataFolder(),
                "Language/" + file + ".yml");
            YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
            configs.put(file, config);
            files.put(file, f);
            return config.getString(s).replaceAll("&", "§").replaceAll("»", "»");
        }
    }

    public static void setString(String file, String s, String message) {
        if (configs.containsKey(file)) {
            configs.get(file).set(s, message);
            try {
                configs.get(file).save(files.get(file));
            } catch (IOException ignored) {

            }
        } else {
            File f = new File(Bukkit.getPluginManager().getPlugin("BetterShops").getDataFolder(),
                "Language/" + file + ".yml");
            YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
            configs.put(file, config);
            files.put(file, f);
            config.set(s, message);
            try {
                configs.get(file).save(files.get(file));
            } catch (IOException ignored) {

            }
        }
    }

    public static void moveMessagesFile() {
        File f = new File(Core.getCore().getDataFolder(), "messages.yml");
        if (f.exists()) {
            File f2 = new File(Core.getCore().getDataFolder(), "Language/messages.yml");
            try {
                Files.copy(f.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                f.delete();
            }
        }
    }

}
