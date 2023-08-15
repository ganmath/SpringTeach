package com.example.demo1;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import com.example.demo1.CashCard;

@JsonTest
public class CashCardJsonTest {

	@Autowired
	private JacksonTester<CashCard> json;

	@Test
	public void cashCardSerializationTest() throws IOException {

		// Convert/Serialize Java Objects to Json. This is Actual
		CashCard cashCard = new CashCard(99L, 123.45D);
		assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
		assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
		assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
		assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
		assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
	}

	@Test
	public void cashCardDeserializationTest() throws IOException {
		String expected = "{\"id\":99,"
				+ "\"amount\":123.45}";
		assertThat(json.parse(expected)).isEqualTo(new CashCard(99L, 123.45));
		assertThat(json.parseObject(expected).getId()).isEqualTo(99);
		assertThat(json.parseObject(expected).getAmount()).isEqualTo(123.45);
	}
}