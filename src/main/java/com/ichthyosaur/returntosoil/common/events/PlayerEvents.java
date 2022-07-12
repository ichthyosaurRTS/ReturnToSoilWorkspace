package com.ichthyosaur.returntosoil.common.events;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.client.entity.model.JawBeetleModel;
import com.ichthyosaur.returntosoil.client.entity.renderer.JawBeetleRenderer;
import com.ichthyosaur.returntosoil.common.entity.JawBeetleEntity;
import com.ichthyosaur.returntosoil.core.config.RTSConfigMisc;
import com.ichthyosaur.returntosoil.core.util.ServerMagicEffects;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderNameplateEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@Mod.EventBusSubscriber(modid = ReturnToSoil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEvents {

    static float oldYRot;

    @SubscribeEvent
    public static void CultivationDefenseBonus (LivingDamageEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)event.getEntity();
            if (!player.level.isClientSide()) {
                int cLvl = RTSConfigMisc.cListGetLvl(player.getName().getString());
                double dmgMod = 1.0;
                if (cLvl<10000) {}
                else if (cLvl<20000) dmgMod = 1.25;
                else if (cLvl<40000) dmgMod = 1.5;
                else if (cLvl<70000) dmgMod = 1.75;
                else if (cLvl<100000) dmgMod = 2;
                else dmgMod = 2.5;

                event.setAmount( (float) (event.getAmount()/dmgMod));
            }
        }
    }

    @SubscribeEvent
    public static void CultivationOffensePenalty (LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)event.getSource().getEntity();
            if (!player.level.isClientSide()) {
                int cLvl = RTSConfigMisc.cListGetLvl(player.getName().getString());
                double dmgMod = 1.0;
                if (cLvl<10000) {}
                else if (cLvl<20000) dmgMod = 1.25;
                else if (cLvl<40000) dmgMod = 1.5;
                else if (cLvl<70000) dmgMod = 1.75;
                else if (cLvl<100000) dmgMod = 2;
                else dmgMod = 2.5;

                float newAmount = (float) (event.getAmount()/dmgMod);
                //if (newAmount < 1) event.setAmount(1);
                event.setAmount(newAmount);
            }
        }
    }

    //just for proof of concept, doesn't go here.
    @SubscribeEvent
    public static void WorldTick (TickEvent.WorldTickEvent event) {
        if (!event.world.isClientSide()) {
            ServerMagicEffects.tickMagicEffectList((ServerWorld) event.world);
        }
    }

    @SubscribeEvent
    public static void ServerStart (FMLServerAboutToStartEvent event) {

        ServerMagicEffects.createList();
    }

    @SubscribeEvent
    public static void onRenderPlayerPre (RenderPlayerEvent.Pre event) {

        JawBeetleModel model = new JawBeetleModel();
        Minecraft instance = Minecraft.getInstance();

        PlayerEntity player = event.getPlayer();

        event.setCanceled(true);

        MatrixStack stack = event.getMatrixStack();

        stack.pushPose();
        stack.translate(0,1.5,0);
        stack.scale(1F, 1F, 1F);
        float newRot = rollChance.rotLerp(oldYRot, -player.getYHeadRot(),10);
        stack.mulPose(Vector3f.YP.rotationDegrees(-instance.gameRenderer.getMainCamera().getYRot()));
        stack.mulPose(Vector3f.XP.rotationDegrees(180.0F));

        instance.gameRenderer.getMainCamera().getYRot();
        //Minecraft.getInstance().getItemRenderer().renderAndDecorateFakeItem(new ItemStack(Items.DIRT), 1, 1);

        IVertexBuilder ivertexbuilder = net.minecraft.client.renderer.ItemRenderer.getFoilBufferDirect(event.getBuffers(), RenderType.entityTranslucent(new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/jaw_beetle/jaw_beetle_1.png")), false,false);
        model.renderToBuffer(stack, ivertexbuilder, event.getLight(), OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        stack.popPose();
        oldYRot = newRot;
    }

    @SubscribeEvent
    public static void onRenderNameplate(RenderNameplateEvent event) {
        event.setResult(Event.Result.DENY);
    }

    @SubscribeEvent
    public static void onEntitySize(EntityEvent.Size event)
    {
        if(event.getEntity() instanceof PlayerEntity)
        {
            event.setNewSize(new EntitySize(1,1, true));
            event.setNewEyeHeight(0.5F);
        }
    }

    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event) {
        event.setCanceled(true);
    }


}
