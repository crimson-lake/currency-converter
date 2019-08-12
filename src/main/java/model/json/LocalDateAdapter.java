package model.json;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
	
	@Override
	public LocalDate unmarshal(String s) throws Exception {
		return LocalDate.parse(s);
	}

	@Override
	public String marshal(LocalDate d) throws Exception {
		return d.toString();
	}
}
