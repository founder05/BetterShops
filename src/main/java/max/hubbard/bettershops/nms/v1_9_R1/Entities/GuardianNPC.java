package max.hubbard.bettershops.nms.v1_9_R1.Entities;

import net.minecraft.server.v1_9_R2.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftGuardian;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftLivingEntity;
import org.bukkit.entity.Guardian;
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
public class GuardianNPC extends EntityGuardian {
    public GuardianNPC(World world) {
        super(world);
    }

    public static Guardian spawn(Location location) {

        MinecraftServer server = MinecraftServer.getServer();
        WorldServer world = server.getWorldServer(0);
        for (WorldServer ws : server.worlds) {
            if (ws.getWorld().getName().equals(location.getWorld().getName())) {
                world = ws;
                break;
            }
        }
        World mcWorld = ((CraftWorld) location.getWorld()).getHandle();
        final GuardianNPC
            customEntity = new GuardianNPC(world);
        customEntity
            .setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(),
                location.getPitch());
        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
        mcWorld.addEntity(customEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (CraftGuardian) customEntity.getBukkitEntity();
    }

    @Override public void move(double d0, double d1, double d2) {
        return;
    }

    @Override public boolean damageEntity(DamageSource damagesource, float f) {
        return false;
    }

    @Override public void g(double x, double y, double z) {
    }

    @Override public void m() {

    }

    public EntityLiving cq() {
        return null;
    }
}
