package com.yond.se.io.lsm.sst;

import com.yond.se.io.lsm.Config;

public class ExtendableBlock extends Block {
    private final int blockSize;
    
    public ExtendableBlock(Config config, int blockSize) {
        super(config);
        this.blockSize = blockSize;
    }
    
    @Override
    protected boolean isFixedSize() {
        return false;
    }
    
    @Override
    protected int blockSize() {
        return this.blockSize;
    }
}
