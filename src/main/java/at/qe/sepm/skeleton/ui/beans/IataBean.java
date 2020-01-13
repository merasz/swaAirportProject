package at.qe.sepm.skeleton.ui.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.springframework.web.context.annotation.ApplicationScope;

@ManagedBean
@ApplicationScoped
public class IataBean {
	private String iata;	
	private List<String> iataList;
	
	@PostConstruct
	public void init() {
        iataList = new ArrayList<>();		
		iataList.add("INN");
		iataList.add("HAM");
		iataList.add("STR");
		iataList.add("SXF");
		iataList.add("MUC");
		iataList.add("DUS");
		iataList.add("SXF");
		iataList.add("FRA");
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public List<String> getIataList() {
		return iataList;
	}

	public void setIataList(List<String> iataList) {
		this.iataList = iataList;
	}
	
	
	
}
