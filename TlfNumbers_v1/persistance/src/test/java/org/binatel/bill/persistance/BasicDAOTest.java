
package org.binatel.bill.persistance;

import java.util.List;
import org.binatel.bill.common.TlfNumbers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicDAOTest {
   
    private static final Logger log = LoggerFactory.getLogger(BasicDAOTest.class);

//    @BeforeClass
//    public static void init() {
//        BasicDAO.init();
//    }
//    
//    @Test
//    public void testLazy() {
//      
//        Session session = BasicDAO.sessionFactory.getCurrentSession();
//        session.beginTransaction();
//
//       //TlfNumbers tlfNum = (TlfNumbers)session.get(TlfNumbers.class, 1);
//        List<TlfNumbers> l = session.createQuery("SELECT a FROM TlfNumbers AS a").list();
//        Query q = session.createQuery("from TlfNumbers where id = :id");
//        q.setParameter("id", 1);
//        TlfNumbers tlfNum = (TlfNumbers)q.uniqueResult();
//        log.info("tlfNum: {}", tlfNum.getE164Number());
//        session.getTransaction().commit();
//    }
//    
//    //@Test
//    public void testAdd() {
//        BasicDAO dao = new BasicDAO();
//        dao.init();
//        TlfNumbers tn = new TlfNumbers();
//        tn.setE164Number("74952808080");
//        tn.setCode("495");
//        tn.setTelNum1("280");
//        tn.setTelNum2("80");
//        tn.setTelNum3("81");
//        tn.setPriceNumber(500000.0);
//        tn.setMonthPriceNumber(1000.0);
//        //dao.addEntity(tn);
//        log.info("numID: {}", dao.addEntity(tn));
//    }
    
    
}
