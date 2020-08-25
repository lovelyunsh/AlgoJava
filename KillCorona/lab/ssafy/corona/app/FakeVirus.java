package lab.ssafy.corona.app;

public class FakeVirus {
	
	protected String name;
	protected int level;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.level;
	}
	
	public FakeVirus() {}
	public FakeVirus(String name, int level) {
		this.name = name;
		this.level = level;
	}
}