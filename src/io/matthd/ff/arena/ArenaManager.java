package io.matthd.ff.arena;

import io.matthd.ff.FamilyFortress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 2016-04-01.
 */
public class ArenaManager {

    private static FamilyFortress instance = FamilyFortress.getInstance();

    private List<Arena> arenas = new ArrayList<>();

    public void init() {
        for (String name : instance.getConfig().getConfigurationSection("arenas").getKeys(false)) {
            Arena a = new Arena(name);
            arenas.add(a);
            System.out.println("Loaded Arena - " + name);
        }
    }

    public void startArena(Arena arena) {
        if (arena.getState() != Arena.ArenaState.JOIN) {
            System.out.println("Arena " + arena.getName() + " cannot be started!");
            return;
        }

        if (arena.getCurrentPlayers() < arena.getMinPlayers()) {
            System.out.println("Arena " + arena.getName() + " cannot be started!");
            return;
        }
        arena.start();
    }

    public void stopArena() {

    }
}
