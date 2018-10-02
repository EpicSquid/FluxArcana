package epicsquid.fluxarcana;

import baubles.api.BaubleType;
import epicsquid.mysticallib.LibRegistry;
import epicsquid.mysticallib.event.RegisterContentEvent;
import epicsquid.mysticallib.item.ItemBase;
import epicsquid.fluxarcana.item.ItemHewnHand;
import epicsquid.fluxarcana.item.ItemRoseateBand;
import epicsquid.fluxarcana.item.ItemWardedMail;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.Thaumcraft;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;

public class Registrar {
  public static Item roseate_band, warded_mail, iron_chain, thaumium_chain, brass_chain, hewn_hand, glass_hand;

  @SubscribeEvent
  public void onRegister(RegisterContentEvent event) {
    LibRegistry.setActiveMod(ThaumArcana.MODID, ThaumArcana.CONTAINER);
    event.addItem(iron_chain = new ItemBase("iron_chain").setModelCustom(true).setCreativeTab(ThaumArcana.tab));
    event.addItem(brass_chain = new ItemBase("brass_chain").setModelCustom(true).setCreativeTab(ThaumArcana.tab));
    event.addItem(thaumium_chain = new ItemBase("thaumium_chain").setModelCustom(true).setCreativeTab(ThaumArcana.tab));
    event.addItem(roseate_band = new ItemRoseateBand("roseate_band", BaubleType.RING).setModelCustom(true).setCreativeTab(ThaumArcana.tab));
    event.addItem(warded_mail = new ItemWardedMail("warded_mail", BaubleType.BODY).setModelCustom(true).setCreativeTab(ThaumArcana.tab));
    event.addItem(hewn_hand = new ItemHewnHand("hewn_hand").setModelCustom(true).setCreativeTab(ThaumArcana.tab));

    ResearchCategories
        .registerCategory("THAUMARCANA", null, new AspectList().add(Aspect.EARTH, 1), new ResourceLocation(ThaumArcana.MODID, "textures/researchicon.png"),
            new ResourceLocation(Thaumcraft.MODID, "textures/gui/gui_research_back_1.jpg"));
    ThaumcraftApi.registerResearchLocation(new ResourceLocation(ThaumArcana.MODID + ":research/main"));
  }
}
