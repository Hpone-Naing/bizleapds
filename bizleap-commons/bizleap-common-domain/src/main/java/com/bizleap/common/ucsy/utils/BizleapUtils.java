package com.bizleap.common.ucsy.utils;


public class BizleapUtils {
	public static String makePath(String path, String fileName) {
		  if (fileName == null)
			  return path;
		  if (path == null)
			  return fileName;
		  if (path.endsWith("\\"))
			  return path + fileName;
		  return path + "\\" + fileName;
	}
}
