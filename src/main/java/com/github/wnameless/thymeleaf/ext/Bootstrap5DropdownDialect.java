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

public class Bootstrap5DropdownDialect extends AbstractProcessorDialect {

  public Bootstrap5DropdownDialect() {
    super("Boostrap 5 Dropdown Dialect", "bs5", 1000);
  }

  @Override
  public Set<IProcessor> getProcessors(final String dialectPrefix) {
    final Set<IProcessor> processors = new HashSet<IProcessor>();
    processors.add(new Bootstrap5DropdownProcessor(dialectPrefix, true));
    processors.add(new Bootstrap5DropupProcessor(dialectPrefix, true));
    processors.add(new Bootstrap5DroprightProcessor(dialectPrefix, true));
    processors.add(new Bootstrap5DropleftProcessor(dialectPrefix, true));
    processors.add(new Bootstrap5DropdownHeaderProcessor(dialectPrefix, true));
    processors.add(new Bootstrap5DropdownDividerProcessor(dialectPrefix, true));
    return processors;
  }

}
