package epicsquid.fluxarcana.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import baubles.api.BaubleType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;

public class ItemAttributeBauble extends ItemBauble {

  public ItemAttributeBauble(String name, BaubleType type) {
    super(name, type);
  }

  @Override
  public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase player) {
    if (!player.world.isRemote) {
      Multimap<String, AttributeModifier> attributes = HashMultimap.create();
      fillModifiers(attributes, stack);
      player.getAttributeMap().applyAttributeModifiers(attributes);
    }
  }

  @Override
  public void onUnequipped(ItemStack stack, EntityLivingBase player) {
    if (!player.world.isRemote) {
      Multimap<String, AttributeModifier> attributes = HashMultimap.create();
      fillModifiers(attributes, stack);
      player.getAttributeMap().removeAttributeModifiers(attributes);
    }
  }

  public void fillModifiers(Multimap<String, AttributeModifier> attributes, ItemStack stack) {

  }

}
