package com.phi;

public sealed interface SealedInterfaceA permits SealedInterfaceB {
	void methodA();
}
