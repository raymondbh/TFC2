package com.bioxx.tfc2;

import java.io.File;
import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

import com.bioxx.tfc2.asm.transform.TF_EntityRenderer;

@TransformerExclusions({ "com.bioxx.tfc2.asm" })
public class TFCASMLoadingPlugin implements IFMLLoadingPlugin
{
	public static boolean runtimeDeobf;
	public static File location;

	@Override
	public String getAccessTransformerClass() {
		return null;
	}

	@Override
	public String[] getASMTransformerClass() {
		return new String[]{
				TF_EntityRenderer.class.getName()};
	}

	@Override
	public String getModContainerClass() {
		return TFC2Core.class.getName();
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		runtimeDeobf = (Boolean) data.get("runtimeDeobfuscationEnabled");
		location = (File) data.get("coremodLocation");
	}

}