package com.ichthyosaur.returntosoil.common.entity;

import com.google.common.collect.Maps;
import com.ichthyosaur.returntosoil.ReturnToSoil;
import com.ichthyosaur.returntosoil.common.item.wearable.CentipedeHelm;
import com.ichthyosaur.returntosoil.core.init.ItemInit;
import com.ichthyosaur.returntosoil.core.util.rollChance;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Random;

public class BeetleEntity extends MonsterEntity {

    //private final int COLOUR_INT;
    private static final DataParameter<Integer> COLOUR_INT = EntityDataManager.defineId(CatEntity.class, DataSerializers.INT);

    public BeetleEntity(EntityType<? extends MonsterEntity> p_i48576_1_, World p_i48576_2_) {
        super(p_i48576_1_, p_i48576_2_);
    }
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, (double)0.1F);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(COLOUR_INT,1);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 4.0D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 4.0D, false)); //that float is move speed or atleast a mod
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0f));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PigEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, true));
    }

    private int getColourInt() {
     return this.entityData.get(COLOUR_INT);
    }

    public void setColourIntData() {
        int i;
        if (rollChance.roll(200)) i = 0;
        else if (rollChance.roll(1000)) i = 6;
        else if (rollChance.roll(5000)) i = 5;
        else if (rollChance.roll(20)) i = 3;
        else if (rollChance.roll(500)) i = 4;
        else {
            Random rand = new Random();
            i = rand.nextInt(2);
            i+=1;
        }

        this.entityData.set(COLOUR_INT, i);
    }

    public void addAdditionalSaveData(CompoundNBT NBT) {
        super.addAdditionalSaveData(NBT);
        NBT.putInt("ColourNumber", this.getColourInt());
    }

    public void readAdditionalSaveData(CompoundNBT NBT) {
        super.readAdditionalSaveData(NBT);
        this.entityData.set(COLOUR_INT, (NBT.getInt("ColourNumber")));
    }

    public ResourceLocation getResourceLocation() {
        return COLOUR_BY_INT.getOrDefault(this.getColourInt(),new ResourceLocation(ReturnToSoil.MOD_ID, "textures/entity/jaw_beetle/jaw_beetle_1.png") );
    }

    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        p_213386_4_ = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
        this.setColourIntData();
        return p_213386_4_;
    }

    protected void dropCustomDeathLoot(DamageSource damage, int i, boolean bool) {
        super.dropCustomDeathLoot(damage, i, bool);
        if (this.entityData.get(COLOUR_INT) == 0 && rollChance.roll(3)) this.spawnAtLocation(ItemInit.ROSE_BEETLE_ITEM.get());
        else if (this.entityData.get(COLOUR_INT) == 6 && rollChance.roll(2)) this.spawnAtLocation(ItemInit.GHOST_BEETLE_ITEM.get());
    }

    @Override
    public boolean hurt(DamageSource src, float amt) {
        if (src.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) src.getEntity();
            if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof CentipedeHelm){
                amt = (float) (amt * 2.5);
            }
        }
        return super.hurt(src, amt);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.BONE_BLOCK_BREAK;
    }

    public static final Map<Integer, ResourceLocation> COLOUR_BY_INT = Util.make(Maps.newHashMap(), (map) -> {
        map.put(0, new ResourceLocation("returntosoil:textures/entity/jaw_beetle/jaw_beetle_0.png"));
        map.put(1, new ResourceLocation("returntosoil:textures/entity/jaw_beetle/jaw_beetle_1.png"));
        map.put(2, new ResourceLocation("returntosoil:textures/entity/jaw_beetle/jaw_beetle_2.png"));
        map.put(3, new ResourceLocation("returntosoil:textures/entity/jaw_beetle/jaw_beetle_3.png"));
        map.put(4, new ResourceLocation("returntosoil:textures/entity/jaw_beetle/jaw_beetle_4.png"));
        map.put(5, new ResourceLocation("returntosoil:textures/entity/jaw_beetle/jaw_beetle_5.png"));
        map.put(6, new ResourceLocation("returntosoil:textures/entity/jaw_beetle/jaw_beetle_6.png"));
    });


    //This works fine but using custom loot is honestly just easier.
    /*
    protected void dropFromLootTable(DamageSource dmgSource, boolean bool) {
        LootTable loottable = LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantRange.exactly(1)).add(ItemLootEntry.lootTableItem(ItemInit.roseBeetleItem)
                        .apply(SetCount.setCount(RandomValueRange.between(0.0F, 1.0F)))).when(KilledByPlayer.killedByPlayer())).build();
        LootContext.Builder lootcontext$builder = this.createLootContext(bool, dmgSource);
        LootContext ctx = lootcontext$builder.create(LootParameterSets.ENTITY);
        loottable.getRandomItems(ctx).forEach(this::spawnAtLocation);
    } */

}
