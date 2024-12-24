package com.yond.multiThreadedDesign.p9_future.exercise4;

import java.util.concurrent.ExecutionException;

public interface Data {
	public abstract String getContent() throws ExecutionException;
}
