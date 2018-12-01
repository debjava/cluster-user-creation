/** Copyright 2017 Dell Inc. or its subsidiaries. All Rights Reserved. */
package com.emc.vxrail.kohl.util;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * The Class CommonUtil.
 *
 * @author Debadatta Mishra
 */
public class CommonUtil {

	/** The Constant DATE_TIME_PATTERN. */
	private static final String DATE_TIME_PATTERN = "dd-MM-yy-HH-mm-ss";

	/** The default logger to log */
	protected static Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	/** The cp. */
	private static ColoredPrinter cp = null;

	static {
		cp = new ColoredPrinter.Builder(1, false).foreground(Ansi.FColor.RED).build();
	}

	private CommonUtil() {
	}

	/**
	 * Gets the date as string.
	 *
	 * @return the date as string
	 */
	private static String getDateAsString() {
		return new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date());
	}

	/**
	 * Gets the file name.
	 *
	 * @param fileName the file name
	 * @return the file name
	 */
	public static String getFileName(String fileName) {
		return new StringBuilder(fileName).append("-").append(getDateAsString()).append(".log").toString();
	}

	/**
	 * Wait for successfull completion.
	 *
	 * @param message       the message
	 * @param timeInMinutes the time in minutes
	 */
	public static void waitForSuccessfullCompletion(String message, long timeInMinutes) {
		CommonUtil.printSuccessfullMessage(message);
		sleepForSometime(timeInMinutes);
	}

	/**
	 * Wait for some time for error.
	 *
	 * @param message       the message
	 * @param timeInMinutes the time in minutes
	 */
	public static void waitForSomeTimeForError(String message, long timeInMinutes) {
		CommonUtil.printError(message);
		sleepForSometime(timeInMinutes);
	}

	/**
	 * Sleep for sometime.
	 *
	 * @param timeInMinutes the time in minutes
	 */
	private static void sleepForSometime(long timeInMinutes) {
		try {
			TimeUnit.MINUTES.sleep(timeInMinutes);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Prints the error.
	 *
	 * @param message the message
	 */
	// ~~~~~~~~~ Beautifier below ~~~~~~~~~~~
	public static void printError1(String message) {
		cp.setBackgroundColor(Ansi.BColor.MAGENTA);
		cp.setForegroundColor(Ansi.FColor.BLACK);
		cp.println(message);
		cp.clear();
	}

	public static void printError(String message) {
		cp.setForegroundColor(Ansi.FColor.RED);
		cp.println(message);
		cp.clear();
	}

	/**
	 * Gets the banner text.
	 *
	 * @return the banner text
	 */
	private static String getBannerText() {
		String bannerText = null;
		ClassLoader clsLoader = CommonUtil.class.getClassLoader();
		InputStream inStream = clsLoader.getResourceAsStream(CommonConstants.BANNER_FILE);
		byte[] bannerBytes = new byte[1024];
		try {
			int readVal = inStream.read(bannerBytes);
			logger.debug("Read contents : {}", readVal);
			bannerText = new String(bannerBytes);
		} catch (IOException e) {
			logger.error("IOException ...\n {}", e);
		} finally {
			try {
				inStream.close();
			} catch (IOException e) {
				// Ignore exception
			}
		}
		return bannerText;
	}

	/** Prints the banner. */
	public static void printBanner() {
		cp.setForegroundColor(Ansi.FColor.GREEN);
		cp.setAttribute(Ansi.Attribute.BOLD);
		cp.println(getBannerText());
		cp.clear();
	}

	/** Display info. */
	public static void displayInfo() {
		cp.setForegroundColor(Ansi.FColor.CYAN);
		cp.println(CommonConstants.HEADER_INFO1);
		cp.println(CommonConstants.HEADER_INFO2);
		cp.println("\n");
		cp.clear();
	}

	public static void displayInfo(String message) {
		cp.setForegroundColor(Ansi.FColor.CYAN);
		cp.println(message);
		cp.clear();
	}

	/**
	 * Prints the successfull message.
	 *
	 * @param message the message
	 */
	public static void printSuccessfullMessage(String message) {
		cp.setForegroundColor(Ansi.FColor.GREEN);
		cp.setAttribute(Ansi.Attribute.BOLD);
		cp.println(message);
		cp.clear();
	}
}
