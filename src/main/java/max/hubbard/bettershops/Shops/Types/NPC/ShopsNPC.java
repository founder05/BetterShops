package max.hubbard.bettershops.Shops.Types.NPC;

import max.hubbard.bettershops.Shops.Shop;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public interface ShopsNPC {

    void spawn();
    Shop getShop();
    void removeChest();
    void returnNPC();
    EntityInfo getInfo();
    LivingEntity getEntity();
    void setLocation(Location l);
}
