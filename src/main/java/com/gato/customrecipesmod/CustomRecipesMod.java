package com.gato.customrecipesmod;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
//import org.apache.logging.log4j.Logger;

import com.gato.customrecipesmod.proxy.CommonProxy;

import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.infuse.InfuseType;

@Mod(modid = CustomRecipesMod.MODID, name = CustomRecipesMod.NAME, version = CustomRecipesMod.VERSION)
public class CustomRecipesMod
{
    public static final String MODID = "customrecipesmod";
    public static final String NAME = "Custom Recipes Mod";
    public static final String VERSION = "1.6";
	public static final String CLIENT_PROXY_CLASS = "com.gato.customrecipesmod.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.gato.customrecipesmod.proxy.CommonProxy";

    //private static Logger logger;
    
	@Instance
	public static CustomRecipesMod instance;
	
	@SidedProxy(clientSide = CustomRecipesMod.CLIENT_PROXY_CLASS, serverSide = CustomRecipesMod.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //logger = event.getModLog();
        InfuseRegistry.registerInfuseType(new InfuseType("QUARTZ", new ResourceLocation(CustomRecipesMod.MODID, "blocks/infuse/Quartz")).setTranslationKey("quartz"));

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
