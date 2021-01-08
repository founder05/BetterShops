package max.hubbard.bettershops.Versions.v1_9_R2;

import net.minecraft.server.v1_9_R2.IChatBaseComponent;
import net.minecraft.server.v1_9_R2.MinecraftServer;
import net.minecraft.server.v1_9_R2.World;
import net.minecraft.server.v1_9_R2.WorldServer;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.craftbukkit.v1_9_R2.block.CraftSign;
import org.bukkit.entity.Player;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class SignChanger {

    public static void doSignChange(Sign sign, org.bukkit.Material mat, Player p, String[] lines) {
        IChatBaseComponent[] components = CraftSign.sanitizeLines(lines);


        World w = MinecraftServer.getServer().getWorld();
        for (WorldServer s : MinecraftServer.getServer().worlds) {
            if (s.getWorld().getName().equals(sign.getWorld().getName())) {
                w = s;
            }
        }

        Location loc = sign.getLocation();
        Sign s = (Sign) loc.getBlock().getState();

        for (int i = 0; i < components.length; i++) {
            String is = components[i].toPlainText();
            s.setLine(i, is);
        }

        s.update();
    }
}
