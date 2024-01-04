package com.Nxer.TwistSpaceTechnology.recipe.machineRecipe;

import static com.Nxer.TwistSpaceTechnology.util.Utils.setStackSize;
import static com.github.technus.tectech.loader.recipe.BaseRecipeLoader.getItemContainer;
import static com.github.technus.tectech.thing.CustomItemList.DATApipe;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.TierEU.RECIPE_EV;
import static gregtech.api.enums.TierEU.RECIPE_IV;
import static gregtech.api.enums.TierEU.RECIPE_LuV;
import static gregtech.api.enums.TierEU.RECIPE_MAX;
import static gregtech.api.enums.TierEU.RECIPE_UEV;
import static gregtech.api.enums.TierEU.RECIPE_UHV;
import static gregtech.api.enums.TierEU.RECIPE_UIV;
import static gregtech.api.enums.TierEU.RECIPE_UMV;
import static gregtech.api.enums.TierEU.RECIPE_UV;
import static gregtech.api.enums.TierEU.RECIPE_ZPM;
import static gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList.SpaceTimeBendingCore;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.Nxer.TwistSpaceTechnology.TwistSpaceTechnology;
import com.Nxer.TwistSpaceTechnology.common.GTCMItemList;
import com.Nxer.TwistSpaceTechnology.common.recipeMap.GTCMRecipe;
import com.Nxer.TwistSpaceTechnology.config.Config;
import com.Nxer.TwistSpaceTechnology.recipe.IRecipePool;
import com.Nxer.TwistSpaceTechnology.util.Utils;
import com.Nxer.TwistSpaceTechnology.util.recipes.TST_RecipeBuilder;
import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.gthandler.GT_CoreModSupport;
import com.github.bartimaeusnek.bartworks.system.material.WerkstoffLoader;

import goodgenerator.items.MyMaterial;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

// spotless:off
public class MiracleTopRecipePool implements IRecipePool {
    static final RecipeMap<?> MT = GTCMRecipe.MiracleTopRecipes;

    @Override
    public void loadRecipes() {

        TwistSpaceTechnology.LOG.info("MiracleTopRecipePool loading recipes.");

        Fluid solderIndAlloy = FluidRegistry.getFluid("molten.indalloy140");
        Fluid solderPlasma = FluidRegistry.getFluid("molten.mutatedlivingsolder");


        final ItemStack Wrapped_Circuit_Chip_Ram = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32735);
        final ItemStack Wrapped_Circuit_Chip_NanoCPU = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32720);

        final ItemStack Wrapped_Circuit_Parts_CapacitorASMD = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32737);
        final ItemStack Wrapped_Circuit_Parts_TransistorASMD = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32738);
        final ItemStack Wrapped_Circuit_Parts_DiodeASMD = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32739);
        final ItemStack Wrapped_Circuit_Parts_ResistorASMD = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32740);
        final ItemStack Wrapped_Circuit_Parts_InductorASMD = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32707);

        final ItemStack Wrapped_Circuit_Parts_CapacitorXSMD = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32708);
        final ItemStack Wrapped_Circuit_Parts_TransistorXSMD = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32709);
        final ItemStack Wrapped_Circuit_Parts_DiodeXSMD = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32710);
        final ItemStack Wrapped_Circuit_Parts_ResistorXSMD = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32711);

        final ItemStack Wrapped_Circuit_Board_Optical = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32704);
        final ItemStack Wrapped_Optically_Perfected_CPU = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32703);
        final ItemStack Wrapped_Optically_Compatible_Memory = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32701);
        final ItemStack Wrapped_Circuit_Parts_InductorXSMD = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32706);

        final ItemStack Wrapped_Circuit_Board_Bio_Ultra = GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32746);



        // region Quantum Circuit and Piko Circuit
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("dreamcraft", "item.PikoCircuit", 2),
                ItemList.Circuit_Parts_CapacitorXSMD.get(64),
                ItemList.Circuit_Parts_DiodeXSMD.get(64),
                ItemList.Circuit_Parts_TransistorXSMD.get(64),
                ItemList.Circuit_Parts_ResistorXSMD.get(64),
                ItemList.Circuit_Chip_QPIC.get(64)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 3744),
                Materials.UUMatter.getFluid(1000 * 24),
                Materials.Osmium.getMolten(144 * 16),
                Materials.Neutronium.getMolten(144 * 8),
                MyMaterial.shirabon.getMolten(144 * 8),
                Materials.Indium.getMolten(144 * 8),
                MaterialsUEVplus.SpaceTime.getMolten(144 * 4),
                Materials.Lanthanum.getMolten(144 * 2)
            )
            .itemOutputs(GT_ModHandler.getModItem("dreamcraft", "item.QuantumCircuit", 1))
            .eut(RECIPE_UMV)
            .duration(20 * 1000)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Board_Optical.get(1L),
                getItemContainer("PicoWafer").get(4L),
                ItemList.Circuit_OpticalMainframe.get(2),
                ItemList.Circuit_Parts_TransistorXSMD.get(48L),
                ItemList.Circuit_Parts_ResistorXSMD.get(48L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(48L),
                ItemList.Circuit_Parts_DiodeXSMD.get(48L),
                ItemList.Circuit_Chip_PPIC.get(64L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 3744),
                Materials.UUMatter.getFluid(1000 * 8),
                Materials.Osmium.getMolten(144 * 8),
                GT_CoreModSupport.RadoxPolymer.getMolten(144 * 4),
                MaterialsUEVplus.TranscendentMetal.getMolten(144 * 4),
                Materials.Neutronium.getMolten(144 * 2),
                Materials.Lanthanum.getMolten(144 * 8)
            )
            .itemOutputs(GT_ModHandler.getModItem("dreamcraft", "item.PikoCircuit", 1))

            .eut(RECIPE_UMV)
            .duration(20 * 500)
            .addTo(MT);
        // endregion

        // region Optical Circuit

        // Optical SoC frame
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                SpaceTimeBendingCore.get(0),
                ItemList.Optical_Cpu_Containment_Housing.get(2),
                Materials.Glowstone.getNanite(4)
            )
            .fluidInputs(
                MaterialsUEVplus.Space.getMolten(144),
                MaterialsUEVplus.Time.getMolten(144),
                MaterialsUEVplus.SpaceTime.getMolten(144 * 2)
            )
            .itemOutputs(
                GTCMItemList.ParticleTrapTimeSpaceShield.get(1)
            )
            .fluidOutputs(MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(2500))
            .eut(RECIPE_UMV)
            .duration(20 * 64)
            .addTo(MT);


        // Optical Frame
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_OpticalComputer.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(32L),
                ItemList.Circuit_Parts_TransistorXSMD.get(32L),
                ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                ItemList.Circuit_Parts_DiodeXSMD.get(32L),
                ItemList.Circuit_Chip_SoC2.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 64L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 3744),
                Materials.Radon.getPlasma(5760),
                Materials.SuperCoolant.getFluid(1000 * 40),
                WerkstoffLoader.Oganesson.getFluidOrGas(1000 * 2),
                Materials.Tritanium.getMolten(144 * 16),
                Materials.Silicone.getMolten(144 * 32),
                Materials.Polybenzimidazole.getMolten(144 * 32)
            )
            .itemOutputs(ItemList.Circuit_OpticalMainframe.get(1))

            .eut(RECIPE_UEV)
            .duration(20 * 500)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_OpticalComputer.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(32L),
                ItemList.Circuit_Parts_TransistorXSMD.get(32L),
                ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                ItemList.Circuit_Parts_DiodeXSMD.get(32L),
                ItemList.Circuit_Chip_SoC2.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 64L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 3744),
                Materials.Radon.getPlasma(5760),
                Materials.SuperCoolant.getFluid(1000 * 40),
                WerkstoffLoader.Oganesson.getFluidOrGas(1000 * 2),
                Materials.Tritanium.getMolten(144 * 16),
                Materials.StyreneButadieneRubber.getMolten(144 * 32),
                Materials.Polybenzimidazole.getMolten(144 * 32)
            )
            .itemOutputs(ItemList.Circuit_OpticalMainframe.get(1))

            .eut(RECIPE_UEV)
            .duration(20 * 500)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_OpticalComputer.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(32L),
                ItemList.Circuit_Parts_TransistorXSMD.get(32L),
                ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                ItemList.Circuit_Parts_DiodeXSMD.get(32L),
                ItemList.Circuit_Chip_SoC2.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 32L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 3744),
                Materials.Radon.getPlasma(5760),
                Materials.SuperCoolant.getFluid(1000 * 40),
                WerkstoffLoader.Oganesson.getFluidOrGas(1000 * 2),
                Materials.Tritanium.getMolten(144 * 16),
                Materials.Silicone.getMolten(144 * 32),
                Materials.Polybenzimidazole.getMolten(144 * 32)
            )
            .itemOutputs(ItemList.Circuit_OpticalMainframe.get(1))

            .eut(RECIPE_UEV)
            .duration(20 * 500)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_OpticalComputer.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(32L),
                ItemList.Circuit_Parts_TransistorXSMD.get(32L),
                ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                ItemList.Circuit_Parts_DiodeXSMD.get(32L),
                ItemList.Circuit_Chip_SoC2.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 32L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 3744),
                Materials.Radon.getPlasma(5760),
                Materials.SuperCoolant.getFluid(1000 * 40),
                WerkstoffLoader.Oganesson.getFluidOrGas(1000 * 2),
                Materials.Tritanium.getMolten(144 * 16),
                Materials.StyreneButadieneRubber.getMolten(144 * 32),
                Materials.Polybenzimidazole.getMolten(144 * 32)
            )
            .itemOutputs(ItemList.Circuit_OpticalMainframe.get(1))

            .eut(RECIPE_UEV)
            .duration(20 * 500)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_OpticalComputer.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(32L),
                ItemList.Circuit_Parts_TransistorXSMD.get(32L),
                ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                ItemList.Circuit_Parts_DiodeXSMD.get(32L),
                ItemList.Circuit_Chip_SoC2.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUMV, 16L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 3744),
                Materials.Radon.getPlasma(5760),
                Materials.SuperCoolant.getFluid(1000 * 40),
                WerkstoffLoader.Oganesson.getFluidOrGas(1000 * 2),
                Materials.Tritanium.getMolten(144 * 16),
                Materials.Silicone.getMolten(144 * 32),
                Materials.Polybenzimidazole.getMolten(144 * 32)
            )
            .itemOutputs(ItemList.Circuit_OpticalMainframe.get(1))

            .eut(RECIPE_UEV)
            .duration(20 * 500)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_OpticalComputer.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(32L),
                ItemList.Circuit_Parts_TransistorXSMD.get(32L),
                ItemList.Circuit_Parts_ResistorXSMD.get(32L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
                ItemList.Circuit_Parts_DiodeXSMD.get(32L),
                ItemList.Circuit_Chip_SoC2.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUMV, 16L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 3744),
                Materials.Radon.getPlasma(5760),
                Materials.SuperCoolant.getFluid(1000 * 40),
                WerkstoffLoader.Oganesson.getFluidOrGas(1000 * 2),
                Materials.Tritanium.getMolten(144 * 16),
                Materials.StyreneButadieneRubber.getMolten(144 * 32),
                Materials.Polybenzimidazole.getMolten(144 * 32)
            )
            .itemOutputs(ItemList.Circuit_OpticalMainframe.get(1))

            .eut(RECIPE_UEV)
            .duration(20 * 500)
            .addTo(MT);

        // Optical Computer
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Board_Optical.get(2L),
                ItemList.Circuit_OpticalAssembly.get(2L),
                ItemList.Circuit_Parts_TransistorXSMD.get(24L),
                ItemList.Circuit_Parts_ResistorXSMD.get(24L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(24L),
                ItemList.Circuit_Parts_DiodeXSMD.get(24L),
                ItemList.Circuit_Chip_NOR.get(64L),
                ItemList.Circuit_Chip_SoC2.get(32L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 144 * 20),
                Materials.Radon.getPlasma(144 * 20),
                Materials.SuperCoolant.getFluid(1000L * 20),
                WerkstoffLoader.Oganesson.getFluidOrGas(1000),
                MyMaterial.lumiium.getMolten(144 * 4),
                Materials.Silicone.getMolten(144 * 16),
                Materials.Polybenzimidazole.getMolten(144 * 16)
            )
            .itemOutputs(ItemList.Circuit_OpticalComputer.get(1))

            .eut(RECIPE_UHV)
            .duration(20 * 200)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Board_Optical.get(2L),
                ItemList.Circuit_OpticalAssembly.get(2L),
                ItemList.Circuit_Parts_TransistorXSMD.get(24L),
                ItemList.Circuit_Parts_ResistorXSMD.get(24L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(24L),
                ItemList.Circuit_Parts_DiodeXSMD.get(24L),
                ItemList.Circuit_Chip_NOR.get(64L),
                ItemList.Circuit_Chip_SoC2.get(32L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 144 * 20),
                Materials.Radon.getPlasma(144 * 20),
                Materials.SuperCoolant.getFluid(1000L * 20),
                WerkstoffLoader.Oganesson.getFluidOrGas(1000),
                MyMaterial.lumiium.getMolten(144 * 4),
                Materials.StyreneButadieneRubber.getMolten(144 * 16),
                Materials.Polybenzimidazole.getMolten(144 * 16)
            )
            .itemOutputs(ItemList.Circuit_OpticalComputer.get(1))

            .eut(RECIPE_UHV)
            .duration(20 * 200)
            .addTo(MT);

        // Optical Assembly
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Board_Optical.get(1L),
                ItemList.Circuit_OpticalProcessor.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(16L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(20L),
                ItemList.Circuit_Parts_ResistorXSMD.get(20L),
                ItemList.Circuit_Chip_NOR.get(32L),
                ItemList.Circuit_Chip_Ram.get(64L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 1440),
                Materials.Radon.getPlasma(1440L),
                Materials.SuperCoolant.getFluid(10_000L),
                WerkstoffLoader.Oganesson.getFluidOrGas(500),
                MyMaterial.lumiium.getMolten(144 * 3),
                Materials.Silicone.getMolten(144 * 16)
            )
            .itemOutputs(ItemList.Circuit_OpticalAssembly.get(1))

            .eut(RECIPE_UHV)
            .duration(20 * 20)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Board_Optical.get(1L),
                ItemList.Circuit_OpticalProcessor.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(16L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(20L),
                ItemList.Circuit_Parts_ResistorXSMD.get(20L),
                ItemList.Circuit_Chip_NOR.get(32L),
                ItemList.Circuit_Chip_Ram.get(64L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 1440),
                Materials.Radon.getPlasma(1440L),
                Materials.SuperCoolant.getFluid(10_000L),
                WerkstoffLoader.Oganesson.getFluidOrGas(500),
                MyMaterial.lumiium.getMolten(144 * 3),
                Materials.StyreneButadieneRubber.getMolten(144 * 16)
            )
            .itemOutputs(ItemList.Circuit_OpticalAssembly.get(1))

            .eut(RECIPE_UHV)
            .duration(20 * 20)
            .addTo(MT);

        // Optical Processor
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                Utils.copyAmount(1, Wrapped_Optically_Perfected_CPU),
                Utils.copyAmount(2, Wrapped_Optically_Compatible_Memory),
                Utils.copyAmount(16, Wrapped_Circuit_Parts_CapacitorXSMD),
                Utils.copyAmount(16, Wrapped_Circuit_Parts_DiodeXSMD),
                DATApipe.get(64)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 144 * 2),
                Materials.EnrichedHolmium.getMolten(144 * 8)
            )
            .itemOutputs(ItemList.Circuit_OpticalProcessor.get(16))

            .eut(RECIPE_UHV)
            .duration(20 * 240)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                Utils.copyAmount(1, Wrapped_Circuit_Board_Optical),
                GTCMItemList.OpticalSOC.get(1),
                DATApipe.get(16)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 144 * 2),
                Materials.EnrichedHolmium.getMolten(144 * 2)
            )
            .itemOutputs(ItemList.Circuit_OpticalProcessor.get(16))

            .eut(9830400)
            .duration(20 * 10)
            .addTo(MT);

        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(16),
                Utils.copyAmount(16, Wrapped_Circuit_Board_Optical),
                GTCMItemList.OpticalSOC.get(16),
                DATApipe.get(64)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 144 * 32),
                Materials.EnrichedHolmium.getMolten(144 * 16)
            )
            .itemOutputs(setStackSize(ItemList.Circuit_OpticalProcessor.get(64), 64*4))
            .eut(9830400 * 4)
            .duration(20 * 10 * 4)
            .addTo(MT);

        // endregion

        // region Bio Circuit

        // Bio Mainframe
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Biowaresupercomputer.get(2L),
                ItemList.Circuit_Parts_InductorASMD.get(24L),
                ItemList.Circuit_Parts_TransistorASMD.get(24L),
                ItemList.Circuit_Parts_ResistorASMD.get(24L),
                ItemList.Circuit_Parts_CapacitorASMD.get(24L),
                ItemList.Circuit_Parts_DiodeASMD.get(24L),
                ItemList.Circuit_Chip_Ram.get(64L),
                new ItemStack[]{
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUHV, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 32L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUMV, 8L)
                }
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 2880),
                Materials.BioMediumSterilized.getFluid(2880L),
                Materials.SuperCoolant.getFluid(20_000L),
                Materials.Tritanium.getMolten(144 * 8),
                Materials.Silicone.getMolten(144 * 16),
                Materials.Polybenzimidazole.getMolten(144 * 16)
            )
            .itemOutputs(
                ItemList.Circuit_Biomainframe.get(1L)
            )

            .eut(RECIPE_UHV)
            .duration(20 * 300)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Biowaresupercomputer.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(6L),
                ItemList.Circuit_Parts_TransistorXSMD.get(6L),
                ItemList.Circuit_Parts_ResistorXSMD.get(6L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(6L),
                ItemList.Circuit_Parts_DiodeXSMD.get(6L),
                ItemList.Circuit_Chip_Ram.get(64L),
                new ItemStack[]{
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUHV, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 32L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUMV, 8L)
                }
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 2880),
                Materials.BioMediumSterilized.getFluid(2880L),
                Materials.SuperCoolant.getFluid(20_000L),
                Materials.Tritanium.getMolten(144 * 8),
                Materials.Silicone.getMolten(144 * 16),
                Materials.Polybenzimidazole.getMolten(144 * 16)
            )
            .itemOutputs(
                ItemList.Circuit_Biomainframe.get(1L)
            )

            .eut(RECIPE_UHV)
            .duration(20 * 150)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Biowaresupercomputer.get(2L),
                ItemList.Circuit_Parts_InductorASMD.get(24L),
                ItemList.Circuit_Parts_TransistorASMD.get(24L),
                ItemList.Circuit_Parts_ResistorASMD.get(24L),
                ItemList.Circuit_Parts_CapacitorASMD.get(24L),
                ItemList.Circuit_Parts_DiodeASMD.get(24L),
                ItemList.Circuit_Chip_Ram.get(64L),
                new ItemStack[]{
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUHV, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 32L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUMV, 8L)
                }
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 2880),
                Materials.BioMediumSterilized.getFluid(2880L),
                Materials.SuperCoolant.getFluid(20_000L),
                Materials.Tritanium.getMolten(144 * 8),
                Materials.StyreneButadieneRubber.getMolten(144 * 16),
                Materials.Polybenzimidazole.getMolten(144 * 16)
            )
            .itemOutputs(
                ItemList.Circuit_Biomainframe.get(1L)
            )

            .eut(RECIPE_UHV)
            .duration(20 * 300)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Biowaresupercomputer.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(6L),
                ItemList.Circuit_Parts_TransistorXSMD.get(6L),
                ItemList.Circuit_Parts_ResistorXSMD.get(6L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(6L),
                ItemList.Circuit_Parts_DiodeXSMD.get(6L),
                ItemList.Circuit_Chip_Ram.get(64L),
                new ItemStack[]{
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUHV, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 32L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUIV, 16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUMV, 8L)
                }
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 2880),
                Materials.BioMediumSterilized.getFluid(2880L),
                Materials.SuperCoolant.getFluid(20_000L),
                Materials.Tritanium.getMolten(144 * 8),
                Materials.StyreneButadieneRubber.getMolten(144 * 16),
                Materials.Polybenzimidazole.getMolten(144 * 16)
            )
            .itemOutputs(
                ItemList.Circuit_Biomainframe.get(1L)
            )

            .eut(RECIPE_UHV)
            .duration(20 * 150)
            .addTo(MT);

        // Bio SuperComputer
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Board_Bio_Ultra.get(2L),
                ItemList.Circuit_Biowarecomputer.get(2L),
                ItemList.Circuit_Parts_TransistorASMD.get(16L),
                ItemList.Circuit_Parts_ResistorASMD.get(16L),
                ItemList.Circuit_Parts_CapacitorASMD.get(16L),
                ItemList.Circuit_Parts_DiodeASMD.get(16L),
                ItemList.Circuit_Chip_NOR.get(32L),
                ItemList.Circuit_Chip_Ram.get(64L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 1440),
                Materials.BioMediumSterilized.getFluid(1440L),
                Materials.SuperCoolant.getFluid(10_000L),
                Materials.NiobiumTitanium.getMolten(144 * 4),
                Materials.Silicone.getMolten(144 * 16)
            )
            .itemOutputs(
                ItemList.Circuit_Biowaresupercomputer.get(1L)
            )

            .eut(RECIPE_UV)
            .duration(20 * 200)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Board_Bio_Ultra.get(2L),
                ItemList.Circuit_Biowarecomputer.get(2L),
                ItemList.Circuit_Parts_TransistorXSMD.get(4L),
                ItemList.Circuit_Parts_ResistorXSMD.get(4L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(4L),
                ItemList.Circuit_Parts_DiodeXSMD.get(4L),
                ItemList.Circuit_Chip_NOR.get(32L),
                ItemList.Circuit_Chip_Ram.get(64L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 1440),
                Materials.BioMediumSterilized.getFluid(1440L),
                Materials.SuperCoolant.getFluid(10_000L),
                Materials.NiobiumTitanium.getMolten(144 * 4),
                Materials.Silicone.getMolten(144 * 16)
            )
            .itemOutputs(
                ItemList.Circuit_Biowaresupercomputer.get(1L)
            )

            .eut(RECIPE_UV)
            .duration(20 * 100)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Board_Bio_Ultra.get(2L),
                ItemList.Circuit_Biowarecomputer.get(2L),
                ItemList.Circuit_Parts_TransistorASMD.get(16L),
                ItemList.Circuit_Parts_ResistorASMD.get(16L),
                ItemList.Circuit_Parts_CapacitorASMD.get(16L),
                ItemList.Circuit_Parts_DiodeASMD.get(16L),
                ItemList.Circuit_Chip_NOR.get(32L),
                ItemList.Circuit_Chip_Ram.get(64L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 1440),
                Materials.BioMediumSterilized.getFluid(1440L),
                Materials.SuperCoolant.getFluid(10_000L),
                Materials.NiobiumTitanium.getMolten(144 * 4),
                Materials.StyreneButadieneRubber.getMolten(144 * 16)
            )
            .itemOutputs(
                ItemList.Circuit_Biowaresupercomputer.get(1L)
            )

            .eut(RECIPE_UV)
            .duration(20 * 200)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                ItemList.Circuit_Board_Bio_Ultra.get(2L),
                ItemList.Circuit_Biowarecomputer.get(2L),
                ItemList.Circuit_Parts_TransistorXSMD.get(4L),
                ItemList.Circuit_Parts_ResistorXSMD.get(4L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(4L),
                ItemList.Circuit_Parts_DiodeXSMD.get(4L),
                ItemList.Circuit_Chip_NOR.get(32L),
                ItemList.Circuit_Chip_Ram.get(64L)
            )
            .fluidInputs(
                new FluidStack(solderPlasma, 1440),
                Materials.BioMediumSterilized.getFluid(1440L),
                Materials.SuperCoolant.getFluid(10_000L),
                Materials.NiobiumTitanium.getMolten(144 * 4),
                Materials.StyreneButadieneRubber.getMolten(144 * 16)
            )
            .itemOutputs(
                ItemList.Circuit_Biowaresupercomputer.get(1L)
            )

            .eut(RECIPE_UV)
            .duration(20 * 100)
            .addTo(MT);

        // Bio Assembly
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                Utils.copyAmount(1, Wrapped_Circuit_Board_Bio_Ultra),
                ItemList.Circuit_Bioprocessor.get(32),
                Utils.copyAmount(12, Wrapped_Circuit_Parts_InductorASMD),
                Utils.copyAmount(16, Wrapped_Circuit_Parts_CapacitorASMD),
                Utils.copyAmount(32, Wrapped_Circuit_Chip_Ram)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 144),
                Materials.NiobiumTitanium.getMolten(144 * 8)
            )
            .itemOutputs(
                ItemList.Circuit_Biowarecomputer.get(16)
            )

            .eut(RECIPE_UV)
            .duration(20 * 240)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                Utils.copyAmount(1, Wrapped_Circuit_Board_Bio_Ultra),
                ItemList.Circuit_Bioprocessor.get(32),
                Utils.copyAmount(3, Wrapped_Circuit_Parts_InductorXSMD),
                Utils.copyAmount(4, Wrapped_Circuit_Parts_CapacitorXSMD),
                Utils.copyAmount(32, Wrapped_Circuit_Chip_Ram)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 144),
                Materials.NiobiumTitanium.getMolten(144 * 8)
            )
            .itemOutputs(
                ItemList.Circuit_Biowarecomputer.get(16)
            )

            .eut(RECIPE_UHV)
            .duration(20 * 30)
            .addTo(MT);

        // Bio Processor
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32714),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32716),
                Utils.copyAmount(2, Wrapped_Circuit_Chip_NanoCPU),
                Utils.copyAmount(12, Wrapped_Circuit_Parts_CapacitorASMD),
                Utils.copyAmount(12, Wrapped_Circuit_Parts_TransistorASMD)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 72),
                Materials.NiobiumTitanium.getMolten(144 * 32)
            )
            .itemOutputs(
                ItemList.Circuit_Bioprocessor.get(16)
            )

            .eut(RECIPE_UV)
            .duration(20 * 180)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32714),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32716),
                Utils.copyAmount(2, Wrapped_Circuit_Chip_NanoCPU),
                Utils.copyAmount(3, Wrapped_Circuit_Parts_CapacitorXSMD),
                Utils.copyAmount(3, Wrapped_Circuit_Parts_TransistorXSMD)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 72),
                Materials.NiobiumTitanium.getMolten(144 * 32)
            )
            .itemOutputs(
                ItemList.Circuit_Bioprocessor.get(16)
            )

            .eut(RECIPE_UHV)
            .duration(444)
            .addTo(MT);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                Utils.copyAmount(1, Wrapped_Circuit_Board_Bio_Ultra),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32699)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 144),
                new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), 144 * 8),
                Materials.NiobiumTitanium.getMolten(144 * 32)
            )
            .itemOutputs(
                ItemList.Circuit_Bioprocessor.get(16)
            )

            .eut(RECIPE_UEV)
            .duration(450)
            .addTo(MT);

        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(16),
                Utils.copyAmount(12, Wrapped_Circuit_Board_Bio_Ultra),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32699)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 144 * 12),
                new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), 144 * 8 * 12),
                Materials.NiobiumTitanium.getMolten(144 * 32 * 12)
            )
            .itemOutputs(setStackSize(ItemList.Circuit_Bioprocessor.get(64), 64*4))
            .eut(RECIPE_UIV)
            .duration(450 * 3)
            .addTo(MT);

        // endregion

        // region Wetware Processor SoC
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32750),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32700)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 144),
                Materials.YttriumBariumCuprate.getMolten(144 * 16),
                Materials.CosmicNeutronium.getMolten(144 * 8)
            )
            .itemOutputs(
                ItemList.Circuit_Neuroprocessor.get(16)
            )
            .eut(614400)
            .duration(20 * 15)
            .addTo(MT);

        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(16),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32750),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32700)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 144 * 12),
                Materials.YttriumBariumCuprate.getMolten(144 * 16 * 12),
                Materials.CosmicNeutronium.getMolten(144 * 8 * 12)
            )
            .itemOutputs(setStackSize(ItemList.Circuit_Neuroprocessor.get(64), 64*4))
            .eut(614400 * 4)
            .duration(20 * 15 * 3)
            .addTo(MT);

        // endregion

        // region Crystal Processor SoC
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32753),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32717)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 72),
                Materials.NiobiumTitanium.getMolten(144 * 16),
                Materials.YttriumBariumCuprate.getMolten(144 * 8))
            .itemOutputs(
                ItemList.Circuit_Crystalprocessor.get(16)
            )

            .eut(153600)
            .duration(20 * 15)
            .addTo(MT);

        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(16),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32753),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32717)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 72 * 12),
                Materials.NiobiumTitanium.getMolten(144 * 16 * 12),
                Materials.YttriumBariumCuprate.getMolten(144 * 8 * 12))
            .itemOutputs(setStackSize(ItemList.Circuit_Crystalprocessor.get(64), 64*4))
            .eut(153600 * 4)
            .duration(20 * 15 * 3)
            .addTo(MT);

        // endregion

        // region Quantum Processor SoC
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32754),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32730)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 72),
                Materials.Platinum.getMolten(144 * 32),
                Materials.NiobiumTitanium.getMolten(144 * 8)
            )
            .itemOutputs(
                ItemList.Circuit_Quantumprocessor.get(16)
            )

            .eut(38400)
            .duration(20 * 15)
            .addTo(MT);

        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(16),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32754),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32730)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 72 * 12),
                Materials.Platinum.getMolten(144 * 32 * 12),
                Materials.NiobiumTitanium.getMolten(144 * 8 * 12)
            )
            .itemOutputs(setStackSize(ItemList.Circuit_Quantumprocessor.get(64), 64*4))
            .eut(38400 * 4)
            .duration(20 * 15 * 3)
            .addTo(MT);

        // endregion

        // region Nano Processor SoC
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32756),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32730)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 72),
                Materials.Electrum.getMolten(144 * 16),
                Materials.Platinum.getMolten(144 * 8)
            )
            .itemOutputs(
                ItemList.Circuit_Nanoprocessor.get(16)
            )
            .eut(9600)
            .duration(20 * 15)
            .addTo(MT);

        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(16),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32756),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32730)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 72 * 12),
                Materials.Electrum.getMolten(144 * 16 * 12),
                Materials.Platinum.getMolten(144 * 8 * 12)
            )
            .itemOutputs(setStackSize(ItemList.Circuit_Nanoprocessor.get(64), 64*4))
            .eut(9600 * 4)
            .duration(20 * 15 * 3)
            .addTo(MT);

        // endregion

        // region High Energy Flow Circuit
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32753),
                GT_ModHandler.getModItem("GoodGenerator", "circuitWrap", 2, 7),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 8, 32721)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 288),
                Materials.Infinity.getMolten(144)
            )
            .itemOutputs(
                GT_ModHandler.getModItem("dreamcraft", "item.HighEnergyFlowCircuit", 16)
            )

            .eut(RECIPE_IV)
            .duration(20 * 720)
            .addTo(MT);

        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(16),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32753),
                GT_ModHandler.getModItem("GoodGenerator", "circuitWrap", 24, 7),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 48, 32721)
            )
            .fluidInputs(
                new FluidStack(solderIndAlloy, 288 * 12),
                Materials.Infinity.getMolten(144 * 12)
            )
            .itemOutputs(setStackSize(GT_ModHandler.getModItem("dreamcraft", "item.HighEnergyFlowCircuit", 64),64*4))
            .eut(RECIPE_LuV)
            .duration(20 * 720 * 3)
            .addTo(MT);

        //ULV LV and MV circuit
        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(16),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32756),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 48, 32728)
            )
            .fluidInputs(
                Materials.SolderingAlloy.getMolten(18 * 4),
                Materials.AnnealedCopper.getMolten(144 * 2 * 4),
                Materials.RedAlloy.getMolten(144 * 8)
            )
            .itemOutputs(setStackSize(CustomItemList.NandChipBoard.get(64), 64*16))
            .eut(RECIPE_EV)
            .duration(20 * 90 * 4)
            .addTo(MT);

        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(16),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32748),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32731)
            )
            .fluidInputs(
                Materials.SolderingAlloy.getMolten(72 * 12),
                Materials.Copper.getMolten(144 * 96)
            )
            .itemOutputs(setStackSize(ItemList.Circuit_Microprocessor.get(64),64*8))
            .eut(600)
            .duration(20 * 30 * 4)
            .addTo(MT);

        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(16),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32748),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 12, 32731)
            )
            .fluidInputs(
                Materials.SolderingAlloy.getMolten(72 * 12),
                Materials.AnnealedCopper.getMolten(144 * 8 * 12),
                Materials.RedAlloy.getMolten(144 * 24)
            )
            .itemOutputs(setStackSize(ItemList.Circuit_Processor.get(1), 64*4))
            .eut(RECIPE_EV)
            .duration(20 * 90 * 4)
            .addTo(MT);

        // endregion

        // region Neuro Processing Unit and Bio Processing Unit
        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32750),
                setStackSize(ItemList.Circuit_Chip_Stemcell.get(64), 64*4)
            )
            .fluidInputs(
                Materials.ReinforceGlass.getMolten(16 * 16 * 288),
                Materials.Polybenzimidazole.getMolten(16 * 8 * 72),
                Materials.NaquadahEnriched.getMolten(16 * 4 * 72),
                Materials.Silicone.getMolten(16 * 16 * 144),
                Materials.TungstenSteel.getMolten(16 * 32 * 18),
                Materials.GrowthMediumSterilized.getFluid(16 * 250),
                Materials.UUMatter.getFluid(16 * 250),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000 * 16)
            )
            .itemOutputs(ItemList.Circuit_Chip_NeuroCPU.get(16))
            .eut(RECIPE_ZPM)
            .duration(20 * 30 * 12)
            .addTo(MT);

        TST_RecipeBuilder
            .builder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 32746),
                setStackSize(ItemList.Circuit_Chip_Biocell.get(64), 64*4)
            )
            .fluidInputs(
                Materials.ReinforceGlass.getMolten(16 * 16 * 288),
                Materials.Polybenzimidazole.getMolten(16 * 16 * 72),
                Materials.ElectrumFlux.getMolten(16 * 16 * 72),
                Materials.Silicone.getMolten(16 * 16 * 144),
                Materials.HSSS.getMolten(16 * 32 * 18),
                Materials.BioMediumSterilized.getFluid(16 * 500),
                Materials.UUMatter.getFluid(16 * 500),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000 * 16)
            )
            .itemOutputs(ItemList.Circuit_Chip_BioCPU.get(16))
            .eut(RECIPE_UHV)
            .duration(20 * 30 * 12)
            .addTo(MT);
        // endregion

        // region Proof Of Heroes
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GTCMItemList.SpaceWarper.get(64),
                GT_ModHandler.getModItem("eternalsingularity", "eternal_singularity", 64),
                GT_ModHandler.getModItem("eternalsingularity", "combined_singularity", 64, 15),
                ItemList.Timepiece.get(64),
                ItemList.GigaChad.get(64),
                com.github.technus.tectech.thing.CustomItemList.SpacetimeCompressionFieldGeneratorTier8.get(64),
                com.github.technus.tectech.thing.CustomItemList.TimeAccelerationFieldGeneratorTier8.get(64),
                com.github.technus.tectech.thing.CustomItemList.StabilisationFieldGeneratorTier8.get(64),
                GT_ModHandler.getModItem("dreamcraft", "item.QuantumCircuit", 64),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "particleBase", 64, 15),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "particleBase", 64, 16),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "particleBase", 64, 20),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "particleBase", 64, 21),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "particleBase", 64, 17),
                ItemList.ZPM6.get(64),
                GTCMItemList.ArtificialStar.get(64)
            )
            .fluidInputs(
                MaterialsUEVplus.Time.getMolten(1000 * 114514),
                MaterialsUEVplus.Space.getMolten(1000 * 114514),
                MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(1000 * 114514),
                MyMaterial.shirabon.getMolten(1000 * 114514),
                MaterialsUEVplus.Universium.getMolten(1000 * 114514),
                MaterialsUEVplus.Eternity.getMolten(1000 * 114514),
                MaterialsUEVplus.PrimordialMatter.getFluid(1000 * 114514)
            )
            .itemOutputs(GTCMItemList.ProofOfHeroes.get(1))
            .noOptimize()
            .specialValue(13500)
            .eut(RECIPE_MAX)
            .duration(20 * 1919810)
            .addTo(MT);


        // endregion
        if (Config.activateMegaSpaceStation) {
            loadMaxRecipe();
        }
    }

    public void loadMaxRecipe() {
        ItemStack[] inStack = new ItemStack[]{
            ItemList.Circuit_Parts_ResistorXSMD.get(16),
            ItemList.Circuit_Parts_DiodeXSMD.get(16),
            ItemList.Circuit_Parts_TransistorXSMD.get(16),
            ItemList.Circuit_Parts_CapacitorXSMD.get(16),
            ItemList.Circuit_Parts_InductorXSMD.get(16)
        };
        ItemStack[] outStack = new ItemStack[]{
            GTCMItemList.HighDimensionalResistor.get(64),
            GTCMItemList.HighDimensionalDiode.get(64),
            GTCMItemList.HighDimensionalTransistor.get(64),
            GTCMItemList.HighDimensionalCapacitor.get(64),
            GTCMItemList.HighDimensionalInterface.get(64),
        };
        for (int i = 0; i < 5; i++) {
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_Utility.getIntegratedCircuit(12),
                    GT_OreDictUnificator.get(OrePrefixes.foil, MaterialsUEVplus.TranscendentMetal, 4),
                    GT_OreDictUnificator.get(OrePrefixes.foil, MaterialsUEVplus.Universium, 2),
                    inStack[i],
                    GTCMItemList.HighDimensionalExtend.get(1)
                )
                .fluidInputs(
                    MaterialsUEVplus.Time.getMolten(144)
                )
                .itemOutputs(
                    outStack[i]
                )
                .eut(RECIPE_UEV)
                .duration(20)
                .addTo(MT);
        }


    }

//    HighDimensionalExtend,
//    HighDimensionalCircuitDoard,

    // pattern
    /*
    GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(1)

            )
            .fluidInputs(

            )
            .itemOutputs(

            )

            .eut()
            .duration(20)
            .addTo(MT);
     */
}
// spotless:on
