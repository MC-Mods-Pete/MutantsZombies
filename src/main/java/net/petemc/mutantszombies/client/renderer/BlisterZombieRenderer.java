package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.petemc.mutantszombies.client.model.BlisterZombieModel;
import net.petemc.mutantszombies.entity.BlisterZombieEntity;

public class BlisterZombieRenderer extends RenderLiving<BlisterZombieEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("mutantszombies", "textures/entities/blisterzombie.png");

    public BlisterZombieRenderer(RenderManager renderManager) {
        super(renderManager, new BlisterZombieModel(), 0.7F);
    }

    @Override
    protected ResourceLocation getEntityTexture(BlisterZombieEntity entity) {
        return TEXTURE;
    }
}
