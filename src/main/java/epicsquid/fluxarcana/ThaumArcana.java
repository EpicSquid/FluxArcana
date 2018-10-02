package epicsquid.fluxarcana;

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

import org.apache.logging.log4j.Logger;

@Mod(modid = ThaumArcana.MODID, name = ThaumArcana.NAME, version = ThaumArcana.VERSION)
public class ThaumArcana
{
    public static final String MODID = "fluxarcana";
    public static final String NAME = "Thaumic Arcana";
    public static final String VERSION = "0.1";
    public static ModContainer CONTAINER = null;

    private static Logger logger;
	
	public static CreativeTabs tab = new CreativeTabs(MODID) {
    	@Override
    	public String getTabLabel(){
    		return MODID;
    	}
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem(){
			return new ItemStack(Registrar.roseate_band,1);
		}
	};

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	CONTAINER = Loader.instance().activeModContainer();
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(new Registrar());
        MinecraftForge.EVENT_BUS.register(new Recipes());
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
    }
}
