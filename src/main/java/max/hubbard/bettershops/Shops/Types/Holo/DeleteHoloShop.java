package max.hubbard.bettershops.Shops.Types.Holo;

import com.cryptomorin.xseries.XMaterial;
import com.gmail.filoghost.holographicdisplays.disk.HologramDatabase;
import com.gmail.filoghost.holographicdisplays.object.NamedHologram;
import max.hubbard.bettershops.Configurations.Language;
import max.hubbard.bettershops.Menus.MenuType;
import max.hubbard.bettershops.ShopManager;
import max.hubbard.bettershops.Shops.Shop;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class DeleteHoloShop {

    public static final BlockFace[] axis = {BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};

    public static void deleteHologramShop(final ShopHologram holo) {


        if (holo != null && holo.getHologram() != null) {
            holo.getHologram().delete();
            HologramDatabase.deleteHologram(((NamedHologram) holo.getHologram()).getName());
            HologramDatabase.trySaveToDisk();

            final Shop shop = holo.getShop();

            final boolean open = shop.isOpen();

            BlockFace fa = null;

            if (shop.getOwner().isOnline()) {
                fa = yawToFace(shop.getOwner().getPlayer().getLocation().getYaw()).getOppositeFace();
            }

            final BlockFace f = fa;

            shop.setObject("Holo", false);
            HologramManager.removeHolographicShop(holo);

            shop.getMenu(MenuType.SHOP_SETTINGS).draw(shop.getOwner().getPlayer(), 1);

            new BukkitRunnable() {

                @Override
                public void run() {
                    shop.getLocation().getBlock().setType(Material.CHEST);

                    Chest chest = (Chest) shop.getLocation().getBlock().getState();

                    org.bukkit.material.Chest c = (org.bukkit.material.Chest) chest.getData();
                    BlockFace fa;
                    if (f == null) {
                        fa = c.getFacing();
                    } else {
                        fa = f;
                    }


                    final BlockFace face = fa;

                    c.setFacingDirection(face.getOppositeFace());

                    chest.setData(c);

                    chest.update();

                    final Block b = chest.getBlock().getRelative(face.getOppositeFace());

                    if (b != null) {


                        b.setType(XMaterial.OAK_WALL_SIGN.parseMaterial());


                        if (b.getState() instanceof Sign) {
                            Sign s = (Sign) b.getState();

                            org.bukkit.material.Sign sign = (org.bukkit.material.Sign) s.getData();

                            sign.setFacingDirection(face.getOppositeFace());

                            s.setData(sign);

                            s.setLine(0, Language.getString("MainGUI", "SignLine1"));
                            s.setLine(1, Language.getString("MainGUI", "SignLine2"));
                            if (open) {
                                s.setLine(2, Language.getString("MainGUI", "SignLine3Open"));
                            } else {
                                s.setLine(2, Language.getString("MainGUI", "SignLine3Closed"));
                            }
                            s.setLine(3, Language.getString("MainGUI", "SignLine4"));

                            s.update();

                            ShopManager.signLocs.values().remove(shop);
                            ShopManager.signLocs.put(s.getLocation(), shop);
                        }

                    }
                }

            }.runTask(Bukkit.getPluginManager().getPlugin("BetterShops"));

        }

    }

    public static BlockFace yawToFace(float yaw) {

        return axis[Math.round(yaw / 90f) & 0x3];

    }

    public static void deleteHoloShop(final ShopHologram holo) {


        if (holo != null && holo.getHologram() != null) {
            holo.getHologram().delete();
            HologramDatabase.deleteHologram(((NamedHologram) holo.getHologram()).getName());
            HologramDatabase.trySaveToDisk();

            final Shop shop = holo.getShop();

            final boolean open = shop.isOpen();

            BlockFace fa = null;

            if (shop.getOwner().isOnline()) {
                fa = yawToFace(shop.getOwner().getPlayer().getLocation().getYaw()).getOppositeFace();
            }

            final BlockFace f = fa;

            shop.setObject("Holo", false);
            HologramManager.removeHolographicShop(holo);


            new BukkitRunnable() {

                @Override
                public void run() {
                    shop.getLocation().getBlock().setType(Material.CHEST);

                    Chest chest = (Chest) shop.getLocation().getBlock().getState();

                    org.bukkit.material.Chest c = (org.bukkit.material.Chest) chest.getData();
                    BlockFace fa;
                    if (f == null) {
                        fa = c.getFacing();
                    } else {
                        fa = f;
                    }


                    final BlockFace face = fa;

                    c.setFacingDirection(face.getOppositeFace());

                    chest.setData(c);

                    chest.update();

                    final Block b = chest.getBlock().getRelative(face.getOppositeFace());

                    if (b != null) {


                        b.setType(XMaterial.OAK_WALL_SIGN.parseMaterial());


                        if (b.getState() instanceof Sign) {
                            Sign s = (Sign) b.getState();

                            org.bukkit.material.Sign sign = (org.bukkit.material.Sign) s.getData();

                            sign.setFacingDirection(face.getOppositeFace());

                            s.setData(sign);

                            s.setLine(0, Language.getString("MainGUI", "SignLine1"));
                            s.setLine(1, Language.getString("MainGUI", "SignLine2"));
                            if (open) {
                                s.setLine(2, Language.getString("MainGUI", "SignLine3Open"));
                            } else {
                                s.setLine(2, Language.getString("MainGUI", "SignLine3Closed"));
                            }
                            s.setLine(3, Language.getString("MainGUI", "SignLine4"));

                            s.update();

                            ShopManager.signLocs.values().remove(shop);
                            ShopManager.signLocs.put(s.getLocation(), shop);
                        }

                    }
                }

            }.runTask(Bukkit.getPluginManager().getPlugin("BetterShops"));

        }

    }
}
