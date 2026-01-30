package exercise.exercise7;

public class OracleDao implements DataAccessObject {
	private String name = "Oracle";
	public String getName() { return this.name; }

	@Override
	public void select() {
		System.out.println(getName() + " DB에서 검색");
	}
	@Override
	public void insert() {
		System.out.println(getName() + " DB에 삽입");
	}
	@Override
	public void update() {
		System.out.println(getName() + " DB를 수정");
	}
	@Override
	public void delete() {
		System.out.println(getName() + " DB에서 삭제");
	}
}
