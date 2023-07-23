package net.phantomclown.horsemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class HorseTab {
    public static final CreativeModeTab Horse_Tab = new CreativeModeTab("horsetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(HorseItem.TESTITEM.get());
        }
    };
}
