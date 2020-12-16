package com.gato.customrecipesmod.init;

import java.util.ArrayList;
import java.util.List;

import com.gato.customrecipesmod.items.ItemBase;

import net.minecraft.item.Item;
//import nmd.primal.core.api.PrimalAPI;
//import nmd.primal.forgecraft.items.parts.ToolPart;

public class ModItems 
{

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item FORGE_HAMMER_HEAD = new ItemBase("forge_hammer_head");
	public static final Item IRON_HAMMER_HEAD = new ItemBase("iron_hammer_head");
	public static final Item STEEL_HAMMER_HEAD = new ItemBase("steel_hammer_head");
	public static final Item CARVING_KNIFE_HEAD = new ItemBase("carving_knife_head");
	public static final Item FLUX_ALLOY_INGOT = new ItemBase("flux_alloy_ingot");

	
}
