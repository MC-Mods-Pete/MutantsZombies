package net.petemc.mutantszombies.sound;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.petemc.mutantszombies.MutantsZombies;

@Mod.EventBusSubscriber(modid = MutantsZombies.MOD_ID)
public class ModSounds {
    public static final SoundEvent FLESH_SOUND = create("mob.split_head_zombie.flesh");
    public static final SoundEvent GURGLE_SOUND = create("mob.split_head_zombie.gurgle");
    public static final SoundEvent ROAR_SOUND = create("mob.mutants.roar");

    private static SoundEvent create(String name) {
        ResourceLocation id = new ResourceLocation(MutantsZombies.MOD_ID, name);
        return new SoundEvent(id).setRegistryName(id);
    }

    @SubscribeEvent
    public static void onRegisterSounds(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(FLESH_SOUND, GURGLE_SOUND, ROAR_SOUND);
    }

    public static void register(Object ignoredEventBus) {
        // 1.12 registriert SoundEvents ueber RegistryEvent; hier kein Bus-Hook noetig.
    }
}
