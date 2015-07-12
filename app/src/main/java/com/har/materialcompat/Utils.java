package com.har.materialcompat;

import java.lang.reflect.Field;

/**
 * Created by hareesh on 6/15/15.
 */
public class Utils {
  public static Object getPrivateMember(Object from, String field)
      throws NoSuchFieldException, IllegalAccessException {
    Field f = from.getClass().getDeclaredField(field);
    f.setAccessible(true);
    return f.get(from);
  }
}
