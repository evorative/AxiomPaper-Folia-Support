package com.moulberry.axiom;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.LevelChunk;

import java.lang.reflect.Method;
import java.util.logging.Level;

public class AxiomReflection {

    private static Method updateBlockEntityTicker = null;

    public static void init() {
        try {
            updateBlockEntityTicker = LevelChunk.class.getDeclaredMethod("updateBlockEntityTicker", BlockEntity.class);
            updateBlockEntityTicker.setAccessible(true);
        } catch (Exception e) {
            AxiomPaper.PLUGIN.getLogger().log(Level.SEVERE, "Failed to initialize Axiom reflection hooks", e);
            throw new RuntimeException(e);
        }
    }

    public static void updateBlockEntityTicker(LevelChunk levelChunk, BlockEntity blockEntity) {
        try {
            updateBlockEntityTicker.invoke(levelChunk, blockEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
