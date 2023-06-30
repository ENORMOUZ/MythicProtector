package com.enormouz.mythicprotector.mixins.entity;

import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({EntityPlayer.class})
public abstract class MixinEntityPlayer extends MixinEntityLivingBase {
    public MixinEntityPlayer() {
    }
}
