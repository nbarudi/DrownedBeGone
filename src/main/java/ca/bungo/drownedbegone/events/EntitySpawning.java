package ca.bungo.drownedbegone.events;

import ca.bungo.drownedbegone.DrownedBeGone;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_19_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_19_R3.entity.CraftZombie;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawning implements Listener {

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {

        //ToDo: Cleanup Code Environment

        if(DrownedBeGone.getInstance().getConfig().getString("stop-mode").equalsIgnoreCase("float")){
            //NMS Code to modify the Pathfinding of a Zombie
            if(DrownedBeGone.getInstance().getConfig().getStringList("entity-list").stream().anyMatch(obj -> obj.equalsIgnoreCase(event.getEntityType().toString()))){
                if(((CraftEntity) event.getEntity()).getHandle() instanceof PathfinderMob pathfinderMob){
                    pathfinderMob.goalSelector.addGoal(6, new FloatGoal(pathfinderMob));
                }else{
                    Bukkit.getLogger().warning("Error: Config Entity `" + event.getEntity().getType() + "` is not a Pathfinder Mob. AI will not be changed!");
                }
            }
        }else if(DrownedBeGone.getInstance().getConfig().getString("stop-mode").equalsIgnoreCase("drown")) {

            if(event.getEntity() instanceof Drowned drowned){

                event.setCancelled(true); //Bye Bye Drowned

            }
        }
    }
}
