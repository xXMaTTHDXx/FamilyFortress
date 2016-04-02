package io.matthd.ff.listeners;

import io.matthd.ff.LocationUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Matt on 2016-04-01.
 */
public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player pl = e.getPlayer();
        pl.teleport(LocationUtil.getLobby());
    }
}
