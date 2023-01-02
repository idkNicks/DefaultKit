package com.github.defaultkit.data;

import com.github.defaultkit.DefaultKit;
import com.github.nicklib.data.Config;
import com.github.nicklib.utils.InventoryUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;


public class DefaultKitData {

    private Player player;


    public DefaultKitData(Player player) {
        this.player = player;
    }


    /**
     * 플레이어가 서버에 접속하면 기본 키트 받은 여부를 설정합니다.
     * @param event PlayerJoinEvent
     */
    public void createPlayerData(PlayerJoinEvent event) {
        Config data = new Config("data/" + player.getUniqueId(), DefaultKit.getPlugin());

        if(!data.isFileExist()) {
            data.setBoolean("defaultKit", false);
        }
    }


    /**
     * 키트 설정 인벤토리를 엽니다.
     */
    public void openSettingDefaultKit() {
        InventoryUtil inventoryUtil = new InventoryUtil(player, new Config("kit", DefaultKit.getPlugin()));
        inventoryUtil.getInventory("defaultkit", "기본템 설정", 4);
    }


    /**
     * 인벤토리를 닫았을 때 콘피그에 아이템이 저장됩니다.
     * @param event InventoryCloseEvent
     */
    public void settingDefaultKit(@NotNull InventoryCloseEvent event) {

        InventoryUtil inventoryUtil = new InventoryUtil(player, new Config("kit", DefaultKit.getPlugin()));

        if (event.getView().getTitle().equalsIgnoreCase("기본템 설정")) {
            inventoryUtil.saveInventory("defaultkit", event, event.getInventory());
        }
    }


    /**
     * 플레이어가 기본템을 받습니다.
     */
    public void getDefaultKit() {
        InventoryUtil inventoryUtil = new InventoryUtil(player, new Config("kit", DefaultKit.getPlugin()));


        if(new Config("data/" + player.getUniqueId(), DefaultKit.getPlugin()).getBoolean("defaultKit") == true) {
            player.sendMessage("이미 기본템을 지급 받았습니다!");
            return;
        }

        if(!inventoryUtil.isInventoryFull("defaultkit", 4)) {
            inventoryUtil.getInventoryItem("defaultkit");
            player.sendMessage("기본템 받았음!");
            new Config("data/" + player.getUniqueId(), DefaultKit.getPlugin()).setBoolean("defaultKit", true);
        } else {
            player.sendMessage("인벤토리 가득찼음 너");
        }
    }


    /**
     * 플레이어의 기본템을 초기화 시킵니다.
     */
    public void resetDefaultKit() {
        Config data = new Config("kit", DefaultKit.getPlugin());
    }
}
