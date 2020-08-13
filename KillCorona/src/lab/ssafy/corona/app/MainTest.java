package lab.ssafy.corona.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lab.ssafy.corona.medical.CDC;
import lab.ssafy.corona.medical.Hospital;
import lab.ssafy.corona.medical.NotCoronaException;
import lab.ssafy.corona.person.Patient;

public class MainTest {

	public static void main(String[] args) {
		// 병원 생성
		Hospital univHospital = new Hospital("대학병원", 15, "001", 50, 10);
		Hospital localHospital = new Hospital("동네병원", 3, "901", 10, 2);
		
		// 환자 생성
		Patient p1 = new Patient("환자1", 42, "010-1111-1111", "호흡곤란", "001", true);
		Patient p2 = new Patient("환자2", 30, "010-2222-2222", "과음", "901", true);
		
		// 병원 Collection
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		hospitalList.add(univHospital);
		hospitalList.add(localHospital);
		
		// 환자 Collection
		Set<Patient> patientList = new HashSet<Patient>();
		patientList.add(p1);
		patientList.add(p2);
		
		CDC cdc = new CDC("질병관리본부", 200, hospitalList, patientList);
		cdc.about();
		
		// 병원에 cdc 등록
		univHospital.setCdc(cdc);
		localHospital.setCdc(cdc);
		
		// 새로운 환자 등록
		Patient p3 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", false);

		try {
			univHospital.addPatient(p3);
		}catch(NotCoronaException e) {
			System.out.println(e.getMessage());
			System.out.println("등록하려는 환자는 Corona 환자가 아닙니다.");
		}

		cdc.printPatientList();
	}

}