package epicsquid.fluxarcana.item;

import epicsquid.mysticallib.item.ItemBase;
import epicsquid.mysticallib.util.Util;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Enchantments;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHewnHand extends ItemBase {

  public ItemHewnHand(String name) {
    super(name);
  }

  @Override
  public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
    if (entity instanceof EntityPlayer) {
      EntityPlayer p = (EntityPlayer) entity;
      for (int i = 0; i < p.inventory.getSizeInventory(); i++) {
        ItemStack s = p.inventory.getStackInSlot(i);
        if (!world.isRemote && s.isItemDamaged()) {
          s.setItemDamage(s.getItemDamage() - 1);
          stack.attemptDamageItem(1, Util.rand, (EntityPlayerMP) p);
        }
      }
    }
  }

  @Override
  public EnumRarity getRarity(ItemStack stack) {
    return EnumRarity.UNCOMMON;
  }

  @Override
  public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment ench) {
    return ench == Enchantments.UNBREAKING;
  }

  @Override
  public boolean isEnchantable(ItemStack stack) {
    return true;
  }

  @Override
  public int getMaxDamage(ItemStack stack) {
    return 760;
  }
}
