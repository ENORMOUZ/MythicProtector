package com.enormouz.mythicprotector.mixins.entity;

import com.enormouz.mythicprotector.utils.ChestUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {EntityPlayerSP.class}, priority = 1)
public abstract class MixinEntityPlayerSP extends MixinAbstractClientPlayer {

    public MixinEntityPlayerSP() {
    }

    @Inject(method = "closeScreen", at = @At("HEAD"), cancellable = true)
    public void closeScreen(CallbackInfo ci) {
        if (ChestUtils.preventClose()) ci.cancel();
    }
}
