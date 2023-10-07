package com.enormouz.mythicprotector.utils;

import com.enormouz.mythicprotector.MythicProtector;
import net.minecraft.init.Items;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class ChestUtils {

    public static boolean preventClose() {
        try {
            if (MythicProtector.mc.player.openContainer instanceof ContainerChest) {
                ContainerChest chest = (ContainerChest) MythicProtector.mc.player.openContainer;
                String chestName = chest.getLowerChestInventory().getDisplayName().getUnformattedText();
                if ((chestName.startsWith("Loot Chest") || chestName.contains("Daily Rewards") || chestName.contains("Objective Rewards") || chestName.contains("Challenge Rewards")) && chest.getLowerChestInventory().getSizeInventory() <= 60) {
                    for (int i = 0; i < chest.getLowerChestInventory().getSizeInventory(); i++) {
                        ItemStack stack = chest.getLowerChestInventory().getStackInSlot(i);
                        if (MythicProtector.configFile.toggleMythicProtector && isMythic(stack)) {
                            TextComponentString text = new TextComponentString("§cMythicProtector: There is a " + stack.getDisplayName() + " §cin this chest!");
                            MythicProtector.mc.player.sendMessage(text);
                            return true;
                        }
                        if (MythicProtector.configFile.toggleCustomItemProtector && isCustomItem(stack)) {
                            TextComponentString text = new TextComponentString("§cMythicProtector: There is a " + stack.getDisplayName() + " §cin this chest!");
                            MythicProtector.mc.player.sendMessage(text);
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        catch (Exception e) {
            System.out.println("Error in ChestUtils.preventClose(): " + e);
            return false;
        }
    }

    private static boolean isMythic(ItemStack itemStack) {
        if (itemStack.isEmpty() || !itemStack.hasDisplayName() || itemStack.getItem() == Items.AIR) return false;
        return itemStack.getDisplayName().contains(TextFormatting.DARK_PURPLE.toString()) && itemStack.getDisplayName().contains("Unidentified");
    }

    private static boolean isCustomItem(ItemStack itemStack) {
        if (itemStack.isEmpty() || !itemStack.hasDisplayName() || itemStack.getItem() == Items.AIR) return false;
        String[] itemNames = MythicProtector.configFile.customItemsToProtect.split("\n");
        for (String itemName : itemNames) {
            if (TextFormatting.getTextWithoutFormattingCodes(itemStack.getDisplayName()).equals(itemName)) return true;
        }
        return false;
    }
}
