package cn.alittler.utils.date;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import com.google.common.base.Strings;

import lombok.extern.java.Log;

/**
 * DateUtils
 *
 * @author LiuDeCai
 * @date 2018/03/29
 */
@Log
public class DateUtils {
	public static final long SECOND = 1000;

	public static final long MINUTE = SECOND * 60;

	public static final long HOUR = MINUTE * 60;

	public static final long DAY = HOUR * 24;

	public static final long WEEK = DAY * 7;

	public static final long YEAR = DAY * 365;

	public static final String FOMTER_TIMES = "yyyy-MM-dd HH:mm:ss";
	public static final String FOMTER_DATE = "yyyy-MM-dd";
	public static final String FOMTER_MINUTE = "yyyy-MM-dd HH:mm";

	public static final String SEPARATOR_HH_mm_ss = ":";
	public static final String SEPARATOR_YYYY_MM_dd = "-";
	public static final String mm_ss_BEGIN = "00";
	public static final String mm_ss_END = "59";

	public static final Date DEFAULT_TIME = parse("2000-01-01");
	// private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

	private static final Map<Integer, String> WEEK_DAY = new HashMap<Integer, String>();

	static {
		WEEK_DAY.put(7, "星期六");
		WEEK_DAY.put(1, "星期天");
		WEEK_DAY.put(2, "星期一");
		WEEK_DAY.put(3, "星期二");
		WEEK_DAY.put(4, "星期三");
		WEEK_DAY.put(5, "星期四");
		WEEK_DAY.put(6, "星期五");
	}

	/**
	 * 解析日期
	 *
	 * @param date
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static Date parse(String date, String pattern) {
		Date resultDate = null;
		try {
			resultDate = new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;
	}

	/**
     * 解析日期 yyyy-MM-dd
     *
     * @param date 日期字符串
     * @return
     */
    public static Timestamp parseSimple(String date) {
        if (date == null) {
            return null;
        }
        Date result = null;
        try {
            DateFormat yyyyMMdd = new SimpleDateFormat(FOMTER_DATE);
            result = yyyyMMdd.parse(date);
        } catch (ParseException e) {
            log.log(Level.WARNING, e.getMessage());
        }
        return result != null ? new Timestamp(result.getTime()) : null;
    }

	public static Date getLong2Date(Long longTime) {
		if (null == longTime) {
			return null;
		}
		Date date = new Date(longTime);
		return date;
	}

	/**
	 * 解析日期字符串
	 *
	 * @param date
	 * @return
	 */
	public static Timestamp parseFull(String date) {
		Date result = null;
		try {
			DateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			result = yyyyMMddHHmmss.parse(date);
		} catch (ParseException e) {
			log.log(Level.WARNING, e.getMessage());
		}
		return result != null ? new Timestamp(result.getTime()) : null;
	}

	/**
	 * 解析日期 yyyy-MM-dd
	 *
	 * @param date
	 *            日期字符串
	 * @return
	 */
	public static Timestamp parse(String date) {
		if (Strings.isNullOrEmpty(date))
			return null;
		try {
			if (date.length() == 10) {
				return parseSimple(date);
			} else if (date.length() == 8) {
				DateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
				Date d = yyyyMMdd.parse(date);
				return new Timestamp(d.getTime());
			} else if (date.length() == 19) {
				return parseFull(date);
			} else if (date.length() == 21 && date.endsWith(".0")) {
				return parseFull(date.substring(0, 19));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化日期字符串
	 *
	 * @param date
	 *            日期
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static String format(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @return yyyy年MM月dd日
	 */
	public static String formatCHS(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		return format.format(date);
	}

	/**
	 * 格式化日期字符串 年月日
	 *
	 * @param date
	 *            日期
	 * @return
	 */
	public static String format(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat YYYY_MM_DD = new SimpleDateFormat(FOMTER_DATE);
		return YYYY_MM_DD.format(date);
	}

	/**
	 * 格式化日期到秒
	 *
	 * @param date
	 * @return
	 */
	public static String formatSecond(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat sdf = new SimpleDateFormat(FOMTER_TIMES);
		return sdf.format(date);
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @return
	 */
	public static String formatFull(Date date) {
		DateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return YYYY_MM_DD_HH_MM_SS.format(date);
	}

	/**
	 * 取得当前日期
	 *
	 * @return
	 */
	public static Timestamp getNow() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 取得当前日期
	 *
	 * @return
	 */
	public static Integer getNowYear() {
		return getYear(getNow());
	}

	/**
	 * 取得年度
	 *
	 * @param value
	 * @return
	 */
	public static Integer getYear(Object value) {
		Calendar c = Calendar.getInstance();
		Date date = getDate(value);
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 取得月份
	 *
	 * @param value
	 * @return
	 */
	public static Integer getMonth(Object value) {
		Calendar c = Calendar.getInstance();
		Date date = getDate(value);
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 取得日
	 *
	 * @param value
	 * @return
	 */
	public static Integer getDay(Object value) {
		Calendar c = Calendar.getInstance();
		Date date = getDate(value);
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得日期对象
	 *
	 * @param value
	 * @return
	 */
	private static Date getDate(Object value) {
		Date date = null;
		if (value instanceof Date) {
			date = (Date) value;
		} else {
			date = parse((String) value);
		}
		if (date == null) {
			throw new RuntimeException("日期格式解析错误!date=" + value);
		}
		return date;
	}

	/**
	 * @param offsetYear
	 * @return 当前时间 + offsetYear
	 */
	public static Timestamp getNowExpiredYear(int offsetYear) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.YEAR, offsetYear);
		return new Timestamp(now.getTime().getTime());
	}

	/**
	 * @param offset
	 * @return 当前时间 + offsetMonth
	 */
	public static Timestamp getNowExpiredMonth(int offset) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, offset);
		return new Timestamp(now.getTime().getTime());
	}

	/**
	 * @param offset
	 * @return 指定时间 + offsetDay
	 */
	public static Timestamp getExpiredDay(Date givenDate, int offset) {
		Calendar date = Calendar.getInstance();
		date.setTime(givenDate);
		date.add(Calendar.DATE, offset);
		return new Timestamp(date.getTime().getTime());
	}

	/**
	 * 实现ORACLE中ADD_MONTHS函数功能
	 *
	 * @param offset
	 * @return 指定时间 + offsetMonth
	 */
	public static Timestamp getExpiredMonth(Date givenDate, int offset) {
		Calendar date = Calendar.getInstance();
		date.setTime(givenDate);
		date.add(Calendar.MONTH, offset);
		return new Timestamp(date.getTime().getTime());
	}

	/**
	 * @param second
	 * @return 指定时间 + offsetSecond
	 */
	public static Timestamp getExpiredSecond(Date givenDate, int second) {
		Calendar date = Calendar.getInstance();
		date.setTime(givenDate);
		date.add(Calendar.SECOND, second);
		return new Timestamp(date.getTime().getTime());
	}

	/**
	 * 给定日期是否在范围内
	 *
	 * @param date
	 *            给定日期
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @return true 在指定范围内
	 */
	public static Boolean between(Date date, Date begin, Date end) {
		if (date == null || begin == null || end == null) {
			return true;
		}
		return date.after(begin) && date.before(end);
	}

	/**
	 * 当前日期是否在范围内
	 *
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @return true 在指定范围内
	 */
	public static Boolean between(Date begin, Date end) {
		Date now = getNow();
		return between(now, begin, end);
	}

	/**
	 * 获取日期相差天数
	 *
	 * @param
	 * @return 日期类型时间
	 * @throws ParseException
	 */
	public static Long getDiffDay(String beginDate, String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Long checkday = 0l;
		// 开始结束相差天数
		try {
			checkday = (formatter.parse(endDate).getTime() - formatter.parse(beginDate).getTime())
					/ (1000 * 24 * 60 * 60);
		} catch (ParseException e) {
			e.printStackTrace();
			checkday = null;
		}
		return checkday;
	}

	public static int getDiffMonth(Date start, Date end) {
		if (start.after(end)) {
			Date t = start;
			start = end;
			end = t;
		}
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(start);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		Calendar temp = Calendar.getInstance();
		temp.setTime(end);
		temp.add(Calendar.DATE, 1);

		int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

		if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month + 1;
		} else if ((startCalendar.get(Calendar.DATE) != 1) && (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month;
		} else if ((startCalendar.get(Calendar.DATE) == 1) && (temp.get(Calendar.DATE) != 1)) {
			return year * 12 + month;
		} else {
			return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
		}
	}

	/**
	 * 两日期相差年数
	 *
	 * @param beginDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return 相差年数
	 */
	public static Long getDiffYear(String beginDate, String endDate) {
		String[] begin = beginDate.split("-");
		String[] end = endDate.split("-");

		int years = Integer.parseInt(end[0]) - Integer.parseInt(begin[0]);
		int months = Integer.parseInt(end[1]) - Integer.parseInt(begin[1]);
		int days = Integer.parseInt(end[2]) - Integer.parseInt(begin[2]);

		if (months > 0) {
			return (long) (years);
		} else if (months < 0) {
			return (long) years - 1;
		} else if (months == 0 && days == 0) {
			return (long) years;
		} else if (months == 0 && days < 0) {
			return (long) (years - 1);
		} else {
			return (long) years;
		}
	}

	/**
	 * 获取日期相差天数
	 *
	 * @param
	 * @return 日期类型时间
	 */
	public static Long getDiffDay(Date beginDate, Date endDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strBeginDate = format.format(beginDate);
		String strEndDate = format.format(endDate);

		return getDiffDay(strBeginDate, strEndDate);
	}

	/**
	 * 获取日期相差年数
	 *
	 * @param
	 * @return 日期类型时间
	 */
	public static Long getDiffYear(Date beginDate, Date endDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String strBeginDate = format.format(beginDate);
		String strEndDate = format.format(endDate);

		return getDiffYear(strBeginDate, strEndDate);
	}

	/**
	 * 取得今天零点日期
	 *
	 * @return
	 */
	public static Calendar getTodayZero() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c;
	}

	/**
	 * <p>
	 * Parses a string representing a date by trying a variety of different parsers.
	 * </p>
	 * <p>
	 * <p>
	 * The parse will try each parse pattern in turn. A parse is only deemed
	 * sucessful if it parses the whole of the input string. If no parse patterns
	 * match, a ParseException is thrown.
	 * </p>
	 *
	 * @param str
	 *            the date to parse, not null
	 * @param parsePatterns
	 *            the date format patterns to use, see SimpleDateFormat, not null
	 * @return the parsed date
	 * @throws IllegalArgumentException
	 *             if the date string or pattern array is null
	 * @throws ParseException
	 *             if none of the date patterns were suitable
	 */
	public static Date parseDate(String str, String[] parsePatterns) throws ParseException {
		if (str == null || parsePatterns == null) {
			throw new IllegalArgumentException("Date and Patterns must not be null");
		}
		SimpleDateFormat parser = null;
		ParsePosition pos = new ParsePosition(0);
		for (int i = 0; i < parsePatterns.length; i++) {
			if (i == 0) {
				parser = new SimpleDateFormat(parsePatterns[0]);
			} else {
				parser.applyPattern(parsePatterns[i]);
			}
			pos.setIndex(0);
			Date date = parser.parse(str, pos);
			if (date != null && pos.getIndex() == str.length()) {
				return date;
			}
		}
		throw new ParseException("Unable to parse the date: " + str, -1);
	}

	/**
	 * 获取本周星期一开始时间
	 *
	 * @return
	 */
	public static Date getNowWeekBegin() {
		int plus;
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			plus = -6;
		} else {
			plus = 2 - dayOfWeek;
		}
		cal.add(Calendar.DATE, plus);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date result = null;
		try {
			result = sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取上周星期一开始时间
	 *
	 * @return
	 */
	public static Date getLastWeekBegin() {
		int plus;
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			plus = -6;
		} else {
			plus = 2 - dayOfWeek;
		}
		// 上周星期一
		plus = plus - 7;
		cal.add(Calendar.DATE, plus);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date result = null;
		try {
			result = sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int getAge(Date dt) {
		if (dt != null) {
			Long age = getDiffYear(dt, getNow());
			return age.intValue();
		} else {
			return -1;
		}
	}

	/**
	 * 获取年龄的字符串，如：35岁，6岁3个月
	 *
	 * @param dt
	 * @return
	 */
	public static String getAgeDisplay(Date dt) {
		if (dt == null) {
			return "";
		}
		int month = getDiffMonth(dt, getNow());
		if (month > 60 || month % 12 == 0) // 大于5岁或整数
		{
			return getAge(dt) + "岁";
		} else {
			String display = String.format("%d岁%d个月", month / 12, month % 12);
			return display;
		}

	}

	public static LocalDate convert2LocalDate(Date date) {
		return LocalDate.parse(format(date));
	}

	/**
	 * LocalDate转换成Date
	 *
	 * @param localDate
	 * @return
	 */
	public static Date localDate2Date(LocalDate localDate) {
		return DateUtils.parseSimple(localDate.format(DateTimeFormatter.ISO_DATE));
	}

	public static Date localTime2Date(LocalTime localTime) {
		return DateUtils.parseSimple(localTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}

	/**
	 * 获取时间的友好显示
	 *
	 * @param date
	 * @return
	 */
	public static String getFriendlyTimeDisplay(Date date) {

		if (date != null) {
			Date now = DateUtils.getNow();
			long diff = DateUtils.getDiffDay(date, now);
			if (diff == 0) {
				return DateUtils.format(date, "今天 HH:mm");
			} else if (diff == 1) {
				return DateUtils.format(date, "昨天 HH:mm");
			} else {
				if (DateUtils.getNowYear().equals(DateUtils.getYear(date)))
					return DateUtils.format(date, "MM月dd日 HH:mm");
				else
					return DateUtils.format(date, "yyyy年MM月dd日");
			}
		}
		return "";
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @return
	 */
	public static String formatFullAndMilliscond(Date date) {
		DateFormat YYYY_MM_DD_HH_MM_SS_SSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
		return YYYY_MM_DD_HH_MM_SS_SSS.format(date);
	}

	/**
	 * 当前日期所在的周属于上一年或是下一年，配合getWeekOfYear使用
	 *
	 * @param calendar
	 * @return
	 */
	public static int getYearByWeek(Calendar calendar) {
		if (calendar == null)
			return -1;

		if (calendar.get(Calendar.MONTH) == Calendar.JANUARY) {
			calendar.setFirstDayOfWeek(GregorianCalendar.MONDAY);
			calendar.setMinimalDaysInFirstWeek(7);

			if (calendar.get(Calendar.WEEK_OF_YEAR) > 50) {
				return calendar.get(Calendar.YEAR) - 1;
			}
		}
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * XX年的第几周，配合getYearByWeek使用
	 *
	 * @param calendar
	 * @return
	 */
	public static int getWeekOfYear(Calendar calendar) {
		if (calendar == null)
			return -1;
		calendar.setFirstDayOfWeek(GregorianCalendar.MONDAY);
		calendar.setMinimalDaysInFirstWeek(7);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获取指定日期的00:00:00
	 *
	 * @param date
	 * @return
	 */
	public static Date getDayOfBeginTime(Date date) {
		if (date == null)
			return null;
		return parse(format(date));
	}

	/**
	 * 获取日期相差天数
	 *
	 * @param
	 * @return 日期类型时间
	 */
	public static Double getDiffDay4Double(Date beginDate, Date endDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strBeginDate = format.format(beginDate);
		String strEndDate = format.format(endDate);

		return getDiffDay4Double(strBeginDate, strEndDate);
	}

	/**
	 * 获取日期相差天数
	 *
	 * @param
	 * @return 日期类型时间
	 * @throws ParseException
	 */
	public static Double getDiffDay4Double(String beginDate, String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Double checkday = 0d;
		// 开始结束相差天数
		try {
			checkday = ((formatter.parse(endDate).getTime() - formatter.parse(beginDate).getTime()) * 1.0)
					/ (1000 * 24 * 60 * 60);
			checkday = new BigDecimal(checkday).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
			checkday = null;
		}

		return checkday;
	}

	public static Date convertDateTime2Date(Date date) {
		LocalDate localDate = convert2LocalDate(date);
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date result = null;
		try {
			result = sdf.parse(year + "-" + month + "-" + day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Date addDay(Date date, int days) {
		LocalDate localDate = convert2LocalDate(date);
		return localDate2Date(localDate.plusDays(days));
	}

	public static Date addSeconds(Date date, int seconds) {
		long ticks = date.getTime();
		return new Date(ticks + seconds * 1000);
	}
}
