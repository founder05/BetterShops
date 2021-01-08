package max.hubbard.bettershops.Shops;

import max.hubbard.bettershops.Menus.MenuType;
import max.hubbard.bettershops.Menus.ShopMenu;
import max.hubbard.bettershops.Shops.Items.ShopItem;
import max.hubbard.bettershops.Shops.Types.Holo.Icons.ShopIcon;
import max.hubbard.bettershops.Shops.Types.Holo.ShopHologram;
import max.hubbard.bettershops.Shops.Types.NPC.ShopsNPC;
import max.hubbard.bettershops.Utils.Transaction;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Sign;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public interface Shop {

    OfflinePlayer owner = null;
    List<ShopItem> items = new ArrayList<ShopItem>();
    List<ShopItem> sell = new ArrayList<ShopItem>();
    List<ShopItem> buy = new ArrayList<ShopItem>();
    List<OfflinePlayer> blacklist = new ArrayList<OfflinePlayer>();
    List<OfflinePlayer> keepers = new ArrayList<OfflinePlayer>();
    Location l = null;
    HashMap<MenuType, ShopMenu> menus = new HashMap<>();
    boolean transLoaded = false;
    History history = null;

    OfflinePlayer getOwner();

    Object getObject(String s);

    void setObject(String path, Object obj);

    String getName();

    boolean setName(String name);

    boolean setOwner(OfflinePlayer owner);

    void loadItems();

    void loadMenus();

    ShopMenu getMenu(MenuType type);

    void clearTransactions();

    void loadTransactions();

    void deleteShopItem(ShopItem item);

    HashMap<UUID, ShopItem> getArrange();

    void deleteFirstTransaction();

    /**
     * @param t    - the Transaction to save
     * @param save - a boolean whether to save to the file or not
     */
    void saveTransaction(Transaction t, boolean save);

    List<ShopItem> getShopItems();

    List<ShopItem> getShopItems(boolean sell);

    void loadKeepers();

    void addKeeper(OfflinePlayer p);

    void removeKeeper(OfflinePlayer p) ;

    List<OfflinePlayer> getKeepers();

    void loadBlacklist();

    void addBlacklist(OfflinePlayer p);

    void removeBlacklist(OfflinePlayer p);

    List<OfflinePlayer> getBlacklist();

    Location getLocation();

    void setOpen(boolean b);

    void setLocation(Location l);

    History getHistory();

    ShopHologram getHolographicShop();

    ShopsNPC getNPCShop();

    ShopIcon getShopIcon();

    boolean useIcon();

    boolean isOpen();

    boolean isNPCShop();

    boolean isHoloShop();

    boolean isServerShop();

    boolean isNotify();

    byte getFrameColor();

    ShopItem createShopItem(ItemStack it, int slot, int page, boolean sell);

    int getNextAvailableId();

    boolean pageFull(int page, boolean sell);

    int getNumberOfItemsOnPage(int page, boolean sell);

    int getNextAvailablePage(boolean sell);

    int getNextSlotForPage(int page, boolean sell);

    Sign getSign();

    void convert();

    void saveConfig();

    void syncSaveConfig();

    void addChest();
}
