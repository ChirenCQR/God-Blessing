package doggystudio.godblessing.render;

import doggystudio.godblessing.god.GodBase;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderGodIcon 
{

public static ResourceLocation GOD_ICON = new ResourceLocation("godblessing", "textures/gods_icon/god.png");
	
	@SubscribeEvent
	public static void onRenderGodIcon(RenderGameOverlayEvent.Pre event) 
	{
		Minecraft mc = Minecraft.getInstance();
		Entity entity = mc.getRenderViewEntity();
		if(entity instanceof PlayerEntity) 
		{
			MainWindow window = event.getWindow();
			int width = window.getScaledWidth() , height = window.getHeight();
			mc.getTextureManager().bindTexture(GOD_ICON);
			mc.ingameGUI.blit(width/2 - 175, height - 40 , 0 ,9 ,80, 40);
		}
	}
	
}
