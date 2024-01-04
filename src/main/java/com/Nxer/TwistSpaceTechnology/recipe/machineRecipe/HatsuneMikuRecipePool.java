package com.Nxer.TwistSpaceTechnology.recipe.machineRecipe;

import static com.Nxer.TwistSpaceTechnology.config.Config.EUPerMikulumL;

import com.Nxer.TwistSpaceTechnology.common.material.MaterialPool;
import com.Nxer.TwistSpaceTechnology.common.recipeMap.GTCMRecipe;
import com.Nxer.TwistSpaceTechnology.recipe.IRecipePool;

import gregtech.api.enums.GT_Values;

public class HatsuneMikuRecipePool implements IRecipePool {

    @Override
    public void loadRecipes() {

        GT_Values.RA.stdBuilder()
            .fluidInputs(MaterialPool.Mikulum.getFluidOrGas(1000))
            .noOptimize()
            .specialValue((int) (EUPerMikulumL * 1000))
            .eut(0)
            .duration(200)
            .addTo(GTCMRecipe.HatsuneMikuRecipes);
    }
}
