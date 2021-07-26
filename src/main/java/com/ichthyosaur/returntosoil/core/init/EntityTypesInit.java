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

    public static final RegistryObject<EntityType<NomadSnailEntity>> NOMADSNAIL = ENTITY_TYPES.register("nomad_snail",
            () -> EntityType.Builder.of(NomadSnailEntity::new, EntityClassification.AMBIENT)
                    .sized(0.8f,0.8f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "nomad_snail").toString()));

    public static final RegistryObject<EntityType<BaruGaruEntity>> BARUGARU = ENTITY_TYPES.register("baru_garu",
            () -> EntityType.Builder.of(BaruGaruEntity::new, EntityClassification.AMBIENT)
                    .sized(0.7f,0.7f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "baru_garu").toString()));

    //needs high size to remain within sight while going up and down slopes so it don't flash black/ could just be bigger overall too
    public static final RegistryObject<EntityType<BaruGaruSegmentEntity>> BARUGARUSEGMENT = ENTITY_TYPES.register("baru_garu_segment",
            () -> EntityType.Builder.of(BaruGaruSegmentEntity::new, EntityClassification.AMBIENT)
                    .sized(0.5f,1f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "baru_garu_segment").toString()));

    public static final RegistryObject<EntityType<FourTailedFoxEntity>> FOURTAILEDFOX = ENTITY_TYPES.register("four_tailed_fox",
            () -> EntityType.Builder.of(FourTailedFoxEntity::new, EntityClassification.AMBIENT)
                    .sized(1.2f,2.0f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "four_tailed_fox").toString()));

    public static final RegistryObject<EntityType<ElderPoluEntity>> ELDERPOLU = ENTITY_TYPES.register("elder_polu",
            () -> EntityType.Builder.of(ElderPoluEntity::new, EntityClassification.CREATURE)
                    .sized(0.6f,0.5f)
                    .build(new ResourceLocation(RTSMain.MOD_ID, "elder_polu").toString()));



}
