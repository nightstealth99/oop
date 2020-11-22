package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import oop.beans.Aggrement;

public class GenerateAggrement implements GenerateData {

	@Override
	public List<Aggrement> getData(int n) {
		List<Aggrement> listAggrement = new ArrayList<Aggrement>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.randomDataInFile("./data/agreement/Aggrement_nhan.txt");
		List<String> dinhDanh = readFile.randomDataInFile("./data/agreement/Aggrement_dinhdanh.txt");
		List<String> moTa = readFile.randomDataInFile("./data/agreement/Aggrement_mota.txt");
		List<String> link = readFile.randomDataInFile("./data/agreement/Aggrement_mota.txt");
		List<String> time = readFile.randomDataInFile("./data/agreement/Aggrement_time.txt");
		List<String> location = readFile.randomDataInFile("./data/agreement/Aggrement_time.txt");
		for (int i = 0; i < n; i++) {
			Aggrement aggrement = new Aggrement(readFile.getOneInListString(dinhDanh),
					readFile.getOneInListString(nhanHienThi), readFile.getOneInListString(moTa),
					readFile.getOneInListString(link), readFile.getOneInListString(time),
					readFile.getOneInListString(location));
			listAggrement.add(aggrement);
		}
		return listAggrement;
	}
}
