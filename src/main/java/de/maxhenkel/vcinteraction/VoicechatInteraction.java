package de.maxhenkel.vcinteraction;

import de.maxhenkel.configbuilder.ConfigBuilder;
import de.maxhenkel.vcinteraction.config.ServerConfig;
import eu.pb4.polymer.rsm.api.RegistrySyncUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.SculkSensorFrequencyRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.gameevent.GameEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VoicechatInteraction implements ModInitializer {

    public static final String MODID = "vcinteraction";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ServerConfig SERVER_CONFIG;

    public static GameEvent VOICE_GAME_EVENT;

    @Override
    public void onInitialize() {
        SERVER_CONFIG = ConfigBuilder
                .builder(ServerConfig::new)
                .path(FabricLoader.getInstance().getConfigDir().resolve(MODID).resolve("%s.properties".formatted(MODID)))
                .build();

        VOICE_GAME_EVENT = Registry.register(BuiltInRegistries.GAME_EVENT, new ResourceLocation(MODID, "voice"), new GameEvent(16));

        RegistrySyncUtils.setServerEntry(BuiltInRegistries.GAME_EVENT, VOICE_GAME_EVENT);

        SculkSensorFrequencyRegistry.register(VOICE_GAME_EVENT, SERVER_CONFIG.voiceSculkFrequency.get());
    }
}
