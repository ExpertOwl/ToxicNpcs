package com.toxicnpcs;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("ToxicNpcs")
public interface ToxicNpcsConfig extends Config {

	@ConfigItem(
			keyName = "toxicNPCs",
			name = "Toxic NPCs",
			description = "NPCs will be toxic when you die"
	)
	default boolean toxicNPCs() {
		return true;

	}
}
