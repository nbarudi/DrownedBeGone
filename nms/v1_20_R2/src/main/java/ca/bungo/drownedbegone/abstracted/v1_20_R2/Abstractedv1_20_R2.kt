package ca.bungo.drownedbegone.abstracted.v1_20_R2

import ca.bungo.drownedbegone.abstracted.AbstractedHandler
import ca.bungo.drownedbegone.abstracted.AbstractedLink
import net.minecraft.world.entity.PathfinderMob
import net.minecraft.world.entity.ai.goal.FloatGoal
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftEntity
import org.bukkit.entity.Entity

class Abstractedv1_20_R2(helper: AbstractedLink) : AbstractedHandler(helper) {

    override fun addFloatGoal(entity: Entity?): Boolean {
        //NMS Code to modify the Pathfinding of a Zombie
        if ((entity as CraftEntity).handle is PathfinderMob) {
            val pathfinderMob: PathfinderMob = ((entity).handle as PathfinderMob)
            pathfinderMob.goalSelector.addGoal(6, FloatGoal(pathfinderMob))
            return true
        }
        return false
    }
}