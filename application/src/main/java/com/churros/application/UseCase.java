package com.churros.application;

public abstract class UseCase<Input, Output> {
	public abstract Output execute(Input input);
}
