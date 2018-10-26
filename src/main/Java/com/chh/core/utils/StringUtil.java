package com.chh.core.utils.utils;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;

/**
 * 工具类-字符串处理
 * 
 * @author xx
 * @version 2.0
 * @since 2014年1月28日
 */
public final class StringUtil extends StringUtils {

	/**
	 * 构造函数
	 */
	private StringUtil() {

	}

	/**
	 * 字符串空处理，去除首尾空格 如果str为null，返回"",否则返回str
	 * 
	 * @param str 字符串
	 * @return 如果str为null，返回"",否则返回str
	 */
	public static String isNull(String str) {
		if (str == null) {
			return "";
		}
		return str.trim();
	}

	public static boolean isEmpty(Object str) {
		return str==null || "".equals(str);
	}

	/**
	 * 判断输入的手机号码是否有效
	 * 
	 * @param str 手机号码
	 * @return 检验结果（true：有效 false：无效）
	 */
	public static boolean isPhone(String str) {
		String phone = isNull(str);
		if(phone.length() != 11 || !phone.startsWith("1")){
			return false;
		}
		Pattern regex = Pattern.compile("^\\d{11}$");
		Matcher matcher = regex.matcher(phone);
		boolean isMatched = matcher.matches();
		if(!isMatched){
			return false;
		}
		return true;
	}
	
	/**
	 * 判断邮箱是否有效
	 * @param str 邮箱
	 * @return 检验结果（true：有效 false：无效）
	 */
	public static boolean isMail(String str) {
		String mail = isNull(str);
		Pattern regex = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
		Matcher matcher = regex.matcher(mail);
		boolean isMatched = matcher.matches();
		return isMatched;
	}

	/**
	 * 判断输入的身份证号码是否有效
	 * 
	 * @param str 身份证号码
	 * @return 检验结果（true：有效 false：无效）
	 */
	public static boolean isCard(String str) {
		String cardId = isNull(str);
		// 身份证正则表达式(15位)
		Pattern isIDCard1 = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
		// 身份证正则表达式(18位)
		Pattern isIDCard2 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
		Matcher matcher1 = isIDCard1.matcher(cardId);
		Matcher matcher2 = isIDCard2.matcher(cardId);
		boolean isMatched = matcher1.matches() || matcher2.matches();
		return isMatched;
	}

	/**
	 * 功能：将输入字符串的首字母改成大写
	 * 
	 * @param str 字符串
	 * @return 首字母大写的字符串
	 */
	public static String upperFirst(String str) {
		if (StringUtil.isBlank(str)) {
			return "";
		} else {
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}
	}

	/**
	 * 功能：将输入字符串的首字母改成小写
	 * 
	 * @param str 字符串
	 * @return 首字母小写的字符串
	 */
	public static String lowerFirst(String str) {
		if (StringUtil.isBlank(str)) {
			return "";
		} else {
			return str.substring(0, 1).toLowerCase() + str.substring(1);
		}
	}

	/**
	 * String to int
	 * @param str
	 * @return
	 */
	public static int getInt(String str) {
		if (StringUtil.isBlank(str))
			return 0;
		int ret = 0;
		try {
			ret = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			ret = 0;
		}
		return ret;
	}

	/**
	 * String to Long
	 * @param str
	 * @return
	 */
	public static long getLong(String str) {
		if (StringUtil.isBlank(str))
			return 0L;
		long ret = 0;
		try {
			ret = Long.parseLong(str);
		} catch (NumberFormatException e) {
			ret = 0;
		}
		return ret;
	}
	
	
	public static String isNull(Object o) {
		if (o == null) {
			return "";
		}
		String str="";
		if(o instanceof String){
			str=(String)o;
		}else{
			str=o.toString();
		}
		return str;
	}
	
	public static boolean isBlank(String str){
		return StringUtil.isNull(str).equals("");
	}

    public static String toString(String separate,int...objs){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<objs.length;i++){
            if(i>0)sb.append(separate);
            sb.append(objs[i]);
        }
        return sb.toString();
    }


	public static String toStringArray(Object... list){
		StringBuilder sb=new StringBuilder();
		int index=0;

		for (Object o : list) {
			if(index>0)sb.append(",");
			sb.append(o.toString());
			index++;
		}
		return sb.toString();
	}

	public static String toString(Collection list){
		return toString(list,",");
	}
    public static String toString(Collection list,String delim){
        StringBuilder sb=new StringBuilder();
		int index=0;

		for (Object o : list) {
			if(index>0)sb.append(delim);
			sb.append(o.toString());
			index++;
		}
        return sb.toString();
    }

    public static String getRelativePath(File file,File parentFile){
        return file.getAbsolutePath().replaceFirst("^\\Q"+parentFile.getAbsolutePath()+"\\E","").replace("\\","/");
    }
    public static String getFileUri(HttpServletRequest request,File file){
        String pre=request.getRealPath("/");
        String fullpath=file.getAbsolutePath();
        return fullpath.replace(pre.replaceFirst("[\\\\/]$",""),"").replace("\\","/");
    };
    
    public static String getRepairedFileUri(String fullpath){
        return fullpath.replaceFirst("[\\\\/]$","").replace("\\","/").replace("//","/");
    };

    public static boolean isNullString(String s) {
		if (s == null || "".equals(s)) {
			return true;
		}
		return false;
	}
    
    /***对象获取成数字类型的Value**/
    public static String getNumberValueOfObject(Object obj){
    	if(obj == null || "".equals(obj)){
    		return "0";
    	}
    	String objValue = String.valueOf(obj);
    	if(isEmpty(objValue) || objValue.length()== 0){
    		return "0";
    	}
    	return objValue;
    }

	public static boolean isNumber(String str) {
        if (isBlank(str)) {
            return false;
        } else {
            Pattern regex = Pattern.compile("(-)?\\d*(.\\d*)?");
            Matcher matcher = regex.matcher(str);
            return matcher.matches();
        }
    }
	
	public static boolean isNotBlank(Object o) {
        return !isNull(o).equals("");
    }
	/**
	 * 汉语中数字大写
	 */
	private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	/**
	 * 汉语中货币单位大写，这样的设计类似于占位符
	 */
	private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾",
			"佰", "仟", "兆", "拾", "佰", "仟" };
	/**
	 * 特殊字符：整
	 */
	private static final String CN_FULL = "整";
	/**
	 * 特殊字符：负
	 */
	private static final String CN_NEGATIVE = "负";
	/**
	 * 金额的精度，默认值为2
	 */
	private static final int MONEY_PRECISION = 2;
	/**
	 * 特殊字符：零元整
	 */
	private static final String CN_ZEOR_FULL = "零元";
	/**
	 * 把输入的金额转换为汉语中人民币的大写
	 *
	 * @param numberOfMoney
	 * 输入的金额
	 * @return 对应的汉语大写
	 */
	public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
		StringBuffer sb = new StringBuffer();
		// 返回-1：表示该数小于0 0：表示该数等于0 1：表示该数大于0
		int signum = numberOfMoney.signum();
		// 零元的情况
		if (signum == 0) {
			return CN_ZEOR_FULL;
		}
		// 这里会进行金额的四舍五入
		long number = numberOfMoney.movePointRight(MONEY_PRECISION).setScale(0, 4).abs().longValue();
		// 得到小数点后两位值
		long scale = number % 100;
		int numUnit = 0;
		int numIndex = 0;
		boolean getZero = false;
		// 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
		if (!(scale > 0)) {
			numIndex = 2;
			number = number / 100;
			getZero = true;
		}
		if ((scale > 0) && (!(scale % 10 > 0))) {
			numIndex = 1;
			number = number / 10;
			getZero = true;
		}
		int zeroSize = 0;
		while (true) {
			if (number <= 0) {
				break;
			}
		// 每次获取到最后一个数
			numUnit = (int) (number % 10);
			if (numUnit > 0) {
				if ((numIndex == 9) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
				}
				if ((numIndex == 13) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
				}
				sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				getZero = false;
				zeroSize = 0;
			} else {
				++zeroSize;
		//"分", "角", "元","万", "亿","兆"位不会出现零
				if (numIndex != 0 && numIndex != 1 && numIndex != 2
						&& numIndex != 6 && numIndex != 10 && numIndex != 14) {
					if (!(getZero)) {
						sb.insert(0, CN_UPPER_NUMBER[numUnit]);
					}
				}

				if (numIndex == 2) {
					if (number > 0) {
						sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
					}
				} else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				}
				getZero = true;
			}
		// 让number每次都去掉最后一个数
			number = number / 10;
			++numIndex;
		}
		// 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
		if (signum == -1) {
			sb.insert(0, CN_NEGATIVE);

		}// 除了0.00其他数据都要带特殊字符：整

		sb.append(CN_FULL);
		return sb.toString();
	}
}
