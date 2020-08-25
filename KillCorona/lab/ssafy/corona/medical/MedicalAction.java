package lab.ssafy.corona.medical;

import lab.ssafy.corona.person.Patient;

public interface MedicalAction {
	void addPatient(Patient p) throws NotCoronaException;

	void removePatient(Patient p);
}