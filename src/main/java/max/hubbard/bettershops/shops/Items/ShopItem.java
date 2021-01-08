package max.hubbard.bettershops.shops.Items;

import max.hubbard.bettershops.shops.Shop;
import max.hubbard.bettershops.utils.Timing;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public interface ShopItem {

    Shop shop = null;
    ItemStack item = null;
    boolean sell = false;
    int id = 0;
    byte data = 0;
    short durability = 0;
    List<String> lore = new ArrayList<>();
    String displayName = null;
    double origAdjustedPrice = 0;
    double priceChangePercent = 1;
    int amountToDouble = 750;
    double minPrice = 0;
    double adjustedPrice = 0;
    double maxPrice = 10000000;
    double amountTo = 0;

    Object getObject(String s) ;

    void setObject(String s, Object o);

    Shop getShop();

    ItemStack getItem();

    boolean isSelling();

    boolean isInfinite();

    boolean getLiveEco();

    boolean isAutoStock();

    boolean isTransCooldown();

    boolean isSellEco();

    Timing getAutoStockTiming();

    Timing getTransCooldownTiming();

    int getPage();

    int getSlot();

    List<String> getLore();

    String getDisplayName();

    int getAmount();

    int getId();

    int getLimit();

    int getStock();

    double getPrice();

    byte getData();

    void setData(byte data);

    short getDurability();

    void setPrice(double price);

    String getPriceAsString();

    double getAdjustedPrice();

    String getAdjustedPriceAsString();

    int getMinPrice();

    void setAdjustedPrice(double amt);

    void setAmountTo(double amt);

    double getAmountTo();

    void setAmountToDouble(int amt);

    int getAmountToDouble();

    void calculatePricePercent();

    void calculatePriceChangePercent();

    double getPriceChangePercent();

    double getOrigPrice();

    ShopItem getSister();

    void calculatePrice();


}
