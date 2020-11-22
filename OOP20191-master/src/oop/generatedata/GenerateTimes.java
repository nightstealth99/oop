package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import oop.beans.Time;

public class GenerateTimes implements GenerateData {

	@Override
	public List<Time> getData(int n) {
		
		List<Time> listTime = new ArrayList<Time>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.randomDataInFile("./data/time/Time_nhan.txt");
		List<String> dinhDanh = readFile.randomDataInFile("./data/time/Time_dinhDanh.txt");
		List<String> moTa = readFile.randomDataInFile("./data/time/Time_moTa.txt");
		List<String> link = readFile.randomDataInFile("./data/time/Time_link.txt");
		List<String> time = readFile.randomDataInFile("./data/time/Time_time.txt");
		for (int i = 0; i < n; i++) {
			Time timee = new Time(readFile.getOneInListString(dinhDanh), readFile.getOneInListString(nhanHienThi),
					readFile.getOneInListString(moTa), readFile.getOneInListString(link), readFile.getOneInListString(time));
			listTime.add(timee);

		}

		return listTime;
	}

}
