package com.scoremgm.repository;

import com.scoremgm.model.Member;

public interface ScoreRepository {
	boolean insert(Member member);
	int getCount();
}
