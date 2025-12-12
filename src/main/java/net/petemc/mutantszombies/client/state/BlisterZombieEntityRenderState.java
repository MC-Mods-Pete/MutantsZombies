package net.petemc.mutantszombies.client.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.petemc.mutantszombies.MutantsZombies;

public class BlisterZombieEntityRenderState extends LivingEntityRenderState {
	public Identifier skinTexture = Identifier.fromNamespaceAndPath(MutantsZombies.MOD_ID, "textures/entities/blisterzombie.png");
}
