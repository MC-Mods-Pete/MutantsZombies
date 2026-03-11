package net.petemc.mutantszombies.client.renderer;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.petemc.mutantszombies.entity.BlisterZombieEntity;
import net.petemc.mutantszombies.entity.CrawlerEntity;
import net.petemc.mutantszombies.entity.MutantBruteEntity;
import net.petemc.mutantszombies.entity.RottenMutantEntity;
import net.petemc.mutantszombies.entity.SpitterEntity;
import net.petemc.mutantszombies.entity.SpitterEntityProjectile;
import net.petemc.mutantszombies.entity.SplitHeadZombieEntity;
import net.petemc.mutantszombies.entity.ZombieBruteEntity;

@SideOnly(Side.CLIENT)
public final class ModEntityRenderers {

    private ModEntityRenderers() {}

    public static void register() {
        RenderingRegistry.registerEntityRenderingHandler(
            BlisterZombieEntity.class,
            (RenderManager rm) -> new BlisterZombieRenderer(rm)
        );
        RenderingRegistry.registerEntityRenderingHandler(
            CrawlerEntity.class,
            (RenderManager rm) -> new CrawlerRenderer(rm)
        );
        RenderingRegistry.registerEntityRenderingHandler(
            SpitterEntity.class,
            (RenderManager rm) -> new SpitterRenderer(rm)
        );
        RenderingRegistry.registerEntityRenderingHandler(
            SpitterEntityProjectile.class,
            (RenderManager rm) -> new RenderSnowball<>(rm, Items.SLIME_BALL, net.minecraft.client.Minecraft.getMinecraft().getRenderItem())
        );
        RenderingRegistry.registerEntityRenderingHandler(
            ZombieBruteEntity.class,
            (RenderManager rm) -> new ZombieBruteRenderer(rm)
        );
        RenderingRegistry.registerEntityRenderingHandler(
            SplitHeadZombieEntity.class,
            (RenderManager rm) -> new SplitHeadZombieRenderer(rm)
        );
        RenderingRegistry.registerEntityRenderingHandler(
            MutantBruteEntity.class,
            (RenderManager rm) -> new MutantBruteRenderer(rm)
        );
        RenderingRegistry.registerEntityRenderingHandler(
            RottenMutantEntity.class,
            (RenderManager rm) -> new RottenMutantRenderer(rm)
        );
    }
}
