package com.nukkitx.protocol.bedrock.v354.serializer;

import com.nukkitx.protocol.bedrock.packet.BlockPickRequestPacket;
import com.nukkitx.protocol.bedrock.v354.BedrockUtils;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlockPickRequestSerializer_v354 implements PacketSerializer<BlockPickRequestPacket> {
    public static final BlockPickRequestSerializer_v354 INSTANCE = new BlockPickRequestSerializer_v354();

    @Override
    public void serialize(ByteBuf buffer, BlockPickRequestPacket packet) {
        BedrockUtils.writeVector3i(buffer, packet.getBlockPosition());
        buffer.writeBoolean(packet.isAddUserData());
        buffer.writeByte(packet.getHotbarSlot());
    }

    @Override
    public void deserialize(ByteBuf buffer, BlockPickRequestPacket packet) {
        packet.setBlockPosition(BedrockUtils.readVector3i(buffer));
        packet.setAddUserData(buffer.readBoolean());
        packet.setHotbarSlot(buffer.readUnsignedByte());
    }
}
