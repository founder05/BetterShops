
package max.hubbard.bettershops.Versions.v1_10_R1;

import java.lang.reflect.Field;

import max.hubbard.bettershops.Utils.ReflectUtil;
import net.minecraft.server.v1_10_R1.EnumProtocolDirection;
import net.minecraft.server.v1_10_R1.NetworkManager;

public class NPCNetworkManager extends NetworkManager {

	public NPCNetworkManager() {
        super(EnumProtocolDirection.CLIENTBOUND); //MCP = isClientSide ---- SRG=field_150747_h
		Field channel = ReflectUtil.makeField(NetworkManager.class, "channel"); //MCP = channel ---- SRG=field_150746_k
		Field address = ReflectUtil.makeField(NetworkManager.class, "l"); //MCP = address ---- SRG=field_77527_e
		
		ReflectUtil.setField(channel, this, new NullChannel());
		ReflectUtil.setField(address, this, new NullSocketAddress());
		
	}

}