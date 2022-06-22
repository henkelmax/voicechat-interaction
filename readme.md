# Voice Chat Interaction

This server side Fabric mod allows Simple Voice Chat to interact with your Minecraft world.

## Features

- A custom, configurable vibration frequency for voice
- Talking in voice chat activates sculk sensors
- Talking in voice chat is detected by the warden
- Optional support for whisper and group chat vibrations
- Talking while sneaking doesn't trigger vibrations (Configurable)
- Configurable volume threshold

## Config Values

*config/vcinteraction/vcinteraction.properties*

|Name| Default Value | Description                                                  |
|---|---------------|--------------------------------------------------------------|
|`group_interaction`| `false`       | If talking in groups should trigger vibrations               |
|`whisper_interaction`| `false`       | If whispering should trigger vibrations                      |
|`sneak_interaction`| `false`       | If talking while sneaking should trigger vibrations          |
|`voice_sculk_frequency`| `7`           | The frequency of the voice vibration                         |
|`minimum_activation_threshold`| `-50`         | The audio level threshold to activate the sculk sensor in dB |
