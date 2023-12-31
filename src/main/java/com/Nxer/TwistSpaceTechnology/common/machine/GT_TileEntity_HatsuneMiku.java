package com.Nxer.TwistSpaceTechnology.common.machine;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.transpose;
import static gregtech.api.enums.GT_HatchElement.Energy;
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

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

import com.Nxer.TwistSpaceTechnology.common.machine.multiMachineClasses.GTCM_MultiMachineBase;
import com.Nxer.TwistSpaceTechnology.util.TextLocalization;
import com.gtnewhorizon.structurelib.structure.IItemSource;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import gregtech.api.GregTech_API;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GT_HatchElementBuilder;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import gregtech.api.util.GT_Utility;

public class GT_TileEntity_HatsuneMiku extends GTCM_MultiMachineBase<GT_TileEntity_HatsuneMiku> {

    public GT_TileEntity_HatsuneMiku(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GT_TileEntity_HatsuneMiku(String aName) {
        super(aName);
    }
    // region Processing Logic

    @Override
    protected boolean isEnablePerfectOverclock() {
        return true;
    }

    @Override
    protected float getSpeedBonus() {
        return 1.0F / 16;
    }

    @Override
    protected int getMaxParallelRecipes() {
        return Integer.MAX_VALUE;
    }

    // endregion

    // region Structure
    private int mCasingAmount;
    protected int mode = 0;
    private static final String STRUCTURE_PIECE_MAIN = "main";
    private final String[][] T0 = new String[][] {
        // spotless:off
    {"                  ","      AAAAAA      ","      AAAAAA      ","      AAAAAA      ","      AAAAAA      ","                  "},
    {"      AAAAAA      ","     A      A     ","    BA      AB    ","    BA      AB    ","     A      A     ","      AAAAAA      "},
    {"      AA  AA      ","    BA  EE  AB    ","   ABA      ABA   ","   ABA      ABA   ","    BA      AB    ","      AAAAAA      "},
    {"                  ","    BAEFEEFEAB    ","  AABAE    EABAA  ","  AABAE    EABAA  ","    BAEEEEEEAB    ","      AAAAAA      "},
    {"                  ","      EEE~EE      "," AAAB E    E BAAA "," AAAB E    E BAAA ","      EEEEEE      ","                  "},
    {"                  ","      EECCEE      "," AAA  E    E  AAA "," AAA  E    E  AAA ","      EEEEEE      ","                  "},
    {"                  ","                  "," AA    DDDD    AA "," AA    DDDD    AA ","                  ","                  "},
    {"     FF    FF     ","     FF    FF     ","AAA  EEDDDDEE  AAA","AAA  EEDDDDEE  AAA","                  ","                  "},
    {"     FF    FF     ","     FF    FF     ","AA   EEDDDDEE   AA","AA   EEDDDDEE   AA","                  ","                  "},
    {"                  ","                  ","AA     DDDD     AA","AA     DDDD     AA","                  ","                  "},
    {"                  ","      CCCCCC      ","A     CDDDDC     A","A     CDDDDC     A","      CCCCCC      ","                  "},
    {"                  ","      CAACAA      ","     A      C     ","     A      A     ","      CAACAA      ","                  "},
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
            .addElement('E', ofBlock(GregTech_API.sBlockCasings8, 6))
            .addElement(
                'F',
                GT_HatchElementBuilder.<GT_TileEntity_HatsuneMiku>builder()
                    .atLeast(InputHatch, OutputHatch, InputBus, OutputBus, Maintenance, Energy)
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
    public boolean addToMachineList(IGregTechTileEntity aTileEntity, int aBaseCasingIndex) {
        return super.addToMachineList(aTileEntity, aBaseCasingIndex)
            || addExoticEnergyInputToMachineList(aTileEntity, aBaseCasingIndex);
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return null;
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
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);

        aNBT.setInteger("mode", mode);
    }

    @Override
    public void loadNBTData(final NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);

        mode = aNBT.getInteger("mode");
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
        tt.addMachineType(TextLocalization.Tooltip_ICD_MachineType)
            .addInfo(TextLocalization.StructureTooComplex)
            .addInfo(TextLocalization.BLUE_PRINT_INFO)
            .addSeparator()
            .beginStructureBlock(11, 13, 11, false)
            .addController(TextLocalization.textFrontBottom)
            .addCasingInfoRange(TextLocalization.textCasing, 8, 26, false)
            .addInputHatch(TextLocalization.textAnyCasing, 1)
            .addOutputHatch(TextLocalization.textAnyCasing, 1)
            .addInputBus(TextLocalization.textAnyCasing, 2)
            .addOutputBus(TextLocalization.textAnyCasing, 2)
            .addMaintenanceHatch(TextLocalization.textAnyCasing, 2)
            .addEnergyHatch(TextLocalization.textAnyCasing, 3)
            .toolTipFinisher(TextLocalization.ModName);
        return tt;
    }

    private void onCasingAdded() {
        mCasingAmount++;
    }

    // endregion

}
