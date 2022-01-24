package com.ichthyosaur.returntosoil.core.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ReturnToSoilItemGroup extends ItemGroup {

    public static final ReturnToSoilItemGroup RETURN_TO_SOIL = new ReturnToSoilItemGroup(ItemGroup.getGroupCountSafe(),
            "returntosoil");

    public ReturnToSoilItemGroup(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemInit.ORIGIN_BERRY_SEED.get());
    }
}
