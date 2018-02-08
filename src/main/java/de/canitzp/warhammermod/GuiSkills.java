package de.canitzp.warhammermod;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

/**
 * @author canitzp
 */
public class GuiSkills extends GuiScreen {

    public static final ResourceLocation LOC = new ResourceLocation("");
    private int guiLeft;
    private int guiTop;

    @Override
    public void initGui() {
        super.initGui();
        this.guiLeft = (this.width - 256) / 2;
        this.guiTop = (this.height - 256) / 2;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        this.mc.getTextureManager().bindTexture(LOC);
        this.drawTexturedModalRect(this.guiLeft, this.guiLeft, 256, 256, 0, 0);

        super.drawScreen(mouseX, mouseY, partialTicks);
        //test
    }
}
