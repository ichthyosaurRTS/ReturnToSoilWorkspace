package com.ichthyosaur.returntosoil.common.entity;

import com.ichthyosaur.returntosoil.core.init.EntityTypesInit;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.UUID;

public class BaruGaruEntity extends TameableEntity {

    //Lets use uuids next time rather than removing and respawning the segments every time the world restarts alright?
    public static final double segmentDistance = 0.7D;
    static final int segmentMaxNumber = 10;
    private UUID[] segmentList = new UUID[segmentMaxNumber];

    public BaruGaruEntity(EntityType<? extends TameableEntity> p_i48574_1_, World p_i48574_2_) {
        super(p_i48574_1_, p_i48574_2_);
    }


    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 48.0D)
                .add(Attributes.ATTACK_KNOCKBACK)
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 20.0D)
                .add(Attributes.ARMOR, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F);
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false)); //that float is move speed
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0f));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, JawBeetleEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));

    }

    public void addAdditionalSaveData(CompoundNBT NBT) {
        super.addAdditionalSaveData(NBT);

        for (int i = 0; i < this.segmentList.length; i++) {
            if (this.segmentList[i] != null) {
                NBT.putUUID("subEntity"+i, this.segmentList[i]);
            }
        }

    }


    public void readAdditionalSaveData(CompoundNBT NBT) {
        super.readAdditionalSaveData(NBT);

        if(this.segmentList[0] == null && NBT.contains("subEntity0")) {
            for (int i = 0; i < this.segmentList.length; i++) {
                this.segmentList[i] = NBT.getUUID("subEntity"+i); }
        }

    }

    public void tick() {
       super.tick();
       //if (this.builtSegments&&this.segmentList[0] == null) this.builtSegments = false;
    }


    public void summonSegmentsToHead() {
        for (int i = 0; i < segmentMaxNumber; i++) {
            if (this.segmentList[i] == null) {}
            else {
                ServerWorld world = (ServerWorld) this.getCommandSenderWorld();
                BaruGaruSegmentEntity segment = (BaruGaruSegmentEntity) world.getEntity(this.segmentList[i]);
                segment.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
            }
        }
    }


    @MethodsReturnNonnullByDefault
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (this.level.isClientSide) {
            return ActionResultType.PASS;
        } else {
            if (item == Items.PORKCHOP && this.getHealth() < this.getMaxHealth()) {
                this.heal((float) item.getFoodProperties().getNutrition());
                itemstack.shrink(1);
                this.level.broadcastEntityEvent(this, (byte)7);
                return ActionResultType.SUCCESS;
                }
                return super.mobInteract(player, hand);
        }}

    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        p_213386_4_ = super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
        createSegments(this,0);
        return p_213386_4_;
    }

    private void createSegments(Entity leader, int number){

        if(number<segmentMaxNumber) {

            BaruGaruSegmentEntity segment;

            World world = this.getCommandSenderWorld();

            segment = EntityTypesInit.BARUGARUSEGMENT.get().create(world);

            //if (i == 0) { segment.torsoParent = this; segment.first = true; } //if the 1st segment, make the torso the parent
            segment.mainBody = this;
            segment.leader = leader;

            segment.moveTo((double) this.getX() + 0.5D, (double) this.getY(), (double) this.getZ() - 0.5D, 0.0F, 0.0F);
            world.addFreshEntity(segment);

            this.segmentList[number] = segment.getUUID();

            createSegments(segment, number+1);
            //Logger.getLogger("Created segment#"+i);
        }

    }



        @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }
}
