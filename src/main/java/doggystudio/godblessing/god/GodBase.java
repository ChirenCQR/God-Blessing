package doggystudio.godblessing.god;

import doggystudio.godblessing.GodBlessing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GodBase {
	
public GodType godType;
public String godName;
public ResourceLocation icon;
public boolean isEvil;
public long godDuration;

	public GodBase(GodType type,String name,ResourceLocation icon,boolean isEvil) {
		this.godType = type;
		this.godName = name;
		this.icon = icon;
	    this.isEvil = isEvil;
	}
	
	public GodBase(GodType type,String name,boolean isEvil) {
		this(type, name, new ResourceLocation("godblessing", "textures/gods_icon/" + name +".png"), isEvil);
	}
	
	public boolean isEvil(){
		return isEvil;
	}
	
	public GodType getGodType() {
		return this.godType;
	}
	
	public String getName() {
		return this.godName;
	}
	
	public void setName(String name) {
		this.godName = name;
	}
	
	private String getTranslationName() {
		return GodBlessing.MODID + "_" + this.getName();
	}
	
    public ResourceLocation getImage() {
        return this.icon;
    }
    
    
    public long getGodDuration() {
		return 240000;
    }
    
	public void setGodDuration(long duration) {
		this.godDuration = duration;
	}
}
