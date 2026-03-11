package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.petemc.mutantszombies.client.model.SpitterModel;
import net.petemc.mutantszombies.entity.SpitterEntity;

public class SpitterRenderer extends RenderLiving<SpitterEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("mutantszombies", "textures/entities/spitter.png");

    public SpitterRenderer(RenderManager renderManager) {
        super(renderManager, new SpitterModel(), 1.3F);
    }

    @Override
    protected ResourceLocation getEntityTexture(SpitterEntity entity) {
        return TEXTURE;
    }
}
