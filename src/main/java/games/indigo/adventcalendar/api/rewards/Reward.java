package games.indigo.adventcalendar.api.rewards;

import games.indigo.adventcalendar.api.Calendar;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Reward {

    private static List<Reward> rewards = new ArrayList<>();

    Reward() {
        rewards.add(this);
    }

    public abstract void givePlayer (Player player);

    public static void addReward (Reward reward) {
        rewards.add(reward);
    }

    public static List<Reward> getRewards() {
        return rewards;
    }

    public static void createPrizes() {
        // Day 1 - 1 Grey Crystal Block
        addReward(new CmdReward("iagive %player% grey_crystal_block 1"));
        // Day 2 - 2 Steel Ingots
        addReward(new CmdReward("iagive %player% steel_ingot 2"));
        // Day 3 - $1000
        addReward(new CmdReward("eco give %player% 1000"));
        // Day 4 - 100 Coins
        addReward(new CmdReward("givecoins %player% 100"));
        // Day 5 - 1 Spawner Wrench
        addReward(new CmdReward("givewrench %player% 1"));
        // Day 6 - Christmas Tree sapling
        List<String> saplingLore = Arrays.asList(   ChatColor.GREEN + "The fresh scent fills",
                                                    ChatColor.GREEN + "you with holiday cheer!");
        addReward(new ItemReward(Calendar.createItem(Material.SPRUCE_SAPLING, 1, ChatColor.DARK_GREEN + "Christmas Tree Sapling", saplingLore)));
        // Day 7 - 1 Black Crystal Block
        addReward(new CmdReward("iagive %player% black_crystal_block"));
        // Day 8 - Christmas Tree ornament (gold)
        addReward(new CmdReward("give %player% minecraft:player_head{display:{Name:\"{\\\"text\\\":\\\"Christmas Ornament\\\"}\"},SkullOwner:{Id:\"7f292b5e-8a1f-4c63-a371-9181631fcd85\",Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjExYWIzYTExMzJjOWQxZWY4MzVlYTgxZDk3MmVkOWI1Y2Q4ZGRmZjBhMDdjNTVhNzQ5YmNmY2Y4ZGY1In19fQ==\"}]}}} 1"));
        // Day 9 - Banner: https://www.planetminecraft.com/banner/christmas-wreath-v6/
        ItemStack banner = Calendar.createItem(Material.BROWN_BANNER, 1, null, null);
        BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
        Pattern[] patterns = {  new Pattern(DyeColor.BLACK, PatternType.BORDER),
                                new Pattern(DyeColor.GREEN, PatternType.RHOMBUS_MIDDLE),
                                new Pattern(DyeColor.YELLOW, PatternType.SKULL),
                                new Pattern(DyeColor.LIME, PatternType.SKULL),
                                new Pattern(DyeColor.GRAY, PatternType.CREEPER),
                                new Pattern(DyeColor.RED, PatternType.CREEPER),
                                new Pattern(DyeColor.BROWN, PatternType.BORDER),
                                new Pattern(DyeColor.GREEN, PatternType.FLOWER),
                                new Pattern(DyeColor.GREEN, PatternType.CIRCLE_MIDDLE),
                                new Pattern(DyeColor.BROWN, PatternType.CIRCLE_MIDDLE)};
        List<Pattern> bannerPatterns = Arrays.asList(patterns);
        bannerMeta.setPatterns(bannerPatterns);
        banner.setItemMeta(bannerMeta);
        addReward(new ItemReward(banner));
        // Day 10 - Christmas crate key
        addReward(new CmdReward("cc give p christmas 1 %player%"));
        // Day 11 - 4 Pumpkin Pies
        addReward(new ItemReward(Calendar.createItem(Material.PUMPKIN_PIE, 4, ChatColor.WHITE + "" + ChatColor.BOLD + "Holiday Pumpkin Pie", null)));
        // Day 12 - Rainbow Crystal Shard
        addReward(new CmdReward("iagive %player% rainbow_crystal_shard 1"));
        // Day 13 - Christmas Tree ornament (green)
        addReward(new CmdReward("give %player% minecraft:player_head{display:{Name:\"{\\\"text\\\":\\\"Christmas Ornament\\\"}\"},SkullOwner:{Id:\"eb2e049e-5563-4df7-be8a-1c89123a79a1\",Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWU0ODYxNWRmNmI3ZGRmM2FkNDk1MDQxODc2ZDkxNjliZGM5ODNhM2ZhNjlhMmFjYTEwN2U4ZjI1MWY3Njg3In19fQ==\"}]}}} 1"));
        // Day 14 - 16 Diamonds
        addReward(new ItemReward(new ItemStack(Material.DIAMOND, 16)));
        // Day 15 - 1 Zombie Spawner
        addReward(new CmdReward("givespawner %player% zombie 1"));
        // Day 16 - 30min temp global flight
        addReward(new CmdReward("lp user %player% settemp indigo.command.fly.global true 30m"));
        // Day 17 - Christmas tag in chat
        addReward(new CmdReward("givetag %player% christmas"));
        // Day 18 - 100 Crystals
        addReward(new CmdReward("givecrystals %player% 100"));
        // Day 19 - 1 Chocolate
        addReward(new CmdReward("iagive %player% chocolate 1"));
        // Day 20 - 2 Ghostwood logs
        addReward(new CmdReward("iagive %player% ghost_wood_log 2"));
        // Day 21 - Christmas Tree ornament (purple)
        addReward(new CmdReward("give %player% minecraft:player_head{display:{Name:\"{\\\"text\\\":\\\"Christmas Ornament\\\"}\"},SkullOwner:{Id:\"4d764571-87eb-4395-b478-a90277ee754d\",Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODQ1ZjM5MzE4ODkwYThhYmZlZTViMzIwYjM1Yjk1OWZjNjZlMTI1ZThmOGNmM2I3MDY2ZDI0ZjY1ZGU0YjkifX19\"}]}}} 1"));
        // Day 22 - 1 Purple Crystal Block
        addReward(new CmdReward("iagive %player% purple_crystal_block 2"));
        // Day 23 - Eggnog
        addReward(new CmdReward("iagive %player% eggnog 1"));
        // Day 24 - Cookies for Santa
        List<String> cookieLore = Arrays.asList(ChatColor.WHITE + "Leave this out for Santa",
                                                ChatColor.WHITE + "so he'll give you presents");
        addReward(new ItemReward(Calendar.createItem(Material.COOKIE, 24, ChatColor.RED + "" + ChatColor.BOLD + "Cookies for Santa", cookieLore)));
        // Day 25 - Christmas Hat
        addReward(new CmdReward("iagive %player% christmas_hat 1"));
    }
}
