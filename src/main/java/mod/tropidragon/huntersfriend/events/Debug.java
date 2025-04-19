package mod.tropidragon.huntersfriend.events;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class Debug {

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        Entity killer = event.getSource().getEntity();
        if (killer instanceof ServerPlayer player) {
            // player.sendMessage(new TextComponent("A KILL!!!"), player.getUUID());
        }
        if (killer instanceof TamableAnimal pet && pet.isTame() && pet.getOwner() instanceof Player player) {
            // player.sendMessage(new TextComponent("An ASSIT! :P"), player.getUUID());
        }
    }
}
