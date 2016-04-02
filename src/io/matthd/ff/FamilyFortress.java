package io.matthd.ff;

import io.matthd.ff.arena.ArenaManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matt on 2016-04-01.
 */
public class FamilyFortress extends JavaPlugin {

    private static FamilyFortress instance;

    private String[] signFormat = {"", ""};

    private ArenaManager arenaManager;

    @Override
    public void onEnable(){
        instance = this;
        arenaManager = new ArenaManager();
        arenaManager.init();
    }

    @Override
    public void onDisable(){
        instance = null;
    }

    public static FamilyFortress getInstance() {
        return instance;
    }
}
