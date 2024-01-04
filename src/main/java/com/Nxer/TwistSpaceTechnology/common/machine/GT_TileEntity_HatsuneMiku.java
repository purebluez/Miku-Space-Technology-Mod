package com.Nxer.TwistSpaceTechnology.common.machine;

import static com.Nxer.TwistSpaceTechnology.config.Config.EUPerMikulumL;
import static com.Nxer.TwistSpaceTechnology.util.TextHandler.texter;
import static com.Nxer.TwistSpaceTechnology.util.Utils.fluidEqual;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.transpose;
import static gregtech.api.enums.GT_HatchElement.Dynamo;
import static gregtech.api.enums.GT_HatchElement.InputBus;
import static gregtech.api.enums.GT_HatchElement.InputHatch;
import static gregtech.api.enums.GT_HatchElement.Maintenance;
import static gregtech.api.enums.GT_HatchElement.OutputBus;
import static gregtech.api.enums.GT_HatchElement.OutputHatch;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_ACTIVE;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_ACTIVE_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.casingTexturePages;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

import com.Nxer.TwistSpaceTechnology.common.machine.multiMachineClasses.GTCM_MultiMachineBase;
import com.Nxer.TwistSpaceTechnology.common.material.MaterialPool;
import com.Nxer.TwistSpaceTechnology.common.recipeMap.GTCMRecipe;
import com.Nxer.TwistSpaceTechnology.util.TextLocalization;
import com.gtnewhorizon.structurelib.structure.IItemSource;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import gregtech.api.GregTech_API;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.recipe.check.CheckRecipeResultRegistry;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GT_HatchElementBuilder;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import gregtech.api.util.GT_Utility;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;

public class GT_TileEntity_HatsuneMiku extends GTCM_MultiMachineBase<GT_TileEntity_HatsuneMiku> {

    public GT_TileEntity_HatsuneMiku(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GT_TileEntity_HatsuneMiku(String aName) {
        super(aName);
    }
    // region Processing Logic

    @Override
    public CheckRecipeResult checkProcessing() {

        ArrayList<FluidStack> tFluids = getStoredFluids();
        for (int i = 0; i < tFluids.size() - 1; i++) {
            for (int j = i + 1; j < tFluids.size(); j++) {
                if (GT_Utility.areFluidsEqual(tFluids.get(i), tFluids.get(j))) {
                    if ((tFluids.get(i)).amount >= (tFluids.get(j)).amount) {
                        tFluids.remove(j--);
                    } else {
                        tFluids.remove(i--);
                        break;
                    }
                }
            }
        }

        boolean hasRecipe = false;
        FluidStack[] input = getStoredFluids().toArray(new FluidStack[0]);
        for (FluidStack fluids : getStoredFluids()) {
            if (fluidEqual(fluids, MaterialPool.Mikulum.getFluidOrGas(1000))) {
                consumeFuel(MaterialPool.Mikulum.getFluidOrGas(1000), input);
                hasRecipe = true;
                currentOutputEU += EUPerMikulumL * outputMultiplier;
            }
        }

        if (!hasRecipe) {
            return CheckRecipeResultRegistry.NO_RECIPE;
        }
        updateSlots();
        return CheckRecipeResultRegistry.GENERATING;
    }

    public boolean consumeFuel(FluidStack target, FluidStack[] input) {
        if (target == null) return false;
        for (FluidStack inFluid : input) {
            if (inFluid != null && inFluid.isFluidEqual(target) && inFluid.amount >= target.amount) {
                inFluid.amount -= target.amount;
                return true;
            }
        }
        return false;
    }

    private double outputMultiplier = 1;
    // private int tierTwintail = -1;
    private long currentOutputEU = 0;
    private long storageEU = 0;

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
        aNBT.setLong("storageEU", storageEU);
        aNBT.setDouble("outputMultiplier", outputMultiplier);
        aNBT.setLong("currentOutputEU", currentOutputEU);
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        storageEU = aNBT.getLong("storageEU");
        outputMultiplier = aNBT.getDouble("outputMultiplier");
        currentOutputEU = aNBT.getLong("currentOutputEU");
    }

    @Override
    public void getWailaBody(ItemStack itemStack, List<String> currentTip, IWailaDataAccessor accessor,
        IWailaConfigHandler config) {
        super.getWailaBody(itemStack, currentTip, accessor, config);
        final NBTTagCompound tag = accessor.getNBTData();
        if (tag.getBoolean("isActive")) {
            currentTip.add(
                EnumChatFormatting.AQUA + texter("Concert will generate : ")
                    + EnumChatFormatting.BLUE
                    + tag.getLong("currentOutputEU")
                    + EnumChatFormatting.RESET
                    + " EU");
        }
    }

    @Override
    public void getWailaNBTData(EntityPlayerMP player, TileEntity tile, NBTTagCompound tag, World world, int x, int y,
        int z) {
        super.getWailaNBTData(player, tile, tag, world, x, y, z);
        final IGregTechTileEntity tileEntity = getBaseMetaTileEntity();
        if (tileEntity != null) {
            if (tileEntity.isActive()) {
                tag.setLong("currentOutputEU", currentOutputEU);
            }
        }
    }

    @Override
    protected boolean isEnablePerfectOverclock() {
        return true;
    }

    @Override
    protected float getSpeedBonus() {
        return 1.0F;
    }

    @Override
    protected int getMaxParallelRecipes() {
        return 1;
    }

    // endregion

    // region Structure
    // protected int mode = 0;
    private static final String STRUCTURE_PIECE_MAIN = "main";
    private final String[][] T0 = new String[][] {
        // spotless:off
    {"                  ","      AAAAAA      ","      AAAAAA      ","      AAAAAA      ","      AAAAAA      ","                  "},
    {"      AAAAAA      ","     A      A     ","    BA      AB    ","    BA      AB    ","     A      A     ","      AAAAAA      "},
    {"      AA  AA      ","    BA  EE  AB    ","   ABA      ABA   ","   ABA      ABA   ","    BA      AB    ","      AAAAAA      "},
    {"                  ","    BAEFEEFEAB    ","  AABAE    EABAA  ","  AABAE    EABAA  ","    BAEEEEEEAB    ","      AAAAAA      "},
    {"                  ","      EEE~EE      "," AAAB E    E BAAA "," AAAB E    E BAAA ","      EEEEEE      ","                  "},
    {"                  ","      EECCEE      "," AAA  EEEEEE  AAA "," AAA  EEEEEE  AAA ","      EEEEEE      ","                  "},
    {"                  ","                  "," AA    DDDD    AA "," AA    DDDD    AA ","                  ","                  "},
    {"     FF    FF     ","     FF    FF     ","AAA  EEDDDDEE  AAA","AAA  EEDDDDEE  AAA","                  ","                  "},
    {"     FF    FF     ","     FF    FF     ","AA   EEDDDDEE   AA","AA   EEDDDDEE   AA","                  ","                  "},
    {"                  ","                  ","AA     DDDD     AA","AA     DDDD     AA","                  ","                  "},
    {"                  ","      CCCCCC      ","A     CDDDDC     A","A     CDDDDC     A","      CCCCCC      ","                  "},
    {"                  ","      CAACAA      ","     AC    CC     ","     AC    CA     ","      CAACAA      ","                  "},
    {"                  ","                  ","      EE  EE      ","      EE  EE      ","                  ","                  "},
    {"                  ","                  ","      FF  FF      ","      FF  FF      ","                  ","                  "},
    {"                  ","                  ","      FF  FF      ","      FF  FF      ","                  ","                  "},
    {"                  ","                  ","      FF  FF      ","      FF  FF      ","                  ","                  "}
    };
    // spotless:on
    private final int horizontalOffSet = 9;
    private final int verticalOffSet = 4;
    private final int depthOffSet = 1;

    @Override
    public IStructureDefinition<GT_TileEntity_HatsuneMiku> getStructureDefinition() {
        return StructureDefinition.<GT_TileEntity_HatsuneMiku>builder()
            .addShape(STRUCTURE_PIECE_MAIN, transpose(T0))
            .addElement('A', ofBlock(GregTech_API.sBlockCasings2, 1))
            .addElement('B', ofBlock(GregTech_API.sBlockCasings4, 2))
            .addElement('C', ofBlock(GregTech_API.sBlockCasings8, 0))
            .addElement('D', ofBlock(GregTech_API.sBlockCasings1, 5))
            .addElement(
                'E',
                GT_HatchElementBuilder.<GT_TileEntity_HatsuneMiku>builder()
                    .atLeast(InputHatch, OutputHatch, InputBus, OutputBus, Maintenance, Dynamo)
                    .dot(1)
                    .casingIndex(GT_Utility.getCasingTextureIndex(GregTech_API.sBlockCasings8, 6))
                    .buildAndChain(GregTech_API.sBlockCasings8, 6))
            .addElement(
                'F',
                GT_HatchElementBuilder.<GT_TileEntity_HatsuneMiku>builder()
                    .atLeast(InputHatch, OutputHatch, InputBus, OutputBus, Maintenance, Dynamo)
                    .dot(1)
                    .casingIndex(GT_Utility.getCasingTextureIndex(GregTech_API.sBlockCasings8, 10))
                    .buildAndChain(GregTech_API.sBlockCasings8, 10))
            .build();
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, horizontalOffSet, verticalOffSet, depthOffSet);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, IItemSource source, EntityPlayerMP actor) {
        if (this.mMachine) return -1;
        int realBudget = elementBudget >= 200 ? elementBudget : Math.min(200, elementBudget * 5);
        return this.survivialBuildPiece(
            STRUCTURE_PIECE_MAIN,
            stackSize,
            horizontalOffSet,
            verticalOffSet,
            depthOffSet,
            realBudget,
            source,
            actor,
            false,
            true);
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        return checkPiece(STRUCTURE_PIECE_MAIN, horizontalOffSet, verticalOffSet, depthOffSet);
    }

    // endregion

    // region Overrides
    @Override
    public RecipeMap<?> getRecipeMap() {
        return GTCMRecipe.HatsuneMikuRecipes;
    }

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return true;
    }

    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }

    @Override
    public int getDamageToComponent(ItemStack aStack) {
        return 0;
    }

    @Override
    public boolean explodesOnComponentBreak(ItemStack aStack) {
        return false;
    }

    @Override
    public boolean supportsVoidProtection() {
        return true;
    }

    @Override
    public boolean supportsInputSeparation() {
        return true;
    }

    @Override
    public boolean supportsBatchMode() {
        return true;
    }

    @Override
    public boolean supportsSingleRecipeLocking() {
        return true;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_TileEntity_HatsuneMiku(this.mName);
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, ForgeDirection side, ForgeDirection facing,
        int aColorIndex, boolean aActive, boolean aRedstone) {
        if (side == facing) {
            if (aActive) return new ITexture[] { casingTexturePages[1][54], TextureFactory.builder()
                .addIcon(OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_ACTIVE)
                .extFacing()
                .build(),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_ACTIVE_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
            return new ITexture[] { casingTexturePages[1][54], TextureFactory.builder()
                .addIcon(OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR)
                .extFacing()
                .build(),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
        }
        return new ITexture[] { casingTexturePages[1][54] };
    }

    // Tooltips
    @Override
    protected GT_Multiblock_Tooltip_Builder createTooltip() {
        final GT_Multiblock_Tooltip_Builder tt = new GT_Multiblock_Tooltip_Builder();
        tt.addMachineType(TextLocalization.Tooltip_HatsuneMiku_MachineType)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_01)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_02)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_03)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_04)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_05)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_06)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_07)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_08)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_09)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_2_01)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_2_02)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_2_03)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_2_04)
            .addInfo(TextLocalization.Tooltip_HatsuneMiku_2_05)
            .addSeparator()
            .addInfo(TextLocalization.StructureTooComplex)
            .addInfo(TextLocalization.BLUE_PRINT_INFO)
            .beginStructureBlock(19, 19, 21, false)
            .addInputHatch(TextLocalization.textUseBlueprint, 1)
            .addOutputHatch(TextLocalization.textUseBlueprint, 1)
            .addInputBus(TextLocalization.textUseBlueprint, 1)
            .addOutputBus(TextLocalization.textUseBlueprint, 1)
            .addMaintenanceHatch(TextLocalization.textUseBlueprint, 3)
            .addEnergyHatch(TextLocalization.textUseBlueprint, 2)
            .toolTipFinisher(TextLocalization.ModName);
        return tt;
    }

    // endregion

}
