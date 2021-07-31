package com.ichthyosaur.returntosoil.client.entity.model.GhostRamModel;

import com.ichthyosaur.returntosoil.common.entity.BaruGaruSegmentEntity;
import com.ichthyosaur.returntosoil.common.entity.entityhelp.GhostRam.GhostRamBodyEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import java.util.logging.Logger;

public class GhostRamBodyModel<T extends GhostRamBodyEntity> extends EntityModel<T> {
    Logger logger = Logger.getLogger("logger");;

    private final ModelRenderer all;
    private final ModelRenderer ribs;
    private final ModelRenderer rib1;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer rib2;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer rib4;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer cube_r17;
    private final ModelRenderer cube_r18;
    private final ModelRenderer rib5;
    private final ModelRenderer cube_r19;
    private final ModelRenderer cube_r20;
    private final ModelRenderer cube_r21;
    private final ModelRenderer cube_r22;
    private final ModelRenderer cube_r23;
    private final ModelRenderer cube_r24;
    private final ModelRenderer cube_r25;
    private final ModelRenderer cube_r26;
    private final ModelRenderer cube_r27;
    private final ModelRenderer cube_r28;
    private final ModelRenderer rib6;
    private final ModelRenderer cube_r29;
    private final ModelRenderer cube_r30;
    private final ModelRenderer cube_r31;
    private final ModelRenderer cube_r32;
    private final ModelRenderer cube_r33;
    private final ModelRenderer cube_r34;
    private final ModelRenderer cube_r35;
    private final ModelRenderer cube_r36;
    private final ModelRenderer cube_r37;
    private final ModelRenderer cube_r38;
    private final ModelRenderer rib7;
    private final ModelRenderer cube_r39;
    private final ModelRenderer cube_r40;
    private final ModelRenderer cube_r41;
    private final ModelRenderer cube_r42;
    private final ModelRenderer cube_r43;
    private final ModelRenderer cube_r44;
    private final ModelRenderer cube_r45;
    private final ModelRenderer cube_r46;
    private final ModelRenderer cube_r47;
    private final ModelRenderer cube_r48;
    private final ModelRenderer rib8;
    private final ModelRenderer cube_r49;
    private final ModelRenderer cube_r50;
    private final ModelRenderer cube_r51;
    private final ModelRenderer cube_r52;
    private final ModelRenderer cube_r53;
    private final ModelRenderer cube_r54;
    private final ModelRenderer cube_r55;
    private final ModelRenderer cube_r56;
    private final ModelRenderer cube_r57;
    private final ModelRenderer cube_r58;
    private final ModelRenderer rib9;
    private final ModelRenderer cube_r59;
    private final ModelRenderer cube_r60;
    private final ModelRenderer cube_r61;
    private final ModelRenderer cube_r62;
    private final ModelRenderer cube_r63;
    private final ModelRenderer cube_r64;
    private final ModelRenderer cube_r65;
    private final ModelRenderer cube_r66;
    private final ModelRenderer rib3;
    private final ModelRenderer cube_r67;
    private final ModelRenderer cube_r68;
    private final ModelRenderer cube_r69;
    private final ModelRenderer cube_r70;
    private final ModelRenderer cube_r71;
    private final ModelRenderer cube_r72;
    private final ModelRenderer spine;
    private final ModelRenderer cube_r73;
    private final ModelRenderer cube_r74;
    private final ModelRenderer legs;
    private final ModelRenderer legright;
    private final ModelRenderer legleft;

    public GhostRamBodyModel() {
        texWidth = 64;
        texHeight = 64;

        all = new ModelRenderer(this);
        all.setPos(0.0F, 18.0F, 0.0F);


        ribs = new ModelRenderer(this);
        ribs.setPos(0.0F, 6.0F, 0.0F);
        all.addChild(ribs);


        rib1 = new ModelRenderer(this);
        rib1.setPos(0.0F, 0.0F, 0.0F);
        ribs.addChild(rib1);
        rib1.texOffs(55, 39).addBox(-4.0F, -11.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(52, 51).addBox(-6.0F, -12.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(27, 0).addBox(3.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(28, 55).addBox(4.0F, -12.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(55, 41).addBox(2.0F, -11.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(38, 2).addBox(2.5F, -1.5F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(18, 55).addBox(1.5F, -2.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(12, 55).addBox(-3.5F, -2.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(38, 0).addBox(-7.5F, -1.5F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(8.5F, -6.0F, 0.5F);
        rib1.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, -0.2182F);
        cube_r1.texOffs(20, 40).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(-8.5F, -6.0F, 0.5F);
        rib1.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.2182F);
        cube_r2.texOffs(16, 40).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(7.0F, -10.5F, 0.5F);
        rib1.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, 0.7854F);
        cube_r3.texOffs(52, 49).addBox(-1.7F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setPos(-6.5F, -10.5F, 0.5F);
        rib1.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, -0.7854F);
        cube_r4.texOffs(45, 52).addBox(-1.6F, -0.7F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setPos(8.0F, -1.5F, 0.5F);
        rib1.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.0F, -0.6109F);
        cube_r5.texOffs(52, 29).addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setPos(-8.0F, -1.5F, 0.5F);
        rib1.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 0.0F, 0.6109F);
        cube_r6.texOffs(37, 52).addBox(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        rib2 = new ModelRenderer(this);
        rib2.setPos(0.0F, 0.0F, -2.0F);
        ribs.addChild(rib2);
        rib2.texOffs(55, 10).addBox(-4.0F, -11.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(16, 51).addBox(-6.0F, -12.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(6, 23).addBox(3.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(6, 55).addBox(4.0F, -12.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(0, 55).addBox(2.0F, -11.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(37, 10).addBox(2.5F, -1.5F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(47, 54).addBox(1.5F, -2.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(41, 54).addBox(-3.5F, -2.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(37, 8).addBox(-7.5F, -1.5F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setPos(8.5F, -6.0F, 0.5F);
        rib2.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, 0.0F, -0.2182F);
        cube_r7.texOffs(8, 40).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setPos(-8.5F, -6.0F, 0.5F);
        rib2.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, 0.0F, 0.2182F);
        cube_r8.texOffs(12, 40).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setPos(7.0F, -10.5F, 0.5F);
        rib2.addChild(cube_r9);
        setRotationAngle(cube_r9, 0.0F, 0.0F, 0.7854F);
        cube_r9.texOffs(8, 51).addBox(-1.7F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setPos(-6.5F, -10.5F, 0.5F);
        rib2.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.0F, 0.0F, -0.7854F);
        cube_r10.texOffs(30, 51).addBox(-1.6F, -0.7F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setPos(8.0F, -1.5F, 0.5F);
        rib2.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.0F, -0.6109F);
        cube_r11.texOffs(51, 47).addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setPos(-8.0F, -1.5F, 0.5F);
        rib2.addChild(cube_r12);
        setRotationAngle(cube_r12, 0.0F, 0.0F, 0.6109F);
        cube_r12.texOffs(23, 52).addBox(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        rib4 = new ModelRenderer(this);
        rib4.setPos(0.0F, 0.0F, -4.0F);
        ribs.addChild(rib4);
        rib4.texOffs(54, 22).addBox(-4.0F, -11.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(30, 49).addBox(-6.0F, -12.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(15, 0).addBox(3.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(52, 53).addBox(4.0F, -12.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(53, 35).addBox(2.0F, -11.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(27, 27).addBox(2.5F, -1.5F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(53, 33).addBox(1.5F, -2.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(53, 31).addBox(-3.5F, -2.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(27, 25).addBox(-7.5F, -1.5F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setPos(8.5F, -6.0F, 0.5F);
        rib4.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.0F, 0.0F, -0.2182F);
        cube_r13.texOffs(38, 32).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setPos(-8.5F, -6.0F, 0.5F);
        rib4.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.0F, 0.0F, 0.2182F);
        cube_r14.texOffs(39, 23).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setPos(7.0F, -10.5F, 0.5F);
        rib4.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.0F, 0.0F, 0.7854F);
        cube_r15.texOffs(49, 17).addBox(-1.7F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r16 = new ModelRenderer(this);
        cube_r16.setPos(-6.5F, -10.5F, 0.5F);
        rib4.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.0F, 0.0F, -0.7854F);
        cube_r16.texOffs(50, 3).addBox(-1.6F, -0.7F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setPos(8.0F, -1.5F, 0.5F);
        rib4.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.0F, 0.0F, -0.6109F);
        cube_r17.texOffs(50, 5).addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setPos(-8.0F, -1.5F, 0.5F);
        rib4.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.0F, 0.0F, 0.6109F);
        cube_r18.texOffs(49, 1).addBox(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        rib5 = new ModelRenderer(this);
        rib5.setPos(0.0F, 0.0F, 0.0F);
        ribs.addChild(rib5);


        cube_r19 = new ModelRenderer(this);
        cube_r19.setPos(-8.0F, -1.5F, -3.5F);
        rib5.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.0F, 0.0F, 0.6109F);
        cube_r19.texOffs(48, 44).addBox(-1.3F, -1.8F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r20 = new ModelRenderer(this);
        cube_r20.setPos(8.0F, -1.5F, -3.5F);
        rib5.addChild(cube_r20);
        setRotationAngle(cube_r20, 0.0F, 0.0F, -0.6109F);
        cube_r20.texOffs(0, 49).addBox(-1.7F, -1.8F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r21 = new ModelRenderer(this);
        cube_r21.setPos(4.0F, -1.5F, -5.5F);
        rib5.addChild(cube_r21);
        setRotationAngle(cube_r21, 0.0F, 0.0F, 0.0873F);
        cube_r21.texOffs(27, 23).addBox(-2.5F, -0.7F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r22 = new ModelRenderer(this);
        cube_r22.setPos(-4.0F, -1.7F, -5.5F);
        rib5.addChild(cube_r22);
        setRotationAngle(cube_r22, 0.0F, 0.0F, -0.0873F);
        cube_r22.texOffs(27, 17).addBox(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r23 = new ModelRenderer(this);
        cube_r23.setPos(-6.5F, -10.5F, -3.5F);
        rib5.addChild(cube_r23);
        setRotationAngle(cube_r23, 0.0F, 0.0F, -0.7854F);
        cube_r23.texOffs(49, 15).addBox(-1.4F, 0.3F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r24 = new ModelRenderer(this);
        cube_r24.setPos(7.0F, -10.5F, -3.5F);
        rib5.addChild(cube_r24);
        setRotationAngle(cube_r24, 0.0F, 0.0F, 0.7854F);
        cube_r24.texOffs(16, 49).addBox(-2.0F, 0.6F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r25 = new ModelRenderer(this);
        cube_r25.setPos(3.5F, -10.8F, -5.5F);
        rib5.addChild(cube_r25);
        setRotationAngle(cube_r25, 0.0F, 0.0F, -0.0873F);
        cube_r25.texOffs(49, 13).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r26 = new ModelRenderer(this);
        cube_r26.setPos(-3.5F, -10.8F, -5.5F);
        rib5.addChild(cube_r26);
        setRotationAngle(cube_r26, 0.0F, 0.0F, 0.0873F);
        cube_r26.texOffs(8, 49).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r27 = new ModelRenderer(this);
        cube_r27.setPos(-8.5F, -6.0F, -3.5F);
        rib5.addChild(cube_r27);
        setRotationAngle(cube_r27, 0.0F, 0.0F, 0.2182F);
        cube_r27.texOffs(40, 41).addBox(0.5F, -4.0F, -2.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        cube_r28 = new ModelRenderer(this);
        cube_r28.setPos(8.5F, -6.0F, -3.5F);
        rib5.addChild(cube_r28);
        setRotationAngle(cube_r28, 0.0F, 0.0F, -0.2182F);
        cube_r28.texOffs(42, 31).addBox(-1.5F, -4.0F, -2.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        rib6 = new ModelRenderer(this);
        rib6.setPos(0.0F, 0.0F, 10.0F);
        ribs.addChild(rib6);


        cube_r29 = new ModelRenderer(this);
        cube_r29.setPos(-8.0F, -1.5F, -3.5F);
        rib6.addChild(cube_r29);
        setRotationAngle(cube_r29, 0.0F, 0.0F, 0.6109F);
        cube_r29.texOffs(48, 9).addBox(-1.3F, -1.8F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r30 = new ModelRenderer(this);
        cube_r30.setPos(8.0F, -1.5F, -3.5F);
        rib6.addChild(cube_r30);
        setRotationAngle(cube_r30, 0.0F, 0.0F, -0.6109F);
        cube_r30.texOffs(48, 11).addBox(-1.7F, -1.8F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r31 = new ModelRenderer(this);
        cube_r31.setPos(4.0F, -1.5F, -5.5F);
        rib6.addChild(cube_r31);
        setRotationAngle(cube_r31, 0.0F, 0.0F, 0.0873F);
        cube_r31.texOffs(0, 16).addBox(-2.5F, -0.7F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r32 = new ModelRenderer(this);
        cube_r32.setPos(-4.0F, -1.7F, -5.5F);
        rib6.addChild(cube_r32);
        setRotationAngle(cube_r32, 0.0F, 0.0F, -0.0873F);
        cube_r32.texOffs(27, 15).addBox(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r33 = new ModelRenderer(this);
        cube_r33.setPos(-6.5F, -10.5F, -3.5F);
        rib6.addChild(cube_r33);
        setRotationAngle(cube_r33, 0.0F, 0.0F, -0.7854F);
        cube_r33.texOffs(23, 48).addBox(-1.4F, 0.3F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r34 = new ModelRenderer(this);
        cube_r34.setPos(7.0F, -10.5F, -3.5F);
        rib6.addChild(cube_r34);
        setRotationAngle(cube_r34, 0.0F, 0.0F, 0.7854F);
        cube_r34.texOffs(48, 40).addBox(-2.0F, 0.6F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r35 = new ModelRenderer(this);
        cube_r35.setPos(3.5F, -10.8F, -5.5F);
        rib6.addChild(cube_r35);
        setRotationAngle(cube_r35, 0.0F, 0.0F, -0.0873F);
        cube_r35.texOffs(48, 42).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r36 = new ModelRenderer(this);
        cube_r36.setPos(-3.5F, -10.8F, -5.5F);
        rib6.addChild(cube_r36);
        setRotationAngle(cube_r36, 0.0F, 0.0F, 0.0873F);
        cube_r36.texOffs(43, 48).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r37 = new ModelRenderer(this);
        cube_r37.setPos(-8.5F, -6.0F, -3.5F);
        rib6.addChild(cube_r37);
        setRotationAngle(cube_r37, 0.0F, 0.0F, 0.2182F);
        cube_r37.texOffs(32, 40).addBox(0.5F, -4.0F, -2.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        cube_r38 = new ModelRenderer(this);
        cube_r38.setPos(8.5F, -6.0F, -3.5F);
        rib6.addChild(cube_r38);
        setRotationAngle(cube_r38, 0.0F, 0.0F, -0.2182F);
        cube_r38.texOffs(36, 41).addBox(-1.5F, -4.0F, -2.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        rib7 = new ModelRenderer(this);
        rib7.setPos(0.0F, 0.0F, -2.0F);
        ribs.addChild(rib7);


        cube_r39 = new ModelRenderer(this);
        cube_r39.setPos(-8.0F, -1.5F, -3.5F);
        rib7.addChild(cube_r39);
        setRotationAngle(cube_r39, 0.0F, 0.0F, 0.6109F);
        cube_r39.texOffs(46, 36).addBox(0.0F, -2.5F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r40 = new ModelRenderer(this);
        cube_r40.setPos(8.0F, -1.5F, -3.5F);
        rib7.addChild(cube_r40);
        setRotationAngle(cube_r40, 0.0F, 0.0F, -0.6109F);
        cube_r40.texOffs(44, 46).addBox(-3.0F, -2.5F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r41 = new ModelRenderer(this);
        cube_r41.setPos(4.0F, -1.5F, -5.5F);
        rib7.addChild(cube_r41);
        setRotationAngle(cube_r41, 0.0F, 0.0F, 0.0873F);
        cube_r41.texOffs(47, 23).addBox(-2.3F, -0.7F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r42 = new ModelRenderer(this);
        cube_r42.setPos(-4.0F, -1.7F, -5.5F);
        rib7.addChild(cube_r42);
        setRotationAngle(cube_r42, 0.0F, 0.0F, -0.0873F);
        cube_r42.texOffs(47, 25).addBox(-0.7F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r43 = new ModelRenderer(this);
        cube_r43.setPos(-6.5F, -10.5F, -3.5F);
        rib7.addChild(cube_r43);
        setRotationAngle(cube_r43, 0.0F, 0.0F, -0.7854F);
        cube_r43.texOffs(47, 27).addBox(-0.4F, 1.3F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r44 = new ModelRenderer(this);
        cube_r44.setPos(7.0F, -10.5F, -3.5F);
        rib7.addChild(cube_r44);
        setRotationAngle(cube_r44, 0.0F, 0.0F, 0.7854F);
        cube_r44.texOffs(47, 38).addBox(-3.0F, 1.6F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r45 = new ModelRenderer(this);
        cube_r45.setPos(3.5F, -10.8F, -5.5F);
        rib7.addChild(cube_r45);
        setRotationAngle(cube_r45, 0.0F, 0.0F, -0.0873F);
        cube_r45.texOffs(53, 20).addBox(-1.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r46 = new ModelRenderer(this);
        cube_r46.setPos(-3.5F, -10.8F, -5.5F);
        rib7.addChild(cube_r46);
        setRotationAngle(cube_r46, 0.0F, 0.0F, 0.0873F);
        cube_r46.texOffs(30, 53).addBox(-0.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r47 = new ModelRenderer(this);
        cube_r47.setPos(-8.5F, -6.0F, -3.5F);
        rib7.addChild(cube_r47);
        setRotationAngle(cube_r47, 0.0F, 0.0F, 0.2182F);
        cube_r47.texOffs(24, 40).addBox(2.0F, -4.0F, -2.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        cube_r48 = new ModelRenderer(this);
        cube_r48.setPos(8.5F, -6.0F, -3.5F);
        rib7.addChild(cube_r48);
        setRotationAngle(cube_r48, 0.0F, 0.0F, -0.2182F);
        cube_r48.texOffs(28, 40).addBox(-3.0F, -4.0F, -2.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);

        rib8 = new ModelRenderer(this);
        rib8.setPos(0.0F, 0.0F, 12.0F);
        ribs.addChild(rib8);


        cube_r49 = new ModelRenderer(this);
        cube_r49.setPos(-8.0F, -1.5F, -3.5F);
        rib8.addChild(cube_r49);
        setRotationAngle(cube_r49, 0.0F, 0.0F, 0.6109F);
        cube_r49.texOffs(43, 6).addBox(0.0F, -2.5F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r50 = new ModelRenderer(this);
        cube_r50.setPos(8.0F, -1.5F, -3.5F);
        rib8.addChild(cube_r50);
        setRotationAngle(cube_r50, 0.0F, 0.0F, -0.6109F);
        cube_r50.texOffs(45, 30).addBox(-3.0F, -2.5F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r51 = new ModelRenderer(this);
        cube_r51.setPos(4.0F, -1.5F, -5.5F);
        rib8.addChild(cube_r51);
        setRotationAngle(cube_r51, 0.0F, 0.0F, 0.0873F);
        cube_r51.texOffs(46, 19).addBox(-2.3F, -0.7F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r52 = new ModelRenderer(this);
        cube_r52.setPos(-4.0F, -1.7F, -5.5F);
        rib8.addChild(cube_r52);
        setRotationAngle(cube_r52, 0.0F, 0.0F, -0.0873F);
        cube_r52.texOffs(46, 21).addBox(-0.7F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r53 = new ModelRenderer(this);
        cube_r53.setPos(-6.5F, -10.5F, -3.5F);
        rib8.addChild(cube_r53);
        setRotationAngle(cube_r53, 0.0F, 0.0F, -0.7854F);
        cube_r53.texOffs(46, 32).addBox(-1.4F, 2.0F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r54 = new ModelRenderer(this);
        cube_r54.setPos(7.0F, -10.5F, -3.5F);
        rib8.addChild(cube_r54);
        setRotationAngle(cube_r54, 0.0F, 0.0F, 0.7854F);
        cube_r54.texOffs(46, 34).addBox(-2.0F, 2.3F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r55 = new ModelRenderer(this);
        cube_r55.setPos(3.5F, -10.8F, -5.5F);
        rib8.addChild(cube_r55);
        setRotationAngle(cube_r55, 0.0F, 0.0F, -0.0873F);
        cube_r55.texOffs(12, 53).addBox(-1.5F, 0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r56 = new ModelRenderer(this);
        cube_r56.setPos(-3.5F, -10.8F, -5.5F);
        rib8.addChild(cube_r56);
        setRotationAngle(cube_r56, 0.0F, 0.0F, 0.0873F);
        cube_r56.texOffs(18, 53).addBox(-0.5F, 0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r57 = new ModelRenderer(this);
        cube_r57.setPos(-8.5F, -6.0F, -3.5F);
        rib8.addChild(cube_r57);
        setRotationAngle(cube_r57, 0.0F, 0.0F, 0.2182F);
        cube_r57.texOffs(44, 39).addBox(2.0F, -3.0F, -2.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

        cube_r58 = new ModelRenderer(this);
        cube_r58.setPos(8.5F, -6.0F, -3.5F);
        rib8.addChild(cube_r58);
        setRotationAngle(cube_r58, 0.0F, 0.0F, -0.2182F);
        cube_r58.texOffs(45, 12).addBox(-3.0F, -3.0F, -2.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

        rib9 = new ModelRenderer(this);
        rib9.setPos(0.0F, 0.0F, 14.0F);
        ribs.addChild(rib9);


        cube_r59 = new ModelRenderer(this);
        cube_r59.setPos(4.0F, -1.5F, -5.5F);
        rib9.addChild(cube_r59);
        setRotationAngle(cube_r59, 0.0F, 0.0F, 0.0873F);
        cube_r59.texOffs(0, 30).addBox(-2.3F, -0.7F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r60 = new ModelRenderer(this);
        cube_r60.setPos(-4.0F, -1.7F, -5.5F);
        rib9.addChild(cube_r60);
        setRotationAngle(cube_r60, 0.0F, 0.0F, -0.0873F);
        cube_r60.texOffs(0, 32).addBox(-1.7F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r61 = new ModelRenderer(this);
        cube_r61.setPos(-6.5F, -10.5F, -3.5F);
        rib9.addChild(cube_r61);
        setRotationAngle(cube_r61, 0.0F, 0.0F, -0.7854F);
        cube_r61.texOffs(11, 17).addBox(-1.4F, 3.7F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r62 = new ModelRenderer(this);
        cube_r62.setPos(7.0F, -10.5F, -3.5F);
        rib9.addChild(cube_r62);
        setRotationAngle(cube_r62, 0.0F, 0.0F, 0.7854F);
        cube_r62.texOffs(43, 4).addBox(-2.0F, 4.1F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r63 = new ModelRenderer(this);
        cube_r63.setPos(2.18F, -8.6769F, -5.5F);
        rib9.addChild(cube_r63);
        setRotationAngle(cube_r63, 0.0F, 0.0F, 0.4363F);
        cube_r63.texOffs(0, 53).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r64 = new ModelRenderer(this);
        cube_r64.setPos(-2.18F, -8.6769F, -5.5F);
        rib9.addChild(cube_r64);
        setRotationAngle(cube_r64, 0.0F, 0.0F, -0.4363F);
        cube_r64.texOffs(6, 53).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r65 = new ModelRenderer(this);
        cube_r65.setPos(-8.5F, -6.0F, -3.5F);
        rib9.addChild(cube_r65);
        setRotationAngle(cube_r65, 0.0F, 0.0F, 0.2182F);
        cube_r65.texOffs(41, 12).addBox(3.5F, -2.0F, -2.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

        cube_r66 = new ModelRenderer(this);
        cube_r66.setPos(8.5F, -6.0F, -3.5F);
        rib9.addChild(cube_r66);
        setRotationAngle(cube_r66, 0.0F, 0.0F, -0.2182F);
        cube_r66.texOffs(43, 23).addBox(-4.5F, -2.0F, -2.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

        rib3 = new ModelRenderer(this);
        rib3.setPos(0.0F, 0.0F, 2.0F);
        ribs.addChild(rib3);
        rib3.texOffs(54, 37).addBox(-4.0F, -11.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(23, 50).addBox(-6.0F, -12.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(15, 8).addBox(3.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(35, 54).addBox(4.0F, -12.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(54, 26).addBox(2.0F, -11.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(27, 31).addBox(2.5F, -1.5F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(54, 24).addBox(1.5F, -2.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(23, 54).addBox(-3.5F, -2.5F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(27, 29).addBox(-7.5F, -1.5F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r67 = new ModelRenderer(this);
        cube_r67.setPos(8.5F, -6.0F, 0.5F);
        rib3.addChild(cube_r67);
        setRotationAngle(cube_r67, 0.0F, 0.0F, -0.2182F);
        cube_r67.texOffs(0, 40).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        cube_r68 = new ModelRenderer(this);
        cube_r68.setPos(-8.5F, -6.0F, 0.5F);
        rib3.addChild(cube_r68);
        setRotationAngle(cube_r68, 0.0F, 0.0F, 0.2182F);
        cube_r68.texOffs(4, 40).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        cube_r69 = new ModelRenderer(this);
        cube_r69.setPos(7.0F, -10.5F, 0.5F);
        rib3.addChild(cube_r69);
        setRotationAngle(cube_r69, 0.0F, 0.0F, 0.7854F);
        cube_r69.texOffs(50, 7).addBox(-1.7F, -0.4F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r70 = new ModelRenderer(this);
        cube_r70.setPos(-6.5F, -10.5F, 0.5F);
        rib3.addChild(cube_r70);
        setRotationAngle(cube_r70, 0.0F, 0.0F, -0.7854F);
        cube_r70.texOffs(37, 50).addBox(-1.6F, -0.7F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r71 = new ModelRenderer(this);
        cube_r71.setPos(8.0F, -1.5F, 0.5F);
        rib3.addChild(cube_r71);
        setRotationAngle(cube_r71, 0.0F, 0.0F, -0.6109F);
        cube_r71.texOffs(45, 50).addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r72 = new ModelRenderer(this);
        cube_r72.setPos(-8.0F, -1.5F, 0.5F);
        rib3.addChild(cube_r72);
        setRotationAngle(cube_r72, 0.0F, 0.0F, 0.6109F);
        cube_r72.texOffs(0, 51).addBox(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        spine = new ModelRenderer(this);
        spine.setPos(0.0F, 6.0F, 0.0F);
        all.addChild(spine);
        spine.texOffs(0, 0).addBox(-2.0F, -10.0F, -9.0F, 4.0F, 4.0F, 19.0F, 0.0F, false);
        spine.texOffs(0, 23).addBox(-4.0F, -10.7F, -7.0F, 8.0F, 6.0F, 11.0F, 0.0F, false);
        spine.texOffs(0, 8).addBox(-3.0F, -10.2F, 3.5F, 6.0F, 5.0F, 3.0F, 0.0F, false);
        spine.texOffs(0, 0).addBox(-3.0F, -10.5F, -8.5F, 6.0F, 5.0F, 3.0F, 0.0F, false);

        cube_r73 = new ModelRenderer(this);
        cube_r73.setPos(0.0F, -7.5F, -9.5F);
        spine.addChild(cube_r73);
        setRotationAngle(cube_r73, 0.2182F, 0.0F, 0.0F);
        cube_r73.texOffs(27, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 5.0F, 0.0F, false);

        cube_r74 = new ModelRenderer(this);
        cube_r74.setPos(0.0F, -8.0F, 11.0F);
        spine.addChild(cube_r74);
        setRotationAngle(cube_r74, -0.2182F, 0.0F, 0.0F);
        cube_r74.texOffs(27, 8).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(legs);


        legright = new ModelRenderer(this);
        legright.setPos(-5.0F, 5.0F, 5.0F);
        legs.addChild(legright);
        setRotationAngle(legright, 1.0036F, 0.0F, 0.0F);
        legright.texOffs(0, 23).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        legleft = new ModelRenderer(this);
        legleft.setPos(5.0F, 5.0F, 5.0F);
        legs.addChild(legleft);
        setRotationAngle(legleft, 1.0036F, 0.0F, 0.0F);
        legleft.texOffs(0, 23).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(GhostRamBodyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.all.xRot = headPitch * ((float)Math.PI / 180F);
        this.all.yRot = netHeadYaw * ((float)Math.PI / 180F);


    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        all.render(matrixStack, buffer, packedLight, packedOverlay); //this will render all the children too
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
