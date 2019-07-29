package yuma140902.mcmods.industrial_essentials.modules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import yuma140902.mcmods.industrial_essentials.IndustrialEssentials;
import yuma140902.mcmods.industrial_essentials.config.ModConfigCore;
import yuma140902.mcmods.industrial_essentials.modules.basic_machines.ModuleBasicMachines;
import yuma140902.mcmods.industrial_essentials.modules.tools.ModuleTools;

public class Modules {
	
	@Nonnull
	private static final List<ModuleBase> loadedModules = new ArrayList<>();
	
	@Nonnull
	private static final TreeSet<EnumModuleConfigEntry> disabledModules = new TreeSet<>();
	
	@Nonnull
	private static final String CATEGORY_MODULES = ModConfigCore.getSubCategory("Modules");
	
	private static final Logger logger = LogManager.getLogger(IndustrialEssentials.MOD_NAME + " Modules");
	
	@Nullable
	private static ModuleTools _tools = null;
	@Nullable
	public static ModuleTools tools() {
		return _tools;
	}
	
	@Nullable
	private static ModuleBasicMachines _basicMachines = null;
	@Nullable
	public static ModuleBasicMachines basicMachines() {
		return _basicMachines;
	}
	
	@SuppressWarnings("null")
	@Nonnull
	public static Iterator<ModuleBase> loadedModules(){
		return loadedModules.iterator();
	}
	
	/**
	 * Should be called from Mod's preInit() method
	 */
	public static void onPreInit(FMLPreInitializationEvent event) {
		Iterator<ModuleBase> iterator = loadedModules();
		while (iterator.hasNext()) {
			ModuleBase module = iterator.next();
			module.preInit(event);
		}
	}
	
	/**
	 * Should be called from Mod's init() method
	 */
	public static void onInit(FMLInitializationEvent event) {
		Iterator<ModuleBase> iterator = loadedModules();
		while (iterator.hasNext()) {
			ModuleBase module = iterator.next();
			module.init(event);
		}
	}
	
	/**
	 * Should be called from Mod's postInit() method
	 */
	public static void onPostInit(FMLPostInitializationEvent event) {
		Iterator<ModuleBase> iterator = loadedModules();
		while (iterator.hasNext()) {
			ModuleBase module = iterator.next();
			module.postInit(event);
		}
	}
	
	
	/**
	 * Should be called after {@link #initConfig(Configuration)} and {@link #syncConfig(Configuration)}
	 */
	public static void initModules() {
		if(moduleIsEnabled(EnumModuleConfigEntry.Tools)) {
			_tools = new ModuleTools();
			loadedModules.add(_tools);
		}
		if(moduleIsEnabled(EnumModuleConfigEntry.BasicMachines)) {
			_basicMachines = new ModuleBasicMachines();
			loadedModules.add(_basicMachines);
		}
	}
	
	public static boolean moduleIsEnabled(EnumModuleConfigEntry module) {
		return !disabledModules.contains(module);
	}
	
	/**
	 * Should be called from {@link ModConfigCore}
	 */
	public static void initConfig(Configuration cfg) {
		cfg.setCategoryRequiresMcRestart(CATEGORY_MODULES, true);
	}
	
	/**
	 * Should be called from {@link ModConfigCore}
	 */
	public static void syncConfig(Configuration cfg) {
		logger.info("== Modules Status ==");
		
		ArrayList<String> order = new ArrayList<>();
		
		for (EnumModuleConfigEntry module : EnumModuleConfigEntry.values()) {
			String comment = module.comment();
			String propName = "Enable " + module;
			order.add(propName);
			Property prop = (comment == null) 
					? cfg.get(CATEGORY_MODULES, propName, true) 
					: cfg.get(CATEGORY_MODULES, propName, true, comment);
			
			boolean isEnabled = prop.getBoolean(true);
			if(!isEnabled) {
				disabledModules.add(module);
			}
			
			logger.info(module + " : " + (isEnabled ? "Enabled" : "Disabled"));
		}
		
		cfg.setCategoryPropertyOrder(CATEGORY_MODULES, order);
	}
}
