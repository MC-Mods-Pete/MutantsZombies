package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.petemc.mutantszombies.client.model.ZombieBruteModel;
import net.petemc.mutantszombies.client.renderer.layer.LayerEmissive;
import net.petemc.mutantszombies.entity.ZombieBruteEntity;

public class ZombieBruteRenderer extends RenderLiving<ZombieBruteEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("mutantszombies", "textures/entities/zombiebrute.png");
    private static final ResourceLocation TEXTURE_EMISSIVE = new ResourceLocation("mutantszombies", "textures/entities/zombiebrute_e.png");

    public ZombieBruteRenderer(RenderManager renderManager) {
        super(renderManager, new ZombieBruteModel(), 1.3F);
        this.addLayer(new LayerEmissive<>(this, TEXTURE_EMISSIVE));
    }

    @Override
    protected ResourceLocation getEntityTexture(ZombieBruteEntity entity) {
        return TEXTURE;
    }
}
