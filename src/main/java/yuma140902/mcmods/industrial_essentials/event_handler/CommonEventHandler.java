package yuma140902.mcmods.industrial_essentials.event_handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import yuma140902.mcmods.industrial_essentials.IndustrialEssentials;
import yuma140902.mcmods.industrial_essentials.config.ModConfigCore;

public class CommonEventHandler {
	private CommonEventHandler() {}
	
	public static final CommonEventHandler INSTANCE = new CommonEventHandler();
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if(IndustrialEssentials.MOD_ID.equals(event.modID))
			ModConfigCore.syncConfig();
	}
}
