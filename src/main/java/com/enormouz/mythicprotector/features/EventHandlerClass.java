package com.enormouz.mythicprotector.features;

import com.enormouz.mythicprotector.MythicProtector;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventHandlerClass {
    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event) {
        if (MythicProtector.guiToDraw != null) {
            MythicProtector.mc.displayGuiScreen(MythicProtector.guiToDraw);
            MythicProtector.guiToDraw = null;
        }
    }
}
