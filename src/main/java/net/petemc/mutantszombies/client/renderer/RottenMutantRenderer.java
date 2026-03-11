package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.petemc.mutantszombies.client.model.RottenMutantModel;
import net.petemc.mutantszombies.client.renderer.layer.LayerEmissive;
import net.petemc.mutantszombies.entity.RottenMutantEntity;

public class RottenMutantRenderer extends RenderLiving<RottenMutantEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("mutantszombies", "textures/entities/rottenmutant.png");
    private static final ResourceLocation TEXTURE_EMISSIVE = new ResourceLocation("mutantszombies", "textures/entities/rottenmutant_e.png");

    public RottenMutantRenderer(RenderManager renderManager) {
        super(renderManager, new RottenMutantModel(), 0.7F);
        this.addLayer(new LayerEmissive<>(this, TEXTURE_EMISSIVE));
    }

    @Override
    protected ResourceLocation getEntityTexture(RottenMutantEntity entity) {
        return TEXTURE;
    }
}
