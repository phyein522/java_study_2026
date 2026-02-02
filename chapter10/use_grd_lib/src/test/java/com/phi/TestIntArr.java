package com.phi;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestIntArr {
	@Test
	public void testRunTest1() {
//		assertThat(2).isEqualTo(3+1);
		assertThat(4).isEqualTo(3+1);
	}
	@Test
	public void testRunTest2() {
		Gson gson = new Gson();
		IntArr ia = new IntArr();
		String str = gson.toJson(ia);

		IntArr a = gson.fromJson(str, IntArr.class);
		assertThat(a.getIntegers().length).isEqualTo(ia.getIntegers().length);
		assertThat(a.getIntegers()).isEqualTo(ia.getIntegers());
	}
}
