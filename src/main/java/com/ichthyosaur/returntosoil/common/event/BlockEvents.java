package com.ichthyosaur.returntosoil.common.event;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.common.block.cropblock.RTSCropsBlock;
import com.ichthyosaur.returntosoil.core.init.ItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ReturnToSoil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockEvents {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final IntegerProperty FUEL_LEVEL = ReturnToSoil.FUEL_LEVEL;

    @SubscribeEvent
    public static void onGrassBreak (BlockEvent.BreakEvent event) {
        BlockState state = event.getState();
        if (state.getBlock()== Blocks.GRASS && rollChance.roll(30) && !event.getPlayer().isCreative() && !event.getWorld().isClientSide()) {
            BlockPos pos = event.getPos();
            ServerWorld worldIn = (ServerWorld) event.getWorld();
            ItemStack originSeed = new ItemStack(ItemInit.ORIGIN_BERRY_SEED.get(),1);
            Block.popResource(worldIn, pos, originSeed);
        }
    }

    @SubscribeEvent
    public static void onCropBreak (BlockEvent.BreakEvent event) {
        BlockState state = event.getState();
        if (state.getBlock() instanceof RTSCropsBlock && !event.getWorld().isClientSide()) {
            if (state.getValue(CropsBlock.AGE)==7 && rollChance.roll(100))  {

            PlayerEntity player = event.getPlayer();
            //RTSConfigMisc.cListIncrease((player.getName().getString()), (int)rollChance.returnRoll(200));
            }
        }
    }

}
