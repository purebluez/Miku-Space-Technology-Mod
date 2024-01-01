package com.Nxer.TwistSpaceTechnology.recipe.specialRecipe;

import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import com.Nxer.TwistSpaceTechnology.common.material.MaterialPool;
import com.Nxer.TwistSpaceTechnology.recipe.IRecipePool;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.MaterialsBotania;
import gregtech.api.enums.TierEU;
import gregtech.api.interfaces.IRecipeMap;
import gregtech.api.recipe.RecipeMaps;

public class MikuFuelRecipePool implements IRecipePool {

    @Override
    public void loadRecipes() {

        final IRecipeMap Mixer = RecipeMaps.mixerRecipes;

        GT_Values.RA.stdBuilder()
            .itemInputs(MaterialsBotania.Manasteel.getIngots(1))
            .fluidOutputs(MaterialPool.Mikulum.getFluidOrGas(1000))
            .noOptimize()
            .duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .addTo(Mixer);
    }
}
