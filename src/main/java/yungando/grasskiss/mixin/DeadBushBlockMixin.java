package yungando.grasskiss.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({DeadBushBlock.class})
@SuppressWarnings("unused")
public abstract class DeadBushBlockMixin extends PlantBlockMixin {
  @Environment(EnvType.CLIENT)
  @Inject(method = "getOutlineShape", at = @At("RETURN"), cancellable = true)
  @Override
  void grasskiss$getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> cir) {
    super.grasskiss$getOutlineShape(state, world, pos, context, cir);
  }
}
