package com.github.defaultkit.event;

import com.github.defaultkit.data.DefaultKitData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.jetbrains.annotations.NotNull;

public class InventoryCloseListener implements Listener {


    @EventHandler
    public void onClose(@NotNull InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        DefaultKitData defaultKitData = new DefaultKitData(player);
        defaultKitData.settingDefaultKit(event);
    }
}
