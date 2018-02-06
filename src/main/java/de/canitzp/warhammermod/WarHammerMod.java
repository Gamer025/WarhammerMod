package de.canitzp.warhammermod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author canitzp
 */
@Mod(modid = WarHammerMod.MODID, name = WarHammerMod.NAME, version = WarHammerMod.VERSION)
public class WarHammerMod {

    public static final String MODID = "warhammermod";
    public static final String NAME = "WarHammer Mod";
    public static final String VERSION = "1.0.0";

    public static Logger LOG = LogManager.getLogger(NAME);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        LOG.info("[PreInit] Loading " + NAME + " v" + VERSION);
    }

}
