package com.ichthyosaur.returntosoil.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LightBallParticle extends SpriteTexturedParticle {

    /*public LightBallParticle(ClientWorld world, double xCord, double yCord, double zCord, double xSpeed, double ySpeed, double zSpeed) {
        super(world, xCord, yCord, zCord, xSpeed, ySpeed, zSpeed);
        this.quadSize *= 0.75F;
        this.lifetime = 100;
        this.move(xSpeed,ySpeed,zSpeed);
    }*/

    public LightBallParticle(ClientWorld p_i232412_1_, double p_i232412_2_, double p_i232412_4_, double p_i232412_6_, double p_i232412_8_, double p_i232412_10_, double p_i232412_12_) {
        super(p_i232412_1_, p_i232412_2_, p_i232412_4_, p_i232412_6_);
        this.xd = p_i232412_8_;
        this.yd = p_i232412_10_;
        this.zd = p_i232412_12_;
        float f = 1.0F * 0.15F;
        float f1 = MathHelper.sqrt(this.xd * this.xd + this.yd * this.yd + this.zd * this.zd);
        this.xd = this.xd / (double)f1 * (double)f * (double)0.4F;
        this.yd = this.yd / (double)f1 * (double)f * (double)0.4F + 0.093F;
        this.zd = this.zd / (double)f1 * (double)f * (double)0.4F;

        this.lifetime = 100;
        this.hasPhysics = false;
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }


    @Override
    public void tick() {

        super.tick();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {

        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite sprite) {
            this.spriteSet = sprite;
        }


        @Override
        public Particle createParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            LightBallParticle particle = new LightBallParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.setColor(1.0f, 1.0f, 1.0f);
            particle.pickSprite(this.spriteSet);
            //needs both power and move destination to move.
            particle.setPower(12);
            //particle.setSize(5,5);
            particle.scale(5);
            return particle;
        }
    }
}
