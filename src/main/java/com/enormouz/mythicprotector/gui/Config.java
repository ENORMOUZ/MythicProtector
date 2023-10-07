package com.enormouz.mythicprotector.gui;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.*;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.Comparator;

public class Config extends Vigilant {
    public static Config INSTANCE = new Config();

    @Property(type = PropertyType.SWITCH, name = "Toggle Mythic Protector", description = "Prevents closing chests with Mythics in them", category = "General")
    public boolean toggleMythicProtector = true;

    @Property(type = PropertyType.SWITCH, name = "Toggle Custom Item Protector", description = "Prevents closing chests with custom items in them", category = "Custom Items")
    public boolean toggleCustomItemProtector = true;

    @Property(type = PropertyType.PARAGRAPH, name = "Custom Items to protect", description = "The items to protect, separated by new lines. They will only be protected if their name EQUALS the item name, so use their full name.", category = "Custom Items", placeholder = "Decaying Heart [✫✫✫]")
    public String customItemsToProtect = "";

    @Property(type = PropertyType.BUTTON, name = "Copy ✫", description = "Click this button to copy ✫ to your clipboard, useful for ingredients and materials", category = "Custom Items")
    public void copyStarCharacter() {
        StringSelection stringSelection = new StringSelection("✫".trim());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public Config() {
        super(new File("./config/mythicprotector/config.toml"), "MythicProtector", new JVMAnnotationPropertyCollector(), new ConfigSorting());
        initialize();
    }

    public static class ConfigSorting extends SortingBehavior {
        @NotNull
        @Override
        public Comparator<Category> getCategoryComparator() {
            return (o1, o2) -> {
                if(o1.getName().equals("MythicProtector")) {
                    return -1;
                } else if(o2.getName().equals("MythicProtector")) {
                    return 1;
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            };
        }
    }
}
