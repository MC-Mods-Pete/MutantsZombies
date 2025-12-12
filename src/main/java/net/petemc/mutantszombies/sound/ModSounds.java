package net.petemc.mutantszombies.sound;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.petemc.mutantszombies.MutantsZombies;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, MutantsZombies.MOD_ID);

    public static final Supplier<SoundEvent> FLESH_SOUND = registerSoundEvent("mob.split_head_zombie.flesh");

    public static final Supplier<SoundEvent> GURGLE_SOUND = registerSoundEvent("mob.split_head_zombie.gurgle");

    public static final Supplier<SoundEvent> ROAR_SOUND = registerSoundEvent("mob.mutants.roar");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        Identifier id = Identifier.tryBuild(MutantsZombies.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
