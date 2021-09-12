package com.ichthyosaur.returntosoil.common.events;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.block.cropblock.SpringLeafBlock;
import com.ichthyosaur.returntosoil.common.block.functional.RTSPottedBlock;
import com.ichthyosaur.returntosoil.common.block.functional.SpringLeafPottedBlock;
import com.ichthyosaur.returntosoil.common.entity.AbstractContractEntity;
import com.ichthyosaur.returntosoil.common.tileentity.CeruleanCoralTileEntity;
import com.ichthyosaur.returntosoil.common.tileentity.IHoldsTarget;
import com.ichthyosaur.returntosoil.common.tileentity.SpringLeafTileEntity;
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


    public static void springTargetSet (LivingEvent event) {

        if ( event.getEntityLiving() != null) {
            LivingEntity entity = event.getEntityLiving();
            World world = entity.level;
            BlockState inState = entity.getFeetBlockState();
            BlockPos in = new BlockPos (entity.getPosition(1));

            if (inState.hasTileEntity() && inState.getBlock() instanceof SpringLeafPottedBlock)
            {
                if (world.getBlockEntity(in) instanceof IHoldsTarget)
                    ((IHoldsTarget) Objects.requireNonNull(world.getBlockEntity(in))).setTarget(entity);
            }
        }
    }

    @SubscribeEvent
    public static void threeCubeTE (LivingEvent event) {

        //this doesn't work if its only serverside...
        if ( event.getEntityLiving() != null) {
            LivingEntity entity = event.getEntityLiving();
            World world = entity.level;
            BlockPos inPos = new BlockPos (entity.getPosition(1));

            for (int x = -1; x < 2; x++) {
                for (int z = -1; z < 2; z++) {
                    for (int y = -4; y < 1; y++) {

                        BlockPos targetPos = new BlockPos(inPos.getX()+x,inPos.getY()+y,inPos.getZ()+z);
                        BlockState targetState = world.getBlockState(targetPos);

                        if (targetState.getBlock() instanceof RTSPottedBlock) {

                        if (targetState.getBlock().hasTileEntity(targetState)) {
                            TileEntity te = world.getBlockEntity(targetPos);
                            if (te instanceof IHoldsTarget) {

                                if (te instanceof CeruleanCoralTileEntity && !(entity instanceof AbstractContractEntity)) {
                                    if (((CeruleanCoralTileEntity) te).getSpiritLevel()>5 && entity.getDeltaMovement().y()< 0.04)
                                        entity.setDeltaMovement(entity.getDeltaMovement().x(), entity.getDeltaMovement().y()+0.03, entity.getDeltaMovement().z());
                                }

                                else if (te instanceof SpringLeafTileEntity) {
                                    if (x==0&&z==0&&y==0) {
                                        entity.setDeltaMovement(entity.getDeltaMovement().x(), entity.getDeltaMovement().y()+5, entity.getDeltaMovement().z());
                                        ((SpringLeafTileEntity) te).resetCoolDown();
                                    }
                                }

                            }}
                        }
                    }
                }
            }
        }
    }
}
