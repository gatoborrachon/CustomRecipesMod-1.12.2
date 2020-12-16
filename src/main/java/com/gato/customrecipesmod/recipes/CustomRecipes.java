package com.gato.customrecipesmod.recipes;


import com.gato.customrecipesmod.init.ModItems;
import com.raoulvdberge.refinedstorage.RSItems;

import defeatedcrow.hac.api.climate.ClimateAPI;
import defeatedcrow.hac.api.climate.DCHeatTier;
import defeatedcrow.hac.api.climate.DCHumidity;
import defeatedcrow.hac.api.recipe.RecipeAPI;
import ic2.api.item.IC2Items;
import mekanism.api.infuse.InfuseObject;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.infuse.InfuseType;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
//import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistry;
import nmd.primal.core.api.PrimalAPI;
import nmd.primal.forgecraft.crafting.AnvilCrafting;
import nmd.primal.forgecraft.crafting.CrucibleCrafting;
import nmd.primal.forgecraft.crafting.ForgeCrafting;
import nmd.primal.forgecraft.crafting.WorkbenchCrafting;


@EventBusSubscriber
public final class CustomRecipes
{
	
    @SubscribeEvent
    public static void registerMekanismRecipes(RegistryEvent.Register<IRecipe> event) {
    	addMekanismRecipes();
    }
    
    public static void addMekanismRecipes() {
    	InfuseType quartz = InfuseRegistry.get("QUARTZ");
        InfuseRegistry.registerInfuseObject(new ItemStack(Items.QUARTZ), new InfuseObject(quartz, 10));
    }
    
  @SubscribeEvent
  public static void registerCrucibleRecipes(RegistryEvent.Register<CrucibleCrafting> event) {
  IForgeRegistry<CrucibleCrafting> recipes = event.getRegistry();
  
  recipes.register(new CrucibleCrafting(Ingredient.fromItem(Items.GOLD_INGOT), Ingredient.fromItem(Items.REDSTONE), Ingredient.fromItem(Items.REDSTONE), Ingredient.EMPTY, Ingredient.EMPTY, new ItemStack(PrimalAPI.Items.SLAG, 3),  new ItemStack(ModItems.FLUX_ALLOY_INGOT, 1),
	        Integer.valueOf(1100), 
	      	Integer.valueOf(500), 
	      	Integer.valueOf(300)).setRecipeName("fluxalloy"));
  
  recipes.register(new CrucibleCrafting(Ingredient.fromItem(Items.IRON_INGOT), Ingredient.fromItem(Items.IRON_INGOT), Ingredient.fromItem(Items.IRON_INGOT), Ingredient.fromItem(Items.QUARTZ), Ingredient.EMPTY, new ItemStack(PrimalAPI.Items.SLAG, 4),  new ItemStack(RSItems.QUARTZ_ENRICHED_IRON, 4),
	        Integer.valueOf(1700), 
	      	Integer.valueOf(950), 
	      	Integer.valueOf(800)).setRecipeName("quartziron"));
  }
  
  @SubscribeEvent
  public static void registerRecipes(RegistryEvent.Register<WorkbenchCrafting> event) {
	  
	  //ForgeCraft
      //PrimalAPI.logger(7, "Registering Recipes: workbench");
      /*IForgeRegistry<WorkbenchCrafting> recipes = event.getRegistry();

	  recipes.register((WorkbenchCrafting)(new WorkbenchCrafting((Ingredient)new OreIngredient("stickTreatedWood"),           
      Ingredient.fromStacks(new ItemStack[] { new ItemStack(ModItems.FORGE_HAMMER_HEAD, 1) }),
      (Ingredient)new OreIngredient("pinBasic"), Ingredient.EMPTY, (Ingredient)new OreIngredient("toolGallagher"), IC2Items.getItem("forge_hammer")))
      .setRecipeName("ic2hammer"));*/
	  
      
      ItemStack emptyAir = ItemStack.EMPTY;
      
      NBTTagCompound setHot = new NBTTagCompound();
      setHot.setBoolean("hot", true);
      
      ItemStack hotIronIngot = new ItemStack(nmd.primal.forgecraft.init.ModItems.ironingotball, 1);
      hotIronIngot.setTagCompound(setHot);
      ItemStack hotChunk = new ItemStack(nmd.primal.forgecraft.init.ModItems.wroughtironchunk, 1);
      hotChunk.setTagCompound(setHot);
      
      ItemStack hotSteelIngot = new ItemStack(nmd.primal.forgecraft.init.ModItems.steelingotball, 1);
      hotSteelIngot.setTagCompound(setHot);
      ItemStack hotSteelChunk = new ItemStack(nmd.primal.forgecraft.init.ModItems.steelchunk, 1);
      hotSteelChunk.setTagCompound(setHot);
      
      ItemStack hotBronzeIngot = new ItemStack(nmd.primal.forgecraft.init.ModItems.bronzeingotball, 1);
      hotBronzeIngot.setTagCompound(setHot);
      ItemStack hotBronzeChunk = new ItemStack(nmd.primal.forgecraft.init.ModItems.bronzechunk, 1);
      hotBronzeChunk.setTagCompound(setHot);
      
      ForgeCrafting.addRecipe(nmd.primal.forgecraft.init.ModItems.bronzeingotball, hotBronzeIngot, 950, 250, 500, 1.0F, 1.0F);
      
      ForgeCrafting.addRecipe(nmd.primal.forgecraft.init.ModItems.bronzechunk, hotBronzeChunk, 950, 130, 500, 1.0F, 1.0F);

      
      AnvilCrafting.addRecipe(new ItemStack[] { emptyAir, emptyAir, emptyAir, emptyAir, emptyAir,
    		  									hotChunk, hotIronIngot, hotIronIngot, hotIronIngot, hotChunk,
    		  									hotChunk, hotChunk, emptyAir, hotChunk, hotChunk,
    		  									emptyAir, emptyAir, emptyAir, emptyAir, emptyAir,
    		  									emptyAir, emptyAir, emptyAir, emptyAir, emptyAir }, new ItemStack(ModItems.FORGE_HAMMER_HEAD, 1), "null");
      
      AnvilCrafting.addRecipe(new ItemStack[] { emptyAir, emptyAir, emptyAir, emptyAir, emptyAir,
												emptyAir, hotIronIngot, hotIronIngot, hotChunk, emptyAir,
												emptyAir, hotChunk, emptyAir, hotChunk, emptyAir,
												emptyAir, emptyAir, emptyAir, emptyAir, emptyAir,
												emptyAir, emptyAir, emptyAir, emptyAir, emptyAir }, new ItemStack(ModItems.IRON_HAMMER_HEAD, 1), "null");
      
      AnvilCrafting.addRecipe(new ItemStack[] { emptyAir, emptyAir, emptyAir, emptyAir, emptyAir,
												emptyAir, hotSteelIngot, hotSteelIngot, hotSteelChunk, emptyAir,
												emptyAir, hotSteelChunk, emptyAir, hotSteelChunk, emptyAir,
												emptyAir, emptyAir, emptyAir, emptyAir, emptyAir,
												emptyAir, emptyAir, emptyAir, emptyAir, emptyAir }, new ItemStack(ModItems.STEEL_HAMMER_HEAD, 1), "null");
      
      AnvilCrafting.addRecipe(new ItemStack[] { emptyAir, emptyAir, emptyAir, emptyAir, emptyAir,
												emptyAir, hotChunk, emptyAir, hotChunk, emptyAir,
												emptyAir, hotChunk, emptyAir, hotChunk, emptyAir,
												emptyAir, emptyAir, hotIronIngot, emptyAir, emptyAir,
												emptyAir, hotChunk, emptyAir, hotChunk, emptyAir }, IC2Items.getItem("cutter"), "null");
      
      AnvilCrafting.addRecipe(new ItemStack[] { emptyAir, hotBronzeChunk, emptyAir, hotBronzeChunk, emptyAir,
												emptyAir, hotBronzeChunk, emptyAir, hotBronzeChunk, emptyAir,
												emptyAir, hotBronzeChunk, hotBronzeChunk, hotBronzeChunk, emptyAir,
												emptyAir, emptyAir, hotBronzeIngot, emptyAir, emptyAir, 
												emptyAir, emptyAir, hotBronzeIngot, emptyAir, emptyAir }, IC2Items.getItem("wrench"), "null");
      
      AnvilCrafting.addRecipe(new ItemStack[] { emptyAir, emptyAir, emptyAir, emptyAir, emptyAir,
												emptyAir, emptyAir, hotChunk, emptyAir, emptyAir,
												emptyAir, hotChunk, hotIronIngot, emptyAir, emptyAir,
												emptyAir, emptyAir, emptyAir, emptyAir, emptyAir,
												emptyAir, emptyAir, emptyAir, emptyAir, emptyAir }, new ItemStack(ModItems.CARVING_KNIFE_HEAD, 1), "null");
      

      
      
      //Heat and Climate
      
      RecipeAPI.registerReactorRecipes.addRecipe(new ItemStack(PrimalAPI.Items.WAX_RESIDUE, 2, 0), null, 0F, new FluidStack(PrimalAPI.Fluids.PARAFFIN,1500), null, DCHeatTier.OVEN, "saltSpecial", FluidRegistry.getFluidStack("benzene", 2000), null, new Object[] { new ItemStack(PrimalAPI.Items.PARAFFIN_CLUMP, 16, 0) });
      RecipeAPI.registerReactorRecipes.addRecipe(null, null, 0F, new FluidStack(PrimalAPI.Fluids.BITUMEN_BOILING,1000), null, DCHeatTier.OVEN, "saltSpecial", FluidRegistry.getFluidStack("bitumen", 1000), FluidRegistry.getFluidStack("brine", 250), new Object[] {  });

      RecipeAPI.registerReactorRecipes.addRecipe(null, null, 0F, new FluidStack(PrimalAPI.Fluids.OVIS_ATRE_MILK, 500), null, DCHeatTier.OVEN, ItemStack.EMPTY, FluidRegistry.getFluidStack("milk", 250), FluidRegistry.getFluidStack("magma_basaltic", 250), new Object[] {  });
      RecipeAPI.registerReactorRecipes.addRecipe(null, null, 0F, new FluidStack(PrimalAPI.Fluids.OVIS_ATRE_MILK, 500), null, DCHeatTier.OVEN, ItemStack.EMPTY, FluidRegistry.getFluidStack("milk", 250), FluidRegistry.getFluidStack("ic2pahoehoe_lava", 250), new Object[] {  });
      
      //ClimateAPI.registerBlock.registerHeatBlock(block, meta, DCHeatTier);
      ClimateAPI.registerBlock.registerHumBlock(PrimalAPI.Blocks.MUD_WET, 0, DCHumidity.WET);
      ClimateAPI.registerBlock.registerHumBlock(PrimalAPI.Blocks.THATCH_WET, 0, DCHumidity.WET);
      
      
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.sellafield_0, 0, DCHeatTier.WARM);
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.sellafield_1, 0, DCHeatTier.HOT);
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.sellafield_2, 0, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.sellafield_3, 0, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.sellafield_4, 0, DCHeatTier.UHT);
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.sellafield_core, 0, DCHeatTier.INFERNO);
      
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.brick_jungle_lava, 0, DCHeatTier.OVEN);
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.brick_jungle_mystic, 0, DCHeatTier.OVEN);
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.brick_jungle_ooze, 0, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.block_meteor_molten, 0, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.geysir_chlorine, 0, DCHeatTier.OVEN);
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.geysir_vapor, 0, DCHeatTier.WARM);
      ClimateAPI.registerBlock.registerHeatBlock(com.hbm.blocks.ModBlocks.geysir_water, 0, DCHeatTier.HOT);
      
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.HIBACHI, 8, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.HIBACHI, 9, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.HIBACHI, 10, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.HIBACHI, 11, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.HIBACHI, 12, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.HIBACHI, 13, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.HIBACHI, 14, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.HIBACHI, 15, DCHeatTier.BOIL);
      
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.SMELTER, 8, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.SMELTER, 9, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.SMELTER, 10, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.SMELTER, 11, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.SMELTER, 12, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.SMELTER, 13, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.SMELTER, 14, DCHeatTier.BOIL);
      ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Blocks.SMELTER, 15, DCHeatTier.BOIL);
      
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_brick, 4, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_brick, 5, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_brick, 6, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_brick, 7, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_brick, 12, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_brick, 13, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_brick, 14, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_brick, 15, DCHeatTier.KILN);
      
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_adobe, 4, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_adobe, 5, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_adobe, 6, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_adobe, 7, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_adobe, 12, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_adobe, 13, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_adobe, 14, DCHeatTier.KILN);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.forge_adobe, 15, DCHeatTier.KILN);
      
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_brick, 4, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_brick, 5, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_brick, 6, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_brick, 7, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_brick, 12, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_brick, 13, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_brick, 14, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_brick, 15, DCHeatTier.SMELTING);
      
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_adobe, 4, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_adobe, 5, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_adobe, 6, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_adobe, 7, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_adobe, 12, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_adobe, 13, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_adobe, 14, DCHeatTier.SMELTING);
      ClimateAPI.registerBlock.registerHeatBlock(nmd.primal.forgecraft.init.ModBlocks.bloomery_adobe, 15, DCHeatTier.SMELTING);
      
      
      //ClimateAPI.registerBlock.registerHeatBlock(PrimalAPI.Items.TORCH_NETHER_LIT, 8, DCHeatTier.OVEN);
      
    }
}