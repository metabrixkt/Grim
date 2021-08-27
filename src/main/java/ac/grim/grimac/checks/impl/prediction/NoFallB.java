package ac.grim.grimac.checks.impl.prediction;

import ac.grim.grimac.checks.type.PostPredictionCheck;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.anticheat.update.PredictionComplete;
import org.bukkit.Bukkit;

public class NoFallB extends PostPredictionCheck {

    public NoFallB(GrimPlayer player) {
        super(player);
    }

    public void onPredictionComplete(final PredictionComplete predictionComplete) {
        // Exemptions
        if (player.inVehicle || player.wasTouchingWater || player.wasTouchingLava
                || player.uncertaintyHandler.pistonX != 0 || player.uncertaintyHandler.pistonY != 0
                || player.uncertaintyHandler.pistonZ != 0 || player.uncertaintyHandler.isSteppingOnSlime
                || player.isFlying || player.uncertaintyHandler.isStepMovement) return;

        // If the player says they were on the ground, but their (1 / 64) didn't match
        boolean invalid = player.clientClaimsLastOnGround != player.clientControlledVerticalCollision;

        if (invalid) Bukkit.broadcastMessage("Ground is invalid!");
    }
}