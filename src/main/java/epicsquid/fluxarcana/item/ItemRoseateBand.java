package epicsquid.fluxarcana.item;

import java.util.List;

import baubles.api.BaubleType;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemRoseateBand extends ItemBauble {

  public ItemRoseateBand(String name, BaubleType type) {
    super(name, type);
  }

  @Override
  public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
    super.addInformation(stack, world, tooltip, flag);
    if (getStored(stack) > 0) {
      tooltip.add(TextFormatting.RED + I18n.format("fluxarcana.tooltip.storedhealth") + getStored(stack));
    }
  }

  @Override
  public boolean willAutoSync(ItemStack stack, EntityLivingBase player) {
    return true;
  }

  @Override
  public void onWornTick(ItemStack stack, EntityLivingBase player) {
    if (player.ticksExisted % 40 == 0 && getStored(stack) < 20 && player.getHealth() == player.getMaxHealth()) {
      changeStored(stack, 1);
    } else if (player.ticksExisted % 20 == 0 && player.getHealth() < player.getMaxHealth() && getStored(stack) > 0) {
      player.heal(Math.min(1.0f, getStored(stack)));
      changeStored(stack, -Math.min(1.0f, getStored(stack)));
    }
  }

  public static NBTTagCompound getTag(ItemStack stack) {
    if (!stack.hasTagCompound()) {
      stack.setTagCompound(new NBTTagCompound());
    }
    return stack.getTagCompound();
  }

  public static float getStored(ItemStack stack) {
    NBTTagCompound tag = getTag(stack);
    if (tag.hasKey("health"))
      return tag.getFloat("health");
    return 0;
  }

  public static void changeStored(ItemStack stack, float health) {
    NBTTagCompound tag = getTag(stack);
    if (!tag.hasKey("health"))
      tag.setFloat("health", 0);
    tag.setFloat("health", tag.getFloat("health") + health);
  }

  public static void setStored(ItemStack stack, float health) {
    getTag(stack).setFloat("health", health);
  }
}
