package me.nokko.hungeronpeaceful.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Redirect(
            method = "Lnet/minecraft/entity/player/PlayerEntity;tickMovement()V",
            at = @At(value = "FIELD",
                    opcode = Opcodes.GETSTATIC,
                    target = "Lnet/minecraft/world/Difficulty;PEACEFUL:Lnet/minecraft/world/Difficulty;"))
    private Difficulty getDifficulty() {
        return Difficulty.NORMAL;
    }


}
