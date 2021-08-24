package com.ichthyosaur.returntosoil.client.entity.model.BallFrogModel;

import com.ichthyosaur.returntosoil.common.entity.BallFrogEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BallFrogDeflatedModel<T extends BallFrogEntity> extends BallFrogModel<T > {
    private final ModelRenderer all;
    private final ModelRenderer body;
    private final ModelRenderer tail;
    private final ModelRenderer tail2;
    private final ModelRenderer head;
    private final ModelRenderer sac;
    private final ModelRenderer skull;
    private final ModelRenderer torso;
    private final ModelRenderer legs;

    public BallFrogDeflatedModel() {
        texWidth = 32;
        texHeight = 32;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 5.0F, 0.0F);
        EmptyAll.addChild(all);


        body = new ModelRenderer(this);
        body.setPos(0.0F, 3.0F, 0.0F);
        all.addChild(body);


        tail = new ModelRenderer(this);
        tail.setPos(0.0F, -2.0F, 4.0F);
        body.addChild(tail);
        tail.texOffs(15, 11).addBox(0.0F, -3.0F, -2.0F, 0.0F, 4.0F, 3.0F, 0.0F, false);
        tail.texOffs(5, 14).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        tail.texOffs(0, 17).addBox(-3.0F, -2.0F, -3.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        tail.texOffs(0, 17).addBox(2.0F, -2.0F, -3.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);

        tail2 = new ModelRenderer(this);
        tail2.setPos(0.0F, 0.0F, 3.0F);
        tail.addChild(tail2);
        tail2.texOffs(11, 9).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        tail2.texOffs(0, 8).addBox(0.0F, -3.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(head);


        sac = new ModelRenderer(this);
        sac.setPos(0.0F, -13.0F, -4.0F);
        head.addChild(sac);
        sac.texOffs(0, 6).addBox(-2.0F, 10.5F, -0.7802F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        skull = new ModelRenderer(this);
        skull.setPos(0.0F, 0.0F, 0.0F);
        head.addChild(skull);
        skull.texOffs(11, 3).addBox(-1.5F, -4.0F, -4.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
        skull.texOffs(11, 0).addBox(-2.0F, -3.8F, -3.7F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        torso = new ModelRenderer(this);
        torso.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(torso);
        torso.texOffs(0, 0).addBox(-2.0F, -4.5F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(legs);

    }
}
