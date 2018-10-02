package epicsquid.fluxarcana.item;

import java.util.UUID;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import epicsquid.mysticallib.item.ItemBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemBauble extends ItemBase implements IBauble {
  BaubleType type;

  public ItemBauble(String name, BaubleType type) {
    super(name);
    this.type = type;
    this.setMaxStackSize(1);
  }

  public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase player) {
  }

  @Override
  public void onWornTick(ItemStack stack, EntityLivingBase player) {
    if (getLastPlayerHashcode(stack) != player.hashCode()) {
      onEquippedOrLoadedIntoWorld(stack, player);
      setLastPlayerHashcode(stack, player.hashCode());
    }
  }

  public static UUID getBaubleUUID(ItemStack stack) {
    if (!stack.hasTagCompound())
      stack.setTagCompound(new NBTTagCompound());
    long most = stack.getTagCompound().hasKey("most") ? stack.getTagCompound().getLong("most") : 0;
    if (most == 0) {
      UUID uuid = UUID.randomUUID();
      stack.getTagCompound().setLong("most", uuid.getMostSignificantBits());
      stack.getTagCompound().setLong("most", uuid.getLeastSignificantBits());
      return getBaubleUUID(stack);
    }

    long least = stack.getTagCompound().getLong("least");
    return new UUID(most, least);
  }

  public static int getLastPlayerHashcode(ItemStack stack) {
    if (!stack.hasTagCompound() || !stack.getTagCompound().hasKey("hash"))
      return -1;
    return stack.getTagCompound().getInteger("hash");
  }

  public static void setLastPlayerHashcode(ItemStack stack, int hash) {
    if (!stack.hasTagCompound())
      stack.setTagCompound(new NBTTagCompound());
    stack.getTagCompound().setInteger("hash", hash);
  }

  @Override
  public void onEquipped(ItemStack stack, EntityLivingBase player) {
    if (player != null) {
      onEquippedOrLoadedIntoWorld(stack, player);
      setLastPlayerHashcode(stack, player.hashCode());
    }
  }

  @Override
  public void onUnequipped(ItemStack stack, EntityLivingBase player) {
  }

  @Override
  public BaubleType getBaubleType(ItemStack arg0) {
    return type;
  }

}
