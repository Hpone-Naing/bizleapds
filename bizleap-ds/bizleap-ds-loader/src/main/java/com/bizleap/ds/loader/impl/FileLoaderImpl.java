package com.bizleap.ds.loader.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bizleap.common.ucsy.utils.BizleapUtils;
import com.bizleap.ds.loader.FileLoader;

@Service("fileLoader")
public class FileLoaderImpl implements FileLoader {
	private int lineNumber;
	private String line;
	private String fileName;
	private Map<String, String> errorMap;
	private BufferedReader bufferedReader;
	
//	@Autowired
//	ConfigurationService configurationService;

	//@Value("${application.data.directory}")
	private String dataDir = "C:\\bizleap\\data";
	private static Logger logger = Logger.getLogger(FileLoaderImpl.class);


	private BufferedReader getBufferedReader(String fileName) throws IOException {
		return getBufferedReader(fileName, null);
	}

	private BufferedReader getBufferedReader(String fileName, String encodingType) throws IOException {
		String fullyQualifiedFileName=BizleapUtils.makePath(dataDir, fileName);
		logger.debug("About to read file "+fullyQualifiedFileName);
		if (org.apache.commons.lang3.StringUtils.isEmpty(encodingType)) {
			return new BufferedReader(new FileReader(fullyQualifiedFileName));
		}
		return new BufferedReader(new InputStreamReader(new FileInputStream(fullyQualifiedFileName), encodingType));
	}

	@Override
	public void start(String fileName, String encodingType) throws IOException {
		this.fileName = fileName;
		bufferedReader = null;
		
		try {
			logger.debug("File name...." + fileName);
			bufferedReader = getBufferedReader(fileName, encodingType);
		} catch (Exception e) {
			logger.error("File not found: " + fileName);		
		}
		
		lineNumber = 0;
		if (errorMap == null)
			errorMap = new HashMap<String, String>();
		errorMap.clear();
	}

	@Override
	public void start(String fileName) throws IOException {
		start(fileName, "");
	}

	@Override
	public void addError(int lineNumber, String line) {
		errorMap.put(String.valueOf(lineNumber), line);
	}

	@Override
	public void error(Exception ex) {
		errorMap.put(String.valueOf(lineNumber), line);
		logger.info( "Current input line: " + lineNumber + ": " + line);
		logger.error("Error encountered while passing - " + fileName, ex);
	}

	@Override
	public boolean hasNext() throws IOException {
		if (bufferedReader == null)
			return false;

		line = bufferedReader.readLine();
		lineNumber++;
		return !StringUtils.isEmpty(line);
	}

	@Override
	public int getLineNumber() {
		return lineNumber;
	}

	@Override
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	@Override
	public String getLine() {
		//logger.debug( "line is: " + line );
		return line;
	}

	@Override
	public void setLine(String line) {
		this.line = line;
	}

	@Override
	public void printErrorMap() {
		if (errorMap.isEmpty())
			return;

		logger.info("Errors encountered while loading!!"); 
		logger.info("Line with error(s) is:");

		Iterator<String> iterator = errorMap.keySet().iterator();

		while (iterator.hasNext()) {
			String key = iterator.next();
			logger.info( key + ":" + errorMap.get(key) ); 
		}
	}

	@Override
	public void finish() {
		String status = errorMap.isEmpty() ? "SUCCESS" : "FAILED";
		printErrorMap();
		if (!errorMap.isEmpty()) {
			logger.error("Quiting due to errors!!");
			System.exit(0);
		}

		if (bufferedReader != null)
			try {
				bufferedReader.close();
			} catch (IOException e) {
				logger.error("Error while closing file", e);
			}
	}
}