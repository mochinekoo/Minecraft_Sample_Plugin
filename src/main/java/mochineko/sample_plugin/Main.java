package mochineko.sample_plugin;

import mochineko.sample_plugin.command.HelloWorldCommand;
import mochineko.sample_plugin.command.TrigonometricFunctionsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("hello_world").setExecutor(new HelloWorldCommand());
        getCommand("cirlce_teleport").setExecutor(new TrigonometricFunctionsCommand());

        getLogger().info("プラグインが有効になりました。");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
