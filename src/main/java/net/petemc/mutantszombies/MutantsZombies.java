package net.petemc.mutantszombies;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.petemc.mutantszombies.client.renderer.ModEntityRenderers;
import net.petemc.mutantszombies.entity.ModEntities;
import net.petemc.mutantszombies.item.ModItems;
import net.petemc.mutantszombies.sound.ModSounds;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = MutantsZombies.MOD_ID, name = "MutantsZombies", version = "1.0")
public class MutantsZombies {
    public static final String MOD_ID = "mutantszombies";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(null);
        ModEntities.register(null);
        ModSounds.register(null);

        if (event.getSide() == Side.CLIENT) {
            registerClientRenderers();
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModEntities.initModEntities();
        ModEntities.registerSpawns();
    }

    @SideOnly(Side.CLIENT)
    private void registerClientRenderers() {
        MutantsZombies.LOGGER.info("--------------------- Registering client renderers");
        ModEntityRenderers.register();
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        // Server startup hook (1.12 lifecycle)
    }
}
