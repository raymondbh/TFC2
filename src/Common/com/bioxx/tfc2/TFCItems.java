package com.bioxx.tfc2;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

import com.bioxx.tfc2.api.Crop;
import com.bioxx.tfc2.api.types.EnumFoodGroup;
import com.bioxx.tfc2.core.RegistryItemQueue;
import com.bioxx.tfc2.items.*;

public class TFCItems 
{
	public static Item StoneAxe;
	public static Item StoneShovel;
	public static Item StoneKnife;
	public static Item StoneHoe;
	public static Item LooseRock;
	public static Item StoneAxeHead;
	public static Item StoneShovelHead;
	public static Item StoneKnifeHead;
	public static Item StoneHoeHead;

	public static Item FoodCabbage;
	public static Item FoodBeefRaw;
	public static Item FoodBeefCooked;
	public static Item FoodBanana;
	public static Item FoodBarleyBread;
	public static Item FoodCheese;

	public static Item SeedsCorn;
	public static Item SeedsCabbage;
	public static Item SeedsTomato;

	public static void Load()
	{
		TFC.log.info(new StringBuilder().append("[TFC2] Loading Items").toString());
		LooseRock = registerItemOnly(new ItemLooseRock().setUnlocalizedName("looserock"));
		StoneAxe = registerItem(new ItemAxe(ToolMaterial.STONE).setUnlocalizedName("stone_axe"));
		StoneShovel = registerItem(new ItemShovel(ToolMaterial.STONE).setUnlocalizedName("stone_shovel"));
		StoneKnife = registerItem(new ItemKnife(ToolMaterial.STONE).setUnlocalizedName("stone_knife"));
		StoneHoe = registerItem(new ItemHoe(ToolMaterial.STONE).setUnlocalizedName("stone_hoe"));

		StoneAxeHead = registerItem(new ItemToolHead().setUnlocalizedName("stone_axe_head"));
		StoneShovelHead = registerItem(new ItemToolHead().setUnlocalizedName("stone_shovel_head"));
		StoneKnifeHead = registerItem(new ItemToolHead().setUnlocalizedName("stone_knife_head"));
		StoneHoeHead = registerItem(new ItemToolHead().setUnlocalizedName("stone_hoe_head"));

		FoodCabbage = registerItem(new ItemFoodTFC(EnumFoodGroup.Vegetable, 1f, 1).setExpiration(3600).setUnlocalizedName("food_cabbage"));
		FoodBeefRaw = registerItem(new ItemFoodTFC(EnumFoodGroup.Protein, 1f, 1).setExpiration(360).setUnlocalizedName("food_beefraw"));
		FoodBeefCooked = registerItem(new ItemFoodTFC(EnumFoodGroup.Protein, 1f, 1).setExpiration(360).setUnlocalizedName("food_beefcooked"));
		FoodBanana = registerItem(new ItemFoodTFC(EnumFoodGroup.Fruit, 1f, 1).setExpiration(3600).setUnlocalizedName("food_banana"));
		FoodBarleyBread = registerItem(new ItemFoodTFC(EnumFoodGroup.Grain, 1f, 1).setExpiration(3600).setUnlocalizedName("food_barleybread"));
		FoodCheese = registerItem(new ItemFoodTFC(EnumFoodGroup.Dairy, 1f, 1).setExpiration(7200).setUnlocalizedName("food_cheese"));

		SeedsCorn = registerItem(new ItemSeeds(Crop.Corn).setUnlocalizedName("seeds_corn"));
		SeedsCabbage = registerItem(new ItemSeeds(Crop.Cabbage).setUnlocalizedName("seeds_cabbage"));
		SeedsTomato = registerItem(new ItemSeeds(Crop.Tomato).setUnlocalizedName("seeds_tomato"));
	}

	public static void Register()
	{
		TFC.log.info(new StringBuilder().append("[TFC2] Registering Items").toString());
		RegistryItemQueue.getInstance().registerItems();

		SetupHarvestLevels();
	}

	/**
	 * Registers the item with the game registry and also registers a single ItemMeshDefinition for this item.
	 */
	private static Item registerItem(Item i)
	{
		RegistryItemQueue.getInstance().addFull(i);
		return i;
	}

	/**
	 * Registers the item with the game registry.<br>
	 * <br>
	 * Should be used for items that have multiple variants where we need to manually create a MeshDef
	 */
	private static Item registerItemOnly(Item i)
	{
		RegistryItemQueue.getInstance().addItemOnly(i);
		return i;
	}

	private static void SetupHarvestLevels()
	{
		StoneAxe.setHarvestLevel("axe", 1);
	}
}
