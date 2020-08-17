package doggystudio.godblessing.god;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.WorldTickEvent;

public class PassiveGod extends GodBase {

	public static String name;

	public PassiveGod(String name, boolean isEvil) 
	{
		super(GodType.PASSIVE, name, isEvil);
		this.godName = this.name;
	}
	
	


}
