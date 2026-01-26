package com.phi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car10 {
	private int speed;	//기본값 0으로 초기화
	private boolean stop;	//기본값 false로 초기화

	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
		} else {
			this.speed = speed;
		}
	}

	public void setStop(boolean stop) {
		this.stop = stop;
		if(stop == true) {
			this.speed = 0;
		}
	}
}
