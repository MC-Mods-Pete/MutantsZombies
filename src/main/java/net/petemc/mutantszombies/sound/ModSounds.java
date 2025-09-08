package net.petemc.mutantszombies.sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.petemc.mutantszombies.MutantsZombies;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MutantsZombies.MOD_ID);

    public static final Supplier<SoundEvent> FLESH_SOUND = registerSoundEvent("mob.split_head_zombie.flesh");

    public static final Supplier<SoundEvent> GURGLE_SOUND = registerSoundEvent("mob.split_head_zombie.gurgle");

    public static final Supplier<SoundEvent> ROAR_SOUND = registerSoundEvent("mob.mutants.roar");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(MutantsZombies.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
