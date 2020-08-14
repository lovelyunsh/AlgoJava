package 기상청RSS파싱;

public class Weather {
	private String hour,temp,reh,wfkor;

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getReh() {
		return reh;
	}

	public void setReh(String reh) {
		this.reh = reh;
	}

	public String getWfkor() {
		return wfkor;
	}

	public void setWfkor(String wfkor) {
		this.wfkor = wfkor;
	}

	@Override
	public String toString() {
		return "Weather [hour=" + hour + ", temp=" + temp + ", reh=" + reh + ", wfkor=" + wfkor + "]";
	}
	
	

	

}
