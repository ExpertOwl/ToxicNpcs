package com.toxicnpcs;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;


import net.runelite.api.events.ActorDeath;
import java.util.List;
import java.util.Arrays;


@Slf4j
@PluginDescriptor(
	name = "ToxicNPC"
)
public class ToxicNpcsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ToxicNpcsConfig config;


List<String> TOXIC_LINES = Arrays.asList(
		"Not like this",
		"lol",
		"L00L",
		"?",
		"????????",
		"Sit"
);


	@Subscribe
	public void onActorDeath(ActorDeath e) {
		if(e.getActor().equals(client.getLocalPlayer())) {
			if(config.toxicNPCs()) {{
				client.getNpcs().forEach(npc -> {
					int roll = (int) Math.floor(Math.random()*TOXIC_LINES.size());
					npc.setOverheadText(TOXIC_LINES.get(roll));
					npc.setOverheadCycle(600);
				});
			}}
		}


	}
	@Provides
	ToxicNpcsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ToxicNpcsConfig.class);
	}
}
