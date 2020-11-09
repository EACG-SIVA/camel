/*
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
package org.apache.camel.component.github.consumer;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.github.GitHubComponent;
import org.apache.camel.component.github.GitHubComponentTestBase;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;

public class SchedulerConfigurationConsumerTest extends GitHubComponentTestBase {

    @EndpointInject("mock:commits")
    protected MockEndpoint mockCommitsEndpoint;

    @Test
    public void testSimpleSchedulerConsumerConfiguration() throws InterruptedException {
        mockCommitsEndpoint.expectedMessageCount(5);
        mockCommitsEndpoint.assertIsSatisfied(10000);
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                context.addComponent("github", new GitHubComponent());
                from("github://commit/master?username=someguy&password=apassword&repoOwner=anotherguy&repoName=somerepo&repeatCount=5&sendEmptyMessageWhenIdle=true&delay=1")
                        .to(mockCommitsEndpoint);
            }
        };
    }
}