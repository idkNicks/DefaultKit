package com.github.defaultkit.data;

import com.github.defaultkit.DefaultKit;
import com.github.nicklib.data.Config;

public class StringData {

    private Config config = new Config("config", DefaultKit.getPlugin());


    public String receiveDefaultKit() {
        return getPrefix() + config.getString("messages.receiveDefaultKit");
    }

    public String setDefaultKit() {
        return getPrefix() + config.getString("messages.setDefaultKit");
    }

    public String resetDefaultKit() {
        return getPrefix() + config.getString("messages.resetDefaultKit");
    }

    public String inventoryFull() {
        return getPrefix() + config.getString("errorMessages.inventoryFull");
    }

    public String alreadyReceived() {
        return getPrefix() + config.getString("errorMessages.alreadyReceived");
    }

    public String playerNotFound() {
        return getPrefix() + config.getString("errorMessages.playerNotFound");
    }

    public String noPlayerName() {
        return getPrefix() + config.getString("errorMessages.noPlayerName");
    }

    public String noPermission() {
        return getPrefix() + config.getString("errorMessages.noPermission");
    }

    public String getPrefix() {
        return config.getString("prefix");
    }
}
