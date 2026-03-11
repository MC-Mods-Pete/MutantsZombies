package net.petemc.mutantszombies.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.petemc.mutantszombies.MutantsZombies;

@Mod.EventBusSubscriber(modid = MutantsZombies.MOD_ID)
public class ModItems {
    public static final SpawnEggItem BLISTER_ZOMBIE_SPAWN_EGG = createEgg("blister_zombie", 0x6E8C5A, 0xC8B49B);
    public static final SpawnEggItem CRAWLER_SPAWN_EGG = createEgg("crawler", 0x4A5240, 0x8C7B6E);
    public static final SpawnEggItem ZOMBIE_BRUTE_SPAWN_EGG = createEgg("zombie_brute", 0x3A5C3A, 0x8C5A3A);
    public static final SpawnEggItem SPITTER_SPAWN_EGG = createEgg("spitter", 0x4A6E4A, 0xB4C86E);
    public static final SpawnEggItem SPLIT_HEAD_ZOMBIE_SPAWN_EGG = createEgg("split_head_zombie", 0x5A6E5A, 0xC8A08C);
    public static final SpawnEggItem MUTANT_BRUTE_SPAWN_EGG = createEgg("mutant_brute", 0x2A4A2A, 0x6E3A2A);
    public static final SpawnEggItem ROTTEN_MUTANT_SPAWN_EGG = createEgg("rotten_mutant", 0x5A7A5A, 0xA0B48C);

    private static SpawnEggItem createEgg(String entityName, int primaryColor, int secondaryColor) {
        ResourceLocation entityId = new ResourceLocation(MutantsZombies.MOD_ID, entityName);
        SpawnEggItem egg = new SpawnEggItem(entityId, primaryColor, secondaryColor);
        egg.setRegistryName(new ResourceLocation(MutantsZombies.MOD_ID, entityName + "_spawn_egg"));
        egg.setUnlocalizedName(MutantsZombies.MOD_ID + "." + entityName + "_spawn_egg");
        egg.setCreativeTab(CreativeTabs.MISC);
        egg.setMaxStackSize(16);
        return egg;
    }

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            BLISTER_ZOMBIE_SPAWN_EGG,
            CRAWLER_SPAWN_EGG,
            ZOMBIE_BRUTE_SPAWN_EGG,
            SPITTER_SPAWN_EGG,
            SPLIT_HEAD_ZOMBIE_SPAWN_EGG,
            MUTANT_BRUTE_SPAWN_EGG,
            ROTTEN_MUTANT_SPAWN_EGG
        );
    }

    public static void register(Object ignoredEventBus) {
        // 1.12 registriert Items ueber RegistryEvent
    }

    public static class SpawnEggItem extends Item {
        private final ResourceLocation entityId;
        private final int primaryColor;
        private final int secondaryColor;

        public SpawnEggItem(ResourceLocation entityId, int primaryColor, int secondaryColor) {
            this.entityId = entityId;
            this.primaryColor = primaryColor;
            this.secondaryColor = secondaryColor;
        }

        public int getColor(int tintIndex) {
            return tintIndex == 0 ? this.primaryColor : this.secondaryColor;
        }

        @Override
        public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
            ItemStack stack = player.getHeldItem(hand);
            BlockPos spawnPos = pos.offset(facing);

            if (!player.canPlayerEdit(spawnPos, facing, stack)) {
                return EnumActionResult.FAIL;
            }

            if (!world.isRemote) {
                Entity entity = EntityList.createEntityByIDFromName(this.entityId, world);
                if (entity == null) {
                    return EnumActionResult.FAIL;
                }

                entity.setLocationAndAngles(spawnPos.getX() + 0.5D, spawnPos.getY(), spawnPos.getZ() + 0.5D, world.rand.nextFloat() * 360.0F, 0.0F);
                if (entity instanceof EntityLiving) {
                    ((EntityLiving) entity).onInitialSpawn(world.getDifficultyForLocation(spawnPos), null);
                }

                world.spawnEntity(entity);
                world.playSound(null, spawnPos, net.minecraft.init.SoundEvents.ENTITY_CHICKEN_EGG, SoundCategory.NEUTRAL, 0.5F, 1.0F);
                if (!player.capabilities.isCreativeMode) {
                    stack.shrink(1);
                }
            }

            return EnumActionResult.SUCCESS;
        }

        @Override
        public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
            return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
        }
    }

    @Mod.EventBusSubscriber(modid = MutantsZombies.MOD_ID, value = Side.CLIENT)
    public static class ClientOnly {
        @SubscribeEvent
        public static void onRegisterModels(ModelRegistryEvent event) {
            Item[] eggs = {
                BLISTER_ZOMBIE_SPAWN_EGG,
                CRAWLER_SPAWN_EGG,
                ZOMBIE_BRUTE_SPAWN_EGG,
                SPITTER_SPAWN_EGG,
                SPLIT_HEAD_ZOMBIE_SPAWN_EGG,
                MUTANT_BRUTE_SPAWN_EGG,
                ROTTEN_MUTANT_SPAWN_EGG
            };
            for (Item egg : eggs) {
                ModelLoader.setCustomModelResourceLocation(
                    egg,
                    0,
                    new ModelResourceLocation(egg.getRegistryName(), "inventory")
                );
            }
        }

        @SubscribeEvent
        public static void onRegisterItemColors(ColorHandlerEvent.Item event) {
            Item[] eggs = {
                BLISTER_ZOMBIE_SPAWN_EGG,
                CRAWLER_SPAWN_EGG,
                ZOMBIE_BRUTE_SPAWN_EGG,
                SPITTER_SPAWN_EGG,
                SPLIT_HEAD_ZOMBIE_SPAWN_EGG,
                MUTANT_BRUTE_SPAWN_EGG,
                ROTTEN_MUTANT_SPAWN_EGG
            };
            event.getItemColors().registerItemColorHandler(
                (stack, tintIndex) -> {
                    Item item = stack.getItem();
                    if (item instanceof SpawnEggItem) {
                        return ((SpawnEggItem) item).getColor(tintIndex);
                    }
                    return 0xFFFFFF;
                },
                eggs
            );
        }
    }
}
