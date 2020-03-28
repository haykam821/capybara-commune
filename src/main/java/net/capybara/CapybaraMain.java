package net.capybara;

import net.capybara.entities.passive.CapybaraEntity;
import net.capybara.entities.passive.CapybaraEntityFactory;
import net.capybara.items.OakBark;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class CapybaraMain implements ModInitializer {
	public static final String CAPYBARA_NAMESPACE = "capybara";

	// Setup the creative item group
	public static ItemGroup CAPYBARA_ITEM_GROUP = FabricItemGroupBuilder.create(
			new Identifier("capybara", "general"))
			.icon(() -> new ItemStack(Items.BOWL))
			.build();


	public static final Block OAK_WITHOUT_BARK = new LogBlock(MaterialColor.WOOD, FabricBlockSettings.of(Material.WOOD).strength(2.0f, 2.0f).build());

	public static final Item OAK_BARK = new OakBark(new Item.Settings().group(CapybaraMain.CAPYBARA_ITEM_GROUP));
	public static final Item CAPYBARA_MEAT = new Item(new Item.Settings().group(CapybaraMain.CAPYBARA_ITEM_GROUP));
	public static final Item CAPYBARA_PELT = new Item(new Item.Settings().group(CapybaraMain.CAPYBARA_ITEM_GROUP));
	public static final EntityType<CapybaraEntity> CAPYBARA_MOB = FabricEntityTypeBuilder
			.create(EntityCategory.CREATURE, new CapybaraEntityFactory()).size(EntityDimensions.fixed(2,1))
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		System.out.println("Initializing Capybara-Commune...");

		Registry.register(Registry.ITEM, new Identifier(CAPYBARA_NAMESPACE, "capybara-meat"), CAPYBARA_MEAT);
		Registry.register(Registry.ITEM, new Identifier(CAPYBARA_NAMESPACE, "capybara-pelt"), CAPYBARA_PELT);
		Registry.register(Registry.ITEM, new Identifier(CAPYBARA_NAMESPACE, "oak_bark"), OAK_BARK);
		Registry.register(Registry.ITEM, new Identifier(CAPYBARA_NAMESPACE, "oak_without_bark"), new BlockItem(OAK_WITHOUT_BARK, new Item.Settings().group(CAPYBARA_ITEM_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(CAPYBARA_NAMESPACE, "oak_without_bark"), OAK_WITHOUT_BARK);
		Registry.register(Registry.ENTITY_TYPE, new Identifier(CAPYBARA_NAMESPACE, "capybara_entity"), CAPYBARA_MOB);
		System.out.println("Completed initialization of Capybara-Commune!");
	}
}
