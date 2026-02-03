import com.phi.machine.Calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Main {
	@Test
	public void testAdd() {
		Calculator cal = new Calculator();
//		assertThat(cal.add(1, 2, 4, 8)).isEqualTo(1+2+4+8);
//		assertThat(cal.add(1, 2, 4, 8, 16)).isEqualTo(1+2+4+8+16);
		assertThat(cal.add(2, 3, 7, 9)).isEqualTo(21L);
		assertThat(cal.add(-33, -77, -989)).isEqualTo(-1099L);
		assertThat(cal.add(9999, 8888, 7777, 6666, 5555)).isEqualTo(38885L);
	}
}
