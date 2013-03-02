package com.oranav.ditheredholobackground;

import android.content.res.XModuleResources;
import android.content.res.XResources;
import de.robv.android.xposed.IXposedHookZygoteInit;

public class DitheredHoloBackground implements IXposedHookZygoteInit {

	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
		XModuleResources modRes = XModuleResources.createInstance(startupParam.modulePath, null);
		XResources.setSystemWideReplacement(
				"android",
				"drawable",
				"background_holo_dark",
				modRes.fwd(R.drawable.background_dither));
	}

}
