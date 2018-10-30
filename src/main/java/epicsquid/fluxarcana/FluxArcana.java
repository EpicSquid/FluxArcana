package epicsquid.fluxarcana;

import org.apache.logging.log4j.Logger;

import epicsquid.mysticallib.MysticalLib;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = FluxArcana.MODID, name = FluxArcana.NAME, version = FluxArcana.VERSION, dependencies = FluxArcana.DEPENDENCIES)
public class FluxArcana {
  public static final String MODID = "fluxarcana";
  public static final String NAME = "Flux Arcana";
  public static final String VERSION = "@VERSION@";
  public static ModContainer CONTAINER = null;
  public static final String DEPENDENCIES = "required-before:mysticallib";

  private static Logger logger;

  public static CreativeTabs tab = new CreativeTabs(MODID) {
    @Override
    public String getTabLabel() {
      return MODID;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem() {
      return new ItemStack(Registrar.roseate_band, 1);
    }
  };

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    CONTAINER = Loader.instance().activeModContainer();
    logger = event.getModLog();
    MinecraftForge.EVENT_BUS.register(new Registrar());
    MinecraftForge.EVENT_BUS.register(new Recipes());
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
  }
}
