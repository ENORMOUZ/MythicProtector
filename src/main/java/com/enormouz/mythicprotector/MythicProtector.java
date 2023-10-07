package com.enormouz.mythicprotector;

import com.enormouz.mythicprotector.commands.MythicProtectorCommand;
import com.enormouz.mythicprotector.features.EventHandlerClass;
import com.enormouz.mythicprotector.gui.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = "mythicprotector", name = "MythicProtector", version = "1.0.1")
public class MythicProtector {
    public static final Minecraft mc = Minecraft.getMinecraft();
    public static Config configFile = Config.INSTANCE;
    public static GuiScreen guiToDraw = null;

    @Mod.EventHandler
    public void onFMLInitialization(FMLPreInitializationEvent event) {
        File directory = new File(event.getModConfigurationDirectory(), "eutilswynn");
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        configFile.initialize();

        register(new EventHandlerClass());
        registerCommand(new MythicProtectorCommand());
    }

    public static void register(Object target) {
        MinecraftForge.EVENT_BUS.register(target);
    }

    private static void registerCommand(ICommand command) {
        ClientCommandHandler.instance.registerCommand(command);
    }
}