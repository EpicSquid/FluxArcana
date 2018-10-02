package epicsquid.fluxarcana.item;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemWardedMail extends ItemBauble {

  public ItemWardedMail(String name, BaubleType type) {
    super(name, type);
    MinecraftForge.EVENT_BUS.register(this);
  }

  @Override
  public EnumRarity getRarity(ItemStack stack) {
    return EnumRarity.UNCOMMON;
  }

  @SubscribeEvent
  public void onLivingAttack(LivingAttackEvent event) {
    if (event.getEntityLiving() instanceof EntityPlayer && (event.getSource().isUnblockable())
        && BaublesApi.isBaubleEquipped((EntityPlayer) event.getEntityLiving(), this) != -1) {
      event.getEntityLiving().attackEntityFrom(new DamageSource("blocked"), event.getAmount());
      event.setCanceled(true);
    }
  }
}
