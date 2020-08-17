package doggystudio.godblessing.event;

import java.util.Random;
import doggystudio.godblessing.GodBlessing;
import doggystudio.godblessing.potion.EffectRegistry;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PassiveGodEvent 
{


	@SubscribeEvent
	public static void dailyGod(TickEvent.PlayerTickEvent event) 
{
        if(event.player.getEntityWorld().getDayTime() % 24000 == 0||event.player.getEntityWorld().getDayTime() == 0) 
	{
        int i = new Random().nextInt(5);
        switch(i)
        {
        case 0 : event.player.addPotionEffect(new EffectInstance(EffectRegistry.TYCHE,23999));
        event.player.addPotionEffect(new EffectInstance(Effects.LUCK,23999));
        event.player.sendMessage(new TranslationTextComponent(GodBlessing.MODID + "tyche"));
        break;
        case 1 : event.player.addPotionEffect(new EffectInstance(EffectRegistry.BESHABA,23999));
        event.player.addPotionEffect(new EffectInstance(Effects.UNLUCK,23999));
        event.player.sendMessage(new TranslationTextComponent(GodBlessing.MODID + "beshaba"));
        break;
		default : event.player.sendMessage(new TranslationTextComponent(GodBlessing.MODID + "beshaba")); ;
        }
	
        }

}
	

}


