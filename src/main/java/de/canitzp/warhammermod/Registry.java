package de.canitzp.warhammermod;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.NetworkManager;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.*;

/**
 * @author canitzp
 */
public class Registry {

    public static KeyBinding openSkill = new KeyBinding(WarHammerMod.MODID + ":key.openskills", Keyboard.KEY_V, "key.categories.misc");

    public static void preInit(FMLPreInitializationEvent event){
        Registry registry = new Registry();
        FMLCommonHandler.instance().bus().register(registry);
        MinecraftForge.EVENT_BUS.register(registry);
        if(event.getSide().isClient()){
            ClientRegistry.registerKeyBinding(openSkill);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void keyPress(InputEvent.KeyInputEvent event){
        if(openSkill.isPressed()){
            Minecraft.getMinecraft().displayGuiScreen(new GuiSkills());
        }
    }

    @SubscribeEvent
    public void entityConstruct(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            HereGamer hereGamer = new HereGamer();
            event.entity.registerExtendedProperties("Skills", hereGamer);
            HereGamer.playerData.put(((EntityPlayer)event.entity), hereGamer);
        }
        }

}
