package io.matthd.ff.arena;

import io.matthd.ff.FamilyFortress;
import io.matthd.ff.LocationUtil;
import io.matthd.ff.team.Team;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * Created by Matt on 2016-04-01.
 */
public class Arena {

    public enum ArenaState {
        JOIN, WAITING, GAME, RESTARTING;
    }

    private static FamilyFortress instance = FamilyFortress.getInstance();

    private String name;
    private Location min, max;
    private List<UUID> allPlayers;

    private int currentPlayers = 0;

    private Map<UUID, Team> playerTeams;
    private ArenaState state;

    private int minPlayers = 6;

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    private int maxPlayers = 20;

    public Arena(String name) {
        this.name = name;
        this.min = LocationUtil.deserialize(instance.getConfig().getString("arenas." + name + ".min"));
        this.max = LocationUtil.deserialize(instance.getConfig().getString("arenas." + name + ".max"));
        this.allPlayers = new ArrayList<>();
        this.playerTeams = new HashMap<>();
        state = ArenaState.JOIN;
    }

    public Arena(String name, Location min, Location max, List<UUID> allPlayers, Map<UUID, Team> playerTeams) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.allPlayers = allPlayers;
        this.playerTeams = playerTeams;
        state = ArenaState.JOIN;
    }

    public ArenaState getState() {
        return state;
    }

    public void setState(ArenaState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getMin() {
        return min;
    }

    public void setMin(Location min) {
        instance.getConfig().set("arenas." + name + ".min", LocationUtil.serialize(min));
        this.min = min;
    }

    public Location getMax() {
        return max;
    }

    public void setMax(Location max) {
        instance.getConfig().set("arenas." + name + ".max", LocationUtil.serialize(max));
        this.max = max;
    }

    public void sendMessage(String msg){
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.sendMessage(msg);
        }
    }

    public void sendMessageToTeam(String msg, Team team){
        for(UUID uuid : team.getMembers()){
            Player pl = Bukkit.getPlayer(uuid);
            pl.sendMessage(msg);
        }
    }

    public void start() {

    }

    public void stop() {

    }

    public int getCurrentPlayers() {
        return allPlayers.size();
    }

    public List<UUID> getAllPlayers() {
        return allPlayers;
    }

    public void setAllPlayers(List<UUID> allPlayers) {
        this.allPlayers = allPlayers;
    }

    public Map<UUID, Team> getPlayerTeams() {
        return playerTeams;
    }

    public void setPlayerTeams(Map<UUID, Team> playerTeams) {
        this.playerTeams = playerTeams;
    }
}
