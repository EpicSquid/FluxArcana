package epicsquid.fluxarcana.item;

import java.text.DecimalFormat;
import java.util.List;

import com.google.common.collect.Multimap;

import baubles.api.BaubleType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemSimpleAttributeBauble extends ItemAttributeBauble {
  public static final DecimalFormat DECIMALFORMAT = new DecimalFormat("#.##");
  String attr = "";
  AttributeModifier val = null;

  public ItemSimpleAttributeBauble(String name, BaubleType type, String attr, AttributeModifier val) {
    super(name, type);
    this.attr = attr;
    this.val = val;
  }

  @Override
  public void fillModifiers(Multimap<String, AttributeModifier> attributes, ItemStack stack) {
    attributes.put(attr, new AttributeModifier(getBaubleUUID(stack), getRegistryName().toString(), val.getAmount(), val.getOperation()));
  }

  @Override
  public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
    tooltip.add("");
    tooltip.add(net.minecraft.client.resources.I18n.format("bauble.whenequipped"));
    tooltip.add(TextFormatting.BLUE + " " + I18n
        .translateToLocalFormatted("attribute.modifier.plus." + val.getOperation(), DECIMALFORMAT.format(val.getAmount() * (val.getOperation() == 1 ? 100 : 1)),
            I18n.translateToLocal("attribute.name." + attr)));
  }

  @Override
  public EnumRarity getRarity(ItemStack stack) {
    return EnumRarity.UNCOMMON;
  }

}
