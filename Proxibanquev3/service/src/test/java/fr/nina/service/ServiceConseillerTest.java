/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nina.service;

import fr.nina.domaine.Client;
import java.util.List;
import junit.framework.TestCase;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author adminl
 */
public class ServiceConseillerTest extends TestCase {
    
    public ServiceConseillerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testListerClientsConseiller() {
        System.out.println("listerClientsConseiller");
        Long idcons = 1L;
        String unexpResult = "pas de clients";
        String result = ServiceConseiller.listerClientsConseiller(idcons);
        assertThat(result, is(not(unexpResult)));
    }
    
}
