package ca.bungo.drownedbegone.abstracted;

import org.bukkit.entity.Entity;

public abstract class AbstractedHandler {
    protected AbstractedLink helper;

    public AbstractedHandler(AbstractedLink helper){
        this.helper = helper;
    }

    public abstract boolean addFloatGoal(Entity entity);

}
