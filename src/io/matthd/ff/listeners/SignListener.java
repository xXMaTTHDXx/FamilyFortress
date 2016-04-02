package io.matthd.ff.listeners;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Matt on 2016-04-01.
 */
public class SignListener implements Listener {

    @EventHandler
    public void onSignClick(PlayerInteractEvent e){
        Player pl = e.getPlayer();
        Action action = e.getAction();

        if(action == Action.RIGHT_CLICK_BLOCK){
            Block block = e.getClickedBlock();
            if(block.getState() instanceof Sign) {
                Sign sign = (Sign) block.getState();


            }
        }
    }
}
