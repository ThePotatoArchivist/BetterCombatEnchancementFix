package archives.tater.bcenchfix;

import moriyashiine.enchancement.common.init.ModEntityComponents;
import net.bettercombat.api.client.BetterCombatClientEvents;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterCombatEnchancementFix implements ClientModInitializer {
	public static final String MOD_ID = "bcenchfix";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		BetterCombatClientEvents.ATTACK_START.register((clientPlayerEntity, attackHand) -> {
			if (ModEntityComponents.LIGHTNING_DASH.get(clientPlayerEntity).isFloating())
				clientPlayerEntity.swingHand(Hand.MAIN_HAND);
		});
	}
}