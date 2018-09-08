package com.optum.hedis.service;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

	
	public abstract class BaseServiceTest {
		
		@Before
		public void initMocks() {
			MockitoAnnotations.initMocks(this);
		}
	}


