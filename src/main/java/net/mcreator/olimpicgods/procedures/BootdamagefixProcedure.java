package net.mcreator.olimpicgods.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.olimpicgods.item.BootsItem;
import net.mcreator.olimpicgods.OlimpicGodsModElements;
import net.mcreator.olimpicgods.OlimpicGodsMod;

import java.util.Map;

@OlimpicGodsModElements.ModElement.Tag
public class BootdamagefixProcedure extends OlimpicGodsModElements.ModElement {
	public BootdamagefixProcedure(OlimpicGodsModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OlimpicGodsMod.LOGGER.warn("Failed to load dependency entity for procedure Bootdamagefix!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
				: ItemStack.EMPTY).getItem() == new ItemStack(BootsItem.boots, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 900, (int) 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 900, (int) 3));
		}
	}
}
