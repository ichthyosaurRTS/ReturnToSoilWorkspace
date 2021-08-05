package com.ichthyosaur.returntosoil.client.entity.model.JudasSheepModel;

import com.ichthyosaur.returntosoil.common.entity.JudasSheep.JudasSheepBodyEntity;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class JudasSheepWoolModel<T extends JudasSheepBodyEntity> extends JudasSheepBodyModel<T> {

    public static final Logger LOGGER = LogManager.getLogger();

    private final ModelRenderer spine;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer ribs;
    private final ModelRenderer rib1;
    private final ModelRenderer rib2;
    private final ModelRenderer rib3;
    private final ModelRenderer rib4;
    private final ModelRenderer rib5;
    private final ModelRenderer rib6;
    private final ModelRenderer rib7;
    private final ModelRenderer rib9;
    private final ModelRenderer rib10;
    private final ModelRenderer rib8;
    private final ModelRenderer legs;
    private final ModelRenderer rightleg;
    private final ModelRenderer leftleg;
    private final ModelRenderer wool;

    public JudasSheepWoolModel() {
        texWidth = 128;
        texHeight = 128;


        spine = new ModelRenderer(this);
        spine.setPos(0.0F, 5.0F, 0.0F);
        all.addChild(spine);
        spine.texOffs(27, 38).addBox(-3.0F, -10.0F, -8.0F, 6.0F, 5.0F, 15.0F, 0.0F, false);
        spine.texOffs(17, 42).addBox(-2.0F, 1.0F, -8.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);
        spine.texOffs(0, 42).addBox(-1.0F, 0.0F, -10.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -7.0F, 7.5F);
        spine.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.2618F, 0.0F, 0.0F);
        cube_r1.texOffs(54, 38).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 3.0F, 8.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, -7.0F, -7.5F);
        spine.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.2618F, 0.0F, 0.0F);
        cube_r2.texOffs(0, 42).addBox(-2.0F, -2.0F, -6.5F, 4.0F, 4.0F, 9.0F, 0.0F, false);

        ribs = new ModelRenderer(this);
        ribs.setPos(0.0F, 5.0F, 0.0F);
        all.addChild(ribs);


        rib1 = new ModelRenderer(this);
        rib1.setPos(0.0F, 0.0F, 0.0F);
        ribs.addChild(rib1);
        rib1.texOffs(48, 58).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib1.texOffs(0, 70).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(8, 72).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(24, 72).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(69, 54).addBox(-8.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(68, 69).addBox(2.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(56, 71).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib1.texOffs(52, 58).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib2 = new ModelRenderer(this);
        rib2.setPos(0.0F, 0.0F, 2.0F);
        ribs.addChild(rib2);
        rib2.texOffs(44, 58).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib2.texOffs(69, 52).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(4, 72).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(0, 72).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(68, 67).addBox(-8.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(68, 65).addBox(2.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(68, 63).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib2.texOffs(40, 58).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib3 = new ModelRenderer(this);
        rib3.setPos(0.0F, 0.0F, 4.0F);
        ribs.addChild(rib3);
        rib3.texOffs(36, 58).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib3.texOffs(68, 61).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(57, 43).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(57, 41).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(68, 59).addBox(-8.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(68, 57).addBox(2.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(68, 44).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib3.texOffs(32, 58).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib4 = new ModelRenderer(this);
        rib4.setPos(0.0F, 0.0F, 6.0F);
        ribs.addChild(rib4);
        rib4.texOffs(28, 58).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib4.texOffs(68, 42).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(57, 39).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(54, 44).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(68, 40).addBox(-8.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(68, 38).addBox(2.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(67, 50).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib4.texOffs(24, 57).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib5 = new ModelRenderer(this);
        rib5.setPos(0.0F, 0.0F, 8.0F);
        ribs.addChild(rib5);
        rib5.texOffs(20, 55).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib5.texOffs(65, 10).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(54, 42).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(54, 40).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(70, 71).addBox(-8.0F, 1.0F, -6.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(13, 71).addBox(3.0F, 1.0F, -6.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(65, 8).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib5.texOffs(16, 55).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib6 = new ModelRenderer(this);
        rib6.setPos(0.0F, 0.0F, 10.0F);
        ribs.addChild(rib6);
        rib6.texOffs(12, 55).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib6.texOffs(65, 6).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(54, 38).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(4, 49).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(0, 13).addBox(-8.0F, 1.0F, -6.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(0, 11).addBox(3.0F, 1.0F, -6.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(65, 4).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib6.texOffs(8, 55).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib7 = new ModelRenderer(this);
        rib7.setPos(0.0F, 0.0F, 12.0F);
        ribs.addChild(rib7);
        rib7.texOffs(4, 55).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib7.texOffs(65, 2).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(0, 49).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(4, 47).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(32, 44).addBox(-8.0F, 1.0F, -6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(32, 42).addBox(4.0F, 1.0F, -6.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(65, 0).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib7.texOffs(0, 55).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        rib9 = new ModelRenderer(this);
        rib9.setPos(0.0F, 0.0F, -2.0F);
        ribs.addChild(rib9);
        rib9.texOffs(54, 49).addBox(1.0F, -11.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib9.texOffs(26, 51).addBox(-7.0F, -11.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib9.texOffs(32, 46).addBox(1.0F, -10.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        rib9.texOffs(17, 46).addBox(-2.0F, -10.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        rib9.texOffs(64, 58).addBox(7.0F, -11.0F, -8.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
        rib9.texOffs(61, 0).addBox(-8.0F, -11.0F, -8.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
        rib9.texOffs(54, 51).addBox(1.0F, 0.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib9.texOffs(0, 19).addBox(-7.0F, 0.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        rib10 = new ModelRenderer(this);
        rib10.setPos(0.0F, 0.0F, 16.0F);
        ribs.addChild(rib10);
        rib10.texOffs(0, 17).addBox(1.0F, -11.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib10.texOffs(0, 15).addBox(-7.0F, -11.0F, -8.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib10.texOffs(20, 44).addBox(1.0F, -10.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        rib10.texOffs(17, 42).addBox(-2.0F, -10.0F, -8.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        rib10.texOffs(60, 58).addBox(7.0F, -11.0F, -8.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
        rib10.texOffs(56, 58).addBox(-8.0F, -11.0F, -8.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
        rib10.texOffs(13, 18).addBox(4.0F, 0.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        rib10.texOffs(13, 16).addBox(-7.0F, 0.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        rib8 = new ModelRenderer(this);
        rib8.setPos(0.0F, 0.0F, -2.0F);
        ribs.addChild(rib8);
        rib8.texOffs(16, 0).addBox(-9.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
        rib8.texOffs(61, 19).addBox(-8.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(0, 47).addBox(-3.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(36, 46).addBox(2.0F, -11.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(61, 17).addBox(-8.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(61, 15).addBox(2.0F, 1.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(61, 13).addBox(2.0F, -12.0F, -6.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
        rib8.texOffs(12, 0).addBox(8.0F, -12.0F, -6.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(legs);


        rightleg = new ModelRenderer(this);
        rightleg.setPos(-5.5F, 7.0F, -2.5F);
        legs.addChild(rightleg);
        setRotationAngle(rightleg, 0.7854F, 0.0F, 0.0F);
        rightleg.texOffs(0, 0).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setPos(5.5F, 7.0F, -2.5F);
        legs.addChild(leftleg);
        setRotationAngle(leftleg, 0.7854F, 0.0F, 0.0F);
        leftleg.texOffs(0, 0).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        wool = new ModelRenderer(this);
        wool.setPos(0.0F, 0.0F, 0.0F);
        all.addChild(wool);
        wool.texOffs(0, 0).addBox(-10.0F, -8.0F, -11.0F, 20.0F, 17.0F, 21.0F, 0.0F, false);
        wool.texOffs(0, 17).addBox(10.0F, 9.0F, -11.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
        wool.texOffs(0, 40).addBox(-10.0F, 9.0F, -11.0F, 20.0F, 2.0F, 0.0F, 0.0F, false);
        wool.texOffs(0, 40).addBox(-10.0F, 9.0F, 10.0F, 20.0F, 2.0F, 0.0F, 0.0F, false);
        wool.texOffs(0, 17).addBox(-10.0F, 9.0F, -11.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
    }

}
