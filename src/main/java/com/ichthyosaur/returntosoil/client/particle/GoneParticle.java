package com.ichthyosaur.returntosoil.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GoneParticle extends SpriteTexturedParticle {

    public GoneParticle(ClientWorld world, double xCord, double yCord, double zCord, double xSpeed, double ySpeed, double zSpeed) {
        super(world, xCord, yCord, zCord, xSpeed, ySpeed, zSpeed);
        this.quadSize *= 0.75F;
        this.lifetime = 0;
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {

        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite sprite) {
            this.spriteSet = sprite;
        }


        @Override
        public Particle createParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            GoneParticle goneParticle = new GoneParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            goneParticle.setColor(1.0f, 1.0f, 1.0f);
            goneParticle.pickSprite(this.spriteSet);
            return goneParticle;
        }
    }
}
