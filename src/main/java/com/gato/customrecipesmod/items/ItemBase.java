package com.gato.customrecipesmod.items;

import com.gato.customrecipesmod.CustomRecipesMod;
import com.gato.customrecipesmod.init.ModItems;
import com.gato.customrecipesmod.util.IHasModel;

import net.minecraft.item.Item;
import nmd.primal.forgecraft.ModInfo;

public class ItemBase extends Item implements IHasModel
{

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModInfo.TAB_FORGECRAFT);
	
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		
		CustomRecipesMod.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
