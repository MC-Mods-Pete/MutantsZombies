package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.petemc.mutantszombies.client.model.ZombieBruteModel;
import net.petemc.mutantszombies.entity.ZombieBruteEntity;

public class ZombieBruteRenderer extends RenderLiving<ZombieBruteEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("mutantszombies", "textures/entities/zombiebrute.png");

    public ZombieBruteRenderer(RenderManager renderManager) {
        super(renderManager, new ZombieBruteModel(), 1.3F);
    }

    @Override
    protected ResourceLocation getEntityTexture(ZombieBruteEntity entity) {
        return TEXTURE;
    }
}
