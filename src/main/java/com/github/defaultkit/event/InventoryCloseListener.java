package com.github.defaultkit.event;

import com.github.defaultkit.data.DefaultKitData;
import com.github.defaultkit.data.StringData;
import org.bukkit.ChatColor;
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

        if (event.getView().getTitle().equalsIgnoreCase("기본템 설정")) {
            defaultKitData.setDefaultKit(event);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', new StringData().setDefaultKit()));
        }
    }
}
