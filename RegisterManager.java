package doggystudio.godblessing;

import java.util.ArrayList;

import java.util.List;

import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterManager 
{
    public static List<Effect> EFFECTS = new ArrayList<>();
    
    @SubscribeEvent
    public static void registerEffects(RegistryEvent.Register<Effect> event)
    {
        event.getRegistry().registerAll(EFFECTS.toArray(new Effect[0]));
    }
    
    public static void clearAll() {

        EFFECTS = null;

    }
}
