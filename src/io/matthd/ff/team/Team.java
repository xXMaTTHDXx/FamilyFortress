package io.matthd.ff.team;

import io.matthd.ff.FamilyFortress;
import io.matthd.ff.LocationUtil;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Matt on 2016-04-01.
 */
public class Team {

    private static FamilyFortress instance = FamilyFortress.getInstance();

    private String name;
    private List<UUID> members;
    private Location spawn;

    public Team(String name){
        this.name = name;
        this.members = new ArrayList<>();
        this.spawn = LocationUtil.deserialize(instance.getConfig().getString("teams." + name + ".spawn"));
    }

    public Team(String name, Location spawn, List<UUID> members) {
        this.name = name;
        this.spawn = spawn;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public List<UUID> getMembers() {
        return members;
    }

    public Location getSpawn() {
        return spawn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(List<UUID> members) {
        this.members = members;
    }

    public void setSpawn(Location spawn) {
        instance.getConfig().set("teams." + name + ".spawn", LocationUtil.serialize(spawn));
        this.spawn = spawn;
    }
}
