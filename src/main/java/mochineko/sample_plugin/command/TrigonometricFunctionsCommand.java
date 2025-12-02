package mochineko.sample_plugin.command;

import mochineko.sample_plugin.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class TrigonometricFunctionsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("cirlce_teleport")) {
            new BukkitRunnable() {
                float r = 0;
                @Override
                public void run() {
                    double sin = Math.sin(r * 1.5f);
                    Player player = ((Player) sender);
                    @NotNull Location loc = player.getLocation();
                    @NotNull World world = player.getWorld();
                    player.setVelocity(new Vector(r, sin, 0));
                    r+=0.1f;

                    boolean air = (loc.clone().subtract(0, 1, 0).getBlock().getType() == Material.AIR);
                    if (player.isOnGround() || !air) {
                        this.cancel();
                    }
                }
            }.runTaskTimer(Main.getPlugin(Main.class), 0L, 2L);
        }
        return false;
    }

}
