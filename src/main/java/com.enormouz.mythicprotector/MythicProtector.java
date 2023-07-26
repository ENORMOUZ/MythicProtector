package com.enormouz.mythicprotector;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "mythicprotector", name = "MythicProtector", version = "1.0.1")
public class MythicProtector {
    public static final Minecraft mc = Minecraft.getMinecraft();

    public static void register(Object target) {
        MinecraftForge.EVENT_BUS.register(target);
    }
}