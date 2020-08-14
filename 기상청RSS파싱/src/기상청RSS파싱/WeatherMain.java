package 기상청RSS파싱;

import java.util.ArrayList;

public class WeatherMain {
	public static void main(String[] args) {
		WeatherDAO dao = WeatherDAO.makeDAO();
		for(Weather w : dao.getWeatherList())
			System.out.println(w);
	}

}
