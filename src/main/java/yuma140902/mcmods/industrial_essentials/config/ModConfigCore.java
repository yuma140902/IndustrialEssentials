package yuma140902.mcmods.industrial_essentials.config;

import java.util.ArrayList;
import javax.annotation.Nonnull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import yuma140902.mcmods.industrial_essentials.IndustrialEssentials;
import yuma140902.mcmods.industrial_essentials.modules.Modules;
import yuma140902.mcmods.yumalib.updatecheck.EnumUpdateChannel;

public class ModConfigCore {
	public static final String CATEGORY_GENERAL = "General";
	
	public static final String
		CONFIG_PROP_LANGKEY = "config.industrial_ess.prop.",
		CONFIG_CATEGORY_LANGKEY = "config.industrial_ess.category.";
	
	public static Configuration cfg;
	
	private static final Logger logger = LogManager.getLogger(IndustrialEssentials.MOD_NAME + "-Config");
	
	public static class Stats {
		static boolean _doUpdateCheck;
		public static boolean doUpdateCheck() {
			return _doUpdateCheck;
		}
		
		static String _updateChannel;
		public static EnumUpdateChannel updateChannel() {
			return EnumUpdateChannel.valueOf(_updateChannel);
		}
		
		static boolean debugMode;
		public static boolean isDebugMode() {
			return debugMode;
		}
	}
	
	public static void loadConfig(FMLPreInitializationEvent event) {
		cfg = new Configuration(event.getSuggestedConfigurationFile(), true);
		initConfig();
		syncConfig();
		wrapConfig();
	}
	
	private static void initConfig() {
		// General
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "Settings of IndustrialEssentials");
		cfg.setCategoryLanguageKey(CATEGORY_GENERAL, CONFIG_CATEGORY_LANGKEY + "general");
		cfg.setCategoryRequiresMcRestart(CATEGORY_GENERAL, true);
		
		Modules.initConfig(cfg);
	}
	
	public static void syncConfig() {
		logger.info("Loading config");
		
		// General
		
		String key;
		ArrayList<String> order = new ArrayList<>();
		
		key = "Check for updates";
		order.add(key);
		Property doUpdateCheck = cfg.get(CATEGORY_GENERAL, key, true, "If true, the mod will check for updates automatically");
		Stats._doUpdateCheck = doUpdateCheck.getBoolean();
		
		key = "Update Channel";
		order.add(key);
		Property updateChannel = cfg.get(CATEGORY_GENERAL, key, EnumUpdateChannel.recommended.toString(), 
				"Channel of update checking", EnumUpdateChannel.valueStrings());
		Stats._updateChannel = updateChannel.getString();
		
		key = "Enable Debug Mode";
		order.add(key);
		Property debugMode = cfg.get(CATEGORY_GENERAL, key, false);
		Stats.debugMode = debugMode.getBoolean();
		
		cfg.getCategory(CATEGORY_GENERAL).setPropertyOrder(order);
		
		Modules.syncConfig(cfg);
		
		cfg.save();
	}
	
	private static void wrapConfig() {
	}
	
	@Nonnull
	public static String getSubCategory(String subCategory) {
		return CATEGORY_GENERAL + "." + subCategory;
	}
	
	@Nonnull
	public static String getCategoryLangkey(String key) {
		return CONFIG_CATEGORY_LANGKEY + key;
	}
	
	@Nonnull
	public static String getPropertyLangkey(String key) {
		return CONFIG_PROP_LANGKEY + key;
	}
}
