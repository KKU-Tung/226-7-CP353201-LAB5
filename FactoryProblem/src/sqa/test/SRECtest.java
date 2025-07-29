package sqa.test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.RepeatedTest;

import sqa.main.Income;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Test;

class SRECtest {
	Income income = new Income();
	
	@ParameterizedTest
	@CsvFileSource(files = "src/TestCSV/SREC.csv", numLinesToSkip = 1)
	
	void calculateIncome(int num_impeller, int num_motor, int num_cover, Double expectedResult) {
		Double TotalIncome = income.calculateIncome(num_impeller, num_motor, num_cover);
		assertEquals(expectedResult, TotalIncome);
	}
}
