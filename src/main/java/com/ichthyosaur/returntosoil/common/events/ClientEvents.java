package com.ichthyosaur.returntosoil.common.events;

import com.ichthyosaur.returntosoil.RTSMain;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = RTSMain.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    public static void addLayers()
    {
    }

    @SubscribeEvent
    public static void backPackItem (TickEvent.PlayerTickEvent event) {
    }
}
