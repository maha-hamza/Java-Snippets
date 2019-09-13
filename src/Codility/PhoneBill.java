package Codility;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PhoneBill {

	public static void main(String[] args) {
		String N = "00:01:07,100-234-090 00:05:00,100-234-090 00:01:07,400-234-090 00:05:01,701-080-080 00:05:00,400-234-090";
		// String N = "00:01:07,400-234-090 00:05:01,701-080-080
		// 00:05:00,400-234-090";
		System.out.println(solution(N));
	}

	private static List<LogHolder> parseLog(String N) {
		List<LogHolder> logH = new ArrayList<>();
		String[] tokens = N.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			String[] inter = tokens[i].split(",");
			logH.add(new LogHolder(inter[1], inter[0]));
		}
		return logH;
	}

	public static List<LogHolder> removeFreeCall(List<LogHolder> logs) {
		List<LogHolder> logH = new ArrayList<>();
		for (LogHolder log : logs) {
			double callDu = (LocalTime.parse(log.getCallDuration()).getHour() * 60
					+ LocalTime.parse(log.getCallDuration()).getMinute()
					+ (LocalTime.parse(log.getCallDuration()).getSecond() > 0 ? 1 : 0));

			int existed = Collections.binarySearch(logH, new LogHolder(log.getPhone(), callDu),
					new Comparator<LogHolder>() {

						@Override
						public int compare(LogHolder o1, LogHolder o2) {
							return o1.getPhone().compareTo(o2.getPhone());
						}
					});
			if (existed < 0) {
				double sum = Pattern.compile("").splitAsStream(log.getPhone().replaceAll("-", ""))
						.mapToInt(Integer::parseInt).sum();
				logH.add(new LogHolder(log.getPhone(), callDu, sum));
			} else if (existed >= 0) {
				logH.get(existed).setTotalDuration(logH.get(existed).getTotalDuration() + callDu);
			}
		}

		final Comparator<LogHolder> comp1 = (p1, p2) -> Double.compare(p1.getTotalDuration(), p2.getTotalDuration());
		double maxDuration = logH.stream().max(comp1).get().getTotalDuration();

		final Comparator<LogHolder> comp2 = (p1, p2) -> Double.compare(p1.getNumericalSum(), p2.getNumericalSum());
		double minNumSum = logH.stream().min(comp2).get().getNumericalSum();

		List<LogHolder> list = logH.stream().filter(call -> call.getTotalDuration() == maxDuration)
				.collect(Collectors.toList());

		LogHolder freeLog = null;
		if (list.size() > 1) {
			freeLog = list.stream().filter(call -> call.getNumericalSum() == minNumSum).collect(Collectors.toList())
					.get(0);
		} else {
			freeLog = list.get(0);
		}

		List<LogHolder> hand = new ArrayList<>();
		for (LogHolder l : logs) {
			if (!l.getPhone().equals(freeLog.getPhone()))
				hand.add(l);
		}

		return hand;
	}

	public static double solution(String N) {
		double totalCost = 0.0;
		List<LogHolder> logs = parseLog(N);
		List<LogHolder> calls = removeFreeCall(logs);

		for (LogHolder logHolder : calls) {
			System.out.println(
					logHolder.getPhone() + " " + logHolder.getCallDuration());
		}
		
		for (LogHolder logHolder : calls) {			
			String duration = logHolder.getCallDuration();
			if (LocalTime.parse(duration).getHour() == 0) {
				int minutes = LocalTime.parse(duration).getMinute();
				if (minutes < 5) {
					totalCost += (minutes * 60 + (LocalTime.parse(duration).getSecond())) * 3;

				} else {
					totalCost += (minutes + (LocalTime.parse(duration).getSecond() > 0 ? 1 : 0)) * 150;

				}
			} else {

				totalCost += ((LocalTime.parse(duration).getHour() * 60) + (LocalTime.parse(duration).getMinute())
						+ (LocalTime.parse(duration).getSecond() > 0 ? 1 : 0)) * 150;
			}
		}

		return totalCost;
	}
}

class LogHolder {
	private String phone;
	private double totalDuration;
	private double numericalSum;
	private String callDuration;

	public LogHolder(String phone, String callDuration) {
		super();
		this.phone = phone;
		this.callDuration = callDuration;
	}

	public LogHolder(String phone, double totalDuration) {
		super();
		this.phone = phone;
		this.totalDuration = totalDuration;

	}

	public LogHolder(String phone, double totalDuration, double numericalSum) {
		super();
		this.phone = phone;
		this.totalDuration = totalDuration;
		this.numericalSum = numericalSum;

	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setTotalDuration(double totalDuration) {
		this.totalDuration = totalDuration;
	}

	public double getTotalDuration() {
		return totalDuration;
	}

	public void setNumericalSum(double numericalSum) {
		this.numericalSum = numericalSum;
	}

	public double getNumericalSum() {
		return numericalSum;
	}

	public void setCallDuration(String callDuration) {
		this.callDuration = callDuration;
	}

	public String getCallDuration() {
		return callDuration;
	}

}
