package com.ichthyosaur.returntosoil.core.init;

import com.ichthyosaur.returntosoil.RTSMain;
import com.ichthyosaur.returntosoil.common.entity.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypesInit {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, RTSMain.MOD_ID);

    public static final RegistryObject<EntityType<HuskLarvaeEntity>> HUSKLARVAE = ENTITY_TYPES.register("husk_larvae",
            () -> EntityType.Builder.of(HuskLarvaeEntity::new, EntityClassification.CREATURE)
                    .sized(0.7f,0.7f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "husk_larvae").toString()));

    public static final RegistryObject<EntityType<JawBeetleEntity>> JAWBEETLE = ENTITY_TYPES.register("jaw_beetle",
            () -> EntityType.Builder.of(JawBeetleEntity::new, EntityClassification.MONSTER)
                    .sized(1.0f,1.0f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "jaw_beetle").toString()));

    public static final RegistryObject<EntityType<BaruGaruEntity>> BARUGARU = ENTITY_TYPES.register("baru_garu",
            () -> EntityType.Builder.of(BaruGaruEntity::new, EntityClassification.AMBIENT)
                    .sized(0.7f,0.7f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "baru_garu").toString()));

    //needs high size to remain within sight while going up and down slopes so it don't flash black/ could just be bigger overall too
    public static final RegistryObject<EntityType<BaruGaruSegmentEntity>> BARUGARUSEGMENT = ENTITY_TYPES.register("baru_garu_segment",
            () -> EntityType.Builder.of(BaruGaruSegmentEntity::new, EntityClassification.AMBIENT)
                    .sized(0.5f,1f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "baru_garu_segment").toString()));

    public static final RegistryObject<EntityType<BallFrogEntity>> BALLFROG = ENTITY_TYPES.register("ball_frog",
            () -> EntityType.Builder.of(BallFrogEntity::new, EntityClassification.CREATURE)
                    .sized(0.6f,0.6f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "ball_frog").toString()));

    public static final RegistryObject<EntityType<VesselEntity>> VESSEL = ENTITY_TYPES.register("vessel",
            () -> EntityType.Builder.of(VesselEntity::new, EntityClassification.CREATURE)
                    .sized(0.5f,0.4f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "vessel").toString()));

    public static final RegistryObject<EntityType<GeneralFlyingSegmentEntity>> GENERALFLYINGSEGMENT = ENTITY_TYPES.register("general_flying_segment",
            () -> EntityType.Builder.of(GeneralFlyingSegmentEntity::new, EntityClassification.CREATURE)
                    .sized(0.3f,0.3f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "general_flying_segment").toString()));

    public static final RegistryObject<EntityType<WarraRupeHeadEntity>> WARRARUPEHEAD = ENTITY_TYPES.register("warra_rupe_head",
            () -> EntityType.Builder.of(WarraRupeHeadEntity::new, EntityClassification.CREATURE)
                    .sized(0.3f,0.3f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "warra_rupe_head").toString()));

    public static final RegistryObject<EntityType<TallSnailEntity>> TALLSNAIL = ENTITY_TYPES.register("tall_snail",
            () -> EntityType.Builder.of(TallSnailEntity::new, EntityClassification.MONSTER)
                    .sized(0.5f,0.5f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "tall_snail").toString()));

    public static final RegistryObject<EntityType<GawanHeadEntity>> GAWANHEAD = ENTITY_TYPES.register("gawan_head",
            () -> EntityType.Builder.of(GawanHeadEntity::new, EntityClassification.MONSTER)
                    .sized(0.8f,0.8f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "gawan_head").toString()));

}
