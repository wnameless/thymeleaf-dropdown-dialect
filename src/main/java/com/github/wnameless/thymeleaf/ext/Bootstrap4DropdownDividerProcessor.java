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

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.processor.element.AbstractElementModelProcessor;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class Bootstrap4DropdownDividerProcessor
    extends AbstractElementModelProcessor {

  public Bootstrap4DropdownDividerProcessor(String dialectPrefix,
      boolean prefixElementName) {
    super(TemplateMode.HTML, dialectPrefix, "dropdown-divider",
        prefixElementName, null, false, 1000);
  }

  @Override
  protected void doProcess(ITemplateContext context, IModel model,
      IElementModelStructureHandler structureHandler) {
    IModelFactory modelFactory = context.getModelFactory();

    model.reset();
    model.add(
        modelFactory.createOpenElementTag("div", "class", "dropdown-divider"));
    model.add(modelFactory.createCloseElementTag("div"));
  }

}
