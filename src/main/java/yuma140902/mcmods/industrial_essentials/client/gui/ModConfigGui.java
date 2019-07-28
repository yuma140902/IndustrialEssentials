package yuma140902.mcmods.industrial_essentials.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import yuma140902.mcmods.industrial_essentials.IndustrialEssentials;
import yuma140902.mcmods.industrial_essentials.config.ModConfigCore;

public class ModConfigGui extends GuiConfig {
	public ModConfigGui(GuiScreen parent) {
		super(parent, (new ConfigElement<Object>(ModConfigCore.cfg.getCategory(ModConfigCore.CATEGORY_GENERAL))).getChildElements(), IndustrialEssentials.MOD_ID, false, false, IndustrialEssentials.MOD_NAME);
	}
}
