package max.hubbard.bettershops.utils;

import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import max.hubbard.bettershops.Core;
import max.hubbard.bettershops.configuration.Config;
import max.hubbard.bettershops.shops.Shop;
import org.bukkit.Location;

import java.util.Objects;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class WorldGuardStuff {

    public static void allowMobs(Location l) {

        for (com.sk89q.worldguard.protection.regions.ProtectedRegion r : Objects
            .requireNonNull(Core.getWorldGuard()).getRegionManager(l.getWorld())
            .getApplicableRegions(l)) {
            r.setFlag(DefaultFlag.MOB_SPAWNING, StateFlag.State.ALLOW);
        }
    }

    public static void denyMobs(Location l) {

        for (com.sk89q.worldguard.protection.regions.ProtectedRegion r : Objects
            .requireNonNull(Core.getWorldGuard()).getRegionManager(l.getWorld())
            .getApplicableRegions(l)) {
            r.setFlag(DefaultFlag.MOB_SPAWNING, StateFlag.State.DENY);
        }
    }

    public static boolean checkNPCOverride(Shop shop) {
        if (Core.useWorldGuard() && (boolean) Config.getObject("NPCOverride")) {
            WorldGuardStuff.allowMobs(shop.getLocation());
        } else if (Core.useWorldGuard()) {

            if (!Objects.requireNonNull(Core.getWorldGuard())
                .getRegionManager(shop.getLocation().getWorld())
                .getApplicableRegions(shop.getLocation()).allows(DefaultFlag.MOB_SPAWNING)) {
                shop.setObject("NPC", false);
                return false;
            }
        }
        return true;
    }

    public static boolean checkCreateShop(Location l) {
        if (Core.useWorldGuard() && (boolean) Config.getObject("EnableAllowShopsFlag")) {

            return Objects.requireNonNull(Core.getWorldGuard()).getRegionManager(l.getWorld())
                .getApplicableRegions(l).allows(DefaultFlag.ENABLE_SHOP);
        } else if (Core.useWorldGuard() && !(boolean) Config.getObject("EnableAllowShopsFlag")) {
            return true;
        } else {
            return true;
        }
    }

}
