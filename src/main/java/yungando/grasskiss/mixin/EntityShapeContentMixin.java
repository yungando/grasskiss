package yungando.grasskiss.mixin;

import net.minecraft.block.EntityShapeContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import yungando.grasskiss.util.EntityContextDuck;

@Mixin(EntityShapeContext.class)
@SuppressWarnings("unused")
public class EntityShapeContentMixin implements EntityContextDuck {
  @Shadow @Final
  private ItemStack heldItem;

  @Unique @Override
  public Item grasskiss$getItem() {
    return this.heldItem.getItem();
  }
}
