package net.guides.springboot.todomanagement.model;

public class TestTable{
	private String name;
	public TestTable(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Beer [name=" + name + "]";
	}
}