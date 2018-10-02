package epicsquid.fluxarcana;

import epicsquid.mysticallib.event.RegisterModRecipesEvent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.items.ItemGenericEssentiaContainer;
import thaumcraft.api.items.ItemsTC;

public class Recipes {

    public static ResourceLocation getRL(String s){
    	return new ResourceLocation(ThaumArcana.MODID+":"+s);
    }

    public static void registerShaped(IForgeRegistry<IRecipe> registry, String name, ItemStack result, Object... ingredients){
    	registry.register(new ShapedOreRecipe(getRL(name),result,ingredients).setRegistryName(getRL(name)));
    }

	@SubscribeEvent
	public void onRegister(RegisterModRecipesEvent event){
		ItemStack life_shard = new ItemStack(ItemsTC.crystalEssence,1);
		((ItemGenericEssentiaContainer)ItemsTC.crystalEssence).setAspects(life_shard,new AspectList().add(Aspect.LIFE, 1));
		ThaumcraftApi.addInfusionCraftingRecipe(getRL("roseate_band"), new InfusionRecipe(
					"ROSEATEBAND",
					new ItemStack(Registrar.roseate_band,1),
					1,
					new AspectList().add(Aspect.LIFE, 40).add(Aspect.PROTECT, 20),
					new ItemStack(ItemsTC.baubles,1,1),
					new Object[]{
							life_shard,
							life_shard,
							life_shard,
							new ItemStack(ItemsTC.salisMundus,1),
							new ItemStack(Items.GOLDEN_APPLE,1)
					}
				));

		ThaumcraftApi.addInfusionCraftingRecipe(getRL("warded_mail"), new InfusionRecipe(
				"warded_mail",
				new ItemStack(Registrar.warded_mail,1),
				3,
				new AspectList().add(Aspect.MAGIC, 30).add(Aspect.PROTECT, 30).add(Aspect.ELDRITCH, 40),
				new ItemStack(Items.GOLDEN_CHESTPLATE,1),
				new Object[]{
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(BlocksTC.amberBlock, 1),
				}
			));

		ThaumcraftApi.addInfusionCraftingRecipe(getRL("warded_mail"), new InfusionRecipe(
				"warded_mail",
				new ItemStack(Registrar.warded_mail,1),
				3,
				new AspectList().add(Aspect.MAGIC, 30).add(Aspect.PROTECT, 30).add(Aspect.ELDRITCH, 40),
				new ItemStack(Items.GOLDEN_CHESTPLATE,1),
				new Object[]{
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(Registrar.thaumium_chain),
						new ItemStack(BlocksTC.amberBlock, 1),
				}
			));

		ThaumcraftApi.addCrucibleRecipe(getRL("hewn_hand"), new CrucibleRecipe(
				"hewn_hand",
				new ItemStack(Registrar.hewn_hand,1),
				"stone",
				new AspectList().add(Aspect.MAN, 20).add(Aspect.EXCHANGE, 40))
			);

		registerShaped(event.getRegistry(), "iron_chain", new ItemStack(Registrar.iron_chain, 1),
				"n n",
				" n ",
				'n', "nuggetIron");
		registerShaped(event.getRegistry(), "brass_chain", new ItemStack(Registrar.brass_chain, 1),
				"n n",
				" n ",
				'n', "nuggetBrass");
		registerShaped(event.getRegistry(), "thaumium_chain", new ItemStack(Registrar.thaumium_chain, 1),
				"n n",
				" n ",
				'n', "nuggetThaumium");

		registerShaped(event.getRegistry(), "chainmail_helm", new ItemStack(Items.CHAINMAIL_HELMET, 1),
				"ccc",
				"c c",
				'c', Registrar.iron_chain);
		registerShaped(event.getRegistry(), "chainmail_chest", new ItemStack(Items.CHAINMAIL_CHESTPLATE, 1),
				"c c",
				"ccc",
				"ccc",
				'c', Registrar.iron_chain);
		registerShaped(event.getRegistry(), "chainmail_legs", new ItemStack(Items.CHAINMAIL_LEGGINGS, 1),
				"ccc",
				"c c",
				"c c",
				'c', Registrar.iron_chain);
		registerShaped(event.getRegistry(), "chainmail_boots", new ItemStack(Items.CHAINMAIL_BOOTS, 1),
				"c c",
				"c c",
				'c', Registrar.iron_chain);
	}
}
