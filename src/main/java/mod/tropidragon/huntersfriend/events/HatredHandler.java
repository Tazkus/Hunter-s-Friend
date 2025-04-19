package mod.tropidragon.huntersfriend.events;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class HatredHandler {
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        Entity attacker = source.getEntity();
        if (attacker instanceof TamableAnimal pet && pet.isTame() && pet.getOwner() instanceof Player) {
            LivingEntity target = event.getEntityLiving();
            // 实际上并不会影响仇恨，只是为了能适配更多获取击杀者的逻辑
            target.setLastHurtByMob(pet.getOwner());
            target.setLastHurtByPlayer((Player) pet.getOwner());
        }
    }
}
