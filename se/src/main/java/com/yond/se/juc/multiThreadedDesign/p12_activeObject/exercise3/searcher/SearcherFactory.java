package com.yond.se.juc.multiThreadedDesign.p12_activeObject.exercise3.searcher;

public class SearcherFactory {
	public static Searcher createSearcher() {
		return new SearcherImpl();
	}
}
