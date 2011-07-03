package tao.xiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class ReportAccess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print(new ReportAccess().whoCanSee(
				new String[] { "joe", "nick", "ted" },
				new String[] { "clients products", "products orders",
						"clients orders" }, new String[] { "clients",
						"products" }));
		System.out.println();

		print(new ReportAccess().whoCanSee(new String[] { "kathy", "john",
				"dan", "steve", "cheryl", "tony" }, new String[] { "users data",
				"data orders", "users permissions", "system users controls",
				"default", "admin users" }, new String[] { "users" }));

	}

	private static void print(String[] userNames) {
		for (String userName : userNames) {
			System.out.print(userName + ",");
		}
	}

	public String[] whoCanSee(String[] userNames, String[] allowedData,
			String[] reportData) {
		String joined = joinReportData(reportData);
		List<String> whoCanSee = new ArrayList<String>();

		for (int i = 0; i < userNames.length; i++) {
			if (allowedData[i].contains(joined)) {
				whoCanSee.add(userNames[i]);
			}
		}

		Collections.sort(whoCanSee);
		String[] whoCanSeeArr = new String[whoCanSee.size()];
		return (String[]) whoCanSee.toArray(whoCanSeeArr);
	}

	private String joinReportData(String[] reportData) {
		return StringUtils.join(reportData, " ");
	}
}
