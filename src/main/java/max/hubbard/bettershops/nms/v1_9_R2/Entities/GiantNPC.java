package max.hubbard.bettershops.nms.v1_9_R2.Entities;

import net.minecraft.server.v1_9_R2.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftGiant;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftLivingEntity;
import org.bukkit.entity.Giant;
import org.bukkit.event.entity.CreatureSpawnEvent;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class GiantNPC extends EntityGiantZombie {
    public GiantNPC(World world) {
        super(world);
    }

    public static Giant spawn(Location location) {

        MinecraftServer server = MinecraftServer.getServer();
        WorldServer world = server.getWorldServer(0);
        for (WorldServer ws : server.worlds) {
            if (ws.getWorld().getName().equals(location.getWorld().getName())) {
                world = ws;
                break;
            }
        }
        World mcWorld = ((CraftWorld) location.getWorld()).getHandle();
        final GiantNPC customEntity = new GiantNPC(world);
        customEntity
            .setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(),
                location.getPitch());
        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
        mcWorld.addEntity(customEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (CraftGiant) customEntity.getBukkitEntity();
    }

    @Override public void move(double d0, double d1, double d2) {
    }

    @Override public boolean damageEntity(DamageSource damagesource, float f) {
        return false;
    }

    @Override public void g(double x, double y, double z) {
    }
}
