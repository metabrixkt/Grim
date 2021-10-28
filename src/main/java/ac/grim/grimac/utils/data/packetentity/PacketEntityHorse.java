package ac.grim.grimac.utils.data.packetentity;

import ac.grim.grimac.player.GrimPlayer;

public class PacketEntityHorse extends PacketEntity {

    public boolean isRearing = false;
    public boolean hasSaddle = false;
    public float jumpStrength = 0.7f;
    public float movementSpeedAttribute = 0.1f;

    // I give up with handling jump boost potions
    // I can't figure out which packet give a horse potion effects
    // Anyways, what's the chances of a plugin:
    // 1) Summoning a horse with packet without a real entity id
    // 2) Having the player ride this horse
    // 3) Giving the horse jump boost, somehow, not sure which packet it is
    //
    // If any one of the three scenarios is false, we are fine
    // If you do see a plugin doing this, please tell me which packet it is

    public PacketEntityHorse(GrimPlayer player, ac.grim.grimac.utils.enums.EntityType type, double x, double y, double z) {
        super(player, type, x, y, z);
    }
}
