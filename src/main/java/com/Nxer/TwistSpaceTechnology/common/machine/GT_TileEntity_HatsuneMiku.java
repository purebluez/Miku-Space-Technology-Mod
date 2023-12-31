package com.Nxer.TwistSpaceTechnology.common.machine;

import static com.github.technus.tectech.thing.casing.TT_Container_Casings.sBlockCasingsTT;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.ofBlock;
import static com.gtnewhorizon.structurelib.structure.StructureUtility.transpose;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_ACTIVE;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_ACTIVE_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_GLOW;
import static gregtech.api.enums.Textures.BlockIcons.casingTexturePages;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

import com.Nxer.TwistSpaceTechnology.common.machine.multiMachineClasses.GTCM_MultiMachineBase;
import com.Nxer.TwistSpaceTechnology.util.TextLocalization;
import com.github.technus.tectech.thing.block.QuantumGlassBlock;
import com.gtnewhorizon.structurelib.alignment.constructable.IConstructable;
import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IItemSource;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import gtPlusPlus.core.block.ModBlocks;

public class GT_TileEntity_HatsuneMiku extends GTCM_MultiMachineBase<GT_TileEntity_HatsuneMiku>
    implements IConstructable, ISurvivalConstructable {

    // region Class Constructor
    public GT_TileEntity_HatsuneMiku(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GT_TileEntity_HatsuneMiku(String aName) {
        super(aName);
    }
    // endregion

    // region Structure
    private final int baseHorizontalOffSet = 9;
    private final int baseVerticalOffSet = 4;
    private final int baseDepthOffSet = 1;
    protected static final String T0 = "Main";

    @Override
    public IStructureDefinition<GT_TileEntity_HatsuneMiku> getStructureDefinition() {
        IStructureDefinition<GT_TileEntity_HatsuneMiku> Structure = StructureDefinition
            .<GT_TileEntity_HatsuneMiku>builder()
            .addShape(
                T0,
                transpose(
                    // spotless:off
                        new String[][] {
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
    {"                  ","                  ","      FF  FF      ","      FF  FF      ","                  ","                  "} }))
                // spotless:on
            .addElement('A', ofBlock(sBlockCasingsTT, 4))
            .addElement('B', ofBlock(sBlockCasingsTT, 7))
            .addElement('C', ofBlock(sBlockCasingsTT, 9))
            .addElement('D', ofBlock(ModBlocks.blockCasings4Misc, 4))
            .addElement('E', ofBlock(QuantumGlassBlock.INSTANCE, 0))
            .addElement('F', ofBlock(sBlockCasingsTT, 4))
            .build();

        return Structure;
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        return checkPiece(T0, baseHorizontalOffSet, baseVerticalOffSet, baseDepthOffSet);
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(T0, stackSize, hintsOnly, 9, 4, 1);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, IItemSource source, EntityPlayerMP actor) {
        if (this.mMachine) return -1;
        int realBudget = elementBudget >= 200 ? elementBudget : Math.min(200, elementBudget * 5);
        return this.survivialBuildPiece(
            T0,
            stackSize,
            baseHorizontalOffSet,
            baseVerticalOffSet,
            baseDepthOffSet,
            realBudget,
            source,
            actor,
            false,
            true);
    }
    // endregion

    // region Overrides
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
            .addInfo(TextLocalization.textScrewdriverChangeMode)
            .addSeparator()
            .addInfo(TextLocalization.StructureTooComplex)
            .addInfo(TextLocalization.BLUE_PRINT_INFO)
            .beginStructureBlock(31, 31, 32, false)
            .addInputHatch(TextLocalization.textUseBlueprint, 1)
            .addOutputHatch(TextLocalization.textUseBlueprint, 1)
            .addInputBus(TextLocalization.textUseBlueprint, 1)
            .addOutputBus(TextLocalization.textUseBlueprint, 1)
            .addMaintenanceHatch(TextLocalization.textUseBlueprint, 1)
            .addEnergyHatch(TextLocalization.textUseBlueprint, 2)
            .toolTipFinisher(TextLocalization.ModName);
        return tt;
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
        return new GTCM_TestMultiMachine(this.mName);
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, ForgeDirection side, ForgeDirection facing,
        int aColorIndex, boolean aActive, boolean aRedstone) {
        if (side == facing) {
            if (aActive) return new ITexture[] { casingTexturePages[1][48], TextureFactory.builder()
                .addIcon(OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_ACTIVE)
                .extFacing()
                .build(),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_ACTIVE_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
            return new ITexture[] { casingTexturePages[1][48], TextureFactory.builder()
                .addIcon(OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR)
                .extFacing()
                .build(),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_LARGE_CHEMICAL_REACTOR_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
        }
        return new ITexture[] { casingTexturePages[1][48] };
    }

    // endregion

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
}
