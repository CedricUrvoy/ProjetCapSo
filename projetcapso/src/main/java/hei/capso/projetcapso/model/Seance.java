package hei.capso.projetcapso.model;

import java.util.Date;

public class Seance {
    public Integer id;
    public String title;
    public Date start;
    public Date end;
    public String place;
    public String infos;
    public Integer idGroupe;
    public Integer idMatiere;
    public String nameGroupe;
	
    
    public Seance(Integer id, String title, Date start, Date end, String place,
			String infos, Integer idGroupe, Integer idMatiere) {
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.place = place;
		this.infos = infos;
		this.idGroupe = idGroupe;
		this.idMatiere = idMatiere;
	}


	public Seance(Integer id, String title, Date start, Date end, String place,
			String infos, Integer idGroupe, Integer idMatiere,String nameGroupe) {
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.place = place;
		this.infos = infos;
		this.idGroupe = idGroupe;
		this.idMatiere = idMatiere;
		this.nameGroupe = nameGroupe;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}


	public Date getEnd() {
		return end;
	}


	public void setEnd(Date end) {
		this.end = end;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getInfos() {
		return infos;
	}


	public void setInfos(String infos) {
		this.infos = infos;
	}


	public Integer getIdGroupe() {
		return idGroupe;
	}


	public void setIdGroupe(Integer idGroupe) {
		this.idGroupe = idGroupe;
	}


	public Integer getIdMatiere() {
		return idMatiere;
	}


	public void setIdMatiere(Integer idMatiere) {
		this.idMatiere = idMatiere;
	}


	public String getNameGroupe() {
		return nameGroupe;
	}


	public void setNameGroupe(String nameGroupe) {
		this.nameGroupe = nameGroupe;
	}
    

    
    
}
    
    
    