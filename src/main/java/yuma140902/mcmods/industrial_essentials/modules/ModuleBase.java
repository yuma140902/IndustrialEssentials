package yuma140902.mcmods.industrial_essentials.modules;

import javax.annotation.Nonnull;
import yuma140902.mcmods.industrial_essentials.IndustrialEssentials;
import yuma140902.mcmods.yumalib.modmodule.IModModule;

public abstract class ModuleBase implements IModModule<IndustrialEssentials> {

	private String modName;
	private Boolean _isEnabled = null;
	
	public ModuleBase(String modName) {
		this.modName = modName;
	}
	
	@Override
	public IndustrialEssentials getParentMod() {
		return IndustrialEssentials.INSTANCE;
	}

	@Override
	public String getModuleDisplayName() {
		return modName;
	}
	
	@Nonnull
	public abstract EnumModuleConfigEntry getModuleConfigEntry();
	
	@Override
	public boolean isEnabled() {
		if(_isEnabled == null) {
			return _isEnabled = Modules.moduleIsEnabled(getModuleConfigEntry());
		}
		return _isEnabled;
	}

}
