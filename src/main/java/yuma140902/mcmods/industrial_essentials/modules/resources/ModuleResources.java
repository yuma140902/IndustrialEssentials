package yuma140902.mcmods.industrial_essentials.modules.resources;

import javax.annotation.Nonnull;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import yuma140902.mcmods.industrial_essentials.modules.EnumModuleConfigEntry;
import yuma140902.mcmods.industrial_essentials.modules.ModuleBase;

public class ModuleResources extends ModuleBase {

	@Nonnull
	private static final String MODULE_NAME = "Resources";
	
	public ModuleResources() {
		super(MODULE_NAME);
	}

	@Override
	public void preInit(FMLPreInitializationEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void init(FMLInitializationEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public EnumModuleConfigEntry getModuleConfigEntry() {
		return EnumModuleConfigEntry.Resources;
	}
	
}
