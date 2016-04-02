package io.matthd.ff;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

/**
 * Created by Matt on 2016-04-01.
 */
public class LocationUtil {

    private static FamilyFortress instance = FamilyFortress.getInstance();

    public static String serialize(Location loc) {
        return loc.getWorld().getName().trim() + "," + loc.getBlockX() + "," + loc.getBlockY() + "," +loc.getBlockZ();
    }

    public static Location deserialize(String path) {
        String[] parse = path.split(",");

        World world = Bukkit.getWorld(parse[0]);
        int x = Integer.valueOf(parse[1]);
        int y = Integer.valueOf(parse[2]);
        int z = Integer.valueOf(parse[3]);
        return new Location(world, x,y,z);
    }

    public static Location getLobby(){
        return deserialize(instance.getConfig().getString("lobby"));
    }
}
