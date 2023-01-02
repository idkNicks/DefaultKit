package com.github.defaultkit.event;

import com.github.defaultkit.data.DefaultKitData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerJoinListener implements Listener {


    @EventHandler
    public void onJoin(@NotNull PlayerJoinEvent event) {
        Player player = event.getPlayer();
        DefaultKitData defaultKitData = new DefaultKitData(player);
        defaultKitData.createPlayerData(event);
    }
}
