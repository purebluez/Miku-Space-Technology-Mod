package com.Nxer.TwistSpaceTechnology.common.recipeMap;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.util.GT_Recipe;

public class TST_Recipe extends GT_Recipe {

    public TST_Recipe(ItemStack[] aInputs, ItemStack[] aOutputs, Object aSpecialItems, int[] aChances,
        FluidStack[] aFluidInputs, FluidStack[] aFluidOutputs, int aDuration, int aEUt, int aSpecialValue) {
        super(
            false,
            aInputs,
            aOutputs,
            aSpecialItems,
            aChances,
            aFluidInputs,
            aFluidOutputs,
            aDuration,
            aEUt,
            aSpecialValue);
    }

}
