package yungando.grasskiss;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;

public class GrassKiss {
	public static boolean toolIgnoresPlants() {
		ClientPlayerEntity player = MinecraftClient.getInstance().player;
		if (player == null) return false;

		Item item = player.getStackInHand(Hand.MAIN_HAND).getItem();

		if (item instanceof SwordItem) return true;
		if (item instanceof PickaxeItem) return true;
		if (item instanceof TridentItem) return true;
		if (item instanceof BowItem) return true;
		if (item instanceof MaceItem) return true;

		return false;
	}
}