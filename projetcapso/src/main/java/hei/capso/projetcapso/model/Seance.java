package hei.capso.projetcapso.model;

import java.util.Date;

public class Seance {
    public int id;
    public String title;
    public Date start;
    public Date end;
    public String place;
    public String infos;
    public int idGroupe;
    public int idMatiere;
    public String nameGroupe;
	
    
    public Seance(int id, String title, Date start, Date end, String place,
			String infos, int idGroupe, int idMatiere) {
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.place = place;
		this.infos = infos;
		this.idGroupe = idGroupe;
		this.idMatiere = idMatiere;
	}


	public Seance(int id, String title, Date start, Date end, String place,
			String infos, int idGroupe, int idMatiere,String nameGroupe) {
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


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public int getIdGroupe() {
		return idGroupe;
	}


	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}


	public int getIdMatiere() {
		return idMatiere;
	}


	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}


	public String getNameGroupe() {
		return nameGroupe;
	}


	public void setNameGroupe(String nameGroupe) {
		this.nameGroupe = nameGroupe;
	}
    

    
    
}
    
    
    