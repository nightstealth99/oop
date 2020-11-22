package oop.generatedata;

import java.util.ArrayList;
import java.util.List;
import oop.beans.Location;

public class GenerateLocations implements GenerateData {
	@Override
	public List<Location> getData(int n) {

		ArrayList<Location> listLocation = new ArrayList<Location>();
		ReadFile readFile = new ReadFile();
		List<String> nhanHienThi = readFile.randomDataInFile("./data/location/Location_nhan.txt");
		List<String> dinhDanh = readFile.randomDataInFile("./data/location/Location_dinhDanh.txt");
		List<String> moTa = readFile.randomDataInFile("./data/location/Location_moTa.txt");
		List<String> link = readFile.randomDataInFile("./data/location/Location_link.txt");
		List<String> country = readFile.randomDataInFile("./data/location/location_country.txt");
		for (int i = 0; i < n; i++) {
			Location location1 = new Location(readFile.getOneInListString(dinhDanh),
					readFile.getOneInListString(nhanHienThi), readFile.getOneInListString(moTa),
					readFile.getOneInListString(link), readFile.getOneInListString(country));
			listLocation.add(location1);
		}
		return listLocation;
	}

}
