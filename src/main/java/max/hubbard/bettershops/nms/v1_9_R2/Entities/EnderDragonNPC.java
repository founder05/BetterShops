package max.hubbard.bettershops.nms.v1_9_R2.Entities;

import net.minecraft.server.v1_9_R2.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftEnderDragon;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftLivingEntity;
import org.bukkit.entity.EnderDragon;
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
public class EnderDragonNPC extends EntityEnderDragon {
    public EnderDragonNPC(World world) {
        super(world);
    }

    public static EnderDragon spawn(Location location) {

        MinecraftServer server = MinecraftServer.getServer();
        WorldServer world = server.getWorldServer(0);
        for (WorldServer ws : server.worlds) {
            if (ws.getWorld().getName().equals(location.getWorld().getName())) {
                world = ws;
                break;
            }
        }
        World mcWorld = ((CraftWorld) location.getWorld()).getHandle();
        final EnderDragonNPC customEntity = new EnderDragonNPC(world);
        customEntity
            .setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(),
                location.getPitch());
        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
        mcWorld.addEntity(customEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (CraftEnderDragon) customEntity.getBukkitEntity();
    }

    @Override public void move(double d0, double d1, double d2) {
    }

    @Override public boolean damageEntity(DamageSource damagesource, float f) {
        return false;
    }

    @Override public void g(double x, double y, double z) {

    }

    @Override public void m() {

    }

    @Override public void g(float paramFloat1, float paramFloat2) {

    }
}
