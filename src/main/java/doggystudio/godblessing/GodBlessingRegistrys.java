package doggystudio.godblessing;

import java.lang.reflect.Field;

import net.minecraft.potion.Effect;

public class GodBlessingRegistrys 
{
	public GodBlessingRegistrys() {
    for (Field field : getClass().getFields())
    {
        try
        {
        	Object o = field.get(null);
            if (o instanceof Effect)
            {
                RegisterManager.EFFECTS.add((Effect) o);
            }

        }
        catch (Exception ignored)
        {
        }
    }
}
}
