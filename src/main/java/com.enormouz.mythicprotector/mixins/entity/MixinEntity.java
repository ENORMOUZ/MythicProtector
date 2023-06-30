package com.enormouz.mythicprotector.mixins.entity;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({Entity.class})
public abstract class MixinEntity {

    public MixinEntity() {
    }
}
