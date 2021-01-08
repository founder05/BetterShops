package max.hubbard.bettershops.listeners;

import com.cryptomorin.xseries.XMaterial;
import max.hubbard.bettershops.menus.MenuType;
import max.hubbard.bettershops.ShopManager;
import max.hubbard.bettershops.configuration.Config;
import max.hubbard.bettershops.configuration.Language;
import max.hubbard.bettershops.configuration.Permissions;
import max.hubbard.bettershops.shops.Items.Actions.ClickableItem;
import max.hubbard.bettershops.shops.Shop;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class Opener implements Listener {

    @EventHandler
    public void onDoubleChestPlace(final BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if (e.getBlock().getType() == Material.CHEST || e.getBlock().getType() == Material.TRAPPED_CHEST) {
            if (e.getBlock().getLocation().add(1, 0, 0).getBlock().getType() == Material.CHEST ||
                    e.getBlock().getLocation().add(-1, 0, 0).getBlock().getType() == Material.CHEST ||
                    e.getBlock().getLocation().add(0, 0, 1).getBlock().getType() == Material.CHEST ||
                    e.getBlock().getLocation().add(0, 0, -1).getBlock().getType() == Material.CHEST || e.getBlock().getLocation().add(1, 0, 0).getBlock().getType() == Material.TRAPPED_CHEST ||
                    e.getBlock().getLocation().add(-1, 0, 0).getBlock().getType() == Material.TRAPPED_CHEST ||
                    e.getBlock().getLocation().add(0, 0, 1).getBlock().getType() == Material.TRAPPED_CHEST ||
                    e.getBlock().getLocation().add(0, 0, -1).getBlock().getType() == Material.TRAPPED_CHEST) {

                if (ShopManager.fromLocation(e.getBlock().getLocation().add(0, 0, -1).getBlock().getLocation()) != null ||
                        ShopManager.fromLocation(e.getBlock().getLocation().add(0, 0, 1).getBlock().getLocation()) != null ||
                        ShopManager.fromLocation(e.getBlock().getLocation().add(1, 0, 0).getBlock().getLocation()) != null ||
                        ShopManager.fromLocation(e.getBlock().getLocation().add(-1, 0, 0).getBlock().getLocation()) != null) {

                    if ((boolean) Config.getObject("UseChests")) {
                        e.setCancelled(false);
                    } else {

                        e.setCancelled(true);
                        p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "CannotPlace"));

                        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("BetterShops"), new Runnable() {
                            @Override
                            public void run() {
                                e.getBlock().setType(Material.AIR);
                            }
                        }, 2L);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block b = e.getClickedBlock();

            if (b.getType() == Material.CHEST || b.getType() == Material.TRAPPED_CHEST) {

                final Player p = e.getPlayer();

                final Shop shop = ShopManager.fromLocation(b.getLocation());
                if (shop != null) {

                    Bukkit.getScheduler().runTaskAsynchronously(Bukkit.getPluginManager().getPlugin("BetterShops"), new Runnable() {
                        @Override
                        public void run() {

                            if (shop.getOwner() != null) {
                                if (!shop.getBlacklist().contains(p)) {
                                    if (shop.getOwner().getUniqueId().toString().equals(p.getUniqueId().toString())) {
                                        if ((boolean) Config.getObject("UseChests")) {
                                            e.setCancelled(false);
                                        } else {
                                            e.setCancelled(true);
                                            ClickableItem.clearPlayer(p);
                                            open(p, shop);
                                        }
                                    } else {
                                        e.setCancelled(true);
                                        ClickableItem.clearPlayer(p);
                                        open(p, shop);
                                    }
                                } else {
                                    p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "NotAllowed"));
                                }
                            } else {
                                p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "NoOwner"));
                            }
                        }
                    });
                }
            } else if (b.getType() == XMaterial.OAK_WALL_SIGN.parseMaterial()) {
                Sign sign = (Sign) b.getState();
                final Player p = e.getPlayer();

                Shop sho = ShopManager.fromSignLocation(b.getLocation());

                if (sho == null) {
                    if (ChatColor.stripColor(sign.getLine(0)).equals(ChatColor.stripColor(Language.getString("MainGUI", "SignLine1").replaceAll("&", "§")))
                            && ChatColor.stripColor(sign.getLine(1)).equals(ChatColor.stripColor(Language.getString("MainGUI", "SignLine2").replaceAll("&", "§")))
                            && ChatColor.stripColor(sign.getLine(3)).equals(ChatColor.stripColor(Language.getString("MainGUI", "SignLine4").replaceAll("&", "§")))) {
                        Block face = e.getClickedBlock().getRelative(((org.bukkit.material.Sign) (sign.getData())).getAttachedFace());
                        if (face.getType() == Material.CHEST || face.getType() == Material.TRAPPED_CHEST) {
                            sho = ShopManager.fromLocation(face.getLocation());
                            if (sho != null) {
                                ShopManager.signLocs.put(sign.getLocation(), sho);
                            } else {
                                if (ShopManager.loadingTotal == ShopManager.getShops().size()) {
                                    p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "InvalidShop"));
                                } else {
                                    p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
                                }
                                return;
                            }
                        }
                    }
                }
                final Shop shop = sho;
                if (shop != null) {
                    Bukkit.getScheduler().runTaskAsynchronously(Bukkit.getPluginManager().getPlugin("BetterShops"), new Runnable() {
                        @Override
                        public void run() {
                            if (shop.getOwner() != null) {
                                if (!shop.getBlacklist().contains(p)) {
                                    ClickableItem.clearPlayer(p);
                                    open(p, shop);

                                } else {
                                    p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "NotAllowed"));
                                }
                            } else {
                                p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "NoOwner"));
                            }
                        }
                    });
                }
            }
        }
    }

    public static void open(Player p, Shop shop) {
        if (shop.isServerShop() || !shop.getOwner().getUniqueId().toString().equals(p.getUniqueId().toString())) {

            if (!shop.getOwner().getUniqueId().toString().equals(p.getUniqueId().toString()) && !shop.isOpen()) {
                if (!Permissions.hasEditPerm(p, shop)) {

                    if (p.isOp()) {
                        if (shop.getShopItems(false).size() != 0 || shop.getShopItems(false).size() == 0 && shop.getShopItems(true).size() == 0) {
                            if (shop.getMenu(MenuType.MAIN_BUYING) != null)
                                shop.getMenu(MenuType.MAIN_BUYING).draw(p, 1);
                            else
                                p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
                        } else {
                            if ((boolean) Config.getObject("SellingShops")) {
                                if (shop.getMenu(MenuType.MAIN_SELLING) != null)
                                    shop.getMenu(MenuType.MAIN_SELLING).draw(p, 1);
                                else
                                    p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
                            } else {
                                if (shop.getMenu(MenuType.MAIN_BUYING) != null)
                                    shop.getMenu(MenuType.MAIN_BUYING).draw(p, 1);
                                else
                                    p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
                            }
                        }
                    } else {
                        p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "ShopClosed"));
                        return;
                    }
                } else {
                    if (shop.getShopItems(false).size() != 0 || shop.getShopItems(false).size() == 0 && shop.getShopItems(true).size() == 0) {

                        if (shop.getMenu(MenuType.OWNER_BUYING) != null)
                            shop.getMenu(MenuType.OWNER_BUYING).draw(p, 1);
                        else
                            p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
                    } else {
                        if ((boolean) Config.getObject("SellingShops")) {
                            if (shop.getMenu(MenuType.OWNER_SELLING) != null)
                                shop.getMenu(MenuType.OWNER_SELLING).draw(p, 1);
                            else
                                p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
                        } else {
                            if (shop.getMenu(MenuType.OWNER_BUYING) != null)
                                shop.getMenu(MenuType.OWNER_BUYING).draw(p, 1);
                            else
                                p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
                        }
                    }
                }
            }

            if (shop.getShopItems(false).size() != 0 || shop.getShopItems(false).size() == 0 && shop.getShopItems(true).size() == 0) {
                if (shop.getMenu(MenuType.MAIN_BUYING) != null)
                    shop.getMenu(MenuType.MAIN_BUYING).draw(p, 1);
                else
                    p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
            } else {
                if ((boolean) Config.getObject("SellingShops")) {
                    if (shop.getMenu(MenuType.MAIN_SELLING) != null)
                        shop.getMenu(MenuType.MAIN_SELLING).draw(p, 1);
                    else
                        p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
                } else {
                    if (shop.getMenu(MenuType.MAIN_BUYING) != null)
                        shop.getMenu(MenuType.MAIN_BUYING).draw(p, 1);
                    else
                        p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
                }
            }
        } else if (shop.getOwner().getUniqueId().toString().equals(p.getUniqueId().toString())) {
            if (shop.getShopItems(false).size() != 0 || shop.getShopItems(false).size() == 0 && shop.getShopItems(true).size() == 0) {

                if (shop.getMenu(MenuType.OWNER_BUYING) != null)
                    shop.getMenu(MenuType.OWNER_BUYING).draw(p, 1);
                else
                    p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
            } else {
                if ((boolean) Config.getObject("SellingShops")) {
                    if (shop.getMenu(MenuType.OWNER_SELLING) != null)
                        shop.getMenu(MenuType.OWNER_SELLING).draw(p, 1);
                    else
                        p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
                } else {
                    if (shop.getMenu(MenuType.OWNER_BUYING) != null)
                        shop.getMenu(MenuType.OWNER_BUYING).draw(p, 1);
                    else
                        p.sendMessage(Language.getString("Messages", "Prefix") + Language.getString("Messages", "Loading"));
                }
            }
        }
    }
}


