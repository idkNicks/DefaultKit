package com.github.defaultkit;

import com.github.defaultkit.command.DefaultKitCmd;
import com.github.defaultkit.command.DefaultKitTabComplete;
import com.github.defaultkit.event.InventoryCloseListener;
import com.github.nicklib.data.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DefaultKit extends JavaPlugin {

    private static JavaPlugin plugin;


    @Override
    public void onEnable() {
        plugin = this;
        init();
    }


    /**
     * 플러그인 이벤트 & 커맨드 & API & Config를 등록합니다.
     */
    public void init() {

        // CONFIG
        Config config = new Config("config", this);
        Config kit = new Config("kit", this);
        config.loadDefaultConfig();
        kit.loadDefaultConfig();

        // EVENT
        Bukkit.getPluginManager().registerEvents(new InventoryCloseListener(), this);

        // COMMAND
        Bukkit.getPluginCommand("defaultkit").setExecutor(new DefaultKitCmd());
        Bukkit.getPluginCommand("defaultkit").setTabCompleter(new DefaultKitTabComplete());
    }


    public static JavaPlugin getPlugin() {
        return plugin;
    }
}
