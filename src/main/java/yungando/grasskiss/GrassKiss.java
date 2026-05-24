package yungando.grasskiss;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;

import java.util.List;

public class GrassKiss {
  private static final List<TagKey<Item>> IGNORED_WEAPON_TAGS = List.of(
    ItemTags.SWORDS,
    ItemTags.PICKAXES,
    ItemTags.TRIDENT_ENCHANTABLE,
    ItemTags.BOW_ENCHANTABLE,
    ItemTags.CROSSBOW_ENCHANTABLE,
    ItemTags.MACE_ENCHANTABLE,
    ItemTags.SPEARS
  );

  private static final List<Class<? extends Block>> IGNORED_BLOCKS = List.of(
    DoublePlantBlock.class,
    FireflyBushBlock.class
  );

  public static boolean isIgnorablePlant(Block block) {
    return IGNORED_BLOCKS.stream()
      .anyMatch(blockClass -> blockClass.isInstance(block));
  }

	public static boolean toolIgnoresPlants(CollisionContext context) {
    if (!(context instanceof EntityCollisionContext entityContext)) return false;

    Entity entity = entityContext.getEntity();
    if (!(entity instanceof Player player)) return false;

		ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);

    return IGNORED_WEAPON_TAGS.stream().anyMatch(itemStack::is);
	}
}