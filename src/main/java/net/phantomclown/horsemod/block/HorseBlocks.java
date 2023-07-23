package net.phantomclown.horsemod.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.phantomclown.horsemod.block.custom.WoodBlocks;
import net.phantomclown.horsemod.block.custom.teststandblock;
import net.phantomclown.horsemod.item.HorseTab;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phantomclown.horsemod.HorseMod;
import net.phantomclown.horsemod.item.HorseItem;

import java.util.function.Supplier;

public class HorseBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HorseMod.MOD_ID);

    public static final RegistryObject<Block> Beam_White_Log = registerBlock("beam_white_log",
            () -> new WoodBlocks(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), HorseTab.Horse_Tab);
    public static final RegistryObject<Block> Beam_White_Wood = registerBlock("beam_white_wood",
            () -> new WoodBlocks(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), HorseTab.Horse_Tab);
    public static final RegistryObject<Block> Stripped_Beam_White_Log = registerBlock("stripped_beam_white_log",
            () -> new WoodBlocks(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), HorseTab.Horse_Tab);
    public static final RegistryObject<Block> Stripped_Beam_White_Wood = registerBlock("stripped_beam_white_wood",
            () -> new WoodBlocks(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), HorseTab.Horse_Tab);


    public static final RegistryObject<Block> Test_Bock = registerBlock("testblock",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2F).requiresCorrectToolForDrops()),
            HorseTab.Horse_Tab);

    public static final RegistryObject<Block> Test_Stand = registerBlock("teststand",
            () -> new teststandblock(BlockBehaviour.Properties.of(Material.WOOD).strength(2F).requiresCorrectToolForDrops()),
            HorseTab.Horse_Tab);

    public static final RegistryObject<Block> Beam_White_Planks = registerBlock("beam_white_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face){
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face){
            return 20;
        }


        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face){
            return 5;
        }

    },HorseTab.Horse_Tab);

    private static <T extends  Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
    return HorseItem.ITEMS.register(name,() -> new BlockItem(block.get(),
            new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus evenBus){
        BLOCKS.register(evenBus);
    }
}
