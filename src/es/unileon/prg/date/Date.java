package es.unileon.prg.date;

public class Date {

	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) throws DateException{
		this.year = year;

		if (month < 1 || month > 12) {
			throw new DateException("Mes " + month + " no valido" +
					" Valores posibles entre 1 y 12.");
		} else {
			this.month = month;
		}

		//TODO falta comprobar el dia
		if (day < 1 || day > getDaysOfMonth(month, year)) {
			throw new DateException("Dia " + day + " no valido" +
					" Valores posibles entre 1 y " + getDaysOfMonth(month, year) + ".");
		} else {
			this.day = day;
		}
	}

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	public int getYear() {
		return this.year;
	}

	public void setMonth(int month) throws DateException {
		if (month < 1 || month > 12) {
			throw new DateException("Mes " + month + " no valido" +
					" Valores posibles entre 1 y 12.");
		} else {
			this.month = month;
		}
	}

	public int getMonth() {
		return this.month;
	}

	public int getDay() {
		return this.day;
	}

	public boolean isSameYear(int year) {
		if (this.year == year) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSameYearWithoutIfStatement(int year) {
		return this.year == year;
	}

	public boolean isSameMonth(int month) {
		if (this.month == month) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSameMonthWithoutIfStatement(int month) {
		return this.month == month;
	}

	public boolean isSameDay(int day) {
		if (this.day == day) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSameDayWithoutIfStatement(int day) {
		return this.day == day;
	}

	public boolean isSame(Date date) {
		if (this.year == date.getYear() && this.month == date.getMonth() && this.day == date.getDay()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSameWithoutIfStatement(Date date) {
		return this.year == date.getYear() && this.month == date.getMonth() && this.day == date.getDay();
	}

	public String getNameOfTheMonth() {
		String month = null;

		switch (this.month) {
			case 1:
				month = "January";
				break;
			case 2:
				month = "February";
				break;
			case 3:
				month = "March";
				break;
			case 4:
				month = "April";
				break;
			case 5:
				month = "May";
				break;
			case 6:
				month = "June";
				break;
			case 7:
				month = "July";
				break;
			case 8:
				month = "August";
				break;
			case 9:
				month = "September";
				break;
			case 10:
				month = "October";
				break;
			case 11:
				month = "November";
				break;
			case 12:
				month = "December";
				break;
		}

		return month;
	}

	public boolean dayOfMonthRight() {
		return this.day > 0 && this.day <= getDaysOfMonth(this.month, this.year);
	}

	public int getDaysOfMonth(int month, int year) {
		int days = 0;

		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 2:
				if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
					days = 29;
				} else {
					days = 28;
				}
				break;				
		}

		return days;
	}

	public String getSeason() {
		String season = null;

		switch (this.month) {
			case 1:
			case 2:
				season = "Winter";
				break;
			case 3:
				if (this.day > 20) {
					season = "Spring";
				} else {
					season = "Winter";
				};
				break;
			case 4:
			case 5:
				season = "Spring";
				break;
			case 6:
				if (this.day > 20) {
					season = "Summer";
				} else {
					season = "Spring";
				};
				break;
			case 7:
			case 8:
				season = "Summer";
				break;
			case 9:
				if (this.day > 22) {
					season = "Autumn";
				} else {
					season = "Summer";
				};
				break;
			case 10:
			case 11:
				season = "Autumn";
				break;
			case 12:
				if (this.day > 20) {
					season = "Winter";
				} else {
					season = "Autumn";
				};
				break;
		}

		return season;
	}

	public String getMonthsLeft() {
		StringBuffer cadena = new StringBuffer();

		try {
			Date fechaAux = new Date(this.day, this.month, this.year);

			for (int i = this.month; i < 12; i++) {
				fechaAux.setMonth(i);
				cadena.append(fechaAux.getNameOfTheMonth() + "\n");
			}
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}

		return cadena.toString();
	}

}