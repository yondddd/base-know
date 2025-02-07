package com.yond.lsm.sst;

import com.yond.lsm.Config;

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
