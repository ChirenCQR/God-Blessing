package doggystudio.godblessing.potion;

import doggystudio.godblessing.GodBlessingRegistrys;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffectRegistry extends GodBlessingRegistrys
{
	public static final Effect TYCHE = new NormalEffect( "tyche",EffectType.BENEFICIAL, 0xADFF2F);
	public static final Effect BESHABA = new NormalEffect("beshaba",EffectType.HARMFUL, 0x696969);
	public static final Effect ZHURONG = new NormalEffect("zhurong",EffectType.BENEFICIAL, 0x8B0000);

	

}
