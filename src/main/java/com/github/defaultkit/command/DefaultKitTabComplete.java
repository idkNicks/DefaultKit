package com.github.defaultkit.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class DefaultKitTabComplete implements TabCompleter {


    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            if (args.length == 1) {
                return List.of("설정", "초기화");
            }
            if (args.length == 2) {
                return Bukkit.getOnlinePlayers().stream().map(Player::getDisplayName).toList();
            }
        }
        return null;
    }
}
