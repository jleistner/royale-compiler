/*
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.royale.compiler.internal.codegen.js.amd;

import org.apache.royale.compiler.internal.test.AMDTestBase;
import org.junit.Test;

/**
 * This class tests the production of AMD JavaScript for the test project,
 * interface com.acme.sub.ISub.
 * 
 * @author Michael Schmalle
 */
public class TestAMDInterfaceISub extends AMDTestBase
{
    //--------------------------------------------------------------------------
    // Interface ISub
    //--------------------------------------------------------------------------

    @Test
    public void test_file()
    {
        asBlockWalker.visitFile(fileNode);
        assertOut("define([\"exports\", \"runtime/AS3\", \"classes/com/acme/I\"], "
                + "function($exports, AS3, I) {\n\t\"use strict\"; \n\tAS3.interface_($exports, {"
                + "\n\t\tpackage_: \"com.acme.sub\",\n\t\tinterface_: \"ISub\"\n\t\textends_: "
                + "[\n\t\t\tI\n\t\t]\n\t});\n});");
    }

    @Override
    protected String getTypeUnderTest()
    {
        return "com.acme.sub.ISub";
    }
}
