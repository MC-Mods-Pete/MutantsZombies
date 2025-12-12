package net.petemc.mutantszombies.client.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.petemc.mutantszombies.MutantsZombies;

public class ZombieBruteEntityRenderState extends LivingEntityRenderState {
	public Identifier skinTexture = Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "textures/entities/zombiebrute.png");
    public float attackTicksRemaining;
}
