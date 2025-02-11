package com.yond.io.lsm.sst;

import com.yond.io.lsm.Config;

public class DataBlock extends Block {
    public DataBlock(Config config) {
        super(config);
    }
    
    @Override
    protected boolean isFixedSize() {
        return true;
    }
    
    @Override
    protected int blockSize() {
        return getConfig().getSstDataBlockSize();
    }
}
