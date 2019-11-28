package games.indigo.adventcalendar;

import games.indigo.adventcalendar.api.rewards.Reward;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import games.indigo.adventcalendar.listeners.InventoryClickListener;

public class Main extends JavaPlugin {

	public static String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "HOLIDAY" + ChatColor.DARK_GRAY + " ⎜ " + ChatColor.GRAY;
	
	private AdventCalendarCommand adventcmd = new AdventCalendarCommand();
	
	public void onEnable() {
		
		saveDefaultConfig();
		
		Reward.createPrizes();
		getCommand(adventcmd.adventcalendar).setExecutor(adventcmd);
		getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);

		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Advent calendar enabled!");
	}
	
	public void onDisable() {
		saveConfig();
	}
/*
	private void createPrizes() {
		Calendar.days.add("eco give %player% 1000");
		
		List<String> pumpkinLore = new ArrayList<String>();
		pumpkinLore.add(ChatColor.YELLOW + "With fluffy whipped cream on top");
		Calendar.days.add(Calendar.createItem(Material.PUMPKIN_PIE, 2, ChatColor.GOLD + "" + ChatColor.BOLD + "Pumpkin Pie", pumpkinLore));
		
		Calendar.days.add(Calendar.createItem(Material.COOKED_CHICKEN, 3, ChatColor.LIGHT_PURPLE + "Turkey", null));
		
		Calendar.days.add("givecrystals %player% 100");
		
		Calendar.days.add(Calendar.createItem(Material.COOKIE, 12, ChatColor.DARK_GREEN + "Freshly Baked Cookies", null));
		
		Calendar.days.add(Calendar.createItem(Material.DIAMOND_BLOCK, 1, null, null));
		
		Calendar.days.add(Calendar.createItem(Material.EMERALD_BLOCK, 2, null, null));
		
		Calendar.days.add(Calendar.createItem(Material.LLAMA_SPAWN_EGG, 1, null, null));
		
		Calendar.days.add("eco give %player% 5000");

		// https://www.planetminecraft.com/banner/peppermint/
		ItemStack banner = Calendar.createItem(Material.WHITE_BANNER, 1, null, null);
		BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
		List<Pattern> bannerPatterns = new ArrayList<Pattern>();
		bannerPatterns.add(new Pattern(DyeColor.RED, PatternType.MOJANG));
		bannerPatterns.add(new Pattern(DyeColor.RED, PatternType.CIRCLE_MIDDLE));
		bannerPatterns.add(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
		bannerPatterns.add(new Pattern(DyeColor.WHITE, PatternType.STRIPE_TOP));
		bannerPatterns.add(new Pattern(DyeColor.GREEN, PatternType.CURLY_BORDER));
		bannerPatterns.add(new Pattern(DyeColor.GREEN, PatternType.SQUARE_TOP_RIGHT));
		bannerPatterns.add(new Pattern(DyeColor.GREEN, PatternType.SQUARE_BOTTOM_LEFT));
		bannerPatterns.add(new Pattern(DyeColor.GREEN, PatternType.TRIANGLES_TOP));
		bannerPatterns.add(new Pattern(DyeColor.GREEN, PatternType.TRIANGLES_BOTTOM));
		bannerMeta.setPatterns(bannerPatterns);
		banner.setItemMeta(bannerMeta);
		Calendar.days.add(banner);
		
		Calendar.days.add("cc give p basic 1 %player%");
		
		Calendar.days.add(Calendar.createItem(Material.SPRUCE_SAPLING, 1, ChatColor.GREEN + "" + ChatColor.BOLD + "Christmas Tree", null));
		
		ItemStack book = Calendar.createItem(Material.ENCHANTED_BOOK, 1, null, null);
		EnchantmentStorageMeta bookmeta = (EnchantmentStorageMeta) book.getItemMeta();
		bookmeta.addStoredEnchant(Enchantment.MENDING, 1, false);
		book.setItemMeta(bookmeta);
		Calendar.days.add(book);
		
		Calendar.days.add("minecraft:give %player% minecraft:player_head{display:{Name:\"{\\\"text\\\":\\\"Christmas Ball Ornament (red)\\\"}\"},SkullOwner:{Id:\"674af43c-ecd1-416c-b4ef-9f182eaeafc6\",Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODg0ZTkyNDg3YzY3NDk5OTViNzk3MzdiOGE5ZWI0YzQzOTU0Nzk3YTZkZDZjZDliNGVmY2UxN2NmNDc1ODQ2In19fQ==\"}]}}} 1");
		
		Calendar.days.add("givecrystals %player% 200");
		
		Calendar.days.add("minecraft:give %player% firework_rocket{Fireworks:{Flight:3,Explosions:[{Type:2,Flicker:0,Trail:1,Colors:[I;11743532,14602026,15790320],FadeColors:[I;15790320]},{Type:1,Flicker:1,Trail:0,Colors:[I;3887386,4312372],FadeColors:[I;15790320]}]}} 5");
		
		ItemStack darkHead = Calendar.createItem(Material.PLAYER_HEAD, 1, null, null);
		SkullMeta darkMeta = (SkullMeta) darkHead.getItemMeta();
		darkMeta.setOwningPlayer(Bukkit.getOfflinePlayer("DarkCornersYT"));
		darkHead.setItemMeta(darkMeta);
		Calendar.days.add(darkHead);
		
		Calendar.days.add("mcmmomultiplier give %player% individual all 14400 1 2");
		
		Calendar.days.add("minecraft:give %player% minecraft:player_head{display:{Name:\"{\\\"text\\\":\\\"Christmas Ball Ornament (green)\\\"}\"},SkullOwner:{Id:\"eb2e049e-5563-4df7-be8a-1c89123a79a1\",Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWU0ODYxNWRmNmI3ZGRmM2FkNDk1MDQxODc2ZDkxNjliZGM5ODNhM2ZhNjlhMmFjYTEwN2U4ZjI1MWY3Njg3In19fQ==\"}]}}} 1");
		
		// https://www.planetminecraft.com/banner/reindeer-forest/
		ItemStack banner2 = Calendar.createItem(Material.GREEN_BANNER, 1, null, null);
		BannerMeta banner2Meta = (BannerMeta) banner.getItemMeta();
		List<Pattern> banner2Patterns = new ArrayList<Pattern>();
		banner2Patterns.add(new Pattern(DyeColor.WHITE, PatternType.CIRCLE_MIDDLE));
		banner2Patterns.add(new Pattern(DyeColor.GREEN, PatternType.BRICKS));
		banner2Patterns.add(new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLE_TOP));
		banner2Patterns.add(new Pattern(DyeColor.BROWN, PatternType.TRIANGLE_BOTTOM));
		banner2Patterns.add(new Pattern(DyeColor.WHITE, PatternType.SQUARE_BOTTOM_LEFT));
		banner2Patterns.add(new Pattern(DyeColor.BROWN, PatternType.SQUARE_BOTTOM_RIGHT));
		banner2Patterns.add(new Pattern(DyeColor.WHITE, PatternType.TRIANGLES_BOTTOM));
		banner2Patterns.add(new Pattern(DyeColor.WHITE, PatternType.TRIANGLES_TOP));
		banner2Patterns.add(new Pattern(DyeColor.LIGHT_BLUE, PatternType.TRIANGLES_TOP));
		banner2Meta.setPatterns(banner2Patterns);
		banner2.setItemMeta(banner2Meta);
		Calendar.days.add(banner2);
		
		Calendar.days.add("minecraft:give %player% minecraft:player_head{display:{Name:\"{\\\"text\\\":\\\"Christmas Ball Ornament (gold)\\\"}\"},SkullOwner:{Id:\"11aca51c-d1f6-4493-b8c0-bfbc74365dda\",Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmVhZWQyMzI1ZDc5NTIyMTIwZjQyMmExZGU3Mjc1NmFmNDRjYWY3NWM3NWRjMjYzM2U1NjczMjM4NDdlZCJ9fX0=\"}]}}} 1");
		
		Calendar.days.add(Calendar.createItem(Material.TOTEM_OF_UNDYING, 1, null, null));
		
		Calendar.days.add(Calendar.createItem(Material.NETHER_STAR, 1, ChatColor.AQUA + "Tree Topper", null));
		
		Calendar.days.add("minecraft:give %player% minecraft:player_head{display:{Name:\"{\\\"text\\\":\\\"Christmas Ball Ornament (white)\\\"}\"},SkullOwner:{Id:\"d49c2625-cb64-4728-9acd-860bc0ef4272\",Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjI0MDcwYzliNjY1OWVkMjViMmNhMTI2OTE1ZjRkODgyMGZhZmNlNDMyNGVkOWE4ZjRiOGE1MDYzNDUzMDdmIn19fQ==\"}]}}} 1");
		
		List<String> potionLore = new ArrayList<String>();
		potionLore.add(ChatColor.YELLOW + "Gives holiday cheer!");
		potionLore.add(ChatColor.WHITE + "" + ChatColor.ITALIC + "Happy Holidays from the DarksCorner staff team!");
		ItemStack potion = Calendar.createItem(Material.POTION, 5, ChatColor.GOLD + "" + ChatColor.BOLD + "Apple Cider", potionLore);
		PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 0), true);
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 3600, 1), true);
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, 3600, 2), true);
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 0), true);
		potionMeta.setColor(Color.YELLOW);
		potion.setItemMeta(potionMeta);
		Calendar.days.add(potion);
		return Calendar.days;


	}

 */
}
