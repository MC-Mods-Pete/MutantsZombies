package net.petemc.mutantszombies.sound;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.petemc.mutantszombies.MutantsZombies;

public class ModSounds {

    public static final SoundEvent FLESH_SOUND = registerSoundEvent("mob.split_head_zombie.flesh");

    public static final SoundEvent GURGLE_SOUND = registerSoundEvent("mob.split_head_zombie.gurgle");

    public static final SoundEvent ROAR_SOUND = registerSoundEvent("mob.mutants.roar");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void registerSounds() {
        MutantsZombies.LOGGER.info("Registering Sounds for " + MutantsZombies.MOD_ID);
    }
}
