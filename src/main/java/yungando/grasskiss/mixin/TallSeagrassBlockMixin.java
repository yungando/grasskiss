package yungando.grasskiss.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.TallSeagrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yungando.grasskiss.GrassKiss;

@Mixin(TallSeagrassBlock.class)
public class TallSeagrassBlockMixin {
  @Environment(EnvType.CLIENT)
  @Inject(method = "getShape", at = @At(value = "RETURN"), cancellable = true)
  private void grasskiss$getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context, CallbackInfoReturnable<VoxelShape> cir) {
    if (GrassKiss.toolIgnoresPlants(context)) {
      cir.setReturnValue(Shapes.empty());
    }
  }
}
