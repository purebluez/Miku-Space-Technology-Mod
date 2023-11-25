package com.Nxer.TwistSpaceTechnology.config;

import static gregtech.api.enums.TierEU.RECIPE_UHV;
import static gregtech.api.enums.TierEU.RECIPE_UMV;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

// spotless:off
public class Config {
    // region Region
    public static final String DSP = "DSP";
    public static final String GENERAL = "General";

    // endregion

//    public static String preInitSign = "pre init GTNH Community Mod";

    // region DSP
    public static long EUPerCriticalPhoton = Integer.MAX_VALUE;
    public static long solarSailPowerPoint = 524288;
    public static long solarSailCanHoldPerNode = 256;
    public static long solarSailCanHoldDefault = 2048;
    public static long maxPowerPointPerReceiver = 1024L * Integer.MAX_VALUE;
    public static long EUEveryAntimatterFuelRod = 1024L * Integer.MAX_VALUE;// default 1024L * Integer.MAX_VALUE;
    public static long EUEveryAntimatter = 4L * Integer.MAX_VALUE;// default 4L * Integer.MAX_VALUE;
    public static double secondsOfArtificialStarProgressCycleTime = 6.4;
    public static int secondsOfEverySpaceWarperProvideToOverloadTime = 60 * 15;
    public static int overloadSpeedUpMultiplier = 30;
    public static double gravitationalLensSpeedMultiplier = 4;
    public static int secondsOfEveryGravitationalLensProvideToIntensifyTime = 60 * 10;
    public static double secondsOfLaunchingSolarSail = 120;
    public static double secondsOfLaunchingNode = 900;
    public static int EUTOfLaunchingSolarSail = (int) RECIPE_UHV;
    public static int EUTOfLaunchingNode = (int) RECIPE_UMV;

    // endregion

    // region General
    public static int MAX_PARALLEL_LIMIT = 8388608;
    public static double secondsOfMiracleDoorProcessingTime = 25.6;
    public static int amountOfPhotonsEveryMiracleDoorProcessingCost = 1;
    public static int multiplierOfMiracleDoorEUCost = 16;

    // endregion

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);
//        preInitSign = configuration.getString("preInitSign", Configuration.CATEGORY_GENERAL, preInitSign, "GTNH Community Mod preInit Sign");

        // General
        MAX_PARALLEL_LIMIT = configuration.getInt("MAX_PARALLEL_LIMIT", GENERAL, MAX_PARALLEL_LIMIT, 1, Integer.MAX_VALUE, "Max parallel limit of normal machines.");
        secondsOfMiracleDoorProcessingTime = Double.parseDouble(configuration.getString("secondsOfMiracleDoorProcessingTime", GENERAL, String.valueOf(secondsOfMiracleDoorProcessingTime), "Seconds of Miracle Door Default Progress Time. Type: double"));
        amountOfPhotonsEveryMiracleDoorProcessingCost = configuration.getInt("amountOfPhotonsEveryMiracleDoorProcessingCost", GENERAL, amountOfPhotonsEveryMiracleDoorProcessingCost, 0, 64, "Needed Photons amount of Miracle Door each run cost.");
        multiplierOfMiracleDoorEUCost = configuration.getInt("multiplierOfMiracleDoorEUCost", GENERAL, multiplierOfMiracleDoorEUCost, 1, Integer.MAX_VALUE, "Miracle Door EU Cost multiplier.");

        // DSP
        EUPerCriticalPhoton = Long.parseLong(configuration.getString("EUPerCriticalPhoton", DSP, String.valueOf(EUPerCriticalPhoton), "EU per Critical Photon Cost. Type: long"));
        solarSailPowerPoint = Long.parseLong(configuration.getString("solarSailPowerPoint", DSP, String.valueOf(solarSailPowerPoint), "DSP Power Point per Solar Sail can produce. Type: long"));
        solarSailCanHoldPerNode = Long.parseLong(configuration.getString("solarSailCanHoldPerNode", DSP, String.valueOf(solarSailCanHoldPerNode), "Solar Sail amount per DSP Node can hold. Type: long"));
        solarSailCanHoldDefault = Long.parseLong(configuration.getString("solarSailCanHoldDefault", DSP, String.valueOf(solarSailCanHoldDefault), "Default Solar Sail amount can hold. Type: long"));
        maxPowerPointPerReceiver = Long.parseLong(configuration.getString("maxPowerPointPerReceiver", DSP, String.valueOf(maxPowerPointPerReceiver), "Max DSP Power Point per DSP Receiver can request. Type: long"));
        EUEveryAntimatterFuelRod = Long.parseLong(configuration.getString("EUEveryAntimatterFuelRod", DSP, String.valueOf(EUEveryAntimatterFuelRod), "EU of every Antimatter Fuel Rod can generate. Type: long"));
        EUEveryAntimatter = Long.parseLong(configuration.getString("EUEveryAntimatter", DSP, String.valueOf(EUEveryAntimatter), "EU of every Antimatter can generate. Type: long"));
        secondsOfArtificialStarProgressCycleTime = Double.parseDouble(configuration.getString("secondsOfArtificialStarProgressCycleTime", DSP, String.valueOf(secondsOfArtificialStarProgressCycleTime), "Seconds of Artificial Star one progress time. Type: double, turn to tick time."));
        secondsOfEverySpaceWarperProvideToOverloadTime = configuration.getInt("secondsOfEverySpaceWarperProvideToOverloadTime", DSP, secondsOfEverySpaceWarperProvideToOverloadTime, 1, Integer.MAX_VALUE, "Overload Time (second) of every Space Warper will provide. Type: int");
        overloadSpeedUpMultiplier = configuration.getInt("overloadSpeedUpMultiplier", DSP, overloadSpeedUpMultiplier, 1, 256, "How much speed up when overload mode. Type: int");
        gravitationalLensSpeedMultiplier = Double.parseDouble(configuration.getString("gravitationalLensSpeedMultiplier", DSP, String.valueOf(gravitationalLensSpeedMultiplier), "How much of Speed Multiplier when in Gravitational Lens intensify mode. Type: double"));
        secondsOfEveryGravitationalLensProvideToIntensifyTime = configuration.getInt("secondsOfEveryGravitationalLensProvideToIntensifyTime", DSP, secondsOfEveryGravitationalLensProvideToIntensifyTime, 0, Integer.MAX_VALUE, "Intensify Mode Time (second) of every Gravitational Lens will provide. Type: int");
        secondsOfLaunchingSolarSail = Double.parseDouble(configuration.getString("secondsOfLaunchingSolarSail", DSP, String.valueOf(secondsOfLaunchingSolarSail), "Seconds of launching a Solar Sail."));
        secondsOfLaunchingNode = Double.parseDouble(configuration.getString("secondsOfLaunchingNode", DSP, String.valueOf(secondsOfLaunchingNode), "Seconds of launching a Dyson Sphere Node."));
        EUTOfLaunchingSolarSail = configuration.getInt("EUTOfLaunchingSolarSail", DSP, EUTOfLaunchingSolarSail, 1, Integer.MAX_VALUE, "EUt of Launching Solar Sail.");
        EUTOfLaunchingNode = configuration.getInt("EUTOfLaunchingNode", DSP, EUTOfLaunchingNode, 1, Integer.MAX_VALUE, "EUt of Launching Node.");


        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
// spotless:on
