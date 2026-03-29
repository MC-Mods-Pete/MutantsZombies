package net.petemc.mutantszombies.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.petemc.mutantszombies.MutantsZombies;

public class MutantBruteEntityRenderState extends LivingEntityRenderState {
	public Identifier skinTexture = Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "textures/entities/mutantbrute.png");
    public float attackTicksRemaining;
}
