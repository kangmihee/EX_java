package acorntest.com.jUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void test() {
		Calculator cal = new Calculator();
		assertEquals(63, cal.multiple(7, 9));
		// assert 계열함수를 이용하여 다양한 테스트 진행
		// null확인
	}
}
