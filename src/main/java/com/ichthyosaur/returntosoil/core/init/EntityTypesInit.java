package com.ichthyosaur.returntosoil.core.init;

import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.common.entity.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypesInit {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ReturnToSoil.MOD_ID);

    public static final RegistryObject<EntityType<GrubEntity>> HUSKLARVAE = ENTITY_TYPES.register("husk_larvae",
            () -> EntityType.Builder.of(GrubEntity::new, EntityClassification.CREATURE)
                    .sized(0.7f,0.7f)
                    .build(new ResourceLocation(ReturnToSoil.MOD_ID, "husk_larvae").toString()));

    public static final RegistryObject<EntityType<BeetleEntity>> JAWBEETLE = ENTITY_TYPES.register("jaw_beetle",
            () -> EntityType.Builder.of(BeetleEntity::new, EntityClassification.MONSTER)
                    .sized(1.0f,1.0f)
                    .build(new ResourceLocation(ReturnToSoil.MOD_ID, "jaw_beetle").toString()));

    public static final RegistryObject<EntityType<DragonflyEntity>> DRAGONFLY = ENTITY_TYPES.register("dragonfly",
            () -> EntityType.Builder.of(DragonflyEntity::new, EntityClassification.MONSTER)
                    .sized(0.8f,0.8f)
                    .build(new ResourceLocation(ReturnToSoil.MOD_ID, "dragonfly").toString()));

    public static final RegistryObject<EntityType<CentipedeEntity>> BARUGARU = ENTITY_TYPES.register("baru_garu",
            () -> EntityType.Builder.of(CentipedeEntity::new, EntityClassification.AMBIENT)
                    .sized(0.7f,0.7f)
                    .build(new ResourceLocation(ReturnToSoil.MOD_ID, "baru_garu").toString()));

    //needs high size to remain within sight while going up and down slopes so it don't flash black/ could just be bigger overall too
    public static final RegistryObject<EntityType<CentipedePartEntity>> BARUGARUSEGMENT = ENTITY_TYPES.register("baru_garu_segment",
            () -> EntityType.Builder.of(CentipedePartEntity::new, EntityClassification.AMBIENT)
                    .sized(0.5f,1f)
                    .build(new ResourceLocation(ReturnToSoil.MOD_ID, "baru_garu_segment").toString()));

    public static final RegistryObject<EntityType<VesselEntity>> VESSEL = ENTITY_TYPES.register("vessel",
            () -> EntityType.Builder.of(VesselEntity::new, EntityClassification.CREATURE)
                    .sized(0.5f,0.4f)
                    .build(new ResourceLocation(ReturnToSoil.MOD_ID, "vessel").toString()));

    public static final RegistryObject<EntityType<PartEntity>> GENERALFLYINGSEGMENT = ENTITY_TYPES.register("general_flying_segment",
            () -> EntityType.Builder.of(PartEntity::new, EntityClassification.CREATURE)
                    .sized(0.3f,0.3f)
                    .build(new ResourceLocation(ReturnToSoil.MOD_ID, "general_flying_segment").toString()));

    public static final RegistryObject<EntityType<GawanHeadEntity>> GAWANHEAD = ENTITY_TYPES.register("gawan_head",
            () -> EntityType.Builder.of(GawanHeadEntity::new, EntityClassification.MONSTER)
                    .sized(0.4f,0.4f)
                    .build(new ResourceLocation(ReturnToSoil.MOD_ID, "gawan_head").toString()));

    public static final RegistryObject<EntityType<SpellEntity>> SPELL = ENTITY_TYPES.register("spell",
            () -> EntityType.Builder.of(SpellEntity::new, EntityClassification.MISC)
                    .sized(0.2f,0.2f)
                    .build(new ResourceLocation(ReturnToSoil.MOD_ID, "spell").toString()));

}
