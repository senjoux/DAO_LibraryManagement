package com.ham.entities;

import java.io.Serializable;


public class Theme implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8552801072140528140L;
	
	private int idTheme;
	private String theme;
	
	public Theme() {	}

	public Theme(int id, String theme) {
		super();
		this.idTheme = id;
		this.theme = theme;
	}

	public Theme(String theme) {
		super();
		this.theme = theme;
	}

	public int getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}


	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	

	@Override
	public String toString() {
		return "Theme [id=" + idTheme + ", theme=" + theme + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTheme;
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theme other = (Theme) obj;
		if (idTheme != other.idTheme)
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		return true;
	}
	
	
	
	
}
