package de.maxhenkel.vcinteraction;

import de.maxhenkel.configbuilder.ConfigBuilder;
import de.maxhenkel.vcinteraction.config.ServerConfig;
import eu.pb4.polymer.rsm.api.RegistrySyncUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.SculkSensorFrequencyRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.gameevent.GameEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VoicechatInteraction implements ModInitializer {

    public static final String MODID = "vcinteraction";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ServerConfig SERVER_CONFIG;

    public static final Identifier VOICE_GAME_EVENT_LOCATION = Identifier.fromNamespaceAndPath(MODID, "voice");
    public static Holder.Reference<GameEvent> VOICE_GAME_EVENT;

    @Override
    public void onInitialize() {
        SERVER_CONFIG = ConfigBuilder
                .builder(ServerConfig::new)
                .path(FabricLoader.getInstance().getConfigDir().resolve(MODID).resolve("%s.properties".formatted(MODID)))
                .build();

        VOICE_GAME_EVENT = Registry.registerForHolder(BuiltInRegistries.GAME_EVENT, VOICE_GAME_EVENT_LOCATION, new GameEvent(16));

        RegistrySyncUtils.setServerEntry(BuiltInRegistries.GAME_EVENT, VOICE_GAME_EVENT_LOCATION);

        SculkSensorFrequencyRegistry.register(VOICE_GAME_EVENT.key(), SERVER_CONFIG.voiceSculkFrequency.get());
    }
}
