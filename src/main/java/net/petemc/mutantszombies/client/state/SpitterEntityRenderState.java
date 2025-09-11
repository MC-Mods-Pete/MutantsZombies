package net.petemc.mutantszombies.client.state;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;
import net.petemc.mutantszombies.MutantsZombies;

public class SpitterEntityRenderState extends LivingEntityRenderState {
    public Identifier skinTexture = Identifier.of(MutantsZombies.MOD_ID, "textures/entities/spitter.png");
}
