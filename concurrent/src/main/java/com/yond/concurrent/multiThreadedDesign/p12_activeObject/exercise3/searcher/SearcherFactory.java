package com.yond.concurrent.multiThreadedDesign.p12_activeObject.exercise3.searcher;

public class SearcherFactory {
	public static Searcher createSearcher() {
		return new SearcherImpl();
	}
}
