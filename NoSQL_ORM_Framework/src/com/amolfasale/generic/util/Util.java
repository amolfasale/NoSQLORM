package com.amolfasale.generic.util;

import java.util.Date;

public class Util {
	public String StringValidator(String str){
		return str!=null && !str.isEmpty() ? str : "";
	}
	public Integer IntegerValidator(Integer i){
		return i!=null ? i : 0;
	}
	public Long LongValidator(Long l){
		return l!=null ? l : 0l;
	}
	public Date DateValidator(Date dt){
		return dt!=null ? dt : new Date();
	}
}
