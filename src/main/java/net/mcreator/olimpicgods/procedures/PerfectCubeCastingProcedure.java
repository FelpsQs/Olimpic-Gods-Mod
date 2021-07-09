package net.mcreator.olimpicgods.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.olimpicgods.block.PerfectCubeWallBlock;
import net.mcreator.olimpicgods.OlimpicGodsModElements;
import net.mcreator.olimpicgods.OlimpicGodsMod;

import java.util.Map;

@OlimpicGodsModElements.ModElement.Tag
public class PerfectCubeCastingProcedure extends OlimpicGodsModElements.ModElement {
	public PerfectCubeCastingProcedure(OlimpicGodsModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				OlimpicGodsMod.LOGGER.warn("Failed to load dependency x for procedure PerfectCubeCasting!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				OlimpicGodsMod.LOGGER.warn("Failed to load dependency y for procedure PerfectCubeCasting!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				OlimpicGodsMod.LOGGER.warn("Failed to load dependency z for procedure PerfectCubeCasting!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				OlimpicGodsMod.LOGGER.warn("Failed to load dependency world for procedure PerfectCubeCasting!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((true)) {
			world.setBlockState(new BlockPos((int) (x + 2), (int) y, (int) z), PerfectCubeWallBlock.block.getDefaultState(), 3);
		}
	}
}
