package mod.tropidragon.huntersfriend.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {
    @Inject(method = "die", at = @At("HEAD"), cancellable = true)
    private void onDie(DamageSource source, CallbackInfo ci) {
        Entity attacker = source.getEntity();
        if (attacker instanceof TamableAnimal pet && pet.isTame() &&
                pet.getOwner() instanceof Player) {
            LivingEntity self = (LivingEntity) (Object) this;
            self.setLastHurtByMob(pet.getOwner());

            DamageSource newSource = DamageSource.playerAttack((Player) pet.getOwner());

            self.die(newSource);
            ci.cancel();
        }
    }
}
