/*
 *
 * Copyright 2020 Wei-Ming Wu
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package com.github.wnameless.thymeleaf.ext;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;

public class Bootstrap4DropdownDialect extends AbstractProcessorDialect {

  public Bootstrap4DropdownDialect() {
    super("Boostrap 4 Dropdown Dialect", "bs4", 1000);
  }

  public Set<IProcessor> getProcessors(final String dialectPrefix) {
    final Set<IProcessor> processors = new HashSet<IProcessor>();
    processors.add(new Bootstrap4DropdownProcessor(dialectPrefix, true));
    processors.add(new Bootstrap4DropupProcessor(dialectPrefix, true));
    processors.add(new Bootstrap4DroprightProcessor(dialectPrefix, true));
    processors.add(new Bootstrap4DropleftProcessor(dialectPrefix, true));
    processors.add(new Bootstrap4DropdownHeaderProcessor(dialectPrefix, true));
    processors.add(new Bootstrap4DropdownDividerProcessor(dialectPrefix, true));
    return processors;
  }

}
