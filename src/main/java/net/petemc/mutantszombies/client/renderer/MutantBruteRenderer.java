package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.petemc.mutantszombies.client.model.MutantBruteModel;
import net.petemc.mutantszombies.entity.MutantBruteEntity;

public class MutantBruteRenderer extends RenderLiving<MutantBruteEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("mutantszombies", "textures/entities/mutantbrute.png");

    public MutantBruteRenderer(RenderManager renderManager) {
        super(renderManager, new MutantBruteModel(), 1.3F);
    }

    @Override
    protected ResourceLocation getEntityTexture(MutantBruteEntity entity) {
        return TEXTURE;
    }
}
