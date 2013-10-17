/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.spring.javaconfig.autowire;

import static junit.framework.Assert.assertEquals;
import org.apache.camel.CamelContext;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.test.JavaConfigContextLoader;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = "org.apache.camel.spring.javaconfig.autowire.NoRoutesConfig", loader = JavaConfigContextLoader.class)
public class AutodetectNoRoutesConfigTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    CamelContext camelContext;

    @Test
    public void shouldAutodetectRouteBuilders() throws InterruptedException {
        // When
        int routesNumber = camelContext.getRoutes().size();

        //Then
        assertEquals(0, routesNumber);
    }

}

@Configuration
class NoRoutesConfig extends CamelConfiguration {
}
