package com.churros.application;

public interface UseCase<Input, Output> {
	public abstract Output execute(Input input);
}
