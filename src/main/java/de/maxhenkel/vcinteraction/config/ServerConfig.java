package de.maxhenkel.vcinteraction.config;

import de.maxhenkel.configbuilder.ConfigBuilder;
import de.maxhenkel.configbuilder.ConfigEntry;

public class ServerConfig {

    public final ConfigEntry<Boolean> groupInteraction;
    public final ConfigEntry<Boolean> whisperInteraction;
    public final ConfigEntry<Integer> voiceSculkFrequency;

    public ServerConfig(ConfigBuilder builder) {
        groupInteraction = builder.booleanEntry("group_interaction", false);
        whisperInteraction = builder.booleanEntry("whisper_interaction", false);
        voiceSculkFrequency = builder.integerEntry("voice_sculk_frequency", 7, 1, 15);
    }

}
