package ca.bungo.drownedbegone;

import ca.bungo.drownedbegone.abstracted.AbstractedHandler;
import ca.bungo.drownedbegone.abstracted.AbstractedLink;
import ca.bungo.drownedbegone.events.EntitySpawning;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;

public final class DrownedBeGone extends JavaPlugin {

    private static DrownedBeGone instance;

    public AbstractedHandler abstractedHandler;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        Bukkit.getServer().getPluginManager().registerEvents(new EntitySpawning(), this);
        this.saveDefaultConfig();

        loadAbstract();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static DrownedBeGone getInstance(){
        return instance;
    }

    private void loadAbstract(){

        AbstractedLink helper =  new AbstractedLink(){
            @Override
            public Plugin getInstance() {
                return DrownedBeGone.getInstance();
            }
        };

        String ver = Bukkit.getServer().getClass().getPackage().getName().replace('.', ',').split(",")[3];
        try {
            Class<?> handler = Class.forName("ca.bungo.drownedbegone.abstracted." + ver + ".Abstracted" + ver);
            this.abstractedHandler = (AbstractedHandler) handler.getConstructor(AbstractedLink.class).newInstance(helper);
        } catch(ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                InvocationTargetException e){
            e.printStackTrace();
            getLogger().warning("Failed to find Abstract Handlder for version: " + ver);
            getLogger().warning("Attempted Class: " + "ca.bungo.drownedbegone.abstracted." + ver + ".Abstracted" + ver);
        }
    }
}
