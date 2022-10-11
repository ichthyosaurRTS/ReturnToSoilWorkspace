package com.ichthyosaur.returntosoil.common.item.tool;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.common.entity.SpellEntity;
import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Set;

public class SpellScroll extends AbstractSpellTool{
    public SpellScroll(float p_i48512_1_, float p_i48512_2_, IItemTier p_i48512_3_, Set<Block> p_i48512_4_, Properties p_i48512_5_) {
        super(p_i48512_1_, p_i48512_2_, p_i48512_3_, p_i48512_4_, p_i48512_5_);
    }

    @Override
    public void inventoryTick(ItemStack stack, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
        super.inventoryTick(stack, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
        //stack.getAttributeModifiers(EquipmentSlotType.MAINHAND);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {


        if (!world.isClientSide()) {
            //ServerMagicEffects.addEffect(player.getStringUUID());
        }

        //IT DOES REMEMBER TAGS JUST DONT GO REPLACING THE NBT EVERY TIME, RATHER CHECK NBT.contains and then add
        //remember we need to leave room for things like durability, or tag editing by other mods so cant make a new nbt tag every time,
        //just edit the existing.
        //player.getItemInHand(hand).getTag();
        //CompoundNBT newTag = new CompoundNBT();
        //newTag.putInt("Damage", 100);
        //newTag.putInt("Damage2", 100);
        //newTag.putString("Spell2", "P.D12.K3.P61-");
        //player.getItemInHand(hand).setTag(newTag);
        //remember if this is null itll crash.
        //if (player.getItemInHand(hand).getTag().contains("Damage2")) {
        ReturnToSoil.LOGGER.info(Objects.requireNonNull(player.getItemInHand(hand).getTag()));
        //looks like we need to remove the nbt before adding a new one.
        //newTag.remove("Damage");
        //}

        if (world.isClientSide()) {
            player.playSound(SoundEvents.NETHER_BRICKS_HIT,1,1);
        }

        SpellEntity entity = EntityTypesInit.SPELL.get().create(world);
        //entity.xRot = (float) (player.getViewXRot(1.0F)*Math.PI/180);
        //entity.yRot = (float) (player.getViewYRot(1.0F)*Math.PI/180);

        //-90 up, 90 down
        //ReturnToSoil.LOGGER.info(player.getViewXRot(1));
        //0 to -360
        //ReturnToSoil.LOGGER.info(player.getViewYRot(1));

        //player.addTag("trun");
        //ReturnToSoil.LOGGER.info(player.getTags());

        entity.setYRot((int)-(player.getViewYRot(1)));
        entity.setXRot((int)-(player.getViewXRot(1)));

        //int xRoot = player.getLookAngle().y
        //1.6 height is eye
        entity.moveTo((double)player.getX() + 0D, (double)player.getY()+1.4D, (double)player.getZ() + 0D, 0.0F, 0.0F);

        //entity.setDeltaMovement(player.getLookAngle());



        entity.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.4F, 1.0F);
        world.addFreshEntity(entity);

        /*if (world.isClientSide())
            world.addParticle(ParticleTypesInit.LIGHT_BALL_PARTICLE.get(),
                    player.getX(), player.getY()+0.2, player.getZ(), player.getLookAngle().x()*20,player.getLookAngle().y()*20,player.getLookAngle().z()*20);*/


        return ActionResult.success(player.getItemInHand(hand));
    }



}
