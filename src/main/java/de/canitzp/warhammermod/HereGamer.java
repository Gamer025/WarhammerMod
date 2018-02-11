package de.canitzp.warhammermod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;


import java.util.HashMap;
import java.util.Map;

/**
 * @author canitzp
 */
public class HereGamer implements IExtendedEntityProperties{

    public static final Map<EntityPlayer, HereGamer> playerData = new HashMap<>();

    public int skillXP, skillS, skillP, skillE, skillC, skillI, skillA, skillL;

    public static HereGamer get(Entity p) {
        return (HereGamer) p.getExtendedProperties("Skills");
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(new Handler());
    }

    @Override
    public void saveNBTData(NBTTagCompound data) {
        data.setInteger("SkillXp", skillXP);
        data.setInteger("SkillS", skillS);
        data.setInteger("SkillP", skillP);
        data.setInteger("SkillE", skillE);
        data.setInteger("SkillC", skillC);
        data.setInteger("SkillI", skillI);
        data.setInteger("SkillA", skillA);
        data.setInteger("SkillL", skillL);
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

public static class Handler {
    @SubscribeEvent
    public void onClonePlayer(PlayerEvent.Clone e) {
        if (e.wasDeath) {
            NBTTagCompound compound = new NBTTagCompound();
            HereGamer.get(e.original).saveNBTData(compound);
            HereGamer.get(e.entityPlayer).loadNBTData(compound);
                }
            }
        }
}