package com.ichthyosaur.returntosoil.common.item.tool;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import com.ichthyosaur.returntosoil.common.entity.SpellEntity;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import net.minecraft.block.Block;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Set;

public class SpellScroll extends AbstractSpellTool{
    public SpellScroll(float p_i48512_1_, float p_i48512_2_, IItemTier p_i48512_3_, Set<Block> p_i48512_4_, Properties p_i48512_5_) {
        super(p_i48512_1_, p_i48512_2_, p_i48512_3_, p_i48512_4_, p_i48512_5_);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {



        SpellEntity entity = EntityTypesInit.SPELL.get().create(world);
        entity.xRot = (float) (player.getViewXRot(1.0F)*Math.PI/180);
        entity.yRot = (float) (player.getViewYRot(1.0F)*Math.PI/180);

        //int xRoot = player.getLookAngle().y
        //1.6 height is eye
        entity.moveTo((double)player.getX() + 0D, (double)player.getY()+1.5D, (double)player.getZ() + 0D, 0.0F, 0.0F);
        world.addFreshEntity(entity);
        //entity.setDeltaMovement(player.getLookAngle());
        entity.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 4.0F, 1.0F);


        return ActionResult.success(player.getItemInHand(hand));
    }
}
