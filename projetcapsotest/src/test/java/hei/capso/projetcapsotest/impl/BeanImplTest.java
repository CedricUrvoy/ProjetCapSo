package hei.capso.projetcapsotest.impl;

import junit.framework.TestCase;
import hei.capso.projetcapsotest.Bean;

public class BeanImplTest extends TestCase {

    public void testBeanIsABean() {
	Bean aBean = new BeanImpl();
        assertTrue(aBean.isABean());
    }

}