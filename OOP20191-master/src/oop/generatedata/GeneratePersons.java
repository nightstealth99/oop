package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import oop.beans.Person;

public class GeneratePersons implements GenerateData {
	@Override
	public List<Person> getData(int n) {
		List<Person> listPerson = new ArrayList<Person>();
		ReadFile readFile = new ReadFile();
		
		List<String> nhanHienThi = readFile.randomDataInFile("./data/person/Person_nhan.txt");
		List<String> dinhDanh = readFile.randomDataInFile("./data/person/Person_dinhDanh.txt");
		List<String> moTa = readFile.randomDataInFile("./data/person/Person_moTa.txt");
		List<String> link = readFile.randomDataInFile("./data/person/Person_link.txt");
		List<String> chucVu = readFile.randomDataInFile("./data/person/Person_chucVu.txt");
		List<String> quocTich = readFile.randomDataInFile("./data/person/Person_quocTich.txt");
		for (int i = 0; i < n; i++) {
			Person person = new Person(readFile.getOneInListString(dinhDanh), readFile.getOneInListString(nhanHienThi),
					readFile.getOneInListString(moTa), readFile.getOneInListString(link), readFile.getOneInListString(chucVu), readFile.getOneInListString(quocTich));
			listPerson.add(person);
		}
		return listPerson;

	}
}
