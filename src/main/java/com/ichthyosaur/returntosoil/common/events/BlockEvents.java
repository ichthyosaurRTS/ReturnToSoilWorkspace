package com.ichthyosaur.returntosoil.common.events;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.entity.AbstractContractEntity;
import com.ichthyosaur.returntosoil.common.entity.AbstractFlyingSegmentEntity;
import com.ichthyosaur.returntosoil.common.tileentity.CeruleanCoralTileEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = RTSMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockEvents {

    private static final IntegerProperty COOL_DOWN = RTSMain.COOL_DOWN;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;

    @SubscribeEvent
    public static void onGrassBreak (BlockEvent.BreakEvent event) {
        BlockState state = event.getState();
        if (state.getBlock()== Blocks.GRASS && rollChance.roll(30) && !event.getPlayer().isCreative()) {
            BlockPos pos = event.getPos();
            ServerWorld worldIn = (ServerWorld) event.getWorld();
            ItemStack originSeed = new ItemStack(BlockItemInit.ORIGIN_BERRY_SEED.get(),1);
            Block.popResource(worldIn, pos, originSeed);
        }
    }


    //normally sets the target of tile entities, but given how simple ceru coral is, its more efficient to plonk it in here
    // rather than iterate thru 2 sets on the te side (one set to act as a buffer and avoid concurrent actions)
    @SubscribeEvent
    public static void threeCubeTE (LivingEvent event) {

        /*if ( event.getEntityLiving() != null) {
            LivingEntity entity = event.getEntityLiving();
            World world = entity.level;


            BlockPos inPos = new BlockPos (entity.getPosition(1));

            for (int x = -1; x < 2; x++) {
                for (int z = -1; z < 2; z++) {
                    for (int y = -4; y < 1; y++) {

                        BlockPos targetPos = new BlockPos(inPos.getX()+x,inPos.getY()+y,inPos.getZ()+z);
                        BlockState targetState = world.getBlockState(targetPos);

                        if (targetState.getBlock().hasTileEntity(targetState)) {
                            TileEntity te = world.getBlockEntity(targetPos);

                                if (te instanceof CeruleanCoralTileEntity && !( (entity instanceof AbstractContractEntity) || entity instanceof AbstractFlyingSegmentEntity)) {
                                    if (targetState.getValue(FUEL_LEVEL) == 1 && entity.getDeltaMovement().y()< 0.04)
                                        entity.setDeltaMovement(entity.getDeltaMovement().x(), entity.getDeltaMovement().y()+0.03, entity.getDeltaMovement().z());
                                }
                        }
                    }
                }
            }
        }*/
    }
}
