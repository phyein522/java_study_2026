import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
	private String name;
	private String number;
	private Major major;

	public Student(String name, String number, Major major) {
		this.name = name;
		this.number = number;
		this.major = major;
	}
}
