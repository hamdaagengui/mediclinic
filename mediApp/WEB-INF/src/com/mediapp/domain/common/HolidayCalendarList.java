package com.mediapp.domain.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

public class HolidayCalendarList extends MediAppBaseDomain{
    /**
	 * 
	 */
	private static final long serialVersionUID = 133212232L; 
	
    private List<Holidays> holidays = LazyList.decorate(
			new ArrayList < Holidays > (),
		FactoryUtils.instantiateFactory(Holidays.class));

	public List<Holidays> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<Holidays> holidays) {
		this.holidays = holidays;
	}

	private int idDoctorPerson;

	public int getIdDoctorPerson() {
		return idDoctorPerson;
	}

	public void setIdDoctorPerson(int idDoctorPerson) {
		this.idDoctorPerson = idDoctorPerson;
	}



}
