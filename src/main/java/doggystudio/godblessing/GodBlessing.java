package doggystudio.godblessing;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import doggystudio.godblessing.event.PassiveGodEvent;
import doggystudio.godblessing.potion.EffectRegistry;
import doggystudio.godblessing.render.RenderGodIcon;

import java.util.stream.Collectors;


@Mod("godblessing")
public class GodBlessing
{
	public static final String NAME = "God Blessing";
	public static final String MODID = "godblessing";
	public static final String VERSION = "Beta-1";
    private static final Logger LOGGER = LogManager.getLogger();


    public GodBlessing() {
       
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
       
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(PassiveGodEvent.class);  
  
        MinecraftForge.EVENT_BUS.register(this);

        new EffectRegistry();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	// CapabilityRegistry.init();
    	//new CommonEventHandler();
        RegisterManager.clearAll();
    	
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }


    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
       
            LOGGER.info("HELLO from Register Block");
        }
    }
}
