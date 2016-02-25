/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.binatel.bill.persistance;

import org.binatel.bill.common.TlfNumbers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author marina
 */
public class TlfNumbersDAOTest {
    
    private static final Logger log = LoggerFactory.getLogger(TlfNumbersDAOTest.class);
    
    public TlfNumbersDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreate() {
        TlfNumbersDAO tlfDao = new TlfNumbersDAO();
        TlfNumbers tlfNum = new TlfNumbers();
        tlfNum.setE164Number("74991286779");
        tlfNum.setCode("499");
        tlfNum.setTelNum1("128");
        tlfNum.setTelNum2("67");
        tlfNum.setTelNum3("79");
        tlfNum.setPriceNumber(1000.0);
        tlfNum.setMonthPriceNumber(300.00);
        
        tlfDao.init();
        tlfDao.save(tlfNum);
        tlfDao.commitAndCloseTransaction();
        
//        log.info("tlfNumID: {}", tlfNum.getId());
    }
    
}
