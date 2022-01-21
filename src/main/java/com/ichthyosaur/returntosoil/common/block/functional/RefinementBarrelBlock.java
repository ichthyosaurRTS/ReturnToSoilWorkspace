package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.tileentity.IHoldsSpirit;
import com.ichthyosaur.returntosoil.common.tileentity.RefinementBarrelTileEntity;
import com.ichthyosaur.returntosoil.core.init.BlockItemInit;
import com.ichthyosaur.returntosoil.core.init.TileEntityTypesInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class RefinementBarrelBlock extends Block {

    public static final IntegerProperty FUEL_LEVEL = RTSMain.FUEL_LEVEL;

    //models based on fuel level
    public RefinementBarrelBlock(Properties prop) {
        super(prop);
        this.registerDefaultState(this.stateDefinition.any().setValue(FUEL_LEVEL,0));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FUEL_LEVEL);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.REFINEMENT_BARREL_TILE_ENTITY_TYPE.get().create();
    }

    @Override
    public void onPlace(BlockState p_220082_1_, World p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
        if (p_220082_2_.getBlockEntity(p_220082_3_) == null) this.createTileEntity(p_220082_1_, p_220082_2_);
        super.onPlace(p_220082_1_, p_220082_2_, p_220082_3_, p_220082_4_, p_220082_5_);
    }


    @ParametersAreNonnullByDefault
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {

        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();


        if (item == BlockItemInit.ORIGIN_JAM_ITEM.get() && state.getValue(FUEL_LEVEL) < 4) {

            if (!world.isClientSide()) {

                int newFuelLevel = state.getValue(FUEL_LEVEL) + 1;
                BlockState news = state.setValue(FUEL_LEVEL,newFuelLevel);
                world.setBlock(pos, news,2);
                itemstack.shrink(1);

                ItemStack returnDrop = new ItemStack(Items.GLASS_BOTTLE, 1);
                player.inventory.add(returnDrop);

            }

            player.playSound(SoundEvents.SALMON_FLOP,1,1 );
            return ActionResultType.SUCCESS;


        }

        else if (item == BlockItemInit.BOTTLED_SPIRIT_ITEM.get() && state.getValue(FUEL_LEVEL) == 4) {

            if (!world.isClientSide()) {

                int newFuelLevel = 5;
                BlockState news = state.setValue(FUEL_LEVEL, newFuelLevel);
                world.setBlock(pos, news, 2);
                itemstack.shrink(1);

                ItemStack returnDrop = new ItemStack(Items.GLASS_BOTTLE, 1);
                player.inventory.add(returnDrop);

                RefinementBarrelTileEntity te = (RefinementBarrelTileEntity) world.getBlockEntity(pos);
                te.resetProgress();
                te.addSpirit();
            }

            player.playSound(SoundEvents.BREWING_STAND_BREW, 1, 1);
            return ActionResultType.SUCCESS;

        }

        else if (item == BlockItemInit.BOTTLED_SPIRIT_ITEM.get() && state.getValue(FUEL_LEVEL) == 5) {

            if (!world.isClientSide()) {
            RefinementBarrelTileEntity te = (RefinementBarrelTileEntity) world.getBlockEntity(pos);
            if (te.addSpirit()) {
                itemstack.shrink(1);
            } }

            player.playSound(SoundEvents.LAVA_AMBIENT,1,1 );
            return ActionResultType.SUCCESS;
        }

        else if (item == BlockItemInit.VESSEL_SAC_ITEM.get() && state.getValue(FUEL_LEVEL) == 5) {

            if (!world.isClientSide()) {
            int newFuelLevel = 6;
            BlockState news = state.setValue(FUEL_LEVEL, newFuelLevel);
            world.setBlock(pos, news, 2);
            itemstack.shrink(1);

            RefinementBarrelTileEntity te = (RefinementBarrelTileEntity) world.getBlockEntity(pos);
            te.resetProgress();
            }

            player.playSound(SoundEvents.BUCKET_FILL_LAVA, 1, 1);
            player.playSound(SoundEvents.GHAST_SCREAM, 1, 1);
            return ActionResultType.SUCCESS;

        }

        else if (item == Items.GLASS_BOTTLE && state.getValue(FUEL_LEVEL) == 7) {

            if (!world.isClientSide()) {
                int newFuelLevel = 0;
                BlockState news = state.setValue(FUEL_LEVEL, newFuelLevel);
                world.setBlock(pos, news, 2);
                itemstack.shrink(1);
                Block.popResource(world, pos.above(), new ItemStack(BlockItemInit.MAGICAL_BLOOD_ITEM.get()));

                RefinementBarrelTileEntity te = (RefinementBarrelTileEntity) world.getBlockEntity(pos);
                te.resetProgress();
            }

            player.playSound(SoundEvents.GHAST_WARN, 1, 1);
            return ActionResultType.SUCCESS;

        }

        return ActionResultType.PASS;
    }

    public ActionResultType use(World p_227031_1_, PlayerEntity p_227031_2_, Hand p_227031_3_, BlockRayTraceResult p_227031_4_) {
        return this.getBlock().use(p_227031_1_.getBlockState(p_227031_4_.getBlockPos()), p_227031_1_, p_227031_4_.getBlockPos(), p_227031_2_, p_227031_3_, p_227031_4_);
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random p_180655_4_) {

        //interestingly, animatetick is not called every tick...
        /*
        if (state.getValue(FUEL_LEVEL)>0 && state.getValue(FUEL_LEVEL)<5 && rollChance.roll(15))
            world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                    pos.getX()+0.5, pos.getY()+0.8, pos.getZ()+0.5, 0.0D, 0.03D, 0.0D);

        else if (state.getValue(FUEL_LEVEL)==5) {
            for (int i=1;i<30;i++){
            double bubbleOffsetX = (rollChance.returnRoll(10) - 5) / 30;
            double bubbleOffsetZ = (rollChance.returnRoll(10) - 5) / 30;
            world.addParticle(ParticleTypes.EFFECT,
                    pos.getX() + 0.5 + bubbleOffsetX, pos.getY() + 0.8, pos.getZ() + 0.5 + bubbleOffsetZ, 0.0D, 0.03D, 0.0D);
        }
        }*/


    }

    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    @ParametersAreNonnullByDefault
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean propagatesSkylightDown(BlockState p_200123_1_, IBlockReader p_200123_2_, BlockPos p_200123_3_) {
        return p_200123_1_.getFluidState().isEmpty();
    }

}
