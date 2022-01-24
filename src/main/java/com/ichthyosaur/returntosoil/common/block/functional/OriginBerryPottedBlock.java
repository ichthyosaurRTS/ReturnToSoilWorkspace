package com.ichthyosaur.returntosoil.common.block.functional;

import com.ichthyosaur.returntosoil.core.config.RTSConfigMisc;
import javafx.scene.paint.Color;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class OriginBerryPottedBlock extends RTSPottedBlock{

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public OriginBerryPottedBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult p_225533_6_) {

        if (world.isClientSide()){

            int lvl =  RTSConfigMisc.cListGetLvl(player.getName().getString());
            StringTextComponent text = new StringTextComponent("Cultivation Level: "+lvl);

            if (lvl<10000) text.setStyle(text.getStyle().withColor(TextFormatting.WHITE));
            else if (lvl<20000) text.setStyle(text.getStyle().withColor(TextFormatting.GREEN));
            else if (lvl<40000) text.setStyle(text.getStyle().withColor(TextFormatting.LIGHT_PURPLE));
            else if (lvl<70000) text.setStyle(text.getStyle().withColor(TextFormatting.BLUE));
            else if (lvl<100000) text.setStyle(text.getStyle().withColor(TextFormatting.AQUA));
            else if (lvl<200000) text.setStyle(text.getStyle().withColor(TextFormatting.GOLD));
            else {
                text = new StringTextComponent("True Warrior");
                text.setStyle(text.getStyle().withColor(TextFormatting.DARK_GRAY));
                for (int i=0;i<5;i++)
                world.addParticle(ParticleTypes.WARPED_SPORE,
                        pos.getX()+0.5, pos.getY()+0.8, pos.getZ()+0.5, 0.0D, 1.0D, 0.0D);

            }

            player.displayClientMessage( text, true);
            return ActionResultType.SUCCESS;
        }
        return super.use(state, world, pos, player, hand, p_225533_6_);

    }
}
