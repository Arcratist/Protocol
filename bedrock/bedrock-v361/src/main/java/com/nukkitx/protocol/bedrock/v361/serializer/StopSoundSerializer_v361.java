package com.nukkitx.protocol.bedrock.v361.serializer;

import com.nukkitx.protocol.bedrock.packet.StopSoundPacket;
import com.nukkitx.protocol.bedrock.v361.BedrockUtils;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StopSoundSerializer_v361 implements PacketSerializer<StopSoundPacket> {
    public static final StopSoundSerializer_v361 INSTANCE = new StopSoundSerializer_v361();


    @Override
    public void serialize(ByteBuf buffer, StopSoundPacket packet) {
        BedrockUtils.writeString(buffer, packet.getSoundName());
        buffer.writeBoolean(packet.isStoppingAllSound());
    }

    @Override
    public void deserialize(ByteBuf buffer, StopSoundPacket packet) {
        packet.setSoundName(BedrockUtils.readString(buffer));
        packet.setStoppingAllSound(buffer.readBoolean());
    }
}
