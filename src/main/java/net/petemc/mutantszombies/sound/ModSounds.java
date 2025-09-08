package net.petemc.mutantszombies.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;

public class ModSounds {

    public static final SoundEvent FLESH_SOUND = registerSoundEvent("mob.split_head_zombie.flesh");

    public static final SoundEvent GURGLE_SOUND = registerSoundEvent("mob.split_head_zombie.gurgle");

    public static final SoundEvent ROAR_SOUND = registerSoundEvent("mob.mutants.roar");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(MutantsZombies.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        MutantsZombies.LOGGER.info("Registering Sounds for " + MutantsZombies.MOD_ID);
    }
}
