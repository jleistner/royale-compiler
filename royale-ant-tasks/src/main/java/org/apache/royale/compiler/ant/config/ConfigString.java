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

package org.apache.royale.compiler.ant.config;

import org.apache.tools.ant.types.Commandline;

/**
 * Extends ConfigVariable by overriding addToCommandline to use the
 * -foo=bar syntax unless the value is null, in which case, -foo=
 * syntax is used.  Note this is different than not setting foo at
 * all, because it overrides any existing values for foo.
 */
public class ConfigString extends ConfigVariable
{
    public ConfigString(OptionSpec option)
    {
        this(option, null);
    }

    public ConfigString(OptionSpec option, String value)
    {
        super(option);
        this.set(value);
    }
    
    private String value;

    public void set(String value)
    {
        this.value = value;
    }

    public boolean isSet()
    {
    	return value != null;
    	}

    public String value()
    {
    	return value;
    }

    public void addToCommandline(Commandline cmdline)
    {
        if (value != null)
        {
            if (value.length() > 0)
                cmdline.createArgument().setValue("-" + spec.getFullName() + "=" + value);
            else
                cmdline.createArgument().setValue("-" + spec.getFullName() + "=");
        }
    }
}
