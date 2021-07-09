package net.mcreator.olimpicgods.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.olimpicgods.item.BootsItem;
import net.mcreator.olimpicgods.OlimpicGodsModElements;
import net.mcreator.olimpicgods.OlimpicGodsMod;

import java.util.Map;

@OlimpicGodsModElements.ModElement.Tag
public class StopflyProcedure extends OlimpicGodsModElements.ModElement {
	public StopflyProcedure(OlimpicGodsModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OlimpicGodsMod.LOGGER.warn("Failed to load dependency entity for procedure Stopfly!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
				: ItemStack.EMPTY).getItem() == new ItemStack(BootsItem.boots, (int) (1)).getItem())) {
			entity.getPersistentData().putBoolean("usarbota", (true));
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.isFlying = (entity.getPersistentData().getBoolean("usarbota"));
				((PlayerEntity) entity).sendPlayerAbilities();
			}
			entity.getPersistentData().putBoolean("usarbota", (false));
		}
	}
}
