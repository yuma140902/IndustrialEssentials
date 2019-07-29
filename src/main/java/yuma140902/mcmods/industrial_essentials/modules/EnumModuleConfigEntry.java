package yuma140902.mcmods.industrial_essentials.modules;

import javax.annotation.Nullable;

public enum EnumModuleConfigEntry {
	Tools,
	BasicMachines;
	
	@Nullable
	private String _comment = null;
	
	@Nullable
	public String comment() {
		return _comment;
	}
	
	private EnumModuleConfigEntry() {}
	
	private EnumModuleConfigEntry(String comment) {
		this._comment = comment;
	}
}
