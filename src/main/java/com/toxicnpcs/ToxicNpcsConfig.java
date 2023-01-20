package com.toxicnpcs;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface ToxicNpcsConfig extends Config {
	@ConfigItem(
			keyName = "greeting",
			name = "Welcome Greeting",
			description = "The message to show to the user when they login"
	)
	default String greeting() {
		return "Hello";
	}

	@ConfigItem(
			keyName = "toxicNPCs",
			name = "Toxic NPCs",
			description = "NPCs will be toxic when you die"
	)
	default boolean toxicNPCs() {
		return true;

	}
}
