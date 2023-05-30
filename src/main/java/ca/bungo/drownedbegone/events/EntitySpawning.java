package ca.bungo.drownedbegone.events;

import ca.bungo.drownedbegone.DrownedBeGone;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import org.bukkit.craftbukkit.v1_19_R3.entity.CraftZombie;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawning implements Listener {

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {

        if(DrownedBeGone.getInstance().getConfig().getString("stop-mode").equalsIgnoreCase("float")){
            //NMS Code to modify the Pathfinding of a Zombie
            if(!(event.getEntity() instanceof Zombie zombie)) return;

            ((CraftZombie)zombie).getHandle().goalSelector.addGoal(6, new FloatGoal(((CraftZombie)zombie).getHandle()));

        }else if(DrownedBeGone.getInstance().getConfig().getString("stop-mode").equalsIgnoreCase("drown")) {

            if(event.getEntity() instanceof Drowned drowned){

                event.setCancelled(true); //Bye Bye Drowned

            }
        }
    }
}
