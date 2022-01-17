package me.nokko.hungeronpeaceful.mixin;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(HungerManager.class)
// Lnet/minecraft/entity/player/PlayerEntity;jump()V
public abstract class HungerManagerMixin {
	@ModifyVariable(
			method = "update(Lnet/minecraft/entity/player/PlayerEntity;)V",
			at = @At(
					value = "INVOKE_ASSIGN",
					target = "Lnet/minecraft/world/World;getDifficulty()Lnet/minecraft/world/Difficulty;"
//					shift = At.Shift.AFTER
			),
			ordinal = 0
	)
	public Difficulty hungerOnPeaceful(Difficulty originalDifficulty) {
		if (originalDifficulty.equals(Difficulty.PEACEFUL)) {
			return Difficulty.EASY;
		}
		return originalDifficulty;
	}
}
