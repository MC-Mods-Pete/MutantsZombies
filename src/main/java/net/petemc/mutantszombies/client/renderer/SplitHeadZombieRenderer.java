package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.petemc.mutantszombies.client.model.SplitHeadZombieModel;
import net.petemc.mutantszombies.client.renderer.layer.LayerEmissive;
import net.petemc.mutantszombies.entity.SplitHeadZombieEntity;

public class SplitHeadZombieRenderer extends RenderLiving<SplitHeadZombieEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("mutantszombies", "textures/entities/splitheadzombie.png");
    private static final ResourceLocation TEXTURE_EMISSIVE = new ResourceLocation("mutantszombies", "textures/entities/splitheadzombie_e.png");

    public SplitHeadZombieRenderer(RenderManager renderManager) {
        super(renderManager, new SplitHeadZombieModel(), 1.3F);
        this.addLayer(new LayerEmissive<>(this, TEXTURE_EMISSIVE));
    }

    @Override
    protected ResourceLocation getEntityTexture(SplitHeadZombieEntity entity) {
        return TEXTURE;
    }
}
