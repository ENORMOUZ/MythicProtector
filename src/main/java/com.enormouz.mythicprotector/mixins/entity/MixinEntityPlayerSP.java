package com.enormouz.mythicprotector.mixins.entity;

import com.enormouz.mythicprotector.utils.ChestUtils;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {EntityPlayerSP.class}, priority = 1)
public abstract class MixinEntityPlayerSP extends AbstractClientPlayer {

    public MixinEntityPlayerSP(World worldIn, GameProfile playerProfile) {
        super(worldIn, playerProfile);
    }

    @Inject(method = "closeScreen", at = @At("HEAD"), cancellable = true)
    public void closeScreen(CallbackInfo ci) {
        if (ChestUtils.preventClose()) ci.cancel();
    }
}
