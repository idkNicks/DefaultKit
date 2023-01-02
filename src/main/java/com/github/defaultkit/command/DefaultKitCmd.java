package com.github.defaultkit.command;

import com.github.defaultkit.DefaultKit;
import com.github.defaultkit.data.DefaultKitData;
import com.github.defaultkit.data.StringData;
import com.github.nicklib.data.Config;
import com.github.nicklib.utils.InventoryUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DefaultKitCmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player player) {
            DefaultKitData defaultKitData = new DefaultKitData(player);
            StringData stringData = new StringData();

            if (args.length == 0) {

                if (defaultKitData.isReceived()) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.alreadyReceived()));
                    return true;
                }

                InventoryUtil inventoryUtil = new InventoryUtil(player, new Config("kit", DefaultKit.getPlugin()));
                if (inventoryUtil.isInventoryFull("defaultkit", 4)) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.inventoryFull()));
                    return true;
                }

                defaultKitData.receiveDefaultKit();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.receiveDefaultKit()));

                return true;
            }

            switch (args[0].toLowerCase()) {


                case "설정", "set", "setting" -> {

                    if (!player.hasPermission("defaulkit.setting")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.noPermission()));
                        return true;
                    }

                        defaultKitData.openDefaultKitSetInv();
                    return true;
                }

                case "초기화", "reset" -> {

                    if (!player.hasPermission("defaulkit.reset")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.noPermission()));
                        return true;
                    }

                    if (args.length == 1) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.noPlayerName()));
                        return true;
                    }

                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.playerNotFound()));
                        return true;
                    }

                    new DefaultKitData(target).resetDefaultKit();
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.resetDefaultKit()
                            .replace("{target}", target.getName())));

                    return true;
                }

            }
        }
        return false;
    }
}
