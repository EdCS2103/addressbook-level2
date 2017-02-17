package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import seedu.addressbook.Main;
import seedu.addressbook.commands.CommandResult;

public class Formatter {
	Formatter() {
	}

	/**
	 * A decorative prefix added to the beginning of lines printed by
	 * AddressBook
	 */
	private static final String LINE_PREFIX = "|| ";

	/** A platform independent line separator. */
	private static final String LINE_SEPARATOR = System.lineSeparator();

	private static final String DIVIDER = "===================================================";

	/** Format of indexed list item */
	private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

	/** Offset required to convert between 1-indexing and 0-indexing. */
	public static final int DISPLAYED_INDEX_OFFSET = 1;

	/**
	 * Format of a comment input line. Comment lines are silently consumed when
	 * reading user input.
	 */
	private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

	public static String getUserCommandFormat() {
		return LINE_PREFIX + "Enter command: ";
	}

	public static boolean isCommentLine(String rawInputLine) {
		return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
	}

	public static String WelComeMessageFormat(String storageFileInfo) {
		return showToUser(DIVIDER, DIVIDER, MESSAGE_WELCOME, Main.VERSION, MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
				storageFileInfo, DIVIDER);
	}

	public static String showToUser(String... message) {
		final StringBuilder formattedString = new StringBuilder();
		for (String m : message) {
			formattedString.append(LINE_PREFIX + m.replace("\n", LINE_SEPARATOR + LINE_PREFIX)).append(LINE_SEPARATOR);
		}
		return formattedString.toString();
	}

	public static void showGoodbyeMessageFormat() {
		showToUser(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
	}

	public static void showInitFailedMessageFormat() {
		showToUser(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
	}

	public static void showResultToUser(CommandResult result) {
		showToUser(result.feedbackToUser, DIVIDER);
	}

	public static int displayIndexFormat() {
		return 0 + DISPLAYED_INDEX_OFFSET;
	}

	public static String getIndexedListItemFormat(int visibleIndex, String listItem) {
		return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
	}

}
