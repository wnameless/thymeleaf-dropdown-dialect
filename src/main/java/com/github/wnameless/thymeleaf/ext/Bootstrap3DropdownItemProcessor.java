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

import java.util.List;
import java.util.Map;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.AttributeValueQuotes;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.ITemplateEvent;
import org.thymeleaf.processor.element.AbstractElementModelProcessor;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class Bootstrap3DropdownItemProcessor
    extends AbstractElementModelProcessor {

  public Bootstrap3DropdownItemProcessor(String dialectPrefix,
      boolean prefixElementName) {
    super(TemplateMode.HTML, dialectPrefix, "dropdown-item", prefixElementName,
        null, false, 1000);
  }

  @Override
  protected void doProcess(ITemplateContext context, IModel model,
      IElementModelStructureHandler structureHandler) {
    IModelFactory modelFactory = context.getModelFactory();

    Map<String, String> attr =
        ThymeleafDialectUtils.getAttributeMap(model.get(0));
    List<ITemplateEvent> events = ThymeleafDialectUtils.getEvents(model);

    model.reset();
    model.add(modelFactory.createOpenElementTag("li"));
    model.add(modelFactory.createOpenElementTag("a", attr,
        AttributeValueQuotes.DOUBLE, false));
    events.forEach(event -> model.add(event));
    model.add(modelFactory.createCloseElementTag("a"));
    model.add(modelFactory.createCloseElementTag("li"));
  }

}
