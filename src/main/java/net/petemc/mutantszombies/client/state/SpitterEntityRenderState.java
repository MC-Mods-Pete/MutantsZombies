package net.petemc.mutantszombies.client.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.petemc.mutantszombies.MutantsZombies;

@OnlyIn(Dist.CLIENT)
public class SpitterEntityRenderState extends LivingEntityRenderState {
	public ResourceLocation skinTexture = ResourceLocation.fromNamespaceAndPath(MutantsZombies.MOD_ID, "textures/entities/spitter.png");
}
