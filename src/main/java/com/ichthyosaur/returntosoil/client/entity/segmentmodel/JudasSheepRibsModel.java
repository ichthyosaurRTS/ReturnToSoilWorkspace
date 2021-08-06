package com.ichthyosaur.returntosoil.client.entity.segmentmodel;

import com.ichthyosaur.returntosoil.client.entity.model.EmptyModel;
import com.ichthyosaur.returntosoil.common.entity.GeneralFlyingSegmentEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class JudasSheepRibsModel<T extends GeneralFlyingSegmentEntity> extends EmptyModel<T > {

    private final ModelRenderer all;
    private final ModelRenderer spine;
    private final ModelRenderer ribs;
    private final ModelRenderer rib1;
    private final ModelRenderer rib2;
    private final ModelRenderer rib3;
    private final ModelRenderer rib4;
    private final ModelRenderer rib5;
    private final ModelRenderer rib6;
    private final ModelRenderer rib7;
    private final ModelRenderer rib8;
    private final ModelRenderer rib9;
    private final ModelRenderer rib10;
    private final ModelRenderer rib11;

    public JudasSheepRibsModel() {
        texWidth = 128;
        texHeight = 128;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 10.0F, 0.0F);
        EmptyAll.addChild(all);


        spine = new ModelRenderer(this);
        spine.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(spine);
        spine.texOffs(0, 0).addBox(-2.0F, -9.0F, -21.0F, 4.0F, 4.0F, 44.0F, 0.0F, false);
        spine.texOffs(80, 35).addBox(-2.5F, -10.0F, -13.0F, 5.0F, 3.0F, 6.0F, 0.0F, false);
        spine.texOffs(80, 26).addBox(-2.5F, -10.0F, -4.0F, 5.0F, 3.0F, 6.0F, 0.0F, false);
        spine.texOffs(76, 17).addBox(-2.5F, -10.0F, 5.0F, 5.0F, 3.0F, 6.0F, 0.0F, false);
        spine.texOffs(76, 8).addBox(-2.5F, -10.0F, 14.0F, 5.0F, 3.0F, 6.0F, 0.0F, false);
        spine.texOffs(0, 48).addBox(-4.0F, 1.0F, -19.0F, 8.0F, 4.0F, 17.0F, 0.0F, false);

        ribs = new ModelRenderer(this);
        ribs.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(ribs);


        rib1 = new ModelRenderer(this);
        rib1.setPos(0.0F, 0.0F, 0.0F);
        ribs.addChild(rib1);
        rib1.texOffs(98, 12).addBox(3.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib1.texOffs(76, 4).addBox(4.0F, 3.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
        rib1.texOffs(76, 0).addBox(-16.0F, 3.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
        rib1.texOffs(96, 44).addBox(-14.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib1.texOffs(72, 73).addBox(-16.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib1.texOffs(40, 69).addBox(14.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib1.texOffs(24, 106).addBox(1.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
        rib1.texOffs(16, 106).addBox(-3.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

        rib2 = new ModelRenderer(this);
        rib2.setPos(0.0F, 0.0F, 4.0F);
        ribs.addChild(rib2);
        rib2.texOffs(96, 35).addBox(3.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib2.texOffs(96, 28).addBox(5.0F, 3.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib2.texOffs(96, 24).addBox(-16.0F, 3.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib2.texOffs(0, 96).addBox(-14.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib2.texOffs(32, 69).addBox(-16.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib2.texOffs(24, 69).addBox(14.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib2.texOffs(100, 105).addBox(1.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
        rib2.texOffs(56, 104).addBox(-3.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

        rib3 = new ModelRenderer(this);
        rib3.setPos(0.0F, 0.0F, -4.0F);
        ribs.addChild(rib3);
        rib3.texOffs(80, 95).addBox(3.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib3.texOffs(52, 39).addBox(4.0F, 3.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
        rib3.texOffs(52, 35).addBox(-16.0F, 3.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
        rib3.texOffs(92, 17).addBox(-14.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib3.texOffs(16, 69).addBox(-16.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib3.texOffs(8, 69).addBox(14.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib3.texOffs(48, 104).addBox(1.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
        rib3.texOffs(40, 104).addBox(-3.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

        rib4 = new ModelRenderer(this);
        rib4.setPos(0.0F, 0.0F, -8.0F);
        ribs.addChild(rib4);
        rib4.texOffs(92, 8).addBox(3.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib4.texOffs(52, 31).addBox(4.0F, 3.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
        rib4.texOffs(52, 27).addBox(-16.0F, 3.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
        rib4.texOffs(80, 91).addBox(-14.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib4.texOffs(0, 69).addBox(-16.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib4.texOffs(68, 0).addBox(14.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib4.texOffs(8, 104).addBox(1.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
        rib4.texOffs(0, 104).addBox(-3.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

        rib5 = new ModelRenderer(this);
        rib5.setPos(0.0F, 0.0F, -12.0F);
        ribs.addChild(rib5);
        rib5.texOffs(80, 87).addBox(3.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib5.texOffs(0, 39).addBox(4.0F, 3.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
        rib5.texOffs(0, 35).addBox(-16.0F, 3.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
        rib5.texOffs(80, 83).addBox(-14.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib5.texOffs(66, 48).addBox(-16.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib5.texOffs(60, 0).addBox(14.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib5.texOffs(92, 103).addBox(1.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
        rib5.texOffs(84, 103).addBox(-3.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

        rib6 = new ModelRenderer(this);
        rib6.setPos(0.0F, 0.0F, 8.0F);
        ribs.addChild(rib6);
        rib6.texOffs(82, 64).addBox(3.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib6.texOffs(78, 99).addBox(6.0F, 3.0F, 0.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
        rib6.texOffs(24, 98).addBox(-16.0F, 3.0F, 0.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);
        rib6.texOffs(82, 60).addBox(-14.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib6.texOffs(58, 48).addBox(-16.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib6.texOffs(52, 0).addBox(14.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib6.texOffs(76, 103).addBox(1.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
        rib6.texOffs(68, 100).addBox(-3.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

        rib7 = new ModelRenderer(this);
        rib7.setPos(0.0F, 0.0F, 12.0F);
        ribs.addChild(rib7);
        rib7.texOffs(82, 56).addBox(3.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib7.texOffs(102, 39).addBox(7.0F, 3.0F, 0.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib7.texOffs(20, 102).addBox(-16.0F, 3.0F, 0.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib7.texOffs(82, 52).addBox(-14.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib7.texOffs(50, 48).addBox(-16.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib7.texOffs(32, 0).addBox(14.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib7.texOffs(41, 48).addBox(1.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
        rib7.texOffs(33, 48).addBox(-3.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

        rib8 = new ModelRenderer(this);
        rib8.setPos(0.0F, 0.0F, -16.0F);
        ribs.addChild(rib8);
        rib8.texOffs(82, 48).addBox(3.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib8.texOffs(0, 31).addBox(4.0F, 3.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
        rib8.texOffs(0, 27).addBox(-16.0F, 3.0F, 0.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
        rib8.texOffs(80, 79).addBox(-14.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib8.texOffs(24, 0).addBox(-16.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib8.texOffs(16, 0).addBox(14.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib8.texOffs(8, 48).addBox(1.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
        rib8.texOffs(0, 48).addBox(-3.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

        rib9 = new ModelRenderer(this);
        rib9.setPos(0.0F, 0.0F, 16.0F);
        ribs.addChild(rib9);
        rib9.texOffs(80, 75).addBox(3.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib9.texOffs(104, 81).addBox(8.0F, 3.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
        rib9.texOffs(104, 77).addBox(-16.0F, 3.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
        rib9.texOffs(80, 71).addBox(-14.0F, -22.0F, 0.0F, 11.0F, 2.0F, 2.0F, 0.0F, false);
        rib9.texOffs(8, 0).addBox(-16.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib9.texOffs(0, 0).addBox(14.0F, -22.0F, 0.0F, 2.0F, 25.0F, 2.0F, 0.0F, false);
        rib9.texOffs(36, 27).addBox(1.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
        rib9.texOffs(28, 27).addBox(-3.0F, -22.0F, 0.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

        rib10 = new ModelRenderer(this);
        rib10.setPos(0.0F, 0.0F, 20.0F);
        ribs.addChild(rib10);
        rib10.texOffs(102, 2).addBox(3.0F, -20.0F, 0.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib10.texOffs(114, 85).addBox(9.0F, 1.0F, 0.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
        rib10.texOffs(108, 63).addBox(-12.0F, 1.0F, 0.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
        rib10.texOffs(100, 101).addBox(-12.0F, -20.0F, 0.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib10.texOffs(64, 75).addBox(-14.0F, -20.0F, 0.0F, 2.0F, 23.0F, 2.0F, 0.0F, false);
        rib10.texOffs(56, 75).addBox(12.0F, -20.0F, 0.0F, 2.0F, 23.0F, 2.0F, 0.0F, false);
        rib10.texOffs(108, 105).addBox(1.0F, -20.0F, 0.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
        rib10.texOffs(108, 48).addBox(-3.0F, -20.0F, 0.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);

        rib11 = new ModelRenderer(this);
        rib11.setPos(0.0F, 0.0F, -20.0F);
        ribs.addChild(rib11);
        rib11.texOffs(46, 100).addBox(3.0F, -20.0F, 0.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib11.texOffs(104, 73).addBox(4.0F, 1.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
        rib11.texOffs(104, 68).addBox(-12.0F, 1.0F, 0.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
        rib11.texOffs(0, 100).addBox(-12.0F, -20.0F, 0.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
        rib11.texOffs(48, 75).addBox(-14.0F, -20.0F, 0.0F, 2.0F, 23.0F, 2.0F, 0.0F, false);
        rib11.texOffs(74, 48).addBox(12.0F, -20.0F, 0.0F, 2.0F, 23.0F, 2.0F, 0.0F, false);
        rib11.texOffs(106, 85).addBox(1.0F, -20.0F, 0.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
        rib11.texOffs(32, 106).addBox(-3.0F, -20.0F, 0.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}

