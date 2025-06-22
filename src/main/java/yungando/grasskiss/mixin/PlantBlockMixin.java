package yungando.grasskiss.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yungando.grasskiss.GrassKiss;
import yungando.grasskiss.util.EntityContextDuck;

@Mixin(PlantBlock.class)
public abstract class PlantBlockMixin extends AbstractBlockMixin {
  @Environment(EnvType.CLIENT)
  @Override
  void grasskiss$getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> cir) {
    if (cir == null) return;

    if (context instanceof EntityContextDuck) {
      Item item = ((EntityContextDuck) context).grasskiss$getItem();
      if (GrassKiss.toolIgnoresPlants(item)) {
        cir.setReturnValue(VoxelShapes.empty());
      }
    }
  }
}
