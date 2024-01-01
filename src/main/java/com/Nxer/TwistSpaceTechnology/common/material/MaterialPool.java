package com.Nxer.TwistSpaceTechnology.common.material;

import static com.github.bartimaeusnek.bartworks.util.BW_Util.subscriptNumbers;

import com.Nxer.TwistSpaceTechnology.config.Config;
import com.github.bartimaeusnek.bartworks.system.material.Werkstoff;
import com.github.bartimaeusnek.bartworks.util.Pair;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TextureSet;

/**
 * Register new material here by Bartworks Material System
 */
public class MaterialPool implements Runnable {

    /*----------- Test the forge item register -----------*/

    // public static ItemAdder_Basic testItem = new ItemAdder_Basic("Testing Item","testingItem.01");
    // public static ItemStack testItem4 = new ItemStack(testItem,1,1);

    /*----------- Test the forge item register -----------*/

    // ID manager
    private static final int offsetID_01 = 20_000;

    public static final Werkstoff HolmiumGarnet = new Werkstoff(
        new short[] { 96, 96, 240 },
        "Holmium Garnet",
        subscriptNumbers("Ho3Al5O12"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust()
            .addMolten(),
        offsetID_01 + 1,
        TextureSet.SET_SHINY);

    // spotless:off

    public static final Werkstoff.GenerationFeatures gf = new Werkstoff.GenerationFeatures();

    public static Werkstoff eventHorizonDiffusers;

    public static Werkstoff entropyReductionProcess;

    public static Werkstoff realSingularity;

    static {
        if (Config.activateMegaSpaceStation) {
            eventHorizonDiffusers = new Werkstoff(
                new short[] { 255, 255, 255 },
                "Event Horizon Diffusers",
                subscriptNumbers("when we face it, we can do nothing before, but not now"),
                new Werkstoff.Stats(),
                Werkstoff.Types.MATERIAL,
                gf,
                offsetID_01 + 2,
                TextureSet.SET_SHINY);
            entropyReductionProcess = new Werkstoff(
                new short[] { 0, 0, 0 },
                "Entropy Reduction Process",
                subscriptNumbers("Trying to fight against the demise of the universe"),
                new Werkstoff.Stats(),
                Werkstoff.Types.MATERIAL,
                gf,
                offsetID_01 + 3,
                TextureSet.SET_SHINY);
            realSingularity = new Werkstoff(
                new short[] { 127, 127, 127 },
                "Real Singularity",
                subscriptNumbers("Not just a compressed body, but a real miniature black hole"),
                new Werkstoff.Stats(),
                Werkstoff.Types.MATERIAL,
                gf,
                offsetID_01 + 4,
                TextureSet.SET_SHINY);
        }
    }

    public static final Werkstoff PureMana = new Werkstoff(
        new short[] { 176, 196, 222 }, // LightSteelBlue
        "Pure Mana",
        subscriptNumbers("Ma⨕"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 5,
        TextureSet.SET_FLUID);

    public static final Werkstoff LiquidMana = new Werkstoff(
        new short[] { 135, 206, 235 }, // skyblue
        "Liquid Mana",
        subscriptNumbers("??Ma⨕??"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MIXTURE,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 6,
        TextureSet.SET_FLUID,
        new Pair<>(PureMana, 1),
        new Pair<>(Materials.Stone, 2));

    public static final Werkstoff PurifiedMana = new Werkstoff(
        new short[] { 173, 216, 230 }, // LightBLue
        "Purified Mana",
        subscriptNumbers("??Ma⨕??"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MIXTURE,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 7,
        TextureSet.SET_FLUID,
        new Pair<>(PureMana, 1),
        new Pair<>(Materials.Stone, 2));

    public static final Werkstoff Mikulum = new Werkstoff(
        new short[] { 134, 206, 203 }, // Miku Hair
        "Mikulum",
        subscriptNumbers("Miλ"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MIXTURE,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 8,
        TextureSet.SET_FLUID);

    // Bartworks' Material System run on Runnable.class
    @Override
    public void run() {
        for (var prefix : OrePrefixes.values()) {
            gf.addPrefix(prefix);
        }
        gf.removePrefix(OrePrefixes.ore);
    }
}
