package ca.bungo.drownedbegone;

import ca.bungo.drownedbegone.events.EntitySpawning;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Villager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DrownedBeGone extends JavaPlugin {

    private static DrownedBeGone instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        Bukkit.getServer().getPluginManager().registerEvents(new EntitySpawning(), this);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static DrownedBeGone getInstance(){
        return instance;
    }
}
