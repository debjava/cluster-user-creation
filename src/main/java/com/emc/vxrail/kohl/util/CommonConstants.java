/** Copyright 2017 Dell Inc. or its subsidiaries. All Rights Reserved. */
package com.emc.vxrail.kohl.util;

import java.util.Arrays;
import java.util.List;

/**
 * The Class CommonConstants.
 *
 * @author Debadatta Mishra
 */
public class CommonConstants {

  private CommonConstants() {}

  /** The Constant BANNER_FILE. */
  public static final String BANNER_FILE = "banner.txt";

  /** The Constant HEADER_INFO1. */
  public static final String HEADER_INFO1 =
      "* Make sure that cluster-config.txt file is located in the current directory.";

  /** The Constant HEADER_INFO2. */
  public static final String HEADER_INFO2 =
      "* Press CTRL+C to terminate, if the system hangs and produces no output .";

  /** The Constant SUCCESSFUL_MESSAGE. */
  public static final String SUCCESSFUL_MESSAGE =
      "Success. Press CTRL+C to terminate, waiting 1 min for auto termination.";

  /** The Constant FAILED_MESSAGE. */
  public static final String FAILED_MESSAGE =
      "Press CTRL+C to terminate, waiting for 2 mins for auto termination ...";

  /** The Constant GENERIC_FAILED_MESSAGE. */
  public static final String GENERIC_FAILED_MESSAGE =
      "Unexpected unknown exception, Press CTRL+C to terminate, waiting for 2 mins for auto termination ...";

  /** The Constant BEFORE_EXECUTION_MSG. */
  public static final String BEFORE_EXECUTION_MSG =
      "Command execution in progress, please wait, it may take some time .";

  /** Generic error message for switch grab utility */
  public static final String GEN_ERR_MSG =
      "UnExpected Generic Switch Grab Error, Check with the support team for proper setup.";
}
