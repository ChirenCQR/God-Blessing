package doggystudio.godblessing.event;





import java.util.Random;

import doggystudio.godblessing.GodBlessing;
import doggystudio.godblessing.potion.EffectRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PassiveGodEvent {


	@SubscribeEvent
	public static void dailyGod(TickEvent.PlayerTickEvent event) 
{

		if(event.player.getEntityWorld().getDayTime() % 24000 == 0) 
		{
        int i = new Random().nextInt(21);
        
        switch(i)
        {
        case 0 : event.player.addPotionEffect(new EffectInstance(EffectRegistry.TYCHE,23999));
        event.player.addPotionEffect(new EffectInstance(Effects.LUCK,23999));
        event.player.sendMessage(new TranslationTextComponent("message." + GodBlessing.MODID + ".tyche"));
        break;
        case 1 : event.player.addPotionEffect(new EffectInstance(EffectRegistry.BESHABA,23999));
        event.player.addPotionEffect(new EffectInstance(Effects.UNLUCK,23999));
        event.player.sendMessage(new TranslationTextComponent("message." + GodBlessing.MODID +  ".beshaba"));
        break;
        case 2 : event.player.addPotionEffect(new EffectInstance(EffectRegistry.ZHURONG,23999));
        event.player.sendMessage(new TranslationTextComponent("message." + GodBlessing.MODID +  ".zhurong"));
        event.player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,23999));
        break;
        }
	
	    }

}
	
	@SubscribeEvent
	public static void playerAttack(AttackEntityEvent event) 
{
		if(event.getPlayer().getActivePotionEffect(EffectRegistry.ZHURONG) != null)
	    {
			event.getTarget().setFire(new Random().nextInt(10) + 1);//1s ~ 10s的火焰攻击；
		}
}
	  
	

}


