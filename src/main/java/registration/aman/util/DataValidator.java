package registration.aman.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class validates input data
 * 
 * @author Bridge Design
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public class DataValidator {

	/**
	 * Checks if value is Null
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isNull(String val) {
		if (val == null || val.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if value's Length > 6
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isPassSize(String val) {
		if (isNotNull(val)) {
			if (val.length() >= 6 && val.length() <= 11) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Checks if value is NOT Null
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isNotNull(String val) {
		return !isNull(val);
	}

	/**
	 * Checks if value is an Integer
	 * 
	 * @param val
	 * @return
	 */

	public static boolean isInteger(String val) {

		if (isNotNull(val)) {
			try {
				int i = Integer.parseInt(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	public static boolean isWhiteSpace(String val) {
		if (val.matches(".*\\s+.*")) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isNumber(String val) {
		String reg = "[A-Za-z ~!@#$%^&*_=-|?/><.,]*";
		if (val.matches(reg)) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean isSpecial(String val) {
		String reg = "[A-Za-z0-9\\s]*";

		if (val.matches(reg)) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Check if value is Long
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isLong(String val) {
		if (isNotNull(val)) {
			try {
				long i = Long.parseLong(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	/**
	 * Checks if value is valid Email ID
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isEmail(String val) {

		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		if (isNotNull(val)) {
			try {
				return val.matches(emailreg);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	/**
	 * Checks if value is Date
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isDate(String val) {

		Date d = null;
		if (isNotNull(val)) {
			d = DataUtility.getDate(val);
		}
		return d != null;
	}
	/**
	 * Checks if value is College name
	 * 
	 * @param val
	 * @return
	 */
	public static  boolean isCollegeName(String val){
		String str1  = "([a-zA-Z]{4,30}) + ([0-9]?)";
		if((val.matches(str1))){
			return true;
		}else {
			return false;
		}
	}

	public static  boolean isSate(String val){
		//String str1  = "([a-zA-Z]{4,30}) + ([0-9]?)";
		String str1 = "[_A-Za-z]+(.[_A-Za-z0-9-]+)[A-Za-z]";
		if((val.matches(str1))){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Checks if  validss age
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isValideAge(String val) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date userDate = format.parse(val);
		Date todayDate = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(todayDate);
		cal.add(Calendar.YEAR, -17);

		Date beforedate = cal.getTime();
		if (beforedate.compareTo(userDate) == -1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if valide Roll no
	 * 
	 * @param val
	 * @return
	 */
/*	public static boolean isCollegeName(String val){
		boolean flag;
		//String str = "([A-Z]{0,30}) + ([0-9]{0,5})";
//		"^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	//	shikha.sharmao925@gmail.
		String str = "^[_A-Za-z]{2,}+(\\[0-9-])$";
		if(val.matches(str))
		{
			if (!isWhiteSpace(val)) {

				if (isLong(val)) {
					if (Long.parseLong(val) > 0) {
						flag = true;
					} else {
						flag = false;
					}
				} else if (isInteger(val)) {
					if (Integer.parseInt(val) > 0) {
						flag = true;
					} else {
						flag = false;
					}

				} else {
					flag = true;
				}
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}
		*/
	
	public static boolean isRollNo(String val) {
		boolean flag;
		//String str = "([_A-Za-z0-9]+)";
		String str = "([0-9]{4})+([A-Za-z]{2})+[0-9]{5}";
		if (val.matches(str)) {
			if (!isWhiteSpace(val)) {

				if (isLong(val)) {
					if (Long.parseLong(val) > 0) {
						flag = true;
					} else {
						flag = false;
					}
				} else if (isInteger(val)) {
					if (Integer.parseInt(val) > 0) {
						flag = true;
					} else {
						flag = false;
					}

				} else {
					flag = true;
				}
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}
	
	public static boolean isRollNo1(String val) {
		boolean flag;
		//String str = "([_A-Za-z0-9]+)";
		String str = "([0-9]{4})+([A-Z]{2})+[0-9]{5}";
		if (val.matches(str)) {
		return true;
	}else{
		return false;
	}
	}
	/**
	 * Checks if valid Roll no
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isRollNum(String val) {
		boolean flag;
		String str = "([0-9]{4})+([A-Z]{2})+[0-9]{6}";
		
		// ^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$
		
		if (val.matches(str)) {
			if (!isWhiteSpace(val)) {

				if (isLong(val)) {
					if (Long.parseLong(val) > 0) {
						flag = true;
					} else {
						flag = false;
					}
				} else if (isInteger(val)) {
					if (Integer.parseInt(val) > 0) {
						flag = true;
					} else {
						flag = false;
					}

				} else {
					flag = true;
				}
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	public static boolean isExamDate(String val) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date userDate = format.parse(val);
		Date todayDate = new Date();

		// Calendar cal = Calendar.getInstance();
		// cal.setTime(todayDate);
		// cal.add(Calendar.YEAR);

		// Date beforedate = cal.getTime();
		System.out.println(todayDate + "Today date   " + userDate + "    userDate");
		/*
		 * if((userDate.compareTo(todayDate) == -1) &&
		 * (userDate.compareTo(todayDate) == 0)) { System.out.println(
		 * "in validator"); return false; } else { return true; }
		 */
		if (userDate.compareTo(todayDate) == -1 || userDate.compareTo(todayDate) == 0) {
			System.out.println("tttttttt");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if valid Mobile no
	 * 
	 * @param val
	 * @return
	 */
	
	public static boolean isLength( String val){
		if(val.length()==10){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if phone Length
	 * 
	 * @param val
	 * @return
	 */
	
	public static boolean isPhnLength ( String value){
		System.out.println(value.length()+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

		if(value.length()==11){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if phone number is valid
	 * 
	 * @param val
	 * @return
	 */
	
	public static boolean isPhoneNo(String val){
		if (val.length() == 11) {
			// return true;
			String str = "[0-1]+([0-9]+)";
			//String str = "(?([0-9]{3}))?([ .-]?)([0-9]{3})\2([0-9]{4})/";
			if (val.matches(str)) {
				if (isLong(val)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	/**
	 * Checks if mobile number is valid
	 * 
	 * @param val
	 * @return
	 */
	
	public static boolean isValideMobileNo(String val) {
		if (val.length() == 10) {
			// return true;
			String str = "[7-9]+([0-9]+)";
			if (val.matches(str)) {
				if (isLong(val)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

}
