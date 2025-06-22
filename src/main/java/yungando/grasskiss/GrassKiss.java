package yungando.grasskiss;
import net.minecraft.item.*;

public class GrassKiss {
	public static boolean toolIgnoresPlants(Item item) {
		if (item instanceof SwordItem) return true;
		if (item instanceof PickaxeItem) return true;
		if (item instanceof TridentItem) return true;
		if (item instanceof BowItem) return true;
		if (item instanceof MaceItem) return true;

		return false;
	}
}