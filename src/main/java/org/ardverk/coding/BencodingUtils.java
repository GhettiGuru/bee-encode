/*
 * Copyright 2009-2012 Roger Kapsi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ardverk.coding;

/**
 * Just a few constants and utility methods for Bencoding (Bee-Encoded) data.
 *
 * <p>Bencoding formats:</p>
 * <ul>
 *   <li>Dictionary: {@code d<key><value>e}</li>
 *   <li>List: {@code l<value>e}</li>
 *   <li>Integer: {@code i<number>e}</li>
 *   <li>Byte strings: {@code <length>:<string>}</li>
 * </ul>
 */
public class BencodingUtils {

  /** Constant for UTF-8 String encoding */
  public static final String UTF_8 = "UTF-8";

  /** Delimiter for byte strings of the form {@code <length>:<string>} */
  public static final int LENGTH_DELIMITER = ':';

  /** Dictionary start marker: {@code d<key><value>e} */
  public static final int DICTIONARY = 'd';

  /** List start marker: {@code l<value>e} */
  public static final int LIST = 'l';

  /** Number start marker: {@code i<number>e} */
  public static final int NUMBER = 'i';

  /** Marks the end of a {@link #DICTIONARY}, {@link #LIST}, or {@link #NUMBER} */
  public static final int EOF = 'e';

  /** Boolean true representation (Bencoding does not support booleans directly) */
  public static final Integer TRUE = Integer.valueOf(1);

  /** Boolean false representation (Bencoding does not support booleans directly) */
  public static final Integer FALSE = Integer.valueOf(0);

  /** Private constructor to prevent instantiation */
  private BencodingUtils() {}
}
