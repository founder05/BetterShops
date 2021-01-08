package max.hubbard.bettershops.Versions.v1_10_R1;

import max.hubbard.bettershops.Versions.v1_10_R1.Entities.BatNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.BlazeNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.CaveSpiderNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.ChickenNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.CowNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.CreeperNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.EnderDragonNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.EndermanNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.EndermiteNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.GhastNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.GiantNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.GuardianNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.HorseNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.IronGolemNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.MagmaCubeNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.MushroomCowNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.OcelotNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.PigNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.PigZombieNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.RabbitNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.SheepNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.SilverfishNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.SkeletonNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.SlimeNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.SnowmanNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.SpiderNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.SquidNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.VillagerNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.WitchNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.WitherNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.WolfNPC;
import max.hubbard.bettershops.Versions.v1_10_R1.Entities.ZombieNPC;
import net.minecraft.server.v1_10_R1.EntityBat;
import net.minecraft.server.v1_10_R1.EntityBlaze;
import net.minecraft.server.v1_10_R1.EntityCaveSpider;
import net.minecraft.server.v1_10_R1.EntityChicken;
import net.minecraft.server.v1_10_R1.EntityCow;
import net.minecraft.server.v1_10_R1.EntityCreeper;
import net.minecraft.server.v1_10_R1.EntityEnderDragon;
import net.minecraft.server.v1_10_R1.EntityEnderman;
import net.minecraft.server.v1_10_R1.EntityEndermite;
import net.minecraft.server.v1_10_R1.EntityGhast;
import net.minecraft.server.v1_10_R1.EntityGiantZombie;
import net.minecraft.server.v1_10_R1.EntityGuardian;
import net.minecraft.server.v1_10_R1.EntityHorse;
import net.minecraft.server.v1_10_R1.EntityIronGolem;
import net.minecraft.server.v1_10_R1.EntityMagmaCube;
import net.minecraft.server.v1_10_R1.EntityMushroomCow;
import net.minecraft.server.v1_10_R1.EntityOcelot;
import net.minecraft.server.v1_10_R1.EntityPig;
import net.minecraft.server.v1_10_R1.EntityPigZombie;
import net.minecraft.server.v1_10_R1.EntityRabbit;
import net.minecraft.server.v1_10_R1.EntitySheep;
import net.minecraft.server.v1_10_R1.EntitySilverfish;
import net.minecraft.server.v1_10_R1.EntitySkeleton;
import net.minecraft.server.v1_10_R1.EntitySlime;
import net.minecraft.server.v1_10_R1.EntitySnowman;
import net.minecraft.server.v1_10_R1.EntitySpider;
import net.minecraft.server.v1_10_R1.EntitySquid;
import net.minecraft.server.v1_10_R1.EntityVillager;
import net.minecraft.server.v1_10_R1.EntityWitch;
import net.minecraft.server.v1_10_R1.EntityWither;
import net.minecraft.server.v1_10_R1.EntityWolf;
import net.minecraft.server.v1_10_R1.EntityZombie;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class Register {

    public static void registerNPCs(){
        NMSUtil nms = new NMSUtil();

        nms.registerEntity("Bat", 65, EntityBat.class, BatNPC.class);
        nms.registerEntity("Blaze", 61, EntityBlaze.class, BlazeNPC.class);
        nms.registerEntity("CaveSpider", 59, EntityCaveSpider.class, CaveSpiderNPC.class);
        nms.registerEntity("Chicken", 93, EntityChicken.class, ChickenNPC.class);
        nms.registerEntity("Cow", 92, EntityCow.class, CowNPC.class);
        nms.registerEntity("Creeper", 50, EntityCreeper.class, CreeperNPC.class);
        nms.registerEntity("EnderDragon", 63, EntityEnderDragon.class, EnderDragonNPC.class);
        nms.registerEntity("Enderman", 58, EntityEnderman.class, EndermanNPC.class);
        nms.registerEntity("Endermite", 67, EntityEndermite.class, EndermiteNPC.class);
        nms.registerEntity("Ghast", 56, EntityGhast.class, GhastNPC.class);
        nms.registerEntity("Giant", 53, EntityGiantZombie.class, GiantNPC.class);
        nms.registerEntity("Guradian", 68, EntityGuardian.class, GuardianNPC.class);
        nms.registerEntity("EntityHorse", 100, EntityHorse.class, HorseNPC.class);
        nms.registerEntity("VillagerGolem", 99, EntityIronGolem.class, IronGolemNPC.class);
        nms.registerEntity("LavaSlime", 62, EntityMagmaCube.class, MagmaCubeNPC.class);
        nms.registerEntity("MushroomCow", 96, EntityMushroomCow.class, MushroomCowNPC.class);
        nms.registerEntity("Ozelot", 98, EntityOcelot.class, OcelotNPC.class);
        nms.registerEntity("Pig", 90, EntityPig.class, PigNPC.class);
        nms.registerEntity("PigZombie", 57, EntityPigZombie.class, PigZombieNPC.class);
        nms.registerEntity("Rabbit", 101, EntityRabbit.class, RabbitNPC.class);
        nms.registerEntity("Sheep", 91, EntitySheep.class, SheepNPC.class);
        nms.registerEntity("Silverfish", 60, EntitySilverfish.class, SilverfishNPC.class);
        nms.registerEntity("Skeleton", 51, EntitySkeleton.class, SkeletonNPC.class);
        nms.registerEntity("Slime", 55, EntitySlime.class, SlimeNPC.class);
        nms.registerEntity("Snowman", 97, EntitySnowman.class, SnowmanNPC.class);
        nms.registerEntity("Spider", 52, EntitySpider.class, SpiderNPC.class);
        nms.registerEntity("Squid", 94, EntitySquid.class, SquidNPC.class);
        nms.registerEntity("Villager", 120, EntityVillager.class, VillagerNPC.class);
        nms.registerEntity("Witch", 66, EntityWitch.class, WitchNPC.class);
        nms.registerEntity("WitherBoss", 64, EntityWither.class, WitherNPC.class);
        nms.registerEntity("Wolf", 95, EntityWolf.class, WolfNPC.class);
        nms.registerEntity("Zombie", 54, EntityZombie.class, ZombieNPC.class);
    }

    public static void unregisterNPCs(){
        NMSUtil nms = new NMSUtil();

        nms.registerEntity("Bat", 65, BatNPC.class, EntityBat.class);
        nms.registerEntity("Blaze", 61, BlazeNPC.class, EntityBlaze.class);
        nms.registerEntity("CaveSpider", 59, CaveSpiderNPC.class, EntityCaveSpider.class);
        nms.registerEntity("Chicken", 93, ChickenNPC.class, EntityChicken.class);
        nms.registerEntity("Cow", 92, CowNPC.class, EntityCow.class);
        nms.registerEntity("Creeper", 50, CreeperNPC.class, EntityCreeper.class);
        nms.registerEntity("EnderDragon", 63, EnderDragonNPC.class, EntityEnderDragon.class);
        nms.registerEntity("Enderman", 58, EndermanNPC.class, EntityEnderman.class);
        nms.registerEntity("Endermite", 67, EndermiteNPC.class, EntityEndermite.class);
        nms.registerEntity("Ghast", 56, GhastNPC.class, EntityGhast.class);
        nms.registerEntity("Giant", 53, GiantNPC.class, EntityGiantZombie.class);
        nms.registerEntity("Guradian", 68, GuardianNPC.class, EntityGuardian.class);
        nms.registerEntity("EntityHorse", 100, HorseNPC.class, EntityHorse.class);
        nms.registerEntity("VillagerGolem", 99, IronGolemNPC.class, EntityIronGolem.class);
        nms.registerEntity("LavaSlime", 62, MagmaCubeNPC.class, EntityMagmaCube.class);
        nms.registerEntity("MushroomCow", 96, MushroomCowNPC.class, EntityMushroomCow.class);
        nms.registerEntity("Ozelot", 98, OcelotNPC.class, EntityOcelot.class);
        nms.registerEntity("Pig", 90, PigNPC.class, EntityPig.class);
        nms.registerEntity("PigZombie", 57, PigZombieNPC.class, EntityPigZombie.class);
        nms.registerEntity("Rabbit", 101, RabbitNPC.class, EntityRabbit.class);
        nms.registerEntity("Sheep", 91, SheepNPC.class, EntitySheep.class);
        nms.registerEntity("Silverfish", 60, SilverfishNPC.class, EntitySilverfish.class);
        nms.registerEntity("Skeleton", 51, SkeletonNPC.class, EntitySkeleton.class);
        nms.registerEntity("Slime", 55, SlimeNPC.class, EntitySlime.class);
        nms.registerEntity("Snowman", 97, SnowmanNPC.class, EntitySnowman.class);
        nms.registerEntity("Spider", 52, SpiderNPC.class, EntitySpider.class);
        nms.registerEntity("Squid", 94, SquidNPC.class, EntitySquid.class);
        nms.registerEntity("Villager", 120, VillagerNPC.class, EntityVillager.class);
        nms.registerEntity("Witch", 66, WitchNPC.class, EntityWitch.class);
        nms.registerEntity("WitherBoss", 64, WitherNPC.class, EntityWither.class);
        nms.registerEntity("Wolf", 95, WolfNPC.class, EntityWolf.class);
        nms.registerEntity("Zombie", 54, ZombieNPC.class, EntityZombie.class);
    }
}
