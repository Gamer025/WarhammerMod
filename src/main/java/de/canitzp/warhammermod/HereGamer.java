package de.canitzp.warhammermod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author canitzp
 */
public class HereGamer implements IExtendedEntityProperties{

    public static final Map<EntityPlayer, HereGamer> playerData = new HashMap<>();

    public int skillXP, skillS, skillP, skillE, skillC, skillI, skillA, skillL;

    @Override
    public void saveNBTData(NBTTagCompound data) {
        data.setInteger("SkillXp", 0);
        data.setInteger("SkillS", 0);
        data.setInteger("SkillP", 0);
        data.setInteger("SkillE", 0);
        data.setInteger("SkillC", 0);
        data.setInteger("SkillI", 0);
        data.setInteger("SkillA", 0);
        data.setInteger("SkillL", 0);
    }

    @Override
    public void loadNBTData(NBTTagCompound data) {
        this.skillXP = data.getInteger("SkillXp");
        this.skillS = data.getInteger("SkillS");
        this.skillP = data.getInteger("SkillP");
        this.skillE = data.getInteger("SkillE");
        this.skillC = data.getInteger("SkillC");
        this.skillI = data.getInteger("SkillI");
        this.skillA = data.getInteger("SkillA");
        this.skillL = data.getInteger("SkillL");
    }

    @Override
    public void init(Entity entity, World world) {

    }
}
