package de.thirst.reworkedmod.block.custom;

import de.thirst.reworkedmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1.5f, 1f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            ItemStack stack = itemEntity.getStack();
            if(stack.getItem() == ModItems.RAW_BLUE_GARNET) {
                stack.setDamage(0);
                Random random = new Random();
                if(random.nextInt(100) < 30) {
                    world.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 1f, 1f);
                    for (int i = 0; i < 5; i++) {
                        double offsetX = random.nextDouble() * 0.2 - 0.1;
                        double offsetY = random.nextDouble() * 0.2 - 0.1;
                        double offsetZ = random.nextDouble() * 0.2 - 0.1;
                        world.addParticle(ParticleTypes.EXPLOSION, true, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, 0.0D, 0.0D, 0.0D);
                    }
                    int diamondCount = stack.getCount();
                    stack.setCount(0);
                    ItemEntity diamondItem = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.DIAMOND, diamondCount));
                    world.spawnEntity(diamondItem);
                } else {
                    itemEntity.remove(Entity.RemovalReason.DISCARDED);
                }
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.reworkedmod.magic_block.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
