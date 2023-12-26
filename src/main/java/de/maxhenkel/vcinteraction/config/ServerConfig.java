package de.maxhenkel.vcinteraction.config;

import de.maxhenkel.configbuilder.ConfigBuilder;
import de.maxhenkel.configbuilder.entry.ConfigEntry;

public class ServerConfig {

    public final ConfigEntry<Boolean> groupInteraction;
    public final ConfigEntry<Boolean> whisperInteraction;
    public final ConfigEntry<Boolean> sneakInteraction;
    public final ConfigEntry<Integer> voiceSculkFrequency;
    public final ConfigEntry<Integer> minActivationThreshold;

    public ServerConfig(ConfigBuilder builder) {
        groupInteraction = builder.booleanEntry(
                "group_interaction",
                false,
                "If talking in groups should trigger vibrations"
        );
        whisperInteraction = builder.booleanEntry(
                "whisper_interaction",
                false,
                "If whispering should trigger vibrations"
        );
        sneakInteraction = builder.booleanEntry(
                "sneak_interaction",
                false,
                "If talking while sneaking should trigger vibrations"
        );
        voiceSculkFrequency = builder.integerEntry(
                "voice_sculk_frequency",
                7,
                1,
                15,
                "The frequency of the voice vibration"
        );
        minActivationThreshold = builder.integerEntry(
                "minimum_activation_threshold",
                -50,
                -127,
                0,
                "The audio level threshold to activate the sculk sensor in dB"
        );
    }

}
