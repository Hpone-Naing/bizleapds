package com.bizleap.ds.loader.test;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.bizleap.common.ucsy.exception.ServiceUnavailableException;

public class DataManagerImplTest extends ServiceTest {
@Ignore
	  @Test
      public void test() {
    	  try {
    		  dataManager.load();
    	  }
    	  catch(IOException e) {
    		  e.printStackTrace();
    	  }
    	  catch(ServiceUnavailableException e) {
    		e.printStackTrace();
    	  }
      }
}

