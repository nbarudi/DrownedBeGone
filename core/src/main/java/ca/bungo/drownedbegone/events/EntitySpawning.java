package ca.bungo.drownedbegone.events;

import ca.bungo.drownedbegone.DrownedBeGone;
import org.bukkit.Bukkit;
import org.bukkit.entity.Drowned;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawning implements Listener {

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {

        if(DrownedBeGone.getInstance().getConfig().getString("stop-mode").equalsIgnoreCase("float")){
            if(DrownedBeGone.getInstance().getConfig().getStringList("entity-list")
                    .stream().anyMatch(e -> e.equalsIgnoreCase(event.getEntityType().toString()))){
                if(!DrownedBeGone.getInstance().abstractedHandler.addFloatGoal(event.getEntity())){
                    DrownedBeGone.getInstance().getLogger().warning("Error: Config Entity `" + event.getEntity().getType()
                            + "` is not a Pathfinder Mob. AI will not be changed!");
                }
            }
        }else if(DrownedBeGone.getInstance().getConfig().getString("stop-mode").equalsIgnoreCase("drown")) {
            if(event.getEntity() instanceof Drowned){
                event.setCancelled(true); //Bye Bye Drowned
            }
        }
    }
}
