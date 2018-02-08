package de.canitzp.warhammermod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraft.entity.player.EntityPlayer;


class ExampleEntityProperty implements IExtendedEntityProperties {
    public static final String PROP_NAME = WarHammerMod.MODID + "Skills";

    public static ExampleEntityProperty get(Entity p) {
        return (ExampleEntityProperty) p.getExtendedProperties(PROP_NAME);
    }

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new Handler());
}

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound propertyData = new NBTTagCompound();

        // Write data to propertyData
        propertyData.setInteger("SkillXp", 0);
        propertyData.setInteger("SkillS", 0);
        propertyData.setInteger("SkillP", 0);
        propertyData.setInteger("SkillE", 0);
        propertyData.setInteger("SkillC", 0);
        propertyData.setInteger("SkillI", 0);
        propertyData.setInteger("SkillA", 0);
        propertyData.setInteger("SkillL", 0);

        compound.setTag(PROP_NAME, propertyData);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {

        if(compound.hasKey(PROP_NAME, Constants.NBT.TAG_COMPOUND)) {
            NBTTagCompound propertyData = compound.getCompoundTag(PROP_NAME);

            // Read data from propertyData
             publicvars.SkillXp = propertyData.getInteger("SkillXp");
            publicvars.SkillS = propertyData.getInteger("SkillS");
            publicvars.SkillP = propertyData.getInteger("SkillP");
            publicvars.SkillE = propertyData.getInteger("SkillE");
            publicvars.SkillC = propertyData.getInteger("SkillC");
            publicvars.SkillI = propertyData.getInteger("SkillI");
            publicvars.SkillA = propertyData.getInteger("SkillA");
            publicvars.SkillL = propertyData.getInteger("SkillL");
        }

    }

   /* public int loadNBTData(NBTTagCompound compound, String nbtname) {

        if(compound.hasKey(PROP_NAME, Constants.NBT.TAG_COMPOUND)) {
            NBTTagCompound propertyData = compound.getCompoundTag(PROP_NAME);

            // Read data from propertyData
            return propertyData.getInteger(nbtname);
        }

    }*/

    @Override
    public void init(Entity entity, World world) {

    }

    @SubscribeEvent
    public void entityConstruct(EntityEvent.EntityConstructing e) {
        if (e.entity instanceof EntityPlayer) {
            if (e.entity.getExtendedProperties(PROP_NAME) == null) {
                e.entity.registerExtendedProperties(PROP_NAME, new ExampleEntityProperty());
            }
        }
    }



    public static class Handler {
        // Event handlers will go here

    }


    @SubscribeEvent
    public void onClonePlayer(PlayerEvent.Clone e) {
        if(e.wasDeath) {
            NBTTagCompound compound = new NBTTagCompound();
            ExampleEntityProperty.get(e.original).saveNBTData(compound);
            ExampleEntityProperty.get(e.entityPlayer).loadNBTData(compound);
        }
    }
}