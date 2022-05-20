package com.ichthyosaur.returntosoil.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LightBallParticle extends SpriteTexturedParticle {

    public LightBallParticle(ClientWorld world, double xCord, double yCord, double zCord, double xSpeed, double ySpeed, double zSpeed) {
        super(world, xCord, yCord, zCord, xSpeed, ySpeed, zSpeed);
        this.quadSize *= 0.75F;
        this.lifetime = 20;
        this.setSize(10, 10);
        this.move(xSpeed, ySpeed, zSpeed);
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
            LightBallParticle particle = new LightBallParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.setColor(1.0f, 1.0f, 1.0f);
            particle.pickSprite(this.spriteSet);
            return particle;
        }
    }
}
