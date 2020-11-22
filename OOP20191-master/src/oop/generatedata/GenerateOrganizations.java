package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import oop.beans.Organization;

public class GenerateOrganizations implements GenerateData {
	@Override
	public List<Organization> getData(int n) {

		List<Organization> listOrganization = new ArrayList<Organization>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.randomDataInFile("./data/organization/Organization_nhan.txt");
		List<String> dinhDanh = readFile.randomDataInFile("./data/organization/Organization_dinhDanh.txt");
		List<String> moTa = readFile.randomDataInFile("./data/organization/Organization_moTa.txt");
		List<String> link = readFile.randomDataInFile("./data/organization/Organization_link.txt");
		List<String> truSo = readFile.randomDataInFile("./data/organization/Organization_truSo.txt");

		for (int i = 0; i < n; i++) {
			Organization Organization = new Organization(readFile.getOneInListString(dinhDanh),
					readFile.getOneInListString(nhanHienThi), readFile.getOneInListString(moTa),
					readFile.getOneInListString(link), readFile.getOneInListString(truSo));
			listOrganization.add(Organization);
		}
		return listOrganization;
	}
}
