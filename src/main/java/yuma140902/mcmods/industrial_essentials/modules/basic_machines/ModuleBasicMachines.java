package yuma140902.mcmods.industrial_essentials.modules.basic_machines;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import yuma140902.mcmods.industrial_essentials.modules.EnumModuleConfigEntry;
import yuma140902.mcmods.industrial_essentials.modules.ModuleBase;

public class ModuleBasicMachines extends ModuleBase {

	public static final String MODULE_NAME = "BasicMachines";
	
	public ModuleBasicMachines() {
		super(MODULE_NAME);
	}

	@Override
	public void preInit(FMLPreInitializationEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("BasicMachines preInit!!!");
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
		return EnumModuleConfigEntry.BasicMachines;
	}

}
