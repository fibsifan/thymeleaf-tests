/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.templateengine.templateboundaries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.templateengine.templateboundaries.dialect.TemplateBoundariesDialect;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;
import org.thymeleaf.tests.util.TestExecutorFactory;


@RunWith(Parameterized.class)
public class TemplateBoundariesTest {


    private final int throttleStep;


    public TemplateBoundariesTest(final Integer throttleStep) {
        super();
        this.throttleStep = throttleStep.intValue();
    }


    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {

        final int[] throttleSteps = new int[] { Integer.MAX_VALUE, 1000, 100, 11, 9, 5, 1};

        final List<Object[]> params = new ArrayList<Object[]>();
        for (int i = 0; i < throttleSteps.length; i++) {
            params.add(new Object[] { Integer.valueOf(i) });
        }
        return params;

    }




    @Test
    public void testAttrProcessor() throws Exception {

        final TestExecutor executor = TestExecutorFactory.createTestExecutor();
        executor.setDialects(Arrays.asList(new IDialect[]{new StandardDialect(), new TemplateBoundariesDialect()}));
        executor.setThrottleStep(this.throttleStep);
        executor.execute("classpath:templateengine/attrprocessors");
        
        Assert.assertTrue(executor.isAllOK());
        
    }
    
    @Test
    public void testConditionalComments() throws Exception {

        final TestExecutor executor = TestExecutorFactory.createTestExecutor();
        executor.setDialects(Arrays.asList(new IDialect[]{new StandardDialect(), new TemplateBoundariesDialect()}));
        executor.setThrottleStep(this.throttleStep);
        executor.execute("classpath:templateengine/conditionalcomments");
        
        Assert.assertTrue(executor.isAllOK());
        
    }


    @Test
    public void testGTVGHTML5() throws Exception {

        final TestExecutor executor = TestExecutorFactory.createTestExecutor();
        executor.setDialects(Arrays.asList(new IDialect[]{new StandardDialect(), new TemplateBoundariesDialect()}));
        executor.setThrottleStep(this.throttleStep);
        executor.execute("classpath:templateengine/gtvg_html5");

        Assert.assertTrue(executor.isAllOK());

    }


    @Test
    public void testGTVGXHTML() throws Exception {

        final TestExecutor executor = TestExecutorFactory.createTestExecutor();
        executor.setDialects(Arrays.asList(new IDialect[]{new StandardDialect(), new TemplateBoundariesDialect()}));
        executor.setThrottleStep(this.throttleStep);
        executor.execute("classpath:templateengine/gtvg_xhtml");

        Assert.assertTrue(executor.isAllOK());

    }

    
}
