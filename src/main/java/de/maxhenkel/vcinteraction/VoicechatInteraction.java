package de.maxhenkel.vcinteraction;

import de.maxhenkel.configbuilder.ConfigBuilder;
import de.maxhenkel.vcinteraction.config.ServerConfig;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SculkSensorBlock;
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
        SERVER_CONFIG = ConfigBuilder.build(FabricLoader.getInstance().getConfigDir().resolve(MODID).resolve("%s.properties".formatted(MODID)), ServerConfig::new);

        VOICE_GAME_EVENT = Registry.register(Registry.GAME_EVENT, new ResourceLocation(MODID, "voice"), new GameEvent("voice", 16));

        Object2IntMap<GameEvent> vibrationFrequencyForEvent = SculkSensorBlock.VIBRATION_FREQUENCY_FOR_EVENT;

        SculkSensorBlock.VIBRATION_FREQUENCY_FOR_EVENT = Object2IntMaps.unmodifiable(
                Util.make(new Object2IntOpenHashMap<>(), map -> {
                    map.putAll(vibrationFrequencyForEvent);
                    map.put(VOICE_GAME_EVENT, SERVER_CONFIG.voiceSculkFrequency.get().intValue());
                })
        );
    }
}
