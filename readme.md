# Voice Chat Interaction

This server side Fabric mod allows Simple Voice Chat to interact with your Minecraft world.

## Features

- A custom, configurable vibration frequency for voice
- Talking in voice chat activates sculk sensors
- Talking in voice chat is detected by the warden
- Optional support for whisper and group chat vibrations

## Config Values

*config/vcinteraction/vcinteraction.properties*

|Name| Default Value | Description                                    |
|---|---------------|------------------------------------------------|
|`group_interaction`| `false`       | If talking in groups should trigger vibrations |
|`whisper_interaction`| `false`       | If whispering should trigger vibrations        |
|`voice_sculk_frequency`| `7`           | The frequency of the voice vibration           |
