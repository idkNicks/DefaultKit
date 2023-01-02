package com.github.defaultkit.data;

import com.github.defaultkit.DefaultKit;
import com.github.nicklib.data.Config;
import com.github.nicklib.utils.InventoryUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.jetbrains.annotations.NotNull;


public class DefaultKitData {

    private Player player;


    public DefaultKitData(Player player) {
        this.player = player;

        Config data = new Config("data/" + player.getUniqueId(), DefaultKit.getPlugin());
        if (!data.isFileExist()) data.setBoolean("defaultKit", false);
    }


    /**
     * 키트 설정 인벤토리를 엽니다.
     */
    public void openDefaultKitSetInv() {
        InventoryUtil inventoryUtil = new InventoryUtil(player, new Config("kit", DefaultKit.getPlugin()));
        inventoryUtil.getInventory("defaultkit", "기본템 설정", 4);
    }


    /**
     * 인벤토리를 닫았을 때 콘피그에 아이템이 저장됩니다.
     *
     * @param event InventoryCloseEvent
     */
    public void setDefaultKit(@NotNull InventoryCloseEvent event) {

        InventoryUtil inventoryUtil = new InventoryUtil(player, new Config("kit", DefaultKit.getPlugin()));
        inventoryUtil.saveInventory("defaultkit", event, event.getInventory());

    }


    /**
     * 플레이어가 기본템을 받습니다.
     */
    public void receiveDefaultKit() {
        InventoryUtil inventoryUtil = new InventoryUtil(player, new Config("kit", DefaultKit.getPlugin()));
        inventoryUtil.getInventoryItem("defaultkit");

        new Config("data/" + player.getUniqueId(), DefaultKit.getPlugin()).setBoolean("defaultKit", true);
    }


    /**
     * 플레이어의 기본템 정보를 초기화 시킵니다.
     */
    public void resetDefaultKit() {
        Config data = new Config("data/" + player.getUniqueId(), DefaultKit.getPlugin());
        data.setBoolean("defaultKit", false);
    }


    public boolean isReceived() {
        Config data = new Config("data/" + player.getUniqueId(), DefaultKit.getPlugin());
        return data.getBoolean("defaultKit");
    }
}
