package com.github.defaultkit.command;

import com.github.defaultkit.data.DefaultKitData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DefaultKitCmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player player) {

            DefaultKitData defaultKitData = new DefaultKitData(player);

            if (args.length == 0) {
                defaultKitData.getDefaultKit();
                return true;
            }

            switch (args[0].toLowerCase()) {

                case "설정", "set", "setting" -> {
                    defaultKitData.openSettingDefaultKit();
                    return true;
                }

                case "초기화", "reset" -> {
                    defaultKitData.resetDefaultKit();
                    return true;
                }


                case "공지" -> {



                    return true;
                }
            }
        }
        return false;
    }
}
